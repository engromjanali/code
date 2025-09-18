

import 'package:momo/core/util/constants/constants.dart';

class OneshotModel {
  String title;
  List<Map<String, dynamic>> items;

  OneshotModel({required this.title, required this.items});

  factory OneshotModel.fromMap(Map<String, dynamic> map) {
    return OneshotModel(title: map[Constants.title], items: map[Constants.items]);
  }

  Map<String, dynamic> toMap() {
    return {Constants.title: title, Constants.items: items};
  }
}

