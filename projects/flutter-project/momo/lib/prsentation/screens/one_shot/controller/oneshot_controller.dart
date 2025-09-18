import 'package:flutter/material.dart';
import 'package:momo/core/util/constants/constants.dart';
import 'package:momo/data/model/explore/explore_model.dart';
import 'package:momo/data/model/one_shot/oneshot_model.dart';

class COneShot extends ChangeNotifier {
  List<OneshotModel> _oneShotList = [];

  void notify() {
    notifyListeners();
  }

  void setExploreList(List<OneshotModel> oneShotList) {
    _oneShotList = oneShotList;

    // for tasting perpose
    _oneShotList = [
      OneshotModel(
        title: "LinkedIn",
        items: [
          {
            Constants.title: "title",
            Constants.subTitle: "subTitle",
            Constants.example: "xyz.jpg",
            Constants.prompt: "make a image in sunlight",
            Constants.imageBehaildText: [
              "set a image here",
              "set a image here-2",
            ],
            Constants.inputImages: [],
          },
          {
            Constants.title: "title",
            Constants.subTitle: "subTitle",
            Constants.example: "xyz.jpg",
            Constants.prompt: "make a image in sunlight",
            Constants.imageBehaildText: [
              "set a image here",
              "set a image here-2",
            ],
            Constants.inputImages: [],
          },
          {
            Constants.title: "title",
            Constants.subTitle: "subTitle",
            Constants.example: "xyz.jpg",
            Constants.prompt: "make a image in sunlight",
            Constants.imageBehaildText: [
              "set a image here",
              "set a image here-2",
            ],
            Constants.inputImages: [],
          },
          {
            Constants.title: "title",
            Constants.subTitle: "subTitle",
            Constants.example: "xyz.jpg",
            Constants.prompt: "make a image in sunlight",
            Constants.imageBehaildText: [
              "set a image here",
              "set a image here-2",
            ],
            Constants.inputImages: [],
          },
        ],
      ),
      OneshotModel(
        title: "LinkedIn",
        items: [
          {
            Constants.title: "title",
            Constants.subTitle: "subTitle",
            Constants.example: "xyz.jpg",
            Constants.prompt: "make a image in sunlight",
            Constants.imageBehaildText: [
              "set a image here",
              "set a image here-2",
            ],
            Constants.inputImages: [],
          },
          {
            Constants.title: "title",
            Constants.subTitle: "subTitle",
            Constants.example: "xyz.jpg",
            Constants.prompt: "make a image in sunlight",
            Constants.imageBehaildText: [
              "set a image here",
              "set a image here-2",
            ],
            Constants.inputImages: [],
          },
          {
            Constants.title: "title",
            Constants.subTitle: "subTitle",
            Constants.example: "xyz.jpg",
            Constants.prompt: "make a image in sunlight",
            Constants.imageBehaildText: [
              "set a image here",
              "set a image here-2",
            ],
            Constants.inputImages: [],
          },
          {
            Constants.title: "title",
            Constants.subTitle: "subTitle",
            Constants.example: "xyz.jpg",
            Constants.prompt: "make a image in sunlight",
            Constants.imageBehaildText: [
              "set a image here",
              "set a image here-2",
            ],
            Constants.inputImages: [],
          },
        ],
      ),
      OneshotModel(
        title: "LinkedIn",
        items: [
          {
            Constants.title: "title",
            Constants.subTitle: "subTitle",
            Constants.example: "xyz.jpg",
            Constants.prompt: "make a image in sunlight",
            Constants.imageBehaildText: [
              "set a image here",
              "set a image here-2",
            ],
            Constants.inputImages: [],
          },
          {
            Constants.title: "title",
            Constants.subTitle: "subTitle",
            Constants.example: "xyz.jpg",
            Constants.prompt: "make a image in sunlight",
            Constants.imageBehaildText: [
              "set a image here",
              "set a image here-2",
            ],
            Constants.inputImages: [],
          },
        ],
      ),
      OneshotModel(
        title: "LinkedIn",
        items: [
          {
            Constants.title: "title",
            Constants.subTitle: "subTitle",
            Constants.example: "xyz.jpg",
            Constants.prompt: "make a image in sunlight",
            Constants.imageBehaildText: [
              "set a image here",
              "set a image here-2",
            ],
            Constants.inputImages: [],
          },
          {
            Constants.title: "title",
            Constants.subTitle: "subTitle",
            Constants.example: "xyz.jpg",
            Constants.prompt: "make a image in sunlight",
            Constants.imageBehaildText: [
              "set a image here",
              "set a image here-2",
            ],
            Constants.inputImages: [],
          },
          {
            Constants.title: "title",
            Constants.subTitle: "subTitle",
            Constants.example: "xyz.jpg",
            Constants.prompt: "make a image in sunlight",
            Constants.imageBehaildText: [
              "set a image here",
              "set a image here-2",
            ],
            Constants.inputImages: [],
          },
          {
            Constants.title: "title",
            Constants.subTitle: "subTitle",
            Constants.example: "xyz.jpg",
            Constants.prompt: "make a image in sunlight",
            Constants.imageBehaildText: [
              "set a image here",
              "set a image here-2",
            ],
            Constants.inputImages: [],
          },
        ],
      ),
      OneshotModel(
        title: "LinkedIn",
        items: [
          {
            Constants.title: "title",
            Constants.subTitle: "subTitle",
            Constants.example: "xyz.jpg",
            Constants.prompt: "make a image in sunlight",
            Constants.imageBehaildText: [
              "set a image here",
              "set a image here-2",
            ],
            Constants.inputImages: [],
          },
          {
            Constants.title: "title",
            Constants.subTitle: "subTitle",
            Constants.example: "xyz.jpg",
            Constants.prompt: "make a image in sunlight",
            Constants.imageBehaildText: [
              "set a image here",
              "set a image here-2",
            ],
            Constants.inputImages: [],
          },

          {
            Constants.title: "title",
            Constants.subTitle: "subTitle",
            Constants.example: "xyz.jpg",
            Constants.prompt: "make a image in sunlight",
            Constants.imageBehaildText: [
              "set a image here",
              "set a image here-2",
            ],
            Constants.inputImages: [],
          },
        ],
      ),
    ];
    notify();
  }

  List<OneshotModel> get oneShotList => _oneShotList;
}
