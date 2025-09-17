import 'package:flutter/material.dart';
import 'package:momo/core/util/constants/colors.dart';

TextStyle getTitleStyle(){
  return const TextStyle(fontSize: 20, color: Colors.white, fontWeight: FontWeight.w600);
}
TextStyle getTitleStyleExplore(){
  return const TextStyle(fontSize: 30, color: Color(0xFFFFFFFF), fontWeight: FontWeight.w700,);
}
TextStyle getTitleStyleOneShot(){
  return const TextStyle(fontSize: 32, color: Color(0xFFFFFFFF), fontWeight: FontWeight.w700,);
}
TextStyle getSubtitleStyle(){
  return const TextStyle(fontSize: 14, color: subTitleColor, fontWeight: FontWeight.w600);
}