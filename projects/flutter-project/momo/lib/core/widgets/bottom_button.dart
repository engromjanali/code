import 'package:flutter/material.dart';

Widget getBottomRoundedButton({
  required String label,
  EdgeInsets margin = const EdgeInsets.all(20),
  required Function() ontap,
}) {
  return GestureDetector(
    onTap: ontap,
    child: Container(
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
  );
}


