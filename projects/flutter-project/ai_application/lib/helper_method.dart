import 'package:flutter/material.dart';
import 'package:intl/intl.dart';

bool isKeyboardOpen(BuildContext context) {
  return MediaQuery.of(context).viewInsets.bottom > 0;
}

String getFormattedDate(String input) {
  String formatted = '--,--,----';
  try {
    // Split manually to handle single-digit month/day
    List<String> parts = input.split('-');
    int year = int.parse(parts[0]);
    int month = int.parse(parts[1]);
    int day = int.parse(parts[2]);

    DateTime date = DateTime(year, month, day);

    // Format to desired output
    formatted = DateFormat("dd MMMM, yyyy").format(date);
  } catch (e) {
    debugPrint("Error parsing date: $e");
  }

  // debugPrint("$input -> $formatted");
  return formatted;
}
