class MeetingState {
  final bool isMicOff;
  final bool isCameraOff;
  final String roomId;

  MeetingState({
    required this.isMicOff, 
    required this.isCameraOff, 
    required this.roomId,
  });

  MeetingState copyWith({bool? isMicOff, bool? isCameraOff, String? roomId}){
    return MeetingState(
      isMicOff: isMicOff?? this.isMicOff, 
      isCameraOff: isCameraOff?? this.isCameraOff, 
      roomId: roomId?? this.roomId,
    );
  }
}