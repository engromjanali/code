import 'dart:ui';

import 'package:flutter/material.dart';
import 'package:get/get.dart';
import 'package:momo/core/util/constants/all_enums.dart';
import 'package:momo/core/util/constants/colors.dart';
import 'package:momo/core/util/constants/constants.dart';
import 'package:momo/core/util/constants/text_style.dart';
import 'package:momo/core/widgets/CustomElevatedButton.dart';

Future<SelectImageFrom> customImageSourceSelectionDialog() async {
  SelectImageFrom? res = await Get.dialog(
    Dialog(
      backgroundColor: Colors.transparent,
      child: ClipRRect(
        borderRadius: BorderRadius.circular(20),
        child: BackdropFilter(
          filter:  ImageFilter.blur(sigmaX: 10, sigmaY: 10),
          child: Container(
            decoration: BoxDecoration(
                  color: Colors.white.withOpacity(0.2), // transparent white
                  borderRadius: BorderRadius.circular(20),
                  border: Border.all(
                    color: Colors.white.withOpacity(0.3),
                    width: 1.5,
                  ),
                ),
            child: Column(
              mainAxisSize: MainAxisSize.min,
              children: [
                Row(
                  children: [
                    IconButton(onPressed: (){
                      Get.back();
                    }, icon: Icon(Icons.close, color: Colors.white,))
                  ],
                ),
                Text(
                  "Take photo from",
                  style: getTitleStyle().copyWith(fontSize: 24),
                ),
                SizedBox(
                  height: 40,
                ),
          
                customElevatedButton(
                  ontap: () {
                    Get.back(result: SelectImageFrom.gellary);
                  },
                  label: "Photo Library",
                  backgroundColor: Colors.white,
                  // backgroundColor: Colors.grey.withAlpha(100),
                  foregroundColor: Colors.black,
                  margin: EdgeInsets.all(10),
                ),
                customElevatedButton(
                  ontap: () {
                    Get.back(result: SelectImageFrom.camera);
                  },
                  label: "Camera",
                  backgroundColor: Colors.white,
                  foregroundColor: Colors.black,
                  margin: EdgeInsets.only(bottom: 30,top: 10, left: 10, right: 10 ),
                ),
              ],
            ),
          ),
        ),
      ),
    ),
  );
  return res ?? SelectImageFrom.unSelected;
}
