// represents the current state of meeting room 

class MeetingRoomState{
  final String elapsedTime;
  MeetingRoomState({required this.elapsedTime});

  // creates a copyy of the state wuth update value
  MeetingRoomState copyWith({String? elapsedTime}){

    return MeetingRoomState(elapsedTime: elapsedTime??this.elapsedTime);
  }
}