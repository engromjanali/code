
import 'package:firebase_auth/firebase_auth.dart';
import 'package:flutter/material.dart';
import 'package:flutter_riverpod/flutter_riverpod.dart';
import 'package:online_class/core/providers/joining_meeting_providre.dart';
import 'package:online_class/core/providers/new_meeting_provider.dart';
import 'package:online_class/futures/home/widgets/custom_button.dart';
import 'package:online_class/resource/join_meeting_method.dart';
import 'package:online_class/resource/start_meeting_method.dart';

class JoiningMeetingScreen extends ConsumerStatefulWidget {
  const JoiningMeetingScreen({super.key});

  @override
  ConsumerState<JoiningMeetingScreen> createState() => _JoiningMeetingScreenState();
}

class _JoiningMeetingScreenState extends ConsumerState<JoiningMeetingScreen> {
  bool isMicOff = false;
  bool isCameraOff = true;

  late TextEditingController meetingIdController;
  late TextEditingController nameController;

  @override
  void initState() {
    // TODO: implement initState

    // initialiisze the controller only 
    meetingIdController = TextEditingController();

    // pre fill name with users's displayedname from google login
    nameController = TextEditingController(
      text: FirebaseAuth.instance.currentUser?.displayName??"",
    );

    super.initState();
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
    // read provider state(mic, camera, error)
    final state = ref.watch(joinMeetingProvider);
    // access notifier to update provider state

    final notifier = ref.read(joinMeetingProvider.notifier);

    return Scaffold(
      appBar: AppBar(
        backgroundColor: Colors.black,
        foregroundColor: Colors.white,
        title: Text("Join A Meeting"),

      ),
      body: Column(
        crossAxisAlignment: CrossAxisAlignment.start,
        children: [
          SizedBox(
            child: Padding(
              padding: const EdgeInsets.all(4.0),
              child: TextField(
                controller: meetingIdController,
                textAlign: TextAlign.center,
                keyboardType: TextInputType.number,
                decoration: InputDecoration(
                  fillColor: Colors.green.shade100,
                  filled: true,
                  errorText: state.errorMessage,
                  hintText: "Meeting Id",
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

          SizedBox(height: 20,),

          CustomButton(
            text: "join", 
            onTap: () {
              if(nameController.text.isEmpty){
                ScaffoldMessenger.of(context).showSnackBar(SnackBar(content: Text("Name Can't Be Empty!")));
                return;
              }
              joinMeeting(ref, context, nameController,meetingIdController);
            },
          ),

          Padding(

            padding: const EdgeInsets.all(8.0),
            child: Text("Join Options-", textAlign: TextAlign.start,),
          ),

          SwitchListTile(
            value: state.isMicOff, 
            title: Text("Don't Connect With Audio"),
            onChanged: notifier.toggleMic,
          ),
          SwitchListTile(
            title: Text("Turn off Camera"),
            value: state.isCameraOff, 
            onChanged: notifier.toggleCamera,
          ),

        ],
      ),
    );
  }
}

// firs i will open the 