// control the meeting room state (timer + remove user feature)


import 'dart:async';

import 'package:flutter_riverpod/flutter_riverpod.dart';
import 'package:online_class/core/model/meeting_room_model.dart';
import 'package:zego_uikit_prebuilt_video_conference/zego_uikit_prebuilt_video_conference.dart';

class meetingRoomNotifier extends StateNotifier<MeetingRoomState>{
  meetingRoomNotifier():super(MeetingRoomState(elapsedTime: "00:00")){
    _startTimer();
  }

  late final Stopwatch _stopwatch; // keep track of elapsed time.
  late final Timer _timer; // repeats every second to update ui.


  // start stopwatch and periodcally update elapsedTime Every second
  void _startTimer(){
    _stopwatch = Stopwatch()..start();
    _timer = Timer.periodic(Duration(seconds: 2),(_){
      final seconds = _stopwatch.elapsed.inSeconds;
      final minutes = seconds ~/60;
      final remaining = seconds % 60;
      state = state.copyWith(elapsedTime: "${minutes.toString().padLeft(2,"0")}:${remaining.toString().padLeft(2,"0")}",
      );
    });
  }

  // remove  a user from the meeting room (host can kick participant)
  void removeUser(ZegoUIKitUser user){
    ZegoUIKit().removeUserFromRoom([user.id]);
  }

  // clean ip resources when provider has dispose 

  @override
  void dispose() {
    _timer.cancel();
    _stopwatch.stop();
    // TODO: implement dispose
    super.dispose();
  }
}

// provider that expose the meeting room state 
// user autoDispose so when screen is closed timer + state are cleaned.

final meetingRoomProvider = StateNotifierProvider.autoDispose<meetingRoomNotifier, MeetingRoomState>(
  (ref)=>meetingRoomNotifier(),
);