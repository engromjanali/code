
import 'package:chess_game/constants.dart';
import 'package:flutter/material.dart';

class PlayerColorRadioButton extends StatelessWidget{
  const PlayerColorRadioButton({
    super.key, 
    required this.title,
    required this.value, 
    required this.groupValue,
    required this.onChanged,
  });

  final String title;
  final PlayerColor value;
  final PlayerColor? groupValue;
  final Function(PlayerColor?)? onChanged; 

  @override
  Widget build(BuildContext context){
    return  RadioListTile<PlayerColor>(
      title: Text(title),
      value: value, 
      dense: true,
      shape: RoundedRectangleBorder(
        borderRadius: BorderRadius.circular(10),
      ),
      contentPadding: EdgeInsets.zero,
      tileColor: Colors.green[50],
      groupValue: groupValue, 
      onChanged: onChanged,
    );
  }
}
class GameLevelRadioButton extends StatelessWidget{
  const GameLevelRadioButton({
    super.key, 
    required this.title,
    required this.value, 
    required this.groupValue,
    required this.onChanged,
  });

  final String title;
  final GameDificulty value;
  final GameDificulty? groupValue;
  final Function(GameDificulty?)? onChanged; 

  @override
  Widget build(BuildContext context) {
    final capitalizedTitle = title[0].toUpperCase() + title.substring(1);
    return  Expanded(
      child: RadioListTile<GameDificulty>(
        title: Text(capitalizedTitle, style: const TextStyle(fontSize: 14 , fontWeight: FontWeight.bold),),
        value: value, 
        dense: true,
        shape: RoundedRectangleBorder(
          borderRadius: BorderRadius.circular(10),
        ),
        contentPadding: EdgeInsets.zero,
        tileColor: Colors.green[50],
        groupValue: groupValue, 
        onChanged: onChanged,
      ),
    );
  }
}


class BuildCustomTime extends StatelessWidget {
  const BuildCustomTime({
    super.key,
    required this.time,
    required this.onLeftArrowClicked,
    required this.onRightArrowClicked,
    });

    final String time;
    final Function() onLeftArrowClicked;
    final Function() onRightArrowClicked;

  @override
  Widget build(BuildContext context) {
    return Row(
      children: [
        IconButton(
          onPressed: onLeftArrowClicked,
           icon: Icon(Icons.arrow_back),
        ),

        Container(
          decoration: BoxDecoration(
            border: Border.all(width:0.5, color: Colors.black),
            borderRadius: BorderRadius.circular(10),
          ),
          child: Padding(
            padding: EdgeInsets.all(8.0),
            child:Center(
              child: Text("$time" , style: TextStyle(fontSize: 20, color: Colors.black),),
            ),
          ),
        ),
        
        IconButton(
          onPressed: onRightArrowClicked, 
          icon: Icon(Icons.arrow_forward),
        ),
      ],
                );
  }
}

showSnackBar({required BuildContext context, required String content}){
  ScaffoldMessenger.of(context).showSnackBar(SnackBar(content: Text(content),));
}