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
  final Function(PlayerColor?)? onChanged; // with paramiter
  final Function()? onChanged; // without paramiter

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