import 'package:flutter/material.dart';

Color get cardColor =>  Colors.grey.withAlpha(50);
Color get white => Color(0xffFFFFFF);
const Color subTitleColor = Colors.grey;
var proLinearGradient = LinearGradient(
  begin: AlignmentGeometry.topRight,
  end: AlignmentGeometry.bottomLeft,
  colors: [
    Color(0xFF01FD8C),
    Color(0xFF2FDFFF),
  ],
);