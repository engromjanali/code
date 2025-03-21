import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';

class reactangle_button extends StatelessWidget{
  final String btnName;
  final TextStyle? btnStyle;
  final Icon? icon;
  final Color? bgColor;
  final VoidCallback? callback;
  final Color? shadoColor;
  final elevation;

  reactangle_button({
    required this.btnName,
    this.btnStyle ,
    this.icon,
    this.bgColor = Colors.white,
    this.callback,
    this.shadoColor,
    this.elevation =1.0,
  }){}
  @override
  Widget build(BuildContext context) {
    // TODO: implement build
    return ElevatedButton(

        onPressed: () {
          if(callback!=null){ // if we did not pass as argument callback we get null value when we fet error, that's why we have to check null or not.
            callback!();
          }
        },
        child: icon != null ? Row(
          mainAxisAlignment: MainAxisAlignment.center,
          children: [
            icon!,
            SizedBox(
              width: 10,
            ),
            Text(btnName, style: btnStyle),
          ],
        ) : Text(btnName, style: btnStyle,),
        style: ElevatedButton.styleFrom(
          backgroundColor: bgColor,
          shadowColor: shadoColor??bgColor,
          elevation: elevation, // shado in under like 3d
          shape: RoundedRectangleBorder(
            borderRadius: BorderRadius.only(topRight: Radius.circular(10), bottomLeft: Radius.circular(10)
            )
          )
      ),
    );
  }
}