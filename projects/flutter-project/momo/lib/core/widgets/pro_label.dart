import 'dart:isolate';

import 'package:flutter/material.dart';
import 'package:get/get.dart';
import 'package:get/get_core/src/get_main.dart';
import 'package:momo/core/asset_manager/assets/font_menager.dart';
import 'package:momo/core/util/constants/colors.dart';
import 'package:momo/prsentation/screens/purchese_screen.dart';
import 'package:momo/core/widgets/get_this_pack.dart';

Widget proLabel() {
  return // the pro label.
  Positioned(
    top: 0,
    left: 0,
    right: 0,
    child: SafeArea(
      child: Padding(
        padding: const EdgeInsets.symmetric(horizontal: 10),
        child: Row(
          mainAxisAlignment: MainAxisAlignment.spaceBetween,
          children: [
            SizedBox(width: 60, height: 34),
            Text(
              "MOMO",
              style: TextStyle(
                fontFamily: FontMenager.SF_Compact_Rounded,
                fontWeight: FontWeight.bold,
                color: white,
                fontSize: 24,
                // fontWeight: FontWeight.bold,
                // fontStyle: FontStyle.normal
              ),
            ),
            
            GestureDetector(
              onTap: () {
                Get.to(() => PurcheseScreen());
              },
              child: Container(
                // padding: EdgeInsets.all(5),
                width: 60,
                height: 34,
                decoration: BoxDecoration(
                  borderRadius: BorderRadius.circular(20),
                  color: Colors.black.withAlpha(200),
                  gradient: proLinearGradient,
                ),
                child: Center(
                  child: Text(
                    "Pro",
                    style: TextStyle(
                      color: white,
                      fontWeight: FontWeight.w600,
                      fontSize: 16,
                    ),
                  ),
                ),
              ),
            ),
          ],
        ),
      ),
    ),
  );
}




