import 'dart:math';

import 'package:flutter_riverpod/flutter_riverpod.dart';
import 'package:online_class/core/model/new_meeting_model.dart';

class MeetingNotifier extends StateNotifier<MeetingState>{
  MeetingNotifier():super(MeetingState(
    
    isMicOff: false, 
    isCameraOff: false, 
    roomId: Random().nextInt(999999).toString(),
  ));

  // turn on/off mic
  void toggleMic(bool value){
    state = state.copyWith(isMicOff: value);
  }

  // turn on/off camera
  void toggleCamera(bool value){
    state  = state.copyWith(isCameraOff: value);
  }
}

// riverpod provider for meetingNotifier
// autoDispose = clears state when not used aanymore
final meetingProvider = StateNotifierProvider.autoDispose<MeetingNotifier, MeetingState>(
  (ref) {
    return MeetingNotifier();
  },
);