import 'package:cloud_firestore/cloud_firestore.dart';
import 'package:firebase_auth/firebase_auth.dart';
import 'package:flutter/material.dart';
import 'package:flutter_riverpod/flutter_riverpod.dart';
import 'package:online_class/colors.dart';
import 'package:online_class/constants.dart';
import 'package:online_class/core/providers/joining_meeting_providre.dart';
import 'package:online_class/core/providers/meeting_room_provider.dart';
import 'package:online_class/core/providers/new_meeting_provider.dart';
import 'package:online_class/core/secret/key.dart';
import 'package:online_class/core/utlity/toast_message.dart';
import 'package:online_class/futures/home/screen/entry_screen.dart';
import 'package:online_class/futures/home/screen/waiting_approve_screen.dart';
import 'package:zego_uikit_prebuilt_video_conference/zego_uikit_prebuilt_video_conference.dart';

class MeetingRoomScreen extends ConsumerStatefulWidget {

  final String name; // user display name 
  final String roomId; // unique room in 
  final bool isMicOff; // mic off or not 
  final bool isCameraOff; // camera off or not 
  final bool isHost; // are you host 

  const MeetingRoomScreen({
    super.key, 
    required this.name, 
    required this.roomId, 
    required this.isMicOff, 
    required this.isCameraOff, 
    required this.isHost,
  });

  @override
  ConsumerState<MeetingRoomScreen> createState() => _MeetingRoomScreenState();
}

class _MeetingRoomScreenState extends ConsumerState<MeetingRoomScreen> {

  @override
  Widget build(BuildContext context, ) {
    final user = FirebaseAuth.instance.currentUser;
    final elapsedTime = ref.watch(meetingRoomProvider).elapsedTime; // meeting timer
    return Scaffold(
      backgroundColor: Colors.transparent,
      body: SafeArea(
        child: Stack(
          children: [
            // zigo prebuid video conferance widget
            ZegoUIKitPrebuiltVideoConference (
              appID: appid,
              appSign: YourAppSign,
            
              userID: user?.uid??"",
            
              userName: widget.name,
              
              conferenceID: widget.roomId.trim(),
              
            
              // Modify your custom configurations here.
              config: ZegoUIKitPrebuiltVideoConferenceConfig(
                // Top menu Bar 
                topMenuBarConfig : ZegoTopMenuBarConfig(
                  isVisible: true,
                  backgroundColor: Colors.transparent,
                  title: '',
                  buttons: [
                    ZegoMenuBarButtonName.switchCameraButton,
                    ZegoMenuBarButtonName.toggleScreenSharingButton,
                  ],
                  extendButtons: [
                    if(widget.isHost) StreamBuilder(
                      stream: FirebaseFirestore.instance
                        .collection(Constants.room)
                        .doc(widget.roomId)
                        .collection(Constants.waitingList)
                        .where(Constants.status , isEqualTo: Constants.waiting)
                        .snapshots(),
                      builder: (context, snapshot){
                        final waitingCount = snapshot.data?.docs.length ?? 0;
                        return IconButton(
                          onPressed: (){
                            Navigator.push(
                              context, MaterialPageRoute(
                                builder: (context)=>WaitingApproveScreen(roomId: widget.roomId)
                              )
                            );
                          }, 
                          icon: Stack(
                            clipBehavior: Clip.none,
                            children: [
                              Icon(Icons.person, color: Colors.white,),
                              if(waitingCount > 0)
                                Positioned(
                                  right:0,
                                  top: -5,
                                  child: CircleAvatar(
                                    radius: 8,
                                    backgroundColor: Colors.red,
                                    child: Text(
                                      waitingCount.toString(),
                                      style: TextStyle(
                                        fontSize: 10,
                                        color: Colors.white,
                                      ),
                                    ),
                                  ), 
                                ),
            
                            ],
                          ),
                        );
                      },
                    )  
                  ],
                  
                ),

                
                turnOnCameraWhenJoining : !widget.isCameraOff,
                turnOnMicrophoneWhenJoining : !widget.isMicOff,
                
              )
              // action when leaving meeting.
              ..onLeave = (){
                ZegoUIKit().leaveRoom();
                // after leaving clear all that state 
                ref.invalidate(meetingProvider);
                ref.invalidate(meetingRoomProvider);
                ref.invalidate(joinMeetingProvider);
                Navigator.pushAndRemoveUntil(context, MaterialPageRoute(builder: (context)=>EntryScreen()), (_)=>false);
              }
              ..bottomMenuBarConfig = ZegoBottomMenuBarConfig(
                maxCount: 6,
                style: ZegoMenuBarStyle.light,
                buttons: [
                  ZegoMenuBarButtonName.toggleMicrophoneButton,
                  ZegoMenuBarButtonName.toggleCameraButton,
                  ZegoMenuBarButtonName.leaveButton,
                  ZegoMenuBarButtonName.chatButton,
                ],
                extendButtons: [
                  // we can customize on the default percipatants button that's what we have created 
                  Stack(
                    clipBehavior: Clip.none,
                    children: [
                      IconButton(
                        onPressed: ()async{
                          final roomSnapshot = await FirebaseFirestore  
                            .instance
                            .collection(Constants.room)
                            .doc(widget.roomId)
                            .get();
                          final hostId = roomSnapshot[Constants.hostId] ??"";
                          final currentUsers = ZegoUIKit().getAllUsers();

                          showModalBottomSheet(
                            context: context, 
                            backgroundColor: appbottomSheetColor,
                            shape: RoundedRectangleBorder(
                              borderRadius: BorderRadius.vertical(
                                top: Radius.circular(16),
                              )
                            ),
                            builder: (_){
                              return _buildMemberList(hostId, currentUsers);
                            }
                          );
                        }, 
                        style: IconButton.styleFrom(
                          padding: EdgeInsets.only(right: 15,left: 7, top: 13, bottom: 13),
                          backgroundColor: iconBackground,
                          shape: CircleBorder(),
                        ),
                        icon: Icon(Icons.group, color: Colors.white,),
                      ),

                      //show total participant count on top
                      Positioned(
                        top: 9,
                        right: 14,
                        child: Text(
                          ZegoUIKit().getAllUsers().length.toString(),
                          style: TextStyle(color: Colors.white),
                        )
                      ),
                    ],
                  )
                ]
              )
              ..layout = ZegoLayout.gallery(),
            ),


            // show room id and elapsed time host only
            if(widget.isHost)
            Positioned(
              top:16,
              left: 20,
              child: Text(
                "Room Id ${widget.roomId} $elapsedTime",
                style: TextStyle(
                  color: Colors.white, 
                  fontWeight: FontWeight.w500,
                  fontSize: 16,

                ),
              ),
            )
          ],
        ),
      ),
    );
  }

