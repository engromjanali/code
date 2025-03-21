import 'package:bishop/bishop.dart';
import 'package:chess_game/constants.dart';
import 'package:chess_game/providers/authantication_provider.dart';
import 'package:chess_game/providers/game_provider.dart';
import 'package:chess_game/widgets/widgets.dart';
import 'package:firebase_auth/firebase_auth.dart';
import 'package:flutter/material.dart';
import 'package:provider/provider.dart';

class GameStartUpScreen extends StatefulWidget {
  const GameStartUpScreen({super.key, required this.isCustomTime, required this.gameTime});

  final bool isCustomTime;
  final String gameTime;

  @override
  State<GameStartUpScreen> createState() => _GameStartUpScreenState();
}

class _GameStartUpScreenState extends State<GameStartUpScreen> {
  PlayerColor playerColorGroup = PlayerColor.white;
  GameDificulty gameDificultyGroup = GameDificulty.easy;

  int whiteTime=0;
  int blackTime=0;



  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(

      ),
      body:Consumer<GameProvider>(builder: (context, gameProvider, child){
        return Padding(
          padding: const EdgeInsets.all(8.0),
          child: Column(
            children: [
              Row(
                mainAxisAlignment: MainAxisAlignment.spaceBetween,
                children: [
                  SizedBox(
                    width: MediaQuery.of(context).size.width * 0.5,
                    child: PlayerColorRadioButton(
                      title: "Play As ${PlayerColor.white.name}",
                      value: PlayerColor.white,
                      groupValue: gameProvider.playerColor,
                      onChanged: (value){
                        print("value 0: $value");
                        gameProvider.setPlayerColor(player: 0);// '0' mean white
                      },
                    ),
                  ),
                  widget.isCustomTime?
                  BuildCustomTime(time: whiteTime.toString(),
                    onLeftArrowClicked: (){
                      setState(() {
                        whiteTime!=0? whiteTime--:whiteTime;
                      });
                    },
                    onRightArrowClicked: (){
                      setState(() {
                        whiteTime++;
                      });
                    },
                  )
                  :
                  Container(
                    decoration: BoxDecoration(
                      border: Border.all(width:0.5, color: Colors.black),
                      borderRadius: BorderRadius.circular(10),
                    ),
                    child: Padding(
                      padding: EdgeInsets.all(8.0),
                      child:Center(
                        child: Text("${widget.gameTime}" , style: TextStyle(fontSize: 20, color: Colors.black),),
                      ),
                    ),
                  ),
                ],
              ),
              SizedBox(
                height: 10,
              ),
              Row(
                mainAxisAlignment: MainAxisAlignment.spaceBetween,
                children: [
                  SizedBox(
                    width: MediaQuery.of(context).size.width * 0.5,
                    child: PlayerColorRadioButton(
                      title: "Play As ${PlayerColor.black.name}",
                      value: PlayerColor.black,
                      groupValue: gameProvider.playerColor,
                      onChanged: (value){
                        gameProvider.setPlayerColor(player: 1);// '1' mean black
                        print("value 1: $value");
                      },
                    ),
                  ),
                  Row(
                    children: [
                      widget.isCustomTime? // for custom time
                      BuildCustomTime(time: blackTime.toString(),
                        onLeftArrowClicked: (){
                          setState(() {
                            blackTime!=0? blackTime--:blackTime;
                          });
                        },
                        onRightArrowClicked: (){
                          setState(() {
                            blackTime++;
                          });
                        },
                      )
                      :
                      Container(// for non custom time
                        decoration: BoxDecoration(
                          border: Border.all(width:0.5, color: Colors.black),
                          borderRadius: BorderRadius.circular(10),
                        ),
                        child: Padding(
                          padding: EdgeInsets.all(8.0),
                          child:Center(
                            child: Text("${widget.gameTime}" , style: TextStyle(fontSize: 20, color: Colors.black),),
                          ),
                        ),
                      ),
                    ],
                  ),
                ],
              ),
              gameProvider.vsComputer?
              Column(
                children: [
                  const Padding(
                    padding: EdgeInsets.all(10.0),
                    child: Text("Game Dificult", style: TextStyle(fontSize: 20, fontWeight: FontWeight.bold),),
                  ),
                  Row(
                    mainAxisAlignment: MainAxisAlignment.spaceEvenly,
                    children: [
                      GameLevelRadioButton(
                        title: GameDificulty.easy.name,
                        value: GameDificulty.easy,
                        groupValue: gameProvider.gameDificulty,
                        onChanged: (value){
                          gameProvider.setGameDificulty(level: 1);
                        },
                      ),
                      SizedBox(
                        width: 10,
                      ),
                      GameLevelRadioButton(
                        title: GameDificulty.medium.name,
                        value: GameDificulty.medium,
                        groupValue: gameProvider.gameDificulty,
                        onChanged: (value){
                          gameProvider.setGameDificulty(level: 2);
                        },
                      ),
                      SizedBox(
                        width: 10,
                      ),
                      GameLevelRadioButton(
                        title: GameDificulty.hard.name,
                        value: GameDificulty.hard,
                        groupValue: gameProvider.gameDificulty,
                        onChanged: (value){
                          gameProvider.setGameDificulty(level: 3);
                        },
                      ),
                    ],
                  ),
                ],
              )
              :
              SizedBox(
                height: 10,
              ),
              gameProvider.isLoading? const CircularProgressIndicator() :
              ElevatedButton(onPressed: (){
                // Navigate to game Screen
                gameProvider.setIsWhitesTurn(value: true);
                playGame(gameProvider : gameProvider);
              },
                child: Text("Play"),
              ),
              SizedBox(
                height: 20,
              ),
              gameProvider.vsComputer? const SizedBox.shrink() : Text(gameProvider.waitingText, textAlign: TextAlign.center,),
            ],
          ),
        );
      })
    );
  }
  void playGame({required GameProvider gameProvider}) async{
  final authProvider = context.read<AuthenticationProvider>();
    if(widget.isCustomTime){
      // for custom
      if(whiteTime<=0 || blackTime <= 0){
        showSnackBar( context : context, content: "Time Can't be 0");
        return;
      }
      //  1. start loading dialog
      gameProvider.setIsLoading(value: true);

      // 2. save time for both players and player color
      await gameProvider.setGameTime(
        newSavedWhitesTime: whiteTime.toString(),
        newSavedBlacksTime: blackTime.toString(),
        ).whenComplete(()async{
          if(gameProvider.vsComputer){// for computer--------
            gameProvider.setIsLoading(value: false);
            // 3. navigate to game screen
            Navigator.pushNamed(context, Constants.gameScreen);
          }
          else if(gameProvider.offlinePlay){
            gameProvider.setIsLoading(value: false);
            // Navigate to game Screen
            Navigator.pushNamed(context, Constants.gameScreen);
          }
          else{// for friend--------------
            // search for player
            await gameProvider.searchPlayer(
              userModel:authProvider.userModel!,
              onSuccess: (){
                //navigate to game screen
                if(gameProvider.waitingText==Constants.searchingPlayerText){
                  // stay on this screen and wait
                  gameProvider.checkIfOpponentJoined(
                    userModel: authProvider.userModel!,
                    onSuccess:(){
                      gameProvider.setIsLoading(value: false);
                      Navigator.pushNamed(context, Constants.gameScreen);
                    },
                  );
                }
                else{
                  // navigate to game Screen
                  gameProvider.setIsLoading(value: false);
                  Navigator.pushNamed(context, Constants.gameScreen);
                }
              },
              onFail: (error){
                gameProvider.setIsLoading(value: false);
                gameProvider.setWaitingText(value: "Something Wrong.\nTry Again!"); // as empty
                showSnackBar(context: context, content: error);
              },
            );
          }
        }
      );
    }
    else{// for non-custom------------
      //  others method here
      // check if is it incremantal
      // get value after + sign
      final String incremantalTime = widget.gameTime.split('+')[1];
      final String gameTime = widget.gameTime.split('+')[0];

      // check if incremantal equal to 0
      if(incremantalTime!='0'){
        // save the incremantal value
        gameProvider.setIncremantalValue(value: int.parse(incremantalTime));
      }
      gameProvider.setIsLoading(value: true);
      await gameProvider.setGameTime(
        newSavedWhitesTime: gameTime, 
        newSavedBlacksTime: gameTime,
        ).whenComplete(
          ()async{
            if(gameProvider.vsComputer){
              gameProvider.setIsLoading(value: false);
              // Navigate to game Screen
              Navigator.pushNamed(context, Constants.gameScreen);
            }
            else if(gameProvider.offlinePlay){
              gameProvider.setIsLoading(value: false);
              // Navigate to game offline play Screen
              Navigator.pushNamed(context, Constants.offlinePlayScreen);
            }
            else{
              // search for players
              await gameProvider.searchPlayer(
                userModel:authProvider.userModel!,
                onSuccess: (){
                  //navigate to game screen
                  if(gameProvider.waitingText==Constants.searchingPlayerText){
                    // stay on this screen and wait
                    gameProvider.checkIfOpponentJoined(
                      userModel: authProvider.userModel!,
                      onSuccess:(){
                        gameProvider.setIsLoading(value: false);
                        Navigator.pushNamed(context, Constants.gameScreen);
                      },
                    );
                  }
                  else{
                    // navigate to game Screen
                    gameProvider.setIsLoading(value: false);
                    Navigator.pushNamed(context, Constants.gameScreen);
                  }
                },
                onFail: (error){
                  gameProvider.setIsLoading(value: false);
                  gameProvider.setWaitingText(value: "Something Wrong.\nTry Again!"); // as empty
                  showSnackBar(context: context, content: error);
                },
              );
            }
          }
        );
    }
  }
}

