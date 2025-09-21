import 'package:flutter/material.dart';
import 'package:get/get.dart';
import 'package:image_picker/image_picker.dart';
import 'package:momo/core/helper/assets/images.dart';
import 'package:momo/core/util/constants/all_enums.dart';
import 'package:momo/core/util/constants/colors.dart';
import 'package:momo/core/util/constants/text_style.dart';
import 'package:momo/core/util/services/image_picker.dart';
import 'package:momo/core/widgets/bottom_button.dart';
import 'package:momo/core/widgets/custom_Image_type_selection_dialog.dart';
import 'package:momo/core/widgets/gender_selection.dart';
import 'package:momo/core/widgets/get_raw_image_card.dart';
import 'package:momo/core/widgets/get_started.dart';
import 'package:momo/data/model/explore/explore_item_model.dart';
import 'package:momo/data/model/one_shot/oneshot_item_model.dart';
import 'package:momo/data/model/one_shot/oneshot_model.dart';

class UploadScreen extends StatefulWidget {
  final bool isExplore;
  final EItemModel? eItem;
  final OSItemModel? oneShotItem;
  const UploadScreen({
    super.key,
    this.isExplore = true,
    this.eItem,
    this.oneShotItem,
  });
  @override
  _UploadScreenState createState() => _UploadScreenState();
}

class _UploadScreenState extends State<UploadScreen> {
  final ScrollController _scrollController = ScrollController();
  double _opacity = 0.0;
  double _imageScale = 1.0; // Scale for bounce effect
  List<String> imageList = [
    Images.myPhoto,
    Images.myPhoto,
    Images.myPhoto,
    Images.myPhoto,
    Images.myPhoto,
  ];
  List<String> goodPhotosList = [
    Images.myPhoto,
    Images.myPhoto,
    Images.myPhoto,
    Images.myPhoto,
    Images.myPhoto,
  ];
  List<String> badPhotosList = [
    Images.myPhoto,
    Images.myPhoto,
    Images.myPhoto,
    Images.myPhoto,
    Images.myPhoto,
  ];

  @override
  void initState() {
    super.initState();

    _scrollController.addListener(() {
      setState(() {
        if (_scrollController.offset < 0) {
          _imageScale =
              1 +
              ((_scrollController.offset).clamp(-100, 0)).abs().toDouble() /
                  1000;
        }

        // Adjust opacity based on scroll position (e.g., 0 to 1 over 400 pixels)
        _opacity = (_scrollController.offset / 90).clamp(0.0, 1.0);
      });
    });
  }

  @override
  void dispose() {
    _scrollController.dispose();
    super.dispose();
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      extendBody: true,
      backgroundColor: Colors.transparent,
      // upload button
      bottomNavigationBar: getBottomRoundedButton(
        label: imageList.length < 8 ? "Upload Photo" : "Continue",
        ontap: () {
          if (imageList.length < 8) {
            // upload Photos
            _chooseImage();
          } else {
            // Continue
            Get.to(()=>GenderSelection());
          }
        },
      ),

      appBar: AppBar(
        scrolledUnderElevation: 0,
        elevation: 0,
        backgroundColor: Colors.black,
        foregroundColor: Colors.white,
        leading: IconButton(
          onPressed: () {
            Get.back();
          },
          icon: Icon(Icons.cancel, size: 35),
        ),
        centerTitle: true,
        title: Opacity(
          opacity: _opacity,
          child: Text("Pick 8-12 hotos of yourself."),
        ),
      ),

      body: SingleChildScrollView(
        controller: _scrollController,
        child: Column(
          children: [
            Text("Pick 8-12 Photos of yourself", style: getTitleStyleExplore()),

            // goold photos
            Container(
              color: cardColor,
              padding: EdgeInsets.symmetric(vertical: 20, horizontal: 10),
              child: Column(
                children: [
                  Row(
                    spacing: 10,
                    children: [
                      Icon(Icons.check_circle, size: 16, color: Colors.green),
                      Text("Good Photos", style: getTitleStyle()),
                    ],
                  ),
                  Text(
                    "We need to colse-up selfies of the same person, taken from a varieaty of angle and with different facial expressions and background ",
                    style: getSubtitleStyle(),
                  ),
                  SizedBox(
                    height: 120,
                    child: ListView.builder(
                      itemCount: goodPhotosList.length,
                      scrollDirection: Axis.horizontal,
                      itemBuilder: (_, index) {
                        return SizedBox(
                          width: 120,
                          child: _getImageWidget(
                            ontap: () {},
                            imagePath: goodPhotosList[index],
                            isGood: true,
                          ),
                        );
                      },
                    ),
                  ),
                ],
              ),
            ),

            // bad photos
            Container(
              // color: cardColor,
              padding: EdgeInsets.symmetric(vertical: 20, horizontal: 10),
              child: Column(
                children: [
                  Row(
                    spacing: 10,
                    children: [
                      Icon(Icons.cancel, size: 16, color: Colors.red),
                      Text("Bad Photos", style: getTitleStyle()),
                    ],
                  ),
                  Text(
                    "We need to colse-up selfies of the same person, taken from a varieaty of angle and with different facial expressions and background ",
                    style: getSubtitleStyle(),
                  ),
                  SizedBox(
                    height: 120,
                    child: ListView.builder(
                      itemCount: badPhotosList.length,
                      scrollDirection: Axis.horizontal,
                      itemBuilder: (_, index) {
                        return SizedBox(
                          width: 120,
                          child: _getImageWidget(
                            ontap: () {},
                            imagePath: badPhotosList[index],
                            isGood: false,
                          ),
                        );
                      },
                    ),
                  ),
                ],
              ),
            ),

            // your photos
            if (imageList.isNotEmpty)
              Container(
                color: cardColor,
                padding: EdgeInsets.symmetric(vertical: 20, horizontal: 10),
                child: Column(
                  crossAxisAlignment: CrossAxisAlignment.start,
                  children: [
                    Text("your Photos", style: getTitleStyle()),

                    Row(
                      children: [
                        Expanded(
                          child: GridView.builder(
                            physics: NeverScrollableScrollPhysics(),
                            padding: EdgeInsets.all(0),
                            gridDelegate:
                                SliverGridDelegateWithFixedCrossAxisCount(
                                  crossAxisCount: 3,
                                  childAspectRatio: 1,
                                ),
                            itemCount: imageList.length,
                            shrinkWrap: true,
                            // scrollDirection: Axis.horizontal,
                            itemBuilder: (_, index) {
                              return SizedBox(
                                width: 120,
                                height: 120,
                                child: getImageCard(
                                  ontap: (isImage) async {
                                    if (isImage) {
                                      // remove image
                                      setState(() {
                                        imageList.removeAt(index);
                                      });
                                    } else {
                                      await _chooseImage();
                                    }
                                  },
                                  imagePath: imageList[index],
                                  label: "Addd Image",
                                ),
                              );
                            },
                          ),
                        ),
                      ],
                    ),
                  ],
                ),
              ),
            SizedBox(height: 100),
          ],
        ),
      ),
    );
  }

  Widget _getImageWidget({
    required String imagePath,
    bool isGood = true,
    required Function() ontap,
  }) {
    return Container(
      margin: EdgeInsets.all(5),
      decoration: BoxDecoration(borderRadius: BorderRadius.circular(10)),
      child:
          // show image
          ClipRRect(
            borderRadius: BorderRadius.circular(10),
            child: Stack(
              children: [
                SizedBox.expand(
                  child: Image.asset(
                    imagePath,
                    fit: BoxFit.cover,
                    alignment: Alignment.topCenter,
                  ),
                ),
                Positioned(
                  bottom: 0,
                  right: 0,
                  child: IconButton(
                    onPressed: ontap,
                    icon: Icon(
                      isGood ? Icons.check_circle : Icons.cancel,
                      color: isGood ? Colors.green : Colors.red,
                      size: 20,
                    ),
                  ),
                ),
              ],
            ),
          ),
    );
  }

  Future<void> _chooseImage() async {
    if (imageList.length < 8) {
      List<XFile>? pickedImageList = await ImagePickerServices()
          .pickMultipleImage();
      if (pickedImageList != null) {
        setState(() {
          imageList.insertAll(
            0,
            pickedImageList.map((image) => image.path).toList(),
          );
        });
      }
    }
  }
}
