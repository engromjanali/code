class JoiningMeetingState {
  final bool isMicOff;
  final bool isCameraOff;
  final String? errorMessage;

  JoiningMeetingState({
    required this.isMicOff, 
    required this.isCameraOff, 
    required this.errorMessage,
  });

  JoiningMeetingState copyWith({
    bool? isMicOff, 
    bool? isCameraOff, 
    String? errorMessage,
  }){
    return JoiningMeetingState(
      isMicOff: isMicOff?? this.isMicOff, 
      isCameraOff: isCameraOff?? this.isCameraOff, 
      errorMessage: errorMessage?? this.errorMessage,
    );
  }
}