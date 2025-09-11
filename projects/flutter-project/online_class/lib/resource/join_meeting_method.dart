import 'package:cloud_firestore/cloud_firestore.dart';
import 'package:firebase_auth/firebase_auth.dart';
import 'package:flutter/material.dart';
import 'package:flutter_riverpod/flutter_riverpod.dart';
import 'package:online_class/constants.dart';
import 'package:online_class/core/providers/joining_meeting_providre.dart';
import 'package:online_class/core/utlity/toast_message.dart';
import 'package:online_class/futures/home/screen/waiting_room_screen.dart';

void joinMeeting(
  WidgetRef ref,
  BuildContext context, 
  TextEditingController nameController,
  TextEditingController meetingIdController,
)async{
  // get room idand name from text field 
  final meetingId  = meetingIdController.text.toString();
  final name = nameController.text.toString();

  // current logged-in firebase user
  final user = FirebaseAuth.instance.currentUser!;

  // riverpod notifier and state for joinMeeingProvider
  final notifier = ref.read(joinMeetingProvider.notifier);
  final state = ref.read(joinMeetingProvider);

  //validation room id and name can't be empty
  if(meetingId.isEmpty || name.isEmpty){
    notifier.setError("Name or Room ID is required.");
    return;
  }

  //check if the meeting room exists in firebase 
  final doc = await FirebaseFirestore.instance
    .collection(Constants.room)
    .doc(meetingId)
    .get();
  
  if(!doc.exists){
    // uf no search room exists show a error
    notifier.setError("No Search Room Found");
    showErrorToast(context: context, description: "No Search Room Found");
    return;
  }


  // add user info waitinglist sub-collection of the room
  // status = waiting (host need to approved to join)

  await FirebaseFirestore.instance
    .collection(Constants.room)
    .doc(meetingId)
    .collection(Constants.waitingList)
    .doc(user.uid)
    .set({
      Constants.name : name,
      Constants.status : Constants.waiting,
  });

  // Navigate to waiting approval screen.
  Navigator.push(context, MaterialPageRoute(builder: (context)=>WaitingRoomScreen(
    roomid:meetingId,
    isMicOff: state.isMicOff,
    isCamOff: state.isCameraOff,
    userId: user.uid,  
    )
  ));

  showInfoToast(context: context, description: "Waiting to approve from admin.");
}