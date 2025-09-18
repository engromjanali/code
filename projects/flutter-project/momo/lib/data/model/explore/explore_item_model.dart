
import 'package:momo/core/util/constants/constants.dart';

class EItemModel {
  String title;
  String details;
  List<String> spacificaton;
  List<String> example;

  EItemModel({
    required this.title,
    required this.details,
    required this.spacificaton,
    required this.example,
  });

  factory EItemModel.fromMap(Map<String, dynamic> map) {
    return EItemModel(
      title: map[Constants.title],
      details: map[Constants.details],
      spacificaton: map[Constants.spacificaton],
      example: map[Constants.example],
    );
  }

  Map<String, dynamic> toMap() {
    return {
      Constants.title: title,
      Constants.details: details,
      Constants.spacificaton: spacificaton,
      Constants.example: example,
    };
  }
}