// here we are going to use custom text what will be useable from any others class, we can use it for any widget also.
import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';

class style_font extends StatefulWidget{

  TextStyle text10()
  {
    return TextStyle(
      fontSize: 10,
    );
  }

  TextStyle text14({
    fontSize = 14.0,
    color = Colors.black,
    fontStyle = FontStyle.normal,
    fontWeight = FontWeight.normal,
  }){
    return TextStyle(
      fontSize: fontSize,
      color: color,
      fontStyle: fontStyle,
      fontWeight: fontWeight,
    );
  }

  TextStyle text18({
    fontSize = 18.0,
    color = Colors.red,
    fontStyle = FontStyle.italic,
    fontWeight = FontWeight.normal,
  }){
    return TextStyle(
      fontSize: fontSize,
      color: color,
      fontStyle: fontStyle,
      fontWeight: fontWeight,
    );
  }

  @override
  State<StatefulWidget> createState() {
    // TODO: implement createState
    throw UnimplementedError();
  }

}