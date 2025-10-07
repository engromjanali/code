import 'package:flutter/material.dart';
import 'package:get/get.dart';
import 'package:get/get_core/src/get_main.dart';
import 'package:momo/core/asset_manager/assets/images.dart';
import 'package:momo/core/util/constants/colors.dart';
import 'package:momo/core/util/constants/text_style.dart';
import 'package:momo/core/widgets/bottom_button.dart';
import 'package:momo/prsentation/screens/home_page.dart';

class SShare extends StatefulWidget {
  const SShare({super.key});

  @override
  State<SShare> createState() => _SShareState();
}

class _SShareState extends State<SShare> {
  List<String> badPhotosList = [
    Images.myPhoto,
    Images.myPhoto,
    Images.myPhoto,
    Images.myPhoto,
    Images.myPhoto,
  ];

  int selectedIndex = 0;

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      backgroundColor: Colors.black,
      body: SafeArea(
        child: Column(
          children: [
            // if i use circle_avater and set as "child" the image overflow by corner 
            // or if i set in circle avater as "background image" it set as fit.cover
            // ClipOval help us to show a image as circuler shape.
            ClipOval(child: Image.asset(Images.myPhoto,height: 150,width: 150, fit: BoxFit.fill)),
          ],
        ),
      ),
    );
  }
}