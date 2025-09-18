import 'package:momo/core/util/constants/constants.dart';

class ExploreModel {
  String title;
  List<Map<String, dynamic>> items;

  ExploreModel({required this.title, required this.items});

  factory ExploreModel.fromMap(Map<String, dynamic> map) {
    return ExploreModel(title: map[Constants.title], items: map[Constants.items]);
  }

  Map<String, dynamic> toMap() {
    return {Constants.title: title, Constants.items: items};
  }
}

