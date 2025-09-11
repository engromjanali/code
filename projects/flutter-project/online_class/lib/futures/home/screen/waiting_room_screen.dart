import 'package:flutter/material.dart';
import 'package:flutter_riverpod/flutter_riverpod.dart';
import 'package:online_class/constants.dart';
import 'package:online_class/core/providers/waiting_room_provider.dart';
import 'package:online_class/futures/home/screen/meeting_room.dart';
import 'package:online_class/futures/home/widgets/bouncing_dot.dart';

class WaitingRoomScreen extends ConsumerWidget {

  final String roomid;
  final bool isMicOff;
  final bool isCamOff;
  final String userId;

  const WaitingRoomScreen({super.key, required this.roomid, required this.isMicOff, required this.isCamOff, required this.userId});

  @override
  Widget build(BuildContext context, WidgetRef ref) {
    // watches the approval status provider using roomid and userid,
    final statusAsync = ref.watch(approvalStatusProvider((roomid, userId)));

    return statusAsync.when(
      data: (data){
        final status = data?[Constants.status];
        // if host approve the request 
        if(status == Constants.approved){
          //add navigation after current frame to avoid build errors
          WidgetsBinding.instance.addPostFrameCallback((_){
            Navigator.push(context, MaterialPageRoute(builder: (context)=>MeetingRoomScreen(
              name: data?[Constants.name]??"Name", 
              roomId: roomid, 
              isMicOff: isMicOff, 
              isCameraOff: isCamOff, 
              isHost: false,
            )));
          }); 
        }
        
        // if the host decline the request 
        else if(status == Constants.rejected){
          return const Scaffold(
            backgroundColor: Colors.white,
            body: Center(child: Text("You were denjed entry"),),
          );
        }

        // if waiting for approval(status null or not yet decided).
        return Scaffold(
          backgroundColor: Colors.white,
          body: Center(
            child: Column(
              mainAxisAlignment: MainAxisAlignment.center,
              children: [
                Text(
                  "Waiting for host approval",
                  style: TextStyle(fontSize: 18),
                ),

                SizedBox(height: 5,),

                // show a loading indicator here.. 
                ThreeBounchingDot(),

              ],
            ),
          ),
        );
      },
      // if somthing face wrong 
      error: (err,_)=>Scaffold(body: Center(child: Text("Error: $err"),),), 
      // while fatching approval status 
      loading: ()=> Scaffold(body: Center(child: CircularProgressIndicator(),),),
    );
  }
}