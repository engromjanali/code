
import 'package:flutter/material.dart';
import 'package:get/get.dart';
import 'package:get/get_core/src/get_main.dart';
import 'package:momo/core/helper/assets/images.dart';
import 'package:momo/core/widgets/see_all_page.dart';
import 'package:momo/prsentation/screens/get_this_pack.dart';

Widget getSection(BuildContext context,{required String name,}){
  return Column(
    children: [

  Padding(
            padding: const EdgeInsets.all(8.0),
            child: Row(
              mainAxisAlignment: MainAxisAlignment.spaceBetween,
              children: [
                Text(name, style:  TextStyle(fontSize: 22, fontWeight: FontWeight.w600, color: Colors.white),),
                GestureDetector(
                  onTap: (){
                    Navigator.push(context, MaterialPageRoute(builder: (context) => SeeAllPage()));
                  },
                  child: Text("See All", style:  TextStyle(fontSize: 20, color: Colors.grey),)),
              ],
            ),
          ),
          
          SizedBox(
            height: 210,
            child: ListView.builder(
              scrollDirection: Axis.horizontal,
              itemCount: 20,
              itemBuilder: (context, Index){
                return Padding(
                  padding: const EdgeInsets.all(5.0),
                  child: getSectionItem(),
                );
              }
            ),
          )
    ],
  );

}



Widget getSectionItem(){
  return GestureDetector(
    onTap: () {
      Get.to(()=>SuitPage());
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
                      Text("Romjan Ali",textAlign: TextAlign.center, style: TextStyle(fontWeight: FontWeight.w600, fontSize: 18, color: Colors.white),),
                      Text("6 Photos",textAlign: TextAlign.center, style: TextStyle(fontWeight: FontWeight.w500, fontSize: 14, color: Colors.white.withAlpha(200))),
    
                    ],
                  )),
      ],
    ),
  );
}

