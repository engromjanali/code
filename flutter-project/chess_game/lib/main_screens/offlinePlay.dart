import 'package:chess_game/providers/game_provider.dart';
import 'package:flutter/material.dart';
import 'package:flutter_chess_board/flutter_chess_board.dart';
import 'package:provider/provider.dart';
import '../constants.dart' show Constants;
import '../helper/helper_method.dart';
import '../providers/authantication_provider.dart';
import '../services/assets_manager.dart';

class OfflinePlayScreen extends StatefulWidget {
  const OfflinePlayScreen({super.key});

  @override
  State<OfflinePlayScreen> createState() => _OfflinePlayScreenState();
}


class _OfflinePlayScreenState extends State<OfflinePlayScreen> {
  ChessBoardController boardController = ChessBoardController();
  String currentMove = "";
  bool isGameOver = false;
  dynamic checked = true;

  @override
  void initState() {
    boardController.addListener(() {
      isGameOver = isGameOver || boardController.isCheckMate();
      isGameOver = isGameOver || boardController.isStaleMate();
      isGameOver = isGameOver || boardController.isDraw();

      _getCurrentMove();
      if(isGameOver){
        showDialogs(context: context);
      }
    });
    super.initState();
  }

  void _getCurrentMove() {
    if (boardController.game.history.isNotEmpty) {
      var lastMove = boardController.game.history.last;
      setState(() {
        currentMove = "${lastMove.move.fromAlgebraic} ${lastMove.move.toAlgebraic}"; // e.g., "e2 e4"
      });
    }
  }

  @override
  Widget build(BuildContext context) {
    final authProvider = context.read<AuthenticationProvider>();
    final gameProvider = context.read<GameProvider>();
    return Scaffold(
      appBar: AppBar(
        title: Text("Offline Chess"),
        actions: [
          IconButton(onPressed: (){
            setState(() {
              boardController.undoMove();
            });
          }, icon: Icon(Icons.undo),)
        ],
      ),
      body: Container(

        child: Column(
          mainAxisAlignment: MainAxisAlignment.start,
          crossAxisAlignment: CrossAxisAlignment.start,
          children: [
            Row(
              children: [
                Checkbox(
                  value: checked,
                  onChanged: (value) {
                    setState(() {
                      checked = value;
                    });
                  },
                ),
                Text("Show Moved Shadow"),
              ],
            ),
            Expanded(
              child: Padding(
                padding: const EdgeInsets.all(8.0),
                child: Column(
                  mainAxisAlignment: MainAxisAlignment.center,
                  children: [
                    Text("Current Move: $currentMove", style: TextStyle(fontSize: 20)),
                    ListTile(
                      leading: CircleAvatar(
                        radius: 15,
                        backgroundImage: AssetImage(AssetsManager.userIcon),
                        backgroundColor: Colors.green,
                      ),
                      title: Text("Opponent"),
                      subtitle: Text('Rating: ${1200}'),
                      trailing: Text(
                        getTimerToDisplay(gameProvider: gameProvider, isUser:false),
                        style: const TextStyle(fontSize: 16),
                      ),
                    ),
                    SizedBox(
                      height: 10,
                    ),
                    ChessBoard(
                      controller: boardController,
                      boardColor: BoardColor.green,
                      boardOrientation: gameProvider.player==0? PlayerColor.white:PlayerColor.black,
                      arrows: currentMove != ""  && checked? [BoardArrow(from: currentMove!=""? currentMove.substring(0,2):"a2", to: currentMove!=""?currentMove.substring(3,5):"a2", color: Colors.black38),] : [],
                    ),
                    SizedBox(
                      height: 10,
                    ),
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
                    ),
                  ],
                ),
              ),
            ),
          ],
        ),
      ),
    );
  }



  void showDialogs({required BuildContext context,}){
    showDialog(context: context, barrierDismissible: false, builder: (context)=> AlertDialog(
      title: Text("Game Over", textAlign: TextAlign.center,),
      content: Text("The game has been over \n play new game.", textAlign: TextAlign.center,),
      actions: [
        TextButton(onPressed: (){
          Navigator.pop(context);
          Navigator.pushNamedAndRemoveUntil(context, Constants.homeScreen, (route)=>false);
        }, child: Text("Ok",style: TextStyle(color:  Colors.red,),)),
        // TextButton(onPressed: (){
        //   Navigator.pop(context);
        // }, child: Text("New Game",style: TextStyle(color:  Colors.red,),)),
      ],
    ));
  }
}
