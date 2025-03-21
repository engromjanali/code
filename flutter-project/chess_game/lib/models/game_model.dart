import 'package:chess_game/constants.dart';
import 'package:squares/squares.dart';


class GameModel{
  String gameId;
  String gameCreatorUid;
  String userId;
  String positionFen;
  String winnerId;
  String whitesTime;
  String blacksTime;
  String whitesCurrentMove;
  String blacksCurrentMove;
  String boardState;
  String playState;
  bool isWhitesTurn;
  bool isGameOver;
  int squareState;
  List<Move> moves;

  GameModel({
    required this.gameId,
    required this.gameCreatorUid,
    required this.userId,
    required this.positionFen,
    required this.winnerId,
    required this.whitesTime,
    required this.blacksTime,
    required this.whitesCurrentMove,
    required this.blacksCurrentMove,
    required this.boardState,
    required this.playState,
    required this.isWhitesTurn,
    required this.isGameOver,
    required this.squareState,
    required this.moves,
  });

  Map<String,dynamic> toMap(){
    return{
      Constants.gameId : gameId,
      Constants.gameCreatorUid : gameCreatorUid,
      Constants.userId : userId,
      Constants.positionFen : positionFen,
      Constants.winnerId : winnerId,
      Constants.whitesTime : whitesTime,
      Constants.blacksTime : blacksTime,
      Constants.whitesCurrentMove : whitesCurrentMove,
      Constants.blacksCurrentMove : blacksCurrentMove,
      Constants.boardState : boardState,
      Constants.playState : playState,
      Constants.isWhitesTurn : isWhitesTurn,
      Constants.isGameOver : isGameOver,
      Constants.squareState : squareState,
      Constants.moves : moves,
    };
  }
  factory GameModel.fromMap(Map<String,dynamic>data){
    return GameModel(
      gameId: data[Constants.gameId]??"",
        gameCreatorUid: data[Constants.gameCreatorUid]??"",
        userId: data[Constants.userId]??"",
        positionFen: data[Constants.positionFen]??"",
        winnerId: data[Constants.winnerId]??"",
        whitesTime: data[Constants.whitesTime]??"",
        blacksTime: data[Constants.blacksTime]??"",
        whitesCurrentMove: data[Constants.whitesCurrentMove]??"",
        blacksCurrentMove: data[Constants.blacksCurrentMove]??"",
        boardState: data[Constants.boardState]??"",
        playState: data[Constants.playState]??"",
        isWhitesTurn: data[Constants.isWhitesTurn]??false,
        squareState: data[Constants.squareState] ?? 0,
        isGameOver: data[Constants.isGameOver]??false,
      moves: List<Move>.from(data[Constants.moves] ?? []),
    );
  }
}
