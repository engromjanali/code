import 'package:flutter/material.dart';
import 'package:flutter/services.dart';
import 'package:get/get.dart';
import 'package:momo/core/asset_manager/assets/images.dart';
import 'package:momo/core/util/constants/all_enums.dart';
import 'package:momo/core/util/constants/colors.dart';
import 'package:momo/core/util/constants/text_style.dart';
import 'package:momo/core/widgets/CustomElevatedButton.dart';
import 'package:momo/core/widgets/bottom_button.dart';
import 'package:momo/core/widgets/get_raw_image_card.dart';
import 'package:momo/core/widgets/upload_screen.dart';

class GetStarted extends StatefulWidget {
  final ImageType imageType;
  const GetStarted({super.key, required this.imageType});

  @override
  State<GetStarted> createState() => _GetStartedState();
}

class _GetStartedState extends State<GetStarted> {
  @override
  Widget build(BuildContext context) {
    SystemChrome.setSystemUIOverlayStyle(
      SystemUiOverlayStyle(
        statusBarBrightness: Brightness.dark, // for ios, “The background of my status bar is dark, so please show light icons/text (white)”.
        statusBarIconBrightness: Brightness.light, // for android color, mean foreground color white
      ),
    );

    return SafeArea(

        child: Scaffold(
      backgroundColor: Colors.black,
      body: Column(
        children: [
          // top area
          Expanded(
            flex: 50,
            child: Row(
              crossAxisAlignment: CrossAxisAlignment.start,
              children: [
                // left blank area with close button/icon
                SizedBox(
                  width: 50,
                  child: IconButton(
                    iconSize: 30,
                    color: Colors.white,
                    icon: Icon(Icons.close),
                    onPressed: () {
                      Get.back();
                    },
                  ),
                ),
                // top image section 
                Expanded(
                  child: ClipRRect(
                    borderRadius: BorderRadius.circular(20),
                    child: SizedBox.expand(child: Image.asset(Images.myPhoto, fit: BoxFit.cover,)),
                  ),
                ),
                // right bnank area 
                SizedBox(width: 50),
              ],
            ),
          ),
              
          // down area
          Expanded(
            flex: 50,
            child: Container(
              padding: EdgeInsets.all(10),
              color: Colors.black,
              child: Column(
                children: [
                  Text(
                    "How it Work?",
                    style: getTitleStyle().copyWith(
                      fontSize: 28,
                      fontWeight: FontWeight.w800,
                    ),
                  ),
                  Expanded(
                    child: Container(
                      margin: EdgeInsets.all(5),
                      padding: EdgeInsets.only(
                        left: 10,
                        right: 10,
                        top: 20,
                        bottom: 10,
                      ),
                      decoration: BoxDecoration(
                        color: cardColor,
                        borderRadius: BorderRadius.circular(20),
                      ),
                      child: Column(
                        crossAxisAlignment: CrossAxisAlignment.start,
                        mainAxisAlignment: MainAxisAlignment.start,
                        children: [
                          Expanded(
                            child: Row(
                              mainAxisAlignment: MainAxisAlignment.start,
                              crossAxisAlignment: CrossAxisAlignment.start,
                              spacing: 10,
                              children: [
                                Icon(
                                  Icons.stars_rounded,
                                  color: Colors.white,
                                ),
                                Expanded(
                                  child: Text(
                                    "Ai Analizesyour apperance to create personalized photo and video content",
                                    style: getTitleStyle().copyWith(
                                      color: Colors.grey,
                                    ),
                                  ),
                                ),
                              ],
                            ),
                          ),
                          Divider(color: Colors.grey),
                          Expanded(
                            child: Row(
                              mainAxisAlignment: MainAxisAlignment.start,
                              crossAxisAlignment: CrossAxisAlignment.start,
                              spacing: 10,
                              children: [
                                Icon(
                                  Icons.photo_library_sharp,
                                  color: Colors.white,
                                ),
                                Expanded(
                                  child: Text(
                                    "Upload your photo to build your ai profile and start genarating unique creation.",
                                    style: getTitleStyle().copyWith(
                                      color: Colors.grey,
                                    ),
                                  ),
                                ),
                              ],
                            ),
                          ),
                        ],
                      ),
                    ),
                  ),
              
                  getBottomRoundedButton(
                    label: "Get Stared",
                    margin: EdgeInsets.only(bottom: 0, top: 10),
                    ontap: () {
                      Get.to(()=>UploadScreen());
                    },
                  ),
                ],
              ),
            ),
          ),
        ],
      ),
      ),
    );
  }
}
