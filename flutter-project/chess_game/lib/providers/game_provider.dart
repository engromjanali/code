import 'dart:async';

import 'package:chess_game/constants.dart';
import 'package:chess_game/helper/uci_commands.dart';
import 'package:chess_game/models/game_model.dart';
import 'package:cloud_firestore/cloud_firestore.dart';
import 'package:firebase_storage/firebase_storage.dart';
import 'package:flutter/material.dart';
import 'package:square_bishop/square_bishop.dart';
import 'package:squares/squares.dart';
import 'package:bishop/bishop.dart' as bishop;
import 'package:uuid/uuid.dart';

import '../models/user_model.dart';
// import 'package:stockfish/stockfish.dart';
class GameProvider extends ChangeNotifier{
  // variable declaration------------------------------------------------------------------
  final FirebaseFirestore firebaseFireStore = FirebaseFirestore.instance;
  final FirebaseStorage firebaseStorage = FirebaseStorage.instance;
  
  late bishop.Game _game = bishop.Game(variant: bishop.Variant.standard());
  late SquaresState _state = SquaresState.initial(0);
  
  bool _aiThinking= false;
  bool _flipBoard = false;

  bool _vsComputer = false;
  bool _offlinePlay = false;
  bool _isLoading = false;

  bool _playWhitesTimer = true;
  bool _playBlacksTimer = true;

  Timer? _whitesTimer;
  Timer? _blacksTimer;
  int _whiteScore=0;
  int _blackScore=0;

  int _gameLevel =1;
  GameDificulty _gameDificulty = GameDificulty.easy;

  int _incremantalvalue = 0;
  int _player = Squares.white;
  PlayerColor _playerColor= PlayerColor.white;

  Duration _whiteTime = Duration.zero;
  Duration _blackTime = Duration.zero;
  
  Duration _savedWhiteTime = Duration.zero;
  Duration _savedBlackTime = Duration.zero;

  String _gameId = "";


  // get -----------------------------------------------------------

  bool get playWhitesTimer => _playWhitesTimer;
  bool get playBlacksTimer => _playBlacksTimer;

  int get getIncremantalValue => _incremantalvalue;
  int get player => _player;
  PlayerColor get playerColor => _playerColor;

  Duration get whiteTime =>_whiteTime;
  Duration get blackTime =>_blackTime;

  Duration get savedWhiteTime =>_savedWhiteTime;
  Duration get savedBlackTime =>_savedBlackTime;

  bishop.Game get game =>_game;
  SquaresState get state => _state;
  bool get aiThinking =>_aiThinking; 
  bool get flipBoard =>_flipBoard; 

  int get whiteScore => _whiteScore;
  int get blackScore => _blackScore;

  // get method
  bool get vsComputer=>_vsComputer;
  bool get offlinePlay=>_offlinePlay;
  bool get isLoading=>_isLoading;

  int get gameLevel=>_gameLevel;
  GameDificulty get gameDificulty=>_gameDificulty;

  // get position fen
  getPositionFen(){
    return game.fen;
  }

  // get gameId
  String get gameId => _gameId;


  // set function --------------------------------------------------------------------

  // set play whitesTimer
  Future<void> setPlayWhitesTimer({required bool value}) async {
    _playWhitesTimer = value;
    notifyListeners();
  }
  // set is whites turn
  Future<void> setIsWhitesTurn({required bool value}) async {
    _isWhitesTurn = value;
    notifyListeners();
  }

  // set play blacksTimer
  Future<void> setPlayBlacksTimer({required bool value}) async {
    _playBlacksTimer = value;
    notifyListeners();
  }

