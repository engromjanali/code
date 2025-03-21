import 'dart:math';

import 'package:bishop/bishop.dart' as bishop;
import 'package:chess_game/constants.dart';
import 'package:chess_game/helper/helper_method.dart';
import 'package:chess_game/helper/uci_commands.dart';
import 'package:chess_game/providers/authantication_provider.dart';
import 'package:chess_game/providers/game_provider.dart';
import 'package:flutter/material.dart';
import 'package:provider/provider.dart';
import 'package:square_bishop/square_bishop.dart';
import 'package:squares/squares.dart';

import 'package:chess_game/services/assets_manager.dart';

import '../models/user_model.dart';
// import 'package:stockfish/stockfish.dart';

class GameScreen extends StatefulWidget {
  const GameScreen({super.key});

  @override
  State<GameScreen> createState() => _GameScreenState();
}

class _GameScreenState extends State<GameScreen> {
  // late Stockfish stockFish;

  @override
  void initState() {
    // stockFish = Stockfish();
    final gameProvider = context.read<GameProvider>();
    gameProvider.resetGame(newGame: false);
    if(mounted){
      letOtherPlayerPlayFirst();
    }
    super.initState();
    gameProvider.pushBlacksTime();
    gameProvider.pushWhitesTime();
  }

  void letOtherPlayerPlayFirst(){
    // wait for widget to rebuild
    WidgetsBinding.instance.addPostFrameCallback((_)async{
      final gameProvider = context.read<GameProvider>();
      if(gameProvider.vsComputer){
        if (gameProvider.state.state == PlayState.theirTurn && !gameProvider.aiThinking) {
          // Set AI to thinking mode
          gameProvider.setAiThinking(value:true);
          // Simulate AI thinking time with a random delay (250ms to 5 seconds)
          await Future.delayed(Duration(milliseconds: Random().nextInt(4750) + 250));
          // AI makes a random move
          gameProvider.game.makeRandomMove();
          // Update game state after AI's move
          gameProvider.setAiThinking(value: false);
          gameProvider.setSquaresState().whenComplete((){
            gameProvider.pushWhitesTime();
            startTimer(isWhiteTimer: false, onNewGame: (){});
            print("first");
          });
        }
      }
      else{
        // listen for game changes in fireStore
        if(gameProvider.offlinePlay){
          // gameProvider.game.makeSquaresMove(move)
        }
        else{
          final authProvider = context.read<AuthenticationProvider>();
          gameProvider.listenForGameChanges(
            context : context, userModel: authProvider.userModel!
          );
        }
      }
    });
  }
  
  void startTimer({
      required bool isWhiteTimer,
      required Function onNewGame,
    }){
    final gameProvider = context.read<GameProvider>();
    if(isWhiteTimer){
      // start white timer
      // gameProvider.startWhitesTimer(context: context, stockfish :stockFish, onNewGame:onNewGame);
      gameProvider.startWhitesTimer(context: context, onNewGame:onNewGame);
    }
    else{
      // start black timer
      // gameProvider.startBlacksTimer(context: context, stockfish :stockFish, onNewGame: onNewGame);
      gameProvider.startBlacksTimer(context: context, onNewGame: onNewGame);
    }
  }


  // Future<void> waitUintilStockfishIsReady()async{
  //   while(stockFish.state.value!=StockfishState.ready){
  //       print("is Ready: ${stockFish.state.value}");
  //     await Future.delayed(const Duration(seconds: 1));
  //   }
  // }

