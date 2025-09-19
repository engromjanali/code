
import 'package:flutter/material.dart';
import 'package:get/get.dart';
import 'package:get/get_core/src/get_main.dart';
import 'package:momo/core/helper/assets/images.dart';
import 'package:momo/core/widgets/see_all_page.dart';
import 'package:momo/data/model/explore/explore_item_model.dart';
import 'package:momo/data/model/explore/explore_model.dart';
import 'package:momo/data/model/one_shot/oneshot_item_model.dart';
import 'package:momo/data/model/one_shot/oneshot_model.dart';
import 'package:momo/prsentation/screens/explore/widgets/explore_item.dart';
import 'package:momo/core/widgets/get_this_pack.dart';
import 'package:momo/prsentation/screens/one_shot/widgets/oneshot_item.dart';

Widget getOneShotList(BuildContext context, {required OneshotModel oneShot,}){
  return Column(
    children: [

  Padding(
            padding: const EdgeInsets.all(8.0),
            child: Row(
              mainAxisAlignment: MainAxisAlignment.spaceBetween,
              children: [
                Text(oneShot.title, style:  TextStyle(fontSize: 22, fontWeight: FontWeight.w600, color: Colors.white),),
                GestureDetector(
                  onTap: (){
                    Get.to(()=>SeeAllPage(oneShot: oneShot, isExplore: false,));
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
              itemCount: oneShot.items.length,
              itemBuilder: (context, index){
                return Padding(
                  padding: const EdgeInsets.all(5.0),
                  child: getOneShotItem(osItem: OSItemModel.fromMap(oneShot.items[index])),
                );
              }
            ),
          )
    ],
  );

}