  Widget _buildMemberList (String hostid, List<ZegoUIKitUser> currentUsers){
    return Container(
      padding: EdgeInsets.all(16),
      child: Column(
        children: [
          Row(
            children: [
              GestureDetector(
                child: Icon(Icons.keyboard_arrow_down_outlined , size: 30, color: Colors.white,),
              )
            ],
          ),
          SizedBox(width: 8,),
          Text(
            "Member (${(ZegoUIKit().getAllUsers().length).toString()})",
            style: TextStyle(
              fontSize: 20,
              fontWeight: FontWeight.w600,
              color: Colors.white,
            ),
          ),

          Divider(
            color: Colors.black,
          ),

          SizedBox(
            height: 5,
          ),

          Expanded(
            child: StreamBuilder(
              stream: ZegoUIKit().getUserListStream(), 
              builder: (_, snapshot){
                final participants = snapshot.data ?? [];
                if(participants.isEmpty){
                  return const Center(
                    child: Text("No Participants Yet", style: TextStyle(color: Colors.white),),
                  );
                }
                return ListView.builder(
                  itemBuilder: (context, index){
                    final user  = participants[index];
                    final isHost = user.id == hostid;

                    return ListTile(
                      leading: StreamBuilder<DocumentSnapshot>(
                        stream: FirebaseFirestore
                          .instance
                          .collection(Constants.users)
                          .doc(user.id)
                          .snapshots(), 
                        builder: (context, userSnapshot){
                            String? photourl;
                            if(userSnapshot.hasData && userSnapshot.data!.exists){
                              final userData = userSnapshot.data!.data() as Map<String,dynamic>?;
                              photourl = userData?[Constants.imageUrl];
                            }
                            //fallback for current user 
                            if(photourl == null && user.id ==FirebaseAuth.instance.currentUser?.uid){
                              photourl = FirebaseAuth.instance.currentUser?.photoURL;
                            }
                            return CircleAvatar(
                              backgroundColor: Colors.white,
                              radius: 20,
                              backgroundImage: photourl != null && photourl.isNotEmpty? NetworkImage(photourl) : NetworkImage("https://cdn-icons-png.flaticon.com/512/3135/3135715.png"),
                            );
                        }
                      ),
                      title: Text(
                        _getuserDisplayName(user, isHost) , 
                        style: TextStyle(
                          color: Colors.white, 
                          fontWeight: isHost ? FontWeight.w600 : FontWeight.normal,
                        ), 
                      ),

                      trailing: _buildUserStatusIcons(user),
                    );
                  },
                );
              },
            )
          )
        ],
      ),
    );
  }

  String _getuserDisplayName(ZegoUIKitUser user, bool isHost){
    final currentUserId = FirebaseAuth.instance.currentUser?.uid;
    final isCurrentUser = user.id == currentUserId;

    String displayName = user.name;
    if(isCurrentUser) displayName += "(Your)";
    if(isHost) displayName += " (Host)";
    return displayName;
  }

  // display to confiram removing a user from meeting (only for host can remove)
  // build mic.camera icon + remove button
  Widget _buildUserStatusIcons(ZegoUIKitUser user){
    return Row(
      mainAxisSize: MainAxisSize.min,
      children: [
        // show remove button only if current user is host 
        // and not trying to remove themeselves
        if(widget.isHost && user.id != FirebaseAuth.instance.currentUser)...[
          SizedBox(
            width: 8,
          ),
          IconButton(
            onPressed: (){
              _showRemoveuserLialog(user);
            }, 
            icon: Icon(Icons.remove_circle,
            color: Colors.red, 
            size: 20,
            ),
          ),
        ],

        // mic status icon
        ValueListenableBuilder<bool>(
          valueListenable: user.microphone, 
          builder: (_,isMicOn,_)=>Icon(
            isMicOn? Icons.mic : Icons.mic_off, 
            color: Colors.white24, 
            size: 20,
          ),
        ),
        // camera status icon
        ValueListenableBuilder<bool>(
          valueListenable: user.microphone, 
          builder: (_,isCameraOn,_)=>Icon(
            isCameraOn? Icons.videocam : Icons.videocam_off, 
            color: Colors.white24, 
            size: 20,
          ),
        )
      ],
    );
  }


  // display to confiram removing a user from meeting (only for host can remove)
  void _showRemoveuserLialog(ZegoUIKitUser user){
    showDialog(context: context, builder: (_){
      return AlertDialog(
        title: Text("Remove user"),
        content: Text("Remove ${user.name} from the meeting?"),
        actions: [
          TextButton(
            onPressed: (){
              // Navigator.push(context, MaterialPageRoute(builder: (context)=> ))
              Navigator.of(context).pop();
            }, 
            child: Text("Cancle"),
          ),
          TextButton(
            onPressed: (){
              // Navigator.push(context, MaterialPageRoute(builder: (context)=> ))
              Navigator.of(context).pop();
              ref.read(meetingRoomProvider.notifier).removeUser(user);
              showSuccessToast(context: context, description: "${user.name} removed from the meeting.");
            }, 
            child: Text("Remove"),
          ),
        ],
      );
    });
  }
}
