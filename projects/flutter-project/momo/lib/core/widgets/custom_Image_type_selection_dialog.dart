import 'package:flutter/material.dart';
import 'package:get/get.dart';
import 'package:momo/core/util/constants/all_enums.dart';
import 'package:momo/core/util/constants/colors.dart';
import 'package:momo/core/util/constants/constants.dart';
import 'package:momo/core/util/constants/text_style.dart';
import 'package:momo/core/widgets/CustomElevatedButton.dart';

Future<SelectImageFrom> customImageTypeSelectionDialog() async {
  SelectImageFrom? res = await Get.dialog(
    Dialog(
      child: ClipRRect(
        borderRadius: BorderRadius.circular(20),
        child: Container(
          color: Colors.white70,
          child: Column(
            mainAxisSize: MainAxisSize.min,
            children: [
              Row(
                children: [
                  IconButton(onPressed: (){
                    Get.back();
                  }, icon: Icon(Icons.close))
                ],
              ),
              Text(
                "Take photo from",
                style: getTitleStyle().copyWith(color: Colors.black, fontSize: 24),
              ),
              SizedBox(
                height: 10,
              ),

              customElevatedButton(
                ontap: () {
                  Get.back(result: SelectImageFrom.gellary);
                },
                label: "Photo Library",
                backgroundColor: Colors.grey.withAlpha(100),
                foregroundColor: Colors.black,
                margin: EdgeInsets.all(10),
              ),
              customElevatedButton(
                ontap: () {
                  Get.back(result: SelectImageFrom.camera);
                },
                label: "Camera",
                backgroundColor: Colors.grey.withAlpha(100),
                foregroundColor: Colors.black,
                margin: EdgeInsets.only(bottom: 30,top: 10, left: 10, right: 10 ),
              ),
            ],
          ),
        ),
      ),
    ),
  );
  return res ?? SelectImageFrom.unSelected;
}
