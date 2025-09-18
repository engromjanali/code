import 'package:flutter/material.dart';
import 'package:get/get.dart';
import 'package:momo/core/helper/assets/images.dart';
import 'package:momo/core/widgets/get_this_pack.dart';

Widget getImageCard({required String label, int ? numberOfPhoto}){
  return  GestureDetector(
    onTap: () {
      Get.to(()=>GetStartedScreen());
    },
    child: Padding(
      padding: const EdgeInsets.all(8.0),
      child: ClipRRect(
        borderRadius: BorderRadiusGeometry.circular(10),
        child: Stack(
          fit: StackFit.expand,
          clipBehavior: Clip.hardEdge,
          children: [
            Image.asset(
              Images.myPhoto, // Replace with your image path
              fit: BoxFit.cover,
            ),
            Container(
                decoration: BoxDecoration(
                  gradient: LinearGradient(
                    begin: Alignment.bottomCenter, // start at bottom
                    end: Alignment.topCenter,  
                    // transform: GradientRotation(4),
                    colors: [
                      Colors.black,    // bottom color
                      Colors.transparent, // top color
                      Colors.transparent, // top color
                    ],
                  ),
                ),
            ),  
            Positioned(
              // top: 250,
              child: Column(
                      mainAxisAlignment: MainAxisAlignment.end,
                      children: [
                        // Text("MOMO"),
                        Text(label, textAlign: TextAlign.center, style: TextStyle(fontWeight: FontWeight.w600, fontSize: 18, color: Colors.white)),
                        if(numberOfPhoto!=null)Text(numberOfPhoto.toString(), textAlign: TextAlign.center, style: TextStyle(fontWeight: FontWeight.w600, fontSize: 16, color: Colors.white)),
                        SizedBox(height: 20,),
                    ]
                  ),
            ),
          ],
        ),
      )
    ),
  );
}