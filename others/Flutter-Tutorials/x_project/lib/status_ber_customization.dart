import 'package:flutter/material.dart';
import 'package:flutter/services.dart';
import 'package:get/get.dart';
import 'package:momo/core/constants/all_enums.dart';
import 'package:momo/core/constants/colors.dart';
import 'package:momo/core/constants/text_style.dart';
import 'package:momo/prsentation/widgets/CustomElevatedButton.dart';
import 'package:momo/prsentation/widgets/bottom_button.dart';
import 'package:momo/prsentation/widgets/get_raw_image_card.dart';

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
      body: Container(
        
      ),
        )
    );
  }
}