  void _onMove(Move move) async {
    final gameProvider = context.read<GameProvider>();
    // print("move: $move");
    // print("move: ${gameProvider.whiteTime}");
    // print("move: ${gameProvider.blackTime}");
    // Player makes a move, and we check if it's valid
    bool result = gameProvider.makeSquaresMove(move);
    // If the move is valid, update the game state

    if(gameProvider.offlinePlay){
      print("offline play");
      if(result){
        gameProvider.setSquaresState().whenComplete(()async{
          if(gameProvider.player == Squares.white && gameProvider.isWhitesTurn){
            gameProvider.pushWhitesTime();
            startTimer(isWhiteTimer: false, onNewGame: (){});
            gameProvider.setIsWhitesTurn(value: false);
            setState(() {

            });
          }
          else{
            gameProvider.pushBlacksTime();
            startTimer(isWhiteTimer: true, onNewGame: (){});
            gameProvider.setIsWhitesTurn(value: true);
          }
        });
      }
      result = false;
      result = gameProvider.makeSquaresMove(move);
      gameProvider.game.squaresState(1);
    }
    else if (result) {
      gameProvider.setSquaresState().whenComplete(()async{
        if(gameProvider.player== Squares.white){
          // check if we are playing vs computer
          if(gameProvider.vsComputer){
            // push timer for white
            gameProvider.pushWhitesTime();

            startTimer(
              isWhiteTimer: false,
              onNewGame: (){},
            );
            // set whites boll flag to true so that we don't run this code again until true
            gameProvider.setPlayWhitesTimer(value: true);
          }
          else{
            // play and save whites move to firestore
            await gameProvider.playMoveAndSaveToFireStore(
              context: context,
              move: move,
              isWhitesMove: true,
            );
          }
        }
        else{
          if(gameProvider.vsComputer){
            // push timer for black
            gameProvider.pushBlacksTime();

            startTimer(
              isWhiteTimer: true,
              onNewGame: (){},
            );
            // set black bool flag to true so that we don't run this code again untill thue
            gameProvider.setPlayBlacksTimer(value: true);
          }
          else{
            // play and save blacks move to firestore
            await gameProvider.playMoveAndSaveToFireStore(
              context: context,
              move: move,
              isWhitesMove: false,
            );

          }
        }
      });
    }
    if (gameProvider.vsComputer) {
      if (gameProvider.state.state == PlayState.theirTurn &&
          !gameProvider.aiThinking) {
        gameProvider.setAiThinking(value: true);

        // wait auntil stockfish is ready
        // await waitUntilReady();
        //
        // // get the current position of the board and sent to stockfish
        // stockfish.stdin =
        // '${UCICommands.position} ${gameProvider.getPositionFen()}';
        //
        // // set stockfish level
        // stockfish.stdin =
        // '${UCICommands.goMoveTime} ${gameProvider.gameLevel * 1000}';
        //
        // stockfish.stdout.listen((event) {
        //   if (event.contains(UCICommands.bestMove)) {
        //     final bestMove = event.split(' ')[1];
        //     gameProvider.makeStringMove(bestMove);
        //     gameProvider.setAiThinking(false);
        //     gameProvider.setSquaresState().whenComplete(() {
        //       if (gameProvider.player == Squares.white) {
        //         // check if we can play whitesTimer
        //         if (gameProvider.playWhitesTimer) {
        //           // pause timer for black
        //           gameProvider.pauseBlacksTimer();
        //
        //           startTimer(
        //             isWhiteTimer: true,
        //             onNewGame: () {},
        //           );
        //
        //           gameProvider.setPlayWhitesTimer(value: false);
        //         }
        //       } else {
        //         if (gameProvider.playBlacksTimer) {
        //           // pause timer for white
        //           gameProvider.pauseWhitesTimer();
        //
        //           startTimer(
        //             isWhiteTimer: false,
        //             onNewGame: () {},
        //           );
        //
        //           gameProvider.setPlayBlactsTimer(value: false);
        //         }
        //       }
        //     });
        //   }
        // });

        await Future.delayed(
            Duration(milliseconds: Random().nextInt(4750) + 250));
        gameProvider.game.makeRandomMove();
        gameProvider.setAiThinking(value: false);
        gameProvider.setSquaresState().whenComplete(() {
          if (gameProvider.player == Squares.white) {
            // pause timer for black
            gameProvider.pushBlacksTime();

            startTimer(
              isWhiteTimer: true,
              onNewGame: () {},
            );
          } else {
            // pause timer for white
            gameProvider.pushWhitesTime();

            startTimer(
              isWhiteTimer: false,
              onNewGame: () {},
            );
          }
        });
      }
    }






    // Check if it's now the opponent's (AI's) turn and AI is not already thinking
    // if (gameProvider.state.state == PlayState.theirTurn && !gameProvider.aiThinking) {
      // Set AI to thinking modefgs d
      // gameProvider.setAiThinking(value:true);
      //  wait until stockfish is ready
      // await waitUintilStockfishIsReady();

      // // get the current position of the board sent to stockfish
      // stockFish.stdin= "${UciCommands.position} ${gameProvider.getPositionFen()}";
      // // set StockFish Level
      // stockFish.stdin ="${UciCommands.goMoveTime} ${gameProvider.gameLevel*1000}";
      // stockFish.stdout.listen((event){
      //   print("Event: $event");
      // });

      // // Simulate AI thinking time with a random delay (250ms to 5 seconds)
      // await Future.delayed(Duration(milliseconds: Random().nextInt(4750) + 250));
      // // AI makes a random move
      // gameProvider.game.makeRandomMove();

      // // Update game state after AI's move
      // gameProvider.setAiThinking(value: false);
      // gameProvider.setSquaresState().whenComplete((){
      //   if(gameProvider.player==Squares.white){
      //     gameProvider.pushBlacksTime();
      //     startTimer(isWhiteTimer: true, onNewGame: (){});
      //   }
      //   else{
      //     gameProvider.pushWhitesTime();
      //     startTimer(isWhiteTimer: false, onNewGame: (){});
      //   }
      // }
      // );
    // }
    // listen if game over
    await Future.delayed(const Duration(seconds: 1));
    checkGameOverListener();
  }