  // set game time
  Future<void>setGameTime({required String newSavedWhitesTime, required String newSavedBlacksTime})async{
     _savedWhiteTime = Duration(minutes: int.parse(newSavedWhitesTime));
     _savedBlackTime = Duration(minutes: int.parse(newSavedBlacksTime));
     notifyListeners();
     setWhitesTime(_savedWhiteTime);
     setBlacksTime(_savedBlackTime);
  }
  // set incremantal value
  void setIncremantalValue({required int value}){
    _incremantalvalue = value;
    notifyListeners();
  }
  //set white time
  void setWhitesTime(Duration time){
    _whiteTime =time;
    notifyListeners();
  }
  // set black time
  void setBlacksTime(Duration time){
    _blackTime =time;
    notifyListeners();
  }
  void setVsComputer ({required bool value}){
    _vsComputer = value;
    notifyListeners();
  }
  void setOfflinePlay ({required bool value}){
    _offlinePlay = value;
    notifyListeners();
  }
  void setIsLoading ({required bool value}){
    _isLoading = value;
    notifyListeners();
  }
  void setAiThinking({required bool value}){
    _aiThinking = value;
    notifyListeners();
  }
  void setPlayerColor({required int player}){
    _player = player;
    _playerColor = player==Squares.white? PlayerColor.white:PlayerColor.black;
    notifyListeners();
  }
  void setGameDificulty({required int level}){
    _gameLevel = level;
    _gameDificulty  = level==1
        ? GameDificulty.easy:
    level==2
        ? GameDificulty.medium :
    GameDificulty.hard;
    notifyListeners();
  }



  // others function ------------------------------------------------------------------

  // reset Game
  void resetGame({required bool newGame}){
    if(newGame){
      // check if the player white in the previous game 
      // change the player
      if(player==Squares.white){
        _player = Squares.black;
      }
      // reset game
      notifyListeners();
    }
    _game = bishop.Game(variant: bishop.Variant.standard());
    _state =game.squaresState(_player);
  }

  // make Square move
  bool makeSquaresMove(Move move){
    bool result = game.makeSquaresMove(move);
    notifyListeners();
    return result;
  }
  // set square State
  Future<void> setSquaresState()async{
    _state = game.squaresState(player);
      print("State updated: $_state");  // Debugging
    notifyListeners();
  }

  // make danrom move
  void makeRandomMove(){
    game.makeRandomMove();
    notifyListeners();
  }

  void flipTheBoard(){
    _flipBoard = !flipBoard;
    notifyListeners();
  }



  void startWhitesTimer({
    required BuildContext context,
    required Function onNewGame,  
    // Stockfish? stockfish,
    }){
    _whitesTimer = Timer.periodic(Duration(seconds: 1), (_){
      _whiteTime = _whiteTime -const Duration(seconds: 1);
      notifyListeners();

      if(_whiteTime<=Duration.zero){
        // white has lost  by timeout
        _whitesTimer!.cancel();
        notifyListeners();

        print(" white has lost");
        // gameOverDialog(context: context, timeOut: true, stockfish :stockfish, whiteWon:false, onNewGame: (){});
        gameOverDialog(context: context, timeOut: true,  whiteWon:false, onNewGame: (){});
      }
    });
  }
  void startBlacksTimer({
    required BuildContext context,
    required Function onNewGame, 
    // Stockfish? stockfish,
    }){
    _blacksTimer = Timer.periodic(Duration(seconds: 1), (_){
      _blackTime = _blackTime-const Duration(seconds: 1);
      notifyListeners();

      if(_blackTime<=Duration.zero){
        // black has lost  by timeout
        _blacksTimer!.cancel();
        notifyListeners();

        print(" black has lost");
        gameOverDialog(context: context, timeOut: true, whiteWon: true, onNewGame: (){});
      }
    });
  }


  // stop whites timer 
  void pushWhitesTime(){
    if(_whitesTimer!=null){
      _whiteTime+=Duration(seconds: _incremantalvalue);
      _whitesTimer!.cancel();
      notifyListeners();
    }
  }
  // stop Blacks timer 
  void pushBlacksTime(){
    if(_blacksTimer!=null){
      _blackTime+=Duration(seconds: _incremantalvalue);
      _blacksTimer!.cancel();
      notifyListeners();
    }
  }

  StreamSubscription? gameStreamSubScription;
  void gameOverListener({
    required BuildContext context, 
    // Stockfish? stockfish,
    required Function onNewGame,
    }){
    if(game.gameOver){
      //stop stockfish
      // if(stockfish!=null){
      //   stockfish.stdin = UciCommands.stop;
      // }

      pushWhitesTime();
      pushBlacksTime();

      // cancel the gameStreamSubscription if its not null
      if (gameStreamSubscription != null) {
        gameStreamSubscription!.cancel();
      }

      // show game over dialog
      if(context.mounted){
        gameOverDialog(
          context: context,
          timeOut: false, 
          whiteWon: false, 
          onNewGame: onNewGame,
        );
      }
    }
  }

  void gameOverDialog({
    required BuildContext context,
    required bool timeOut,
    required bool whiteWon,
    required Function onNewGame,
    // Stockfish? stockfish,
  }){
    String resultToShow="";
    int whiteScoreToShow=0;
    int blackScoreToShow=0;
    if(timeOut){
      if(whiteWon){
        resultToShow = "White Won On Time";
        whiteScoreToShow=_whiteScore+1;
      }
      else{
       resultToShow = "Black Won On Time";
       blackScoreToShow=_blackScore+1;
      }
    }
    else{
      resultToShow = game.result!.readable;
      if(game.drawn){
      String whiteResults = game.result!.scoreString.split("-").first;
      String blackResults = game.result!.scoreString.split("-").last;
      whiteScoreToShow = _whiteScore + int.parse(whiteResults);
      blackScoreToShow = _blackScore + int.parse(blackResults);
      }
      else if(game.winner==0){
      String whiteResults = game.result!.scoreString.split("-").first;
      whiteScoreToShow = _whiteScore + int.parse(whiteResults);

      }
      else if(game.winner==1){
      String blackResults = game.result!.scoreString.split("-").last;
      blackScoreToShow = _blackScore + int.parse(blackResults);
        
      }
      else if(game.stalemate){
        whiteScoreToShow = whiteScore;
        blackScoreToShow = blackScore;
      }

    }
    showDialog(context: context, barrierDismissible: false, builder: (context)=> AlertDialog(
      title: Text("Game Over\n $whiteScoreToShow - $blackScoreToShow", textAlign: TextAlign.center,),
      content: Text(resultToShow, textAlign: TextAlign.center,),
      actions: [
        TextButton(onPressed: (){
          Navigator.pop(context);
          Navigator.pushNamedAndRemoveUntil(context, Constants.homeScreen, (route)=>false);
        }, child: Text("Cancel",style: TextStyle(color:  Colors.red,),)),
        TextButton(onPressed: (){
          Navigator.pop(context);
        }, child: Text("New Game",style: TextStyle(color:  Colors.red,),)),
      ],
    ));
  }


  // create game
  void createNewGameInFireStore({
    required UserModel userModel,
    required Function onSuccess,
    required Function(String) onFail,
  })async{
    // create game id
    _gameId =  Uuid().v4();
    notifyListeners();

    try{
      await firebaseFireStore
      .collection(Constants.availableGames)
      .doc(userModel.uId)
      .set({
        Constants.uId: "",
        Constants.name: "",
        Constants.image: "",
        Constants.userRating: 1200,
        Constants.gameCreatorUid: userModel.uId,
        Constants.gameCreatorName: userModel.name,
        Constants.gameCreatorPhoto: userModel.image,
        Constants.gameCreatorRating: userModel.userRating,
        Constants.isPlaying: false,
        Constants.gameId: gameId,
        Constants.dateCreated: DateTime.now().microsecondsSinceEpoch.toString(),
        Constants.whitesTime: _savedWhiteTime.toString(),
        Constants.blacksTime: _savedBlackTime.toString(),
      });

      onSuccess();
    } on FirebaseException catch (e){
      onFail(e.toString());
    }catch(e){
      onFail("UnExcepted Exception : " + e.toString());
    }
  }


  String _gameCreatorUid = "";
  String _gameCreatorName = "";
  String _gameCreatorPhoto = "";
  int _gameCreatorRating = 1200;
  String _userId = "";
  String _userName = "";
  String _userPhoto = "";
  int _userRating = 1200;

  String get gameCreatorUid => _gameCreatorUid;
  String get gameCreatorName => _gameCreatorName;
  String get gameCreatorPhoto => _gameCreatorPhoto;
  int get gameCreatorRating => _gameCreatorRating;
  String get userId => _userId;
  String get userName => _userName;
  String get userPhoto => _userPhoto;
  int get userRating => _userRating;

// joining the game
  void joinGame({
    required DocumentSnapshot<Object?> game,
    required UserModel userModel,
    required Function() onSuccess,
    required Function(String) onFail,
  })async{
    try{
      // get our created game
      final myGame = await firebaseFireStore
          .collection(Constants.availableGames)
          .doc(userModel.uId)
          .get();

    // get data from the game we are joining
      _gameCreatorUid = game[Constants.gameCreatorUid];
      _gameCreatorName = game[Constants.gameCreatorName];
      _gameCreatorPhoto = game[Constants.gameCreatorPhoto];
      _gameCreatorRating = game[Constants.gameCreatorRating];
      _userId = userModel.uId;
      _userName = userModel.name;
      _userPhoto = userModel.image;
      _userRating = userModel.userRating;
      _gameId = game[Constants.gameId];
      notifyListeners();
      if(myGame.exists){
        // delete created game since we are joining another game
        await myGame.reference.delete();
      }
      // initialize the game
      final gameModel = GameModel(
        gameId: gameId,
        gameCreatorUid: _gameCreatorUid,
        userId: userId,
        positionFen: getPositionFen(),
        winnerId: "",
        whitesTime: game[Constants.whitesTime],
        blacksTime: game[Constants.blacksTime],
        blacksCurrentMove: "",
        whitesCurrentMove: "",
        boardState: state.board.flipped().toString(),
        playState: PlayState.ourTurn.name.toString(),
        isWhitesTurn: true,
        isGameOver: false,
        squareState: state.player,
        moves: state.moves.toList(),
      );

      // create  game Controller Directory in fireStore
      await firebaseFireStore
          .collection(Constants.runningGame)
          .doc(gameId)
          .collection(Constants.game)
          .doc(gameId)
          .set(gameModel.toMap());

      await firebaseFireStore
      .collection(Constants.runningGame)
      .doc(gameId)
      .set(
        {
          Constants.gameCreatorUid : gameCreatorUid,
          Constants.gameCreatorName : gameCreatorName,
          Constants.gameCreatorPhoto : gameCreatorPhoto,
          Constants.gameCreatorRating : gameCreatorRating,

          Constants.uId : userId ,
          Constants.name : userName,
          Constants.image : userPhoto,
          Constants.userRating : userRating,

          Constants.isPlaying : true,
          Constants.dateCreated: DateTime.now().microsecondsSinceEpoch.toString(),
          Constants.gameScore: "0-0",
        }
      );

      // upload game setting depending on the data of the game we are joining
      await setGameDataAndSetting(game: game, userModel: userModel);
      onSuccess();
    }on FirebaseStorage catch(e){
      onFail(e.toString());
    }catch(e){
      onFail(e.toString());
    }
  }

  StreamSubscription? isPlayingStreamSubscription;
  // check if the other player has joined
  void checkIfOpponentJoined({required UserModel userModel, required Function() onSuccess})async{
    isPlayingStreamSubscription = firebaseFireStore
        .collection(Constants.availableGames)
        .doc(userModel.uId)
        .snapshots()
        .listen((event)async{
          print("check if the game exist");
      // check if the game exist
      if(event.exists){
        final DocumentSnapshot game = event;

        // check if it's playing
        if(game[Constants.isPlaying]){
          print("check if the game exist-2");

          isPlayingStreamSubscription!.cancel();
          await Future.delayed(const Duration(microseconds: 100));
          //get data from the game we are joining
          _gameCreatorUid = game[Constants.gameCreatorUid];
          _gameCreatorName = game[Constants.gameCreatorName];
          _gameCreatorPhoto = game[Constants.gameCreatorPhoto];
          _gameCreatorRating = game[Constants.gameCreatorRating];
          _userId = game[Constants.uId];
          _userName = game[Constants.name];
          _userPhoto = game[Constants.image];
          _userRating = game[Constants.userRating];

          setPlayerColor(player: 0);
          notifyListeners();
          print("check if the game exist-3");
          onSuccess();
        }
      }
    });
  }
  // set game data and setting
  Future<void> setGameDataAndSetting({
    required DocumentSnapshot<Object?> game,
    required UserModel userModel,
  })async{
    // get reference to the game we are joining
    final opponentsGame = firebaseFireStore
        .collection(Constants.availableGames)
        .doc(game[Constants.gameCreatorUid]);

    // time -0:10:00.0000
    List<String> whiteTimeParts = game[Constants.whitesTime].split(":");
    List<String> blackTimeParts = game[Constants.whitesTime].split(":");
    
    int whiteGameTime = int.parse(whiteTimeParts[0]) * 60 + int.parse(whiteTimeParts[1]);
    int blackGameTime = int.parse(blackTimeParts[0]) * 60 + int.parse(blackTimeParts[1]);

    // set game time
    await setGameTime(
      newSavedBlacksTime: blackGameTime.toString(),
      newSavedWhitesTime: whiteGameTime.toString(),
    );
    // update the created game in fireStore
    await opponentsGame.update({
      Constants.isPlaying:true,
      Constants.uId: userModel.uId,
      Constants.name: userModel.name,
      Constants.photoUrl:userModel.image,
      Constants.userRating:userModel.userRating,
    });

    // set the player state
    setPlayerColor(player: 1);
    notifyListeners();
  }


  String _waitingText="";
  String get waitingText =>_waitingText;
  void setWaitingText({String value =""}){
    _waitingText = value;
    notifyListeners();
  }

  // search for player
  Future searchPlayer({
    required UserModel userModel,
    required Function() onSuccess,
    required Function(String) onFail,
  })async{
    try{
      // get all available game
      final availableGames =
          await firebaseFireStore.collection(Constants.availableGames).get();
      // check are there any available game
      if(availableGames.docs.isNotEmpty){
        final List<DocumentSnapshot> gameList =
          availableGames.docs.where((element) => element[Constants.isPlaying]==false).toList();

        // check there are any player ready to play with you
        if(gameList.isEmpty){
          // create new game
          setWaitingText(value:Constants.searchingPlayerText);
          createNewGameInFireStore(
            userModel: userModel,
            onSuccess: onSuccess,
            onFail: onFail,
          );
        }
        else{
          // join to the game
          setWaitingText(value: Constants.joiningGameText);
          joinGame(
            game: gameList.first,
            userModel: userModel,
            onSuccess: onSuccess,
            onFail: onFail,
          );
        }
      }
      else{
        // create new game
          setWaitingText(value:Constants.searchingPlayerText);
          createNewGameInFireStore(
            userModel: userModel,
            onSuccess: onSuccess,
            onFail: onFail,
          );
        // create new game

      }
    }on FirebaseException catch(e){
      _isLoading = false;
      notifyListeners();
      print(e.toString());
      onFail(e.toString());
    }
  }

  bool _isWhitesTurn = true;
  String blacksMove = "";
  String whitesMove = "";
  bool get whitesTurn => _isWhitesTurn;

  bool get isWhitesTurn => _isWhitesTurn;

  StreamSubscription? gameStreamSubscription;

  // listen for game changes
  Future<void> listenForGameChanges({required BuildContext context, required UserModel userModel})async{
    CollectionReference gameCollectionReferance = firebaseFireStore
        .collection(Constants.runningGame)
        .doc(gameId)
        .collection(Constants.game);

    gameStreamSubscription = gameCollectionReferance.snapshots().listen((event){
      if(event.docs.isNotEmpty){
        // get the game
        final DocumentSnapshot game = event.docs.first;

        // check if we are white - that's mean we are game creator
        if(game[Constants.gameCreatorUid] == userModel.uId){
          // check if whites turn
          if(game[Constants.isWhitesTurn]){
            _isWhitesTurn = true;

            // check if blacksCurrentMove is not empty or equal the old move - means black has played his move
            // this means its our turn to play
            if(game[Constants.blacksCurrentMove]!= blacksMove){
              // update the whites UI
              Move convartedMove = convertMoveStringToMove(moveString : game[Constants.blacksCurrentMove],);

              bool result  = makeSquaresMove(convartedMove);
              if(result){
                setSquaresState().whenComplete((){
                  pushBlacksTime();
                  startWhitesTimer(context: context, onNewGame: (){});
                  gameOverListener(context: context, onNewGame: (){});
                });
              }
            }
              notifyListeners();
          }
        }
        else{
          // not the game creator
          _isWhitesTurn = false;
          // check is white played his move
          if(game[Constants.whitesCurrentMove] != whitesMove){
            Move convertedMove = convertMoveStringToMove(
              moveString: game[Constants.whitesCurrentMove],
            );
            bool result = makeSquaresMove(convertedMove);

            if(result){
              setSquaresState().whenComplete((){
                pushWhitesTime();
                startBlacksTimer(context: context, onNewGame: (){});
                gameOverListener(context: context, onNewGame: (){});
              });
            }
          }
          notifyListeners();
        }
      }
    });
  }

  // convert move String ot move format
  Move convertMoveStringToMove({required String moveString}){
    // split the move string into it's components
    List<String> parts =  moveString.split('-');

    // extract "from" and "to"
    int from = int.parse(parts[0]);
    int to = int.parse(parts[1].split('[')[0]);

    // Extract 'promo' and 'piece' if available
    String? promo;
    String? piece;
    if(moveString.contains('[')){
      String extras = moveString.split('[')[1].split(']')[0];
      List<String> extraList = extras.split(',');
      promo = extraList[0];
      if (extraList.length > 1) {
        piece = extraList[1];
      }
    }

    // create and return the move object
    return Move(
      from: from,
      to: to,
      promo: promo,
      piece: piece,
    );
  }

  // play Move and save to firestore
  Future<void> playMoveAndSaveToFireStore({
    required BuildContext context,
    required Move move,
    required bool isWhitesMove,
  })async{
    // check if whites turn
    if(isWhitesMove){
      // update whites move
      await firebaseFireStore.collection(Constants.runningGame).doc(gameId).collection(Constants.game).doc(gameId).update({
        Constants.positionFen:getPositionFen(),
        Constants.whitesCurrentMove : move.toString(),
        Constants.isWhitesTurn:false,
        Constants.playState: PlayState.theirTurn.name.toString(),
      });

      // push whites timer and start blacks timer
      pushWhitesTime();
      startBlacksTimer(
        context: context,
        onNewGame: (){},
      );
    }
    else{
      // update blacks move
      await firebaseFireStore.collection(Constants.runningGame).doc(gameId).collection(Constants.game).doc(gameId).update({
        Constants.positionFen:getPositionFen(),
        Constants.blacksCurrentMove : move.toString(),
        Constants.isWhitesTurn:true,
        Constants.playState: PlayState.ourTurn.name.toString(),
      });

      // push blacks timer and start whites timer
      pushBlacksTime();
      startWhitesTimer(
        context: context,
        onNewGame: (){},
      );
    }
  }




}
