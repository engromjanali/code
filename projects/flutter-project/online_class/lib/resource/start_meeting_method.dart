import 'package:cloud_firestore/cloud_firestore.dart';
import 'package:firebase_auth/firebase_auth.dart';
import 'package:firebase_core/firebase_core.dart';
import 'package:flutter/material.dart';
import 'package:flutter_riverpod/flutter_riverpod.dart';
import 'package:online_class/constants.dart';
import 'package:online_class/core/providers/new_meeting_provider.dart';
import 'package:online_class/core/utlity/toast_message.dart';
import 'package:online_class/futures/home/screen/meeting_room.dart';

void startMeeting(
  WidgetRef ref,
  BuildContext context,
  TextEditingController nameController,
)async{
  // current login in firebase user 
  final currentUser = FirebaseAuth.instance.currentUser;
  // read state from meetingProvider 
  final state = ref.read(meetingProvider);

  // create a new document in firestore 
  try {
    await FirebaseFirestore.instance
      .collection(Constants.room)
      .doc(state.roomId)
      .set({
        Constants.createdBy : currentUser?.uid, // WHO CREATED THE ROOM,
        Constants.hostId : currentUser?.uid, // host user id,
        Constants.hostName : currentUser?.displayName, // host user name ,
        Constants.createdAt : FieldValue.serverTimestamp(),
        Constants.room : state.roomId, // unique room id,
      });
  } catch (e) {
    debugPrint(e.toString());
    showErrorToast(context: context, description: e.toString());
  }

    // navigatge directelly to meeting room screen 
    Navigator.push(
      context, 
      MaterialPageRoute(builder: (context)=> MeetingRoomScreen(
        name: nameController.text.toString(), 
        roomId: state.roomId, 
        isMicOff: state.isMicOff, 
        isCameraOff: state.isCameraOff, 
        isHost: true,
      ),
    )    
  );
}
