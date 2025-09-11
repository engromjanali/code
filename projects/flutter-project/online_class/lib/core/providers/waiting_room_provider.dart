// a provider that listens to the aproval status of a user in a spacific room
// it's returns real-time updates from firebase 

import 'package:cloud_firestore/cloud_firestore.dart';
import 'package:flutter_riverpod/flutter_riverpod.dart';
import 'package:online_class/constants.dart';

final approvalStatusProvider = StreamProvider.family<
Map<String, dynamic>?, // the type of data returned
(String roomId , String userId) // input augument
>((ref, arg) {
  final (roomId, userId) = arg;
  return FirebaseFirestore.instance
    .collection(Constants.room)
    .doc(roomId)
    .collection(Constants.waitingList)
    .doc(userId)
    .snapshots()
    .map((doc)=>doc.data()); // convart document snapshot to map
});