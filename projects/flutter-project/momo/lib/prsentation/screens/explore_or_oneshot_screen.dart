import 'dart:async';

import 'package:auto_size_text/auto_size_text.dart';
import 'package:flutter/material.dart';
import 'package:font_awesome_flutter/font_awesome_flutter.dart';
import 'package:get/get.dart';
import 'package:momo/core/helper/assets/images.dart';
import 'package:momo/prsentation/screens/model_name_screen.dart';
import 'package:momo/prsentation/screens/one_photo_with_prompt.dart';
import 'package:momo/prsentation/screens/one_photo_without_prompt.dart';
import 'package:momo/prsentation/screens/two_photos_with_prompt.dart';
import 'package:momo/core/widgets/see_all_page.dart';
import 'package:momo/core/widgets/explore_oneshot_section.dart';
import 'package:momo/core/widgets/pro_label.dart';

class ExploreAndOneShotScreen extends StatefulWidget {
  final bool isExplore;
  const ExploreAndOneShotScreen({super.key, required this.isExplore});

  @override
  State<ExploreAndOneShotScreen> createState() =>
      _ExploreAndOneShotScreenState();
}

class _ExploreAndOneShotScreenState extends State<ExploreAndOneShotScreen> {
  final PageController _pageController = PageController();
  late Timer _timer;

  int _pageCount = 10;
  int _currentPage = 0;

  // @override
  // bool get wantKeepAlive => true;

  @override
  void initState() {
    // TODO: implement initState
    super.initState();

    _timer = Timer.periodic(Duration(seconds: 3), (timer) {

      if(context.mounted){
        debugPrint("check");
        if (_currentPage < _pageCount - 1) {
          _currentPage++;
        } else {
          _currentPage = 0;
        }
        _pageController.animateToPage(
          _currentPage,
          duration: Duration(milliseconds: (_currentPage == 0) ? 10 : 500),
          curve: Curves.easeIn,
        );
      }
    });
  }


  @override
  void dispose() {
    _timer.cancel();
    _pageController.dispose();
    // TODO: implement dispose
    super.dispose();
  }

  @override
  Widget build(BuildContext context) {
    final size = MediaQuery.of(context).size;
    return Scaffold(
      backgroundColor: Colors.black,
      body: Stack(
        children: [
          SingleChildScrollView(
            child: Column(
              children: [
                widget.isExplore
                    ? SizedBox(
                        height: size.height / 2,
                        width: size.width,
                        child: Stack(
                          children: [
                            PageView.builder(
                              physics: const PageScrollPhysics(),
                              controller: _pageController,
                              itemCount: _pageCount,
                              onPageChanged: (value) {
                                setState(() {
                                  _currentPage = value;
                                });
                              },
                              itemBuilder: (context, index) {
                                return Column(
                                  children: [
                                    Stack(
                                      children: [
                                        Container(
                                          height: size.height / 2,
                                          width: double.infinity,
                                          decoration: BoxDecoration(),
                                          child: Image.asset(
                                            errorBuilder:
                                                (context, error, stackTrace) =>
                                                    SizedBox.shrink(),
                                            Images.myPhoto,
                                            fit: BoxFit.fill,
                                          ),
                                        ),

                                        Container(
                                          height: size.height / 2,
                                          width: size.width,
                                          decoration: BoxDecoration(
                                            gradient: LinearGradient(
                                              begin: Alignment
                                                  .bottomCenter, // start at bottom
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
                                        Positioned.fill(
                                          child: Column(
                                            children: [
                                              Spacer(),
                                              Padding(
                                                padding: const EdgeInsets.all(
                                                  8.0,
                                                ),
                                                child: AutoSizeText(
                                                  "Create 60 Likedin Profile",
                                                  textAlign: TextAlign.center,
                                                  style: TextStyle(
                                                    fontWeight: FontWeight.w700,
                                                    fontSize: 30,
                                                    color: Colors.white,
                                                    overflow:
                                                        TextOverflow.ellipsis,
                                                  ),
                                                  minFontSize: 26,
                                                  maxLines: 2,
                                                ),
                                              ),
                                              ElevatedButton.icon(
                                                onPressed: () {
                                                  // Navigator.push(
                                                  //   context,
                                                  //   MaterialPageRoute(
                                                  //     builder: (context) =>
                                                  //         SeeAllPage(),
                                                  //   ),
                                                  // );
                                                  Get.to(()=>ModelNameScreen());
                                                },
                                                icon: Text(
                                                  "Try Dream Job",
                                                  style: TextStyle(
                                                    color: Colors.black,
                                                  ),
                                                ),
                                                label: Icon(
                                                  Icons
                                                      .keyboard_arrow_right_outlined,
                                                ),
                                                style: ElevatedButton.styleFrom(
                                                  backgroundColor: Colors.white
                                                      .withAlpha(150),
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

                            Column(
                              mainAxisAlignment: MainAxisAlignment.end,
                              children: [
                                // Text("MOMO"),
                                SizedBox(height: 20),

                                // Custom Line Indicator
                                Row(
                                  mainAxisAlignment: MainAxisAlignment.center,
                                  children: List.generate(_pageCount, (index) {
                                    return AnimatedContainer(
                                      curve: Curves.ease,
                                      duration: const Duration(
                                        milliseconds: 500,
                                      ),
                                      // margin: const EdgeInsets.symmetric(horizontal: 4),
                                      height: 3,
                                      width: 200 / _pageCount,
                                      decoration: BoxDecoration(
                                        color: _currentPage == index
                                            ? Colors.white
                                            : Colors.grey,
                                        borderRadius: 0 == index
                                            ? BorderRadius.only(
                                                topLeft: Radius.circular(2),
                                                bottomLeft: Radius.circular(2),
                                              )
                                            : (_pageCount - 1) == index
                                            ? BorderRadius.only(
                                                topRight: Radius.circular(2),
                                                bottomRight: Radius.circular(2),
                                              )
                                            : BorderRadius.circular(0),
                                      ),
                                    );
                                  }),
                                ),
                                SizedBox(height: 20),
                              ],
                            ),
                          ],
                        ),
                      )
                    :
                      // Slide Section if One Shot
                      SizedBox(
                        height: size.height / 2,
                        width: size.width,
                        child: Stack(
                          children: [
                            // background image / Slider
                            PageView.builder(
                              physics: const PageScrollPhysics(),
                              controller: _pageController,
                              itemCount: _pageCount,
                              onPageChanged: (value) {
                                setState(() {
                                  _currentPage = value;
                                });
                              },
                              itemBuilder: (context, index) {
                                return Column(
                                  children: [
                                    Stack(
                                      children: [
                                        Container(
                                          height: size.height / 2,
                                          width: double.infinity,
                                          decoration: BoxDecoration(),
                                          child:
                                              // Image.asset(
                                              //   // errorBuilder: (context, error, stackTrace) => SizedBox.shrink(),
                                              //   Images.myPhoto, // Replace with your image path
                                              //   fit: BoxFit.fill,
                                              // ),
                                              Image.asset(
                                                Images.myPhoto, // Replace with your image path
                                                fit: BoxFit.fill,
                                              ),
                                        ),

                                        Container(
                                          height: size.height / 2,
                                          width: size.width,
                                          decoration: BoxDecoration(
                                            gradient: LinearGradient(
                                              begin: Alignment
                                                  .bottomCenter, // start at bottom
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
                                        Positioned.fill(
                                          child: Column(
                                            children: [
                                              Spacer(),
                                              Padding(
                                                padding:
                                                    const EdgeInsets.symmetric(
                                                      horizontal: 4,
                                                    ),
                                                child: Row(
                                                  spacing: 10,
                                                  children: [
                                                    Expanded(
                                                      child: Column(
                                                        crossAxisAlignment:
                                                            CrossAxisAlignment
                                                                .start,
                                                        children: [
                                                          AutoSizeText(
                                                            "Create 60 Linkedin",
                                                            textAlign:
                                                                TextAlign.start,
                                                            style: TextStyle(
                                                              fontWeight:
                                                                  FontWeight
                                                                      .w700,
                                                              fontSize: 30,
                                                              color:
                                                                  Colors.white,
                                                              overflow:
                                                                  TextOverflow
                                                                      .ellipsis,
                                                            ),
                                                            minFontSize: 26,
                                                            maxLines: 1,
                                                          ),
                                                          Text(
                                                            "It's me, Md Romjan Ali, i have created 60 miages with the application.",
                                                            textAlign:
                                                                TextAlign.start,
                                                            style: TextStyle(
                                                              fontWeight:
                                                                  FontWeight
                                                                      .w600,
                                                              fontSize: 16,
                                                              color: Colors
                                                                  .white70,
                                                            ),
                                                            overflow:
                                                                TextOverflow
                                                                    .ellipsis,
                                                            maxLines: 2,
                                                          ),
                                                        ],
                                                      ),
                                                    ),
                                                    ElevatedButton.icon(
                                                      onPressed: () {
                                                        Get.to(()=>OnePhotosWithPrompt());
                                                      },
                                                      iconAlignment:
                                                          IconAlignment.end,
                                                      label: Text(
                                                        "Try It",
                                                        style: TextStyle(
                                                          color: Colors.black,
                                                        ),
                                                      ),
                                                      style:
                                                          ElevatedButton.styleFrom(
                                                            padding:
                                                                EdgeInsets.all(
                                                                  0,
                                                                ),
                                                            backgroundColor:
                                                                Colors.white
                                                                    .withAlpha(
                                                                      150,
                                                                    ),
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

                            Column(
                              mainAxisAlignment: MainAxisAlignment.end,
                              children: [
                                // Text("MOMO"),
                                SizedBox(height: 20),

                                // Custom Line Indicator
                                Row(
                                  mainAxisAlignment: MainAxisAlignment.center,
                                  children: List.generate(_pageCount, (index) {
                                    return AnimatedContainer(
                                      curve: Curves.ease,
                                      duration: const Duration(
                                        milliseconds: 500,
                                      ),
                                      // margin: const EdgeInsets.symmetric(horizontal: 4),
                                      height: 3,
                                      width: 200 / _pageCount,
                                      decoration: BoxDecoration(
                                        color: _currentPage == index
                                            ? Colors.white
                                            : Colors.grey,
                                        borderRadius: 0 == index
                                            ? BorderRadius.only(
                                                topLeft: Radius.circular(2),
                                                bottomLeft: Radius.circular(2),
                                              )
                                            : (_pageCount - 1) == index
                                            ? BorderRadius.only(
                                                topRight: Radius.circular(2),
                                                bottomRight: Radius.circular(2),
                                              )
                                            : BorderRadius.circular(0),
                                      ),
                                    );
                                  }),
                                ),
                                SizedBox(height: 20),
                              ],
                            ),
                          ],
                        ),
                      ),

                getSection(context, name: "Linkedin"),
                getSection(context, name: "Trend Video"),
                getSection(context, name: "Linkedin"),
                getSection(context, name: "Trend Video"),
                getSection(context, name: "Linkedin"),
                getSection(context, name: "Trend Video"),
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
