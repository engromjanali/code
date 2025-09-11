
import 'package:firebase_auth/firebase_auth.dart';
import 'package:flutter/material.dart';
import 'package:flutter_riverpod/flutter_riverpod.dart';
import 'package:online_class/core/providers/new_meeting_provider.dart';
import 'package:online_class/futures/home/widgets/custom_button.dart';
import 'package:online_class/resource/start_meeting_method.dart';

class NewMeetingScreen extends ConsumerStatefulWidget {
  const NewMeetingScreen({super.key});

  @override
  ConsumerState<NewMeetingScreen> createState() => _NewMeetingScreenState();
}

class _NewMeetingScreenState extends ConsumerState<NewMeetingScreen> {
  bool isMicOff = false;
  bool isCameraOff = true;

  late TextEditingController meetingIdController;
  late TextEditingController nameController;

  @override
  void initState() {
    // TODO: implement initState
    super.initState();

    // read initial meeting state 
    final meetingState = ref.read(meetingProvider);

    // pre fill meeting id with random genarated roomid
    meetingIdController = TextEditingController(
      text: meetingState.roomId,
    );

    // pre fill name with users's displayedname from google login
    nameController = TextEditingController(
      text: FirebaseAuth.instance.currentUser?.displayName??"",
    );
  }

  @override
  void dispose() {
    meetingIdController.dispose();
    nameController.dispose();

    // TODO: implement dispose
    super.dispose();
  }

  @override
  Widget build(BuildContext context) {

    final meetingState = ref.watch(meetingProvider);

    return Scaffold(
      appBar: AppBar(
        title: Text("Start New Meeting..."),

      ),
      body: Column(
        children: [
          SizedBox(
            child: Padding(
              padding: const EdgeInsets.all(4.0),
              child: TextField(
                controller: meetingIdController,
                textAlign: TextAlign.center,
                decoration: InputDecoration(
                  fillColor: Colors.green.shade100,
                  filled: true,
                  hintText: "Meeting Id ${meetingState.roomId}",
                  border:InputBorder.none,
                  enabled: false, // desable user to change room id 
                  hintStyle: TextStyle(fontWeight: FontWeight.w600),
                  enabledBorder: OutlineInputBorder(
                    borderRadius: BorderRadius.circular(10),
                    borderSide: BorderSide(
                      color: Colors.transparent
                    )
                  ),
                ),
              ),
            ),
          ),
          SizedBox(
            child: Padding(
              padding: const EdgeInsets.all(4.0),
              child: TextField(
                controller: nameController,
                textAlign: TextAlign.center,
                decoration: InputDecoration(
                  fillColor: Colors.green.shade100,
                  filled: true,
                  hintText: "User Name",
                  border:InputBorder.none,
                  hintStyle: TextStyle(fontWeight: FontWeight.w600),
                  enabledBorder: OutlineInputBorder(
                    borderRadius: BorderRadius.circular(10),
                    borderSide: BorderSide(
                      color: Colors.transparent
                    )
                  ),
                ),
              ),
            ),
          ),

          SwitchListTile(
            value: meetingState.isCameraOff, 
            title: Text("Turn Off Camera"),
            onChanged: (val){
              setState(() {
                ref.read(meetingProvider.notifier).toggleCamera(val);
              });
            },
          ),
          SwitchListTile(
            title: Text("Mute Microphone"),
            value: meetingState.isMicOff, 
            onChanged: (val){
              setState(() {
                ref.read(meetingProvider.notifier).toggleMic(val);
              });
            },
          ),

          CustomButton(
            text: "Start New Meeting", 
            onTap: () {
              if(nameController.text.isEmpty){
                ScaffoldMessenger.of(context).showSnackBar(SnackBar(content: Text("Name Can't Be Empty!")));
                return;
              }
              startMeeting(ref, context, nameController);
            },
          ),
        ],
      ),
    );
  }
}