import 'package:flutter/material.dart';
class UiHelperMethod {

}

Widget getItemType ({ required String label, IconData? icon, String description= "" ,required Function() ontap}){
  return InkWell(
    onTap:ontap,
    child: Card(
      shadowColor: Colors.red,
      elevation: 6.0,
      child: Column(
        mainAxisAlignment: MainAxisAlignment.center,
        children: [
          icon != null ? Icon(icon, size: 50,): SizedBox.shrink(),
          const SizedBox( height: 10,),
          Text(label, style: TextStyle(fontSize: 16,),textAlign: TextAlign.center, ),
          Text(description,style: TextStyle(fontSize: 10),)
        ],
      ),
    ),
  );
}

Widget getButton ({ required String label, IconData? icon, required Function() ontap, Color color = Colors.blue}){
  return MaterialButton(
    shape:RoundedRectangleBorder(
      
      borderRadius: BorderRadius.circular(50)
    ),
    onPressed: ontap,
    height: 50,
    color: color,
    child: Center(
      child: icon==null? Text(label,style: TextStyle(fontSize: 20),) : Row(mainAxisAlignment:MainAxisAlignment.center, children:[Icon(icon), Text(label,style: TextStyle(fontSize: 20),),]),
    ),
  );
}

