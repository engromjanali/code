
import 'package:flutter/material.dart';
import 'package:get/get.dart';
import 'package:momo/core/helper/assets/images.dart';
import 'package:momo/data/model/explore/explore_item_model.dart';
import 'package:momo/core/widgets/get_this_pack.dart';

Widget getExploreItem({required EItemModel eItem}){
  return GestureDetector(
    onTap: () {
      Get.to(()=>GetStartedScreen(eItem: eItem,));
    },
    child: Stack(
      children: [
        Stack(
          children: [
            SizedBox(
                      height: 200,
                      width: 150,
                      child: ClipRRect(
                        borderRadius: BorderRadius.circular(20),
                        child: Image.asset(
                            Images.myPhoto, // Replace with your image path
                            fit: BoxFit.cover,
                          ),
                      ),
                    ),
            Container(
                      height: 200,
                      width: 150,
                      
                      decoration: BoxDecoration(
                        gradient: LinearGradient(
                          begin: AlignmentGeometry.topCenter,
                          end: AlignmentGeometry.bottomCenter,
                          colors: [
                            Colors.transparent,
                            Colors.transparent,
                            Colors.black,
                          ],
                        ),
                        borderRadius: BorderRadius.circular(20),
                      ),
                    ),
    
          ],
        ),
    
                Positioned(
                  bottom: 8,
                  left: 0,
                  right: 0,
                  child: Column(
                    children: [
                      Text(eItem.title,textAlign: TextAlign.center, style: TextStyle(fontWeight: FontWeight.w600, fontSize: 18, color: Colors.white),),
                      Text("${eItem.example.length} Photos",textAlign: TextAlign.center, style: TextStyle(fontWeight: FontWeight.w500, fontSize: 14, color: Colors.white.withAlpha(200))),
    
                    ],
                  )),
      ],
    ),
  );
}