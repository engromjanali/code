import 'dart:async';

import 'package:auto_size_text/auto_size_text.dart';
import 'package:flutter/material.dart';
import 'package:font_awesome_flutter/font_awesome_flutter.dart';
import 'package:get/get.dart';
import 'package:momo/core/helper/assets/images.dart';
import 'package:momo/core/util/constants/all_enums.dart';
import 'package:momo/prsentation/screens/explore/widgets/current_item_indicator.dart';
import 'package:momo/prsentation/screens/explore/widgets/top_slider.dart';
import 'package:momo/prsentation/screens/model_name_screen.dart';
import 'package:momo/prsentation/screens/one_photo_with_prompt.dart';
import 'package:momo/prsentation/screens/one_photo_without_prompt.dart';
import 'package:momo/prsentation/screens/one_shot/controller/oneshot_controller.dart';
import 'package:momo/prsentation/screens/two_photos_with_prompt.dart';
import 'package:momo/core/widgets/see_all_page.dart';
import 'package:momo/prsentation/screens/explore/widgets/explore_section.dart';
import 'package:momo/core/widgets/pro_label.dart';
import 'package:momo/test.dart';
import 'package:provider/provider.dart';

class OneShot extends StatefulWidget {
  const OneShot({super.key});

  @override
  State<OneShot> createState() => _OneShotState();
}

class _OneShotState extends State<OneShot> {
  // @override
  // bool get wantKeepAlive => true;

  @override
  void initState() {
    // TODO: implement initState
    super.initState();
  }

  @override
  void dispose() {
    print("dispose");
    // TODO: implement dispose
    super.dispose();
  }

  @override
  Widget build(BuildContext context) {
    final size = MediaQuery.of(context).size;
    COneShot cOneShot = context.watch<COneShot>();

    return Scaffold(
      backgroundColor: Colors.black,
      body: Stack(
        children: [
          SingleChildScrollView(
            child: Column(
              children: [
                TopSlider(
                  exploreList: cOneShot.oneShotList,
                  isExplore: true,
                  onTap: () {},
                ),

                // OneShot list
                ListView.builder(
                  physics: NeverScrollableScrollPhysics(),
                  itemCount: cOneShot.oneShotList.length,
                  shrinkWrap: true,
                  itemBuilder: (_, index) {
                    return getOneShotList(
                      context,
                      explore: cOneShot.oneShotList[index],
                    );
                  },
                ),
              ],
            ),
          ),

          // the top label of pro
          proLabel(),
        ],
      ),
    );
  }
}
