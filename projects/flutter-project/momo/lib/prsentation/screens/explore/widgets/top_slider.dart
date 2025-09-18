import 'dart:async';

import 'package:auto_size_text/auto_size_text.dart';
import 'package:flutter/material.dart';
import 'package:get/get.dart';
import 'package:momo/core/helper/assets/images.dart';
import 'package:momo/data/model/explore/explore_model.dart';
import 'package:momo/prsentation/screens/explore/widgets/current_item_indicator.dart';
import 'package:momo/prsentation/screens/one_photo_with_prompt.dart';
import 'package:momo/test.dart';
import 'dart:async';

import 'package:flutter/material.dart';

class TopSlider extends StatefulWidget {
  final List<ExploreModel> exploreList;
  final bool isExplore;
  final Function() onTap;

  const TopSlider({
    super.key,
    required this.exploreList,
    required this.isExplore,
    required this.onTap,
  });

  @override
  State<TopSlider> createState() => _TopSliderState();
}

class _TopSliderState extends State<TopSlider> {
  int _currentItem = 0;
  Timer? _timer;
  PageController pageController = PageController();
  @override
  void initState() {
    // TODO: implement initState
    super.initState();

    WidgetsBinding.instance.addPostFrameCallback((_) {
      _timer = Timer.periodic(const Duration(seconds: 3), (_) {
        // setState(() {

        _currentItem = widget.exploreList.length==0? 0 :(_currentItem + 1) % widget.exploreList.length;
        // });

        pageController.animateToPage(
          _currentItem,
          duration: Duration(milliseconds: (_currentItem == 0) ? 10 : 500),
          curve: Curves.easeIn,
        );
      });
    });
  }

  @override
  void dispose() {
    // TODO: implement dispose
    _timer?.cancel();
    _timer?.cancel();
    _timer?.cancel();
    _timer?.cancel();
    pageController.dispose();
    super.dispose();
  }

  @override
  Widget build(BuildContext context) {
    final size = MediaQuery.of(context).size;

    return SizedBox(
      width: size.width,
      height: size.height / 2,
      child: StatefulBuilder(
        builder: (_, setLocalState) {
          return Stack(
            children: [
              PageView.builder(
                physics: const PageScrollPhysics(),
                controller: pageController,
                itemCount: widget.exploreList.length,
              
                onPageChanged: (value) {
                  setLocalState(() {
                    _currentItem = value;
                  });
                },
                itemBuilder: (context, index) {
                  return Column(
                    children: [
                      Stack(
                        children: [
                          // image
                          Container(
                            height: size.height / 2,
                            width: double.infinity,
                            decoration: BoxDecoration(),
                            child: Image.asset(
                              errorBuilder: (context, error, stackTrace) =>
                                  SizedBox.shrink(),
                              Images.myPhoto,
                              fit: BoxFit.fill,
                            ),
                          ),
              
                          // gradient filter
                          Container(
                            height: size.height / 2,
                            width: size.width,
                            decoration: BoxDecoration(
                              gradient: LinearGradient(
                                begin: Alignment.bottomCenter, // start at bottom
                                end: Alignment.topCenter,
                                // transform: GradientRotation(4),
                                colors: [
                                  Colors.black, // bottom color
                                  Colors.transparent, // top color
                                  Colors.transparent, // top color
                                ],
                              ),
                            ),
                          ),
              
                          widget.isExplore
                              ? Positioned.fill(
                                  child: Column(
                                    children: [
                                      Spacer(),

                                      // Slider label
                                      Padding(
                                        padding: const EdgeInsets.all(8.0),
                                        child: AutoSizeText(
                                          "Create 60 ${widget.exploreList[_currentItem].title} version of you",
                                          textAlign: TextAlign.center,
                                          style: TextStyle(
                                            fontWeight: FontWeight.w700,
                                            fontSize: 30,
                                            color: Colors.white,
                                            overflow: TextOverflow.ellipsis,
                                          ),
                                          minFontSize: 26,
                                          maxLines: 2,
                                        ),
                                      ),

                                      // Elevated button
                                      ElevatedButton.icon(
                                        onPressed: widget.onTap,
                                        icon: Text(
                                          "Try ${widget.exploreList[_currentItem].title}",
                                          style: TextStyle(color: Colors.black),
                                        ),
                                        label: Icon(
                                          Icons.keyboard_arrow_right_outlined,
                                        ),
                                        style: ElevatedButton.styleFrom(
                                          backgroundColor: Colors.white.withAlpha(
                                            150,
                                          ),
                                        ),
                                      ),
                                      SizedBox(height: 40),
                                    ],
                                  ),
                                )
                              : 
                              // for One Shot (label, button, subtitle)
                              Positioned.fill(
                                  child: Column(
                                    children: [
                                      Spacer(),
                                      Padding(
                                        padding: const EdgeInsets.symmetric(
                                          horizontal: 4,
                                        ),
                                        child: Row(
                                          spacing: 10,
                                          children: [
                                            Expanded(
                                              child: Column(
                                                crossAxisAlignment:
                                                    CrossAxisAlignment.start,
                                                children: [
                                                  AutoSizeText(
                                                    "Create 60 Linkedin",
                                                    textAlign: TextAlign.start,
                                                    style: TextStyle(
                                                      fontWeight: FontWeight.w700,
                                                      fontSize: 30,
                                                      color: Colors.white,
                                                      overflow:
                                                          TextOverflow.ellipsis,
                                                    ),
                                                    minFontSize: 26,
                                                    maxLines: 1,
                                                  ),
                                                  Text(
                                                    "widget.itemList[_currentItem].subTitle??""",
                                                    textAlign: TextAlign.start,
                                                    style: TextStyle(
                                                      fontWeight: FontWeight.w600,
                                                      fontSize: 16,
                                                      color: Colors.white70,
                                                    ),
                                                    overflow: TextOverflow.ellipsis,
                                                    maxLines: 2,
                                                  ),
                                                ],
                                              ),
                                            ),
                                            ElevatedButton.icon(
                                              onPressed: () {
                                                Get.to(() => OnePhotosWithPrompt());
                                              },
                                              iconAlignment: IconAlignment.end,
                                              label: Text(
                                                "Try It",
                                                style: TextStyle(
                                                  color: Colors.black,
                                                ),
                                              ),
                                              style: ElevatedButton.styleFrom(
                                                padding: EdgeInsets.all(0),
                                                backgroundColor: Colors.white
                                                    .withAlpha(150),
                                              ),
                                            ),
                                          ],
                                        ),
                                      ),
                                      SizedBox(height: 40),
                                    ],
                                  ),
                                ),
              
              
                        ],
                      ),
                    ],
                  );
                },
              ),
                                // the linier indicator
                                Positioned(
                                  bottom: 0,
                                  left: 0,
                                  right: 0,
                                  child: currentItemIndicator(
                                    widget.exploreList.length.clamp(0, 10), // maximun 10, minimum how have
                                    _currentItem,
                                  ),
                                ),
            ],
          );
        },
      ),
    );
  }
}
