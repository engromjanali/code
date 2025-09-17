import 'package:flutter/material.dart';
import 'package:momo/core/helper/assets/images.dart';
import 'package:momo/core/util/constants/colors.dart';
import 'package:momo/core/util/constants/text_style.dart';

Widget getImageCard({
    required bool showImage,
    required String label,
    }) {
    return Container(
      margin: EdgeInsets.all(5),
      decoration: BoxDecoration(
        color: cardColor,
        borderRadius: BorderRadius.circular(10),

        // image: DecorationImage(image: ,fit: BoxFit.fill,))
      ),
      child: showImage
          ? ClipRRect(
              borderRadius: BorderRadius.circular(10),
              child: Stack(
                children: [
                  SizedBox.expand(
                    child: Image.asset(
                      Images.myPhoto, 
                      fit: BoxFit.cover,
                      alignment : Alignment.topCenter,
                    ),
                  ),
                  Positioned(
                    top: 5,
                    right: 5,
                    child: IconButton(
                      onPressed: () {},
                      icon: Icon(Icons.cancel, color: Colors.white, size: 20),
                    ),
                  ),
                ],
              ),
            )
          : Container(
              padding: EdgeInsets.all(10),
              child: Column(
                crossAxisAlignment: CrossAxisAlignment.center,
                mainAxisAlignment: MainAxisAlignment.center,
                children: [
                  Icon(
                    Icons.image_search_sharp,
                    size: 40,
                    color: subTitleColor,
                  ),
                  Text(
                    label,
                    style: getSubtitleStyle(),
                    textAlign: TextAlign.center,
                  ),
                ],
              ),
            ),
    );
  }