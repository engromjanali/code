import 'package:flutter/material.dart';

// TimeOfDay to String time
String formatTimeOfDay(TimeOfDay time) {
  final hour = time.hourOfPeriod == 0 ? 12 : time.hourOfPeriod;
  final minute = time.minute.toString().padLeft(2, '0');
  final period = time.period == DayPeriod.am ? 'AM' : 'PM';
  return '$hour:$minute $period';
}

void add_in_bazer_List(List<Map<String, dynamic>> list, Map<String,dynamic> map){
  list.add(map);
}