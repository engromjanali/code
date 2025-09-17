import 'package:flutter/material.dart';

Widget customElevatedButton({
    required Function() ontap,
    required String label,
    Color backgroundColor = Colors.black,
    Color foregroundColor = Colors.white,
    EdgeInsets margin = const EdgeInsets.all(10),
  }) {
    return Padding(
      padding: margin,
      child: ElevatedButton(
        style: ElevatedButton.styleFrom(
          backgroundColor: backgroundColor,
          foregroundColor: foregroundColor,
          minimumSize: Size(double.maxFinite, 30),
          elevation: 0,
          shape: RoundedRectangleBorder(
            borderRadius: BorderRadius.circular(10),
          ),
        ),
        onPressed: ontap,
        child: Padding(
          padding: const EdgeInsets.all(10.0),
          child: Text(
            label,
            style: TextStyle(fontSize: 18, fontWeight: FontWeight.w600),
          ),
        ),
      ),
    );
  }