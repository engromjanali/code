import 'package:flutter/material.dart';
import 'package:momo/core/util/constants/constants.dart';
import 'package:momo/data/model/explore/explore_model.dart';

class CExplore extends ChangeNotifier {
  List<ExploreModel> _exploreList = [];

  void notify(){
    notifyListeners();
  }

  void setExploreList(List<ExploreModel> exploreList) {
    _exploreList = exploreList;

    // for tasting perpose 
    _exploreList = [
      ExploreModel(
        title: "LinkedIn",
        items: [
          {
            Constants.title: "suit",
            Constants.details:
                "Business-oriented attire and demeanor for corporate settings",
            Constants.spacificaton: [
              "Corporate Headshots",
              "Resume Styling",
              "Networking Events",
              "Professional Branding",
            ],
            Constants.example: [
              "professional_1.png",
              "professional_2.png",
              "professional_3.png",
              "professional_4.png",
            ],
          },
          {
            Constants.title: "suit",
            Constants.details:
                "Business-oriented attire and demeanor for corporate settings",
            Constants.spacificaton: [
              "Corporate Headshots",
              "Resume Styling",
              "Networking Events",
              "Professional Branding",
            ],
            Constants.example: [
              "professional_1.png",
              "professional_2.png",
              "professional_3.png",
              "professional_4.png",
            ],
          },
          {
            Constants.title: "suit",
            Constants.details:
                "Business-oriented attire and demeanor for corporate settings",
            Constants.spacificaton: [
              "Corporate Headshots",
              "Resume Styling",
              "Networking Events",
              "Professional Branding",
            ],
            Constants.example: [
              "professional_1.png",
              "professional_2.png",
              "professional_3.png",
              "professional_4.png",
            ],
          },
          {
            Constants.title: "suit",
            Constants.details:
                "Business-oriented attire and demeanor for corporate settings",
            Constants.spacificaton: [
              "Corporate Headshots",
              "Resume Styling",
              "Networking Events",
              "Professional Branding",
            ],
            Constants.example: [
              "professional_1.png",
              "professional_2.png",
              "professional_3.png",
              "professional_4.png",
            ],
          },
          {
            Constants.title: "suit",
            Constants.details:
                "Business-oriented attire and demeanor for corporate settings",
            Constants.spacificaton: [
              "Corporate Headshots",
              "Resume Styling",
              "Networking Events",
              "Professional Branding",
            ],
            Constants.example: [
              "professional_1.png",
              "professional_2.png",
              "professional_3.png",
              "professional_4.png",
            ],
          },
        ],
      ),
      ExploreModel(
        title: "LinkedIn1",
        items: [
          {
            Constants.title: "suit1",
            Constants.details:
                "Business-oriented attire and demeanor for corporate settings1",
            Constants.spacificaton: [
              "Corporate Headshots1",
              "Resume Styling1",
              "Networking Events1",
              "Professional Branding1",
            ],
            Constants.example: [
              "professional_1.png1",
              "professional_2.png1",
              "professional_3.png1",
              "professional_4.png1",
            ],
          },
        ],
      ),
      ExploreModel(
        title: "LinkedIn2",
        items: [
          {
            Constants.title: "suit2",
            Constants.details:
                "Business-oriented attire and demeanor for corporate settings2",
            Constants.spacificaton: [
              "Corporate Headshots2",
              "Resume Styling2",
              "Networking Events2",
              "Professional Branding2",
            ],
            Constants.example: [
              "professional_1.png2",
              "professional_2.png2",
              "professional_3.png2",
              "professional_4.png2",
            ],
          },
        ],
      ),
    ];
    notify();
  }

  List<ExploreModel> get exploreList => _exploreList;
}
