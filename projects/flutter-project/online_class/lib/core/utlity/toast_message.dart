import 'package:cherry_toast/cherry_toast.dart';
import 'package:cherry_toast/resources/arrays.dart';
import 'package:flutter/material.dart';

void showWorningToast({required BuildContext context, String? title, required String description }){
  CherryToast.warning(
  title: Text(title??"Worning"),
  description:  Text(description, style: TextStyle(color: Colors.black)),

  animationType:  AnimationType.fromLeft,

  action:  Text("Backup data", style: TextStyle(color: Colors.black)),

  actionHandler: (){

  print("Hello World!!");
  },
  ).show(context);
}


void showInfoToast({required BuildContext context, String? title, required String description }){
  CherryToast.info(

  title:  Text(title?? "Info", style: TextStyle(color: Colors.black)),
  description: Text(description),
  // action: Text("ok", style: TextStyle(color: Colors.black)),
  // horizontalAlignment: CrossAxisAlignment.end,
  // iconWidget: Icon(Icons.abc_outlined),
  
  toastDuration: Duration(seconds: 3),
  animationDuration: Duration(seconds: 1),
  animationCurve: Curves.easeInOutCirc,
  actionHandler: (){

  print("Action button pressed");

  },
  

  ).show(context);

}
void showSuccessToast({required BuildContext context, String? title, required String description }){
  CherryToast.success(
  title:  Text(title?? "Successed", style: TextStyle(color: Colors.black)),
  description: Text(description),
  // action: Text("ok", style: TextStyle(color: Colors.black)),
  // horizontalAlignment: CrossAxisAlignment.end,
  // iconWidget: Icon(Icons.abc_outlined),
  toastDuration: Duration(seconds: 3),
  animationDuration: Duration(seconds: 1),
  animationCurve: Curves.easeInOutCirc,
  actionHandler: (){
  print("Action button pressed");
  },
  ).show(context);
}


void showErrorToast({required BuildContext context, String? title, required String description }){
  CherryToast.error(
    title: Text(title??"Error"),
  description:  Text(description, style: TextStyle(color: Colors.black)),

  animationType:  AnimationType.fromRight,

  animationDuration:  Duration(milliseconds:  1000),

  autoDismiss:  true

  ).show(context);

}



