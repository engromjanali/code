import 'package:flutter_riverpod/flutter_riverpod.dart';
import 'package:online_class/core/model/joining_meeting_model.dart';
import 'package:online_class/core/model/new_meeting_model.dart';
import 'package:online_class/core/providers/new_meeting_provider.dart';
import 'package:online_class/futures/home/screen/join_meeting.dart';

class JoinMeetingNotifier extends StateNotifier<JoiningMeetingState>{
  JoinMeetingNotifier()
  : super(JoiningMeetingState(
    isMicOff: false, 
    isCameraOff: false, 
    errorMessage: null,
    )
  );

  //toggle microphone State
  void toggleMic(bool value){
    state = state.copyWith(isMicOff: value);
  }

  //toggle camera State
  void toggleCamera(bool value){
    state = state.copyWith(isCameraOff: value);
  }

  // set an error messsage when joining meeting failed.
  void setError(String? message){
    state = state.copyWith(errorMessage: message);
  }


  
}


// riverpod provider for joinMeetingnotifier
// autoDispose clear state autometically when not used.


final joinMeetingProvider = StateNotifierProvider.autoDispose<JoinMeetingNotifier, JoiningMeetingState>(
  (ref)=> JoinMeetingNotifier()
  );