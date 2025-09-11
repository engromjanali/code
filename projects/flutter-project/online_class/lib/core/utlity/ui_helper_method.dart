
import 'package:flutter/material.dart';

GestureDetector meetFutures(
  Color color,
  IconData iconData,
  String name,
  Function() onTap,
){
  return GestureDetector(
    onTap: onTap,
    child: Column(
      children: [
        Container(
          height: 60,
          width: 60,
          decoration: BoxDecoration(
            color: color,
            borderRadius: BorderRadius.circular(10),
          ),
          child: Center(
            child: Icon(iconData, color: Colors.white,size: 30,),
          ),
        ),

        SizedBox(
          height: 5,
        ),

        Text(name, textAlign: TextAlign.center,),
      ],
    ),
  );
}