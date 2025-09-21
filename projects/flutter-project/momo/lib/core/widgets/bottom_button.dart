import 'package:flutter/material.dart';

Widget getBottomRoundedButton({
  required String label,
  EdgeInsets margin = const EdgeInsets.only(bottom: 20,left: 10,right: 10,),
  required Function() ontap,
  bool isEnabled = true,
}) {
  return GestureDetector(
    onTap: ontap,
    child: Stack(
      
      children: [
        Container(
          height: 60,
          margin: margin,
          decoration: BoxDecoration(
            borderRadius: BorderRadius.circular(10),
            color: Colors.white,
          ),
          alignment: AlignmentGeometry.center,
          child: Text(
            "$label",
            style: TextStyle(fontSize: 20, fontWeight: FontWeight.bold),
          ),
        ),
        if(!isEnabled)Positioned.fill(
          child: Container(
            decoration: BoxDecoration(
              color: Colors.black.withAlpha(120)
            ),
          ),
        )
      ],
    ),
  );
}


