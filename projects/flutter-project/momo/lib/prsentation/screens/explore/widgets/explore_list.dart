
import 'package:flutter/material.dart';
import 'package:get/get.dart';
import 'package:get/get_core/src/get_main.dart';
import 'package:momo/core/asset_manager/assets/images.dart';
import 'package:momo/core/widgets/see_all_page.dart';
import 'package:momo/data/model/explore/explore_item_model.dart';
import 'package:momo/data/model/explore/explore_model.dart';
import 'package:momo/prsentation/screens/explore/widgets/explore_item.dart';
import 'package:momo/core/widgets/get_this_pack.dart';

Widget getExploreList(BuildContext context, {required ExploreModel explore,}){
  return Column(
    children: [

  Padding(
            padding: const EdgeInsets.all(8.0),
            child: Row(
              mainAxisAlignment: MainAxisAlignment.spaceBetween,
              children: [
                Text(explore.title, style:  TextStyle(fontSize: 22, fontWeight: FontWeight.w600, color: Colors.white),),
                GestureDetector(
                  onTap: (){
                    Get.to(()=>SeeAllPage(explore: explore,));
                  },
                  child: Text("See All", style:  TextStyle(fontSize: 20, color: Colors.grey),)),
              ],
            ),
          ),
          
          // explore item list 
          SizedBox(
            height: 210,
            child: ListView.builder(
              scrollDirection: Axis.horizontal,
              itemCount: explore.items.length,
              itemBuilder: (context, index){
                return Padding(
                  padding: const EdgeInsets.all(5.0),
                  child: getExploreItem(eItem: EItemModel.fromMap(explore.items[index])),
                );
              }
            ),
          )
    ],
  );

}




