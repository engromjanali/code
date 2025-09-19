import 'package:momo/core/util/constants/constants.dart';

class OSItemModel {
  String title;
  String subTitle;
  String prompt;
  String example;
  List<String> inputImages; // user input
  List<String> imageBehaildText;

  OSItemModel({
    required this.title,
    required this.subTitle,
    required this.example,
    required this.prompt,
    required this.inputImages,
    required this.imageBehaildText,
  });

  factory OSItemModel.fromMap(Map<String, dynamic> map) {
    print(map[Constants.inputImages]);
    return OSItemModel(
      title: map[Constants.title],
      subTitle: map[Constants.subTitle],
      example: map[Constants.example],
      prompt: map[Constants.prompt],
      imageBehaildText: List<String>.from(map[Constants.imageBehaildText]??[]),
      inputImages:  List<String>.from(map[Constants.inputImages]??[]),
    );
  }

  Map<String, dynamic> toMap() {
    return {
      Constants.title: title,
      Constants.subTitle: subTitle,
      Constants.example: example,
      Constants.prompt: prompt,
      Constants.imageBehaildText: imageBehaildText,
      Constants.inputImages: inputImages,
    };
  }
}