  void checkGameOverListener(){
    final gameProvider = context.read<GameProvider>();        
    // gameProvider.gameOverListener(context: context,stockfish:stockFish, onNewGame: (){
    gameProvider.gameOverListener(context: context, onNewGame: (){
      // start new game

    });

  }


  // void _onMove(Move move) async {
  //   // Player makes a move, and we check if it's valid
  //   bool result = game.makeSquaresMove(move);

  //   // If the move is valid, update the game state
  //   if (result) {
  //     setState(() => state = game.squaresState(player));
  //   }

  //   // Check if it's now the opponent's (AI's) turn and AI is not already thinking
  //   if (state.state == PlayState.theirTurn && !aiThinking) {
  //     // Set AI to thinking mode
  //     setState(() => aiThinking = true);

  //     // Simulate AI thinking time with a random delay (250ms to 5 seconds)
  //     await Future.delayed(Duration(milliseconds: Random().nextInt(4750) + 250));

  //     // AI makes a random move
  //     game.makeRandomMove();

  //     // Update game state after AI's move
  //     setState(() {
  //       aiThinking = false;  // AI is no longer thinking
  //       state = game.squaresState(player);  // Refresh the game state
  //     });
  //   }
  // }


  @override
  Widget build(BuildContext context) {
    final gameProvider = context.read<GameProvider>();
    final authProvider = context.read<AuthenticationProvider>();
  print("whites time : ${gameProvider.whiteTime}");
  print("blacks time : ${gameProvider.blackTime}");

    return PopScope(
      canPop: false, // Prevents the back button from automatically popping the screen
      onPopInvoked: (didPop) async {
        if (!didPop) {
          bool? leave = await _showExitConfirmDialog(context);
          if (leave == true) {
            await Future.delayed(const Duration(microseconds: 200)).whenComplete(() {
              Navigator.pushNamedAndRemoveUntil(context, Constants.homeScreen, (route) => false);
            });
          }
        }

      },
      child: Scaffold(
        appBar: AppBar(
          automaticallyImplyLeading: false, // Hides the back button
          // leading: IconButton(
          //  icon: const Icon(Icons.arrow_back, color: Colors.white,),
          //   onPressed: (){
          //     // show dialog if sur
          //     Navigator.pop(context);
          //   },
          // ),
          backgroundColor: Colors.orange,
          title: Text("romjan developer!"),
          actions: [
            IconButton(
              onPressed: (){
                gameProvider.resetGame(newGame: true);
              }, 
              icon: const Icon(Icons.start ,color: Colors.white,),
            ),
            
            IconButton(
              onPressed: (){
                gameProvider.flipTheBoard();
              }, 
              icon: const Icon(Icons.rotate_90_degrees_ccw ,color: Colors.white,),
            ),
            
          ],
        ),
        body: Consumer<GameProvider>(
          builder: (context, gameProvider, child){
      
          return Column(
            mainAxisAlignment: MainAxisAlignment.center,
            children: [
          
              // opponents data
              gameProvider.flipBoard ?
              ListTile(
                leading: CircleAvatar(
                  radius: 15,
                  backgroundImage: authProvider.userModel!.image==""? AssetImage(AssetsManager.userIcon) : NetworkImage(authProvider.userModel!.image),
                  backgroundColor: Colors.green,
                ),
                title: Text(authProvider.userModel!.name),
                subtitle: Text('Rating: ${authProvider.userModel!.userRating}'),
                trailing: Text(
                  getTimerToDisplay(gameProvider: gameProvider, isUser:true),
                  style: const TextStyle(fontSize: 16),
                  ),
              )
              :
              showOpponentsData(
                gameProvider: gameProvider, 
                timeToShow: getTimerToDisplay(
                  gameProvider: gameProvider, 
                  isUser: false,
                  ),
                userModel: authProvider.userModel!,
              ),
          
              gameProvider.vsComputer || gameProvider.offlinePlay?
              Padding(
                padding: const EdgeInsets.all(4.0),
                child: BoardController(
                  // state: gameProvider.flipBoard ? gameProvider.state.board.flipped() : gameProvider.state.board,
                  state: getState(gameProvider: gameProvider),
                  playState: gameProvider.state.state,
                  pieceSet: PieceSet.merida(),
                  theme: BoardTheme.brown,
                  moves: gameProvider.state.moves,
                  onMove: _onMove,
                  onPremove: _onMove,
                  markerTheme: MarkerTheme(
                    empty: MarkerTheme.dot,
                    piece: MarkerTheme.corners(),
                  ),
                  promotionBehaviour: PromotionBehaviour.autoPremove,
                ),
              )
              : buildChessBoard(
                gameProvider: gameProvider,
                userModel: authProvider.userModel!,
              ),

              // our data
              gameProvider.flipBoard ?
                showOpponentsData(
                  gameProvider: gameProvider,
                  userModel: authProvider.userModel!,
                  timeToShow:getTimerToDisplay(
                    gameProvider: gameProvider,
                    isUser: false,
                  ),
                )
              : ListTile(
                leading: CircleAvatar(
                  radius: 15,
                  backgroundImage: authProvider.userModel!.image==""? AssetImage(AssetsManager.userIcon) : NetworkImage(authProvider.userModel!.image),
                  backgroundColor: Colors.green,
                ),
                title: Text(authProvider.userModel!.name),
                subtitle: Text('Rating: ${authProvider.userModel!.userRating}'),
                trailing: Text(
                  getTimerToDisplay(gameProvider: gameProvider, isUser:true),
                  style: const TextStyle(fontSize: 16),
                ),
              ),
              const SizedBox(height: 32),
            ],
          );
          },
        ),
      ),
    );
  }

  Future<bool?> _showExitConfirmDialog(BuildContext context) async{
    return showDialog<bool>(
      context: context,
      builder: (context)=> AlertDialog(
        title:Text("Leave Geame",textAlign: TextAlign.center),
        content: Text("Are you sure to leave this game? ",textAlign: TextAlign.center),
        actions: [
          TextButton(onPressed: (){
            Navigator.of(context).pop(false); // return false with dispose the dialog
          }, 
          child: const Text("Cancel")),
          TextButton(onPressed: (){
            Navigator.of(context).pop(true); // return true with dispose the dialog 
          }, 
          child: const Text("Yes")),
        ],
      ));
  }

  Widget buildChessBoard({required GameProvider gameProvider, required UserModel userModel}){
    bool isOurTurn = gameProvider.isWhitesTurn == (gameProvider.gameCreatorUid==userModel.uId);

    return Padding(
      padding: const EdgeInsets.all(4.0),
      child: BoardController(
        state: getState(gameProvider: gameProvider),
        playState:  isOurTurn? PlayState.ourTurn : PlayState.theirTurn,
        pieceSet: PieceSet.merida(),
        theme: BoardTheme.brown,
        moves: gameProvider.state.moves,
        onMove: _onMove,
        onPremove: _onMove,
        markerTheme: MarkerTheme(
          empty: MarkerTheme.dot,
          piece: MarkerTheme.corners(),
        ),
        promotionBehaviour: PromotionBehaviour.autoPremove,
      ),
    );
  }

  getState({required GameProvider gameProvider}) {
    if (gameProvider.flipBoard) {
      return gameProvider.state.board.flipped();
    } else {
      return gameProvider.state.board;
    }
  }

  Widget showOpponentsData({
    required GameProvider gameProvider,
    required UserModel userModel,
    required String timeToShow,
  }){
    if(gameProvider.vsComputer){
      return ListTile(
        leading: CircleAvatar(
          radius: 25,
          backgroundImage: AssetImage(AssetsManager.stockfishIcon),
        ),
        title: Text("StockFish"),
        subtitle: Text("Rating :${gameProvider.gameLevel *1000}"),
        trailing: Text(timeToShow, style: const TextStyle(fontSize: 16),),
      );
    }
    else if(gameProvider.offlinePlay){
      return ListTile(
        leading: CircleAvatar(
          radius: 25,
          backgroundImage: AssetImage(AssetsManager.userIcon),
        ),
        title: Text("Opponent"),
        subtitle: Text("Rating :${1200}"),
        trailing: Text(timeToShow, style: const TextStyle(fontSize: 16),),
      );
    }
    else{
      // check is it game creator or opponent
      if(gameProvider.gameCreatorUid == userModel.uId){
        // it's me
        return ListTile(
          leading: CircleAvatar(
            radius: 25,
            backgroundImage: gameProvider.userPhoto ==""? AssetImage(AssetsManager.userIcon) : NetworkImage(gameProvider.userPhoto),
          ),
          title: Text(gameProvider.userName),
          subtitle: Text("Rating :${gameProvider.userRating}"),
          trailing: Text(timeToShow, style: const TextStyle(fontSize: 16),),
        );
      }
      else{
        // opponent
        return ListTile(
          leading: CircleAvatar(
            radius: 25,
            backgroundImage: gameProvider.gameCreatorPhoto ==""? AssetImage(AssetsManager.userIcon) : NetworkImage(gameProvider.gameCreatorPhoto),
          ),
          title: Text(gameProvider.gameCreatorName),
          subtitle: Text("Rating :${gameProvider.gameCreatorRating}"),
          trailing: Text(timeToShow, style: const TextStyle(fontSize: 16),),
        );
      }
    }
  }
}
