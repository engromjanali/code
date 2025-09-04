import 'package:flutter/material.dart';



Widget getRoundedButton(){
  return Container(
    margin: EdgeInsets.symmetric(horizontal: 8),
    decoration: BoxDecoration(
      // border: Border.all(color: )
      color: Colors.purpleAccent.withAlpha(30),
      borderRadius: BorderRadius.circular(20)
    ),
    child: Padding(
      padding: const EdgeInsets.all(8.0),
      child: Row(
        spacing: 10,
        children: [
          Icon(Icons.rocket_launch_outlined),
          Text("Upgrade", style: TextStyle(color: Colors.purpleAccent, fontWeight: FontWeight.w700),)
        ],
      ),
    ),
  );
}

Widget getSuggestionRoundedButton({required IconData icon, required String text,}){
  return Container(
    height: 30,
    margin: EdgeInsets.symmetric(horizontal: 8),
    decoration: BoxDecoration(
      border: Border.all(color: Colors.purpleAccent ),
      // color: Colors.purpleAccent.withAlpha(30),
      borderRadius: BorderRadius.circular(20)
    ),
    child: Padding(
      padding: const EdgeInsets.all(8.0),
      child: Row(
        spacing: 10,
        children: [
          Icon(icon),
          Text(text, style: TextStyle(color: Colors.black, fontWeight: FontWeight.w700),),
          Icon(Icons.keyboard_arrow_down_sharp),
        ],
      ),
    ),
  );
}
