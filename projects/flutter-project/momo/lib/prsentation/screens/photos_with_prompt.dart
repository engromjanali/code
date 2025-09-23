import 'package:flutter/material.dart';
import 'package:get/get.dart';
import 'package:get/get_connect/http/src/utils/utils.dart';
import 'package:image_picker/image_picker.dart';
import 'package:momo/core/asset_manager/assets/images.dart';
import 'package:momo/core/util/constants/all_enums.dart';
import 'package:momo/core/util/constants/colors.dart';
import 'package:momo/core/util/constants/text_style.dart';
import 'package:momo/core/util/services/image_picker.dart';
import 'package:momo/core/widgets/bottom_button.dart';
import 'package:momo/core/widgets/custom_Image_type_selection_dialog.dart';
import 'package:momo/core/widgets/get_raw_image_card.dart';
import 'package:momo/data/model/one_shot/oneshot_item_model.dart';
import 'package:momo/prsentation/screens/purchese_screen.dart';

class PhotosWithPrompt extends StatefulWidget {
  final OSItemModel osItem;
  const PhotosWithPrompt({super.key, required this.osItem});

  @override
  State<PhotosWithPrompt> createState() => _PhotosWithPromptState();
}

class _PhotosWithPromptState extends State<PhotosWithPrompt> {
  List<String?> pickedImageList = [];
  TextEditingController promptController = TextEditingController();

  @override
  void initState() {
    promptController.text = widget.osItem.prompt!;
    pickedImageList.addAll(
      widget.osItem.imageBehaildText.map((x) => null).toList(),
    );
    // TODO: implement initState
    super.initState();
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      extendBody: true,
      backgroundColor: Colors.black,
      bottomNavigationBar: getBottomRoundedButton(label: "Continue * 10", ontap: () {
        Get.to(()=>PurcheseScreen());
      }, isEnabled: !pickedImageList.contains(null)),
      body: Column(
        children: [
          // top area
          Expanded(
            flex: 40,
            child: Stack(
              children: [
                // image
                SizedBox.expand(
                  child: Image.asset(Images.myPhoto, fit: BoxFit.fill),
                ),
                // top color shadow
                Positioned(
                  child: Container(
                    decoration: BoxDecoration(
                      gradient: LinearGradient(
                        stops: [0.0, 0.6, 0.8, 1.0],
                        begin: AlignmentGeometry.topCenter,
                        end: AlignmentGeometry.bottomCenter,
                        colors: [
                          Colors.transparent,
                          Colors.transparent,
                          Colors.black,
                          Colors.black,
                        ],
                      ),
                    ),
                  ),
                ),
                // text
                Positioned(
                  bottom: 0,
                  right: 0,
                  left: 0,
                  child: Padding(
                    padding: const EdgeInsets.all(15.0),
                    child: Column(
                      spacing: 16,
                      crossAxisAlignment: CrossAxisAlignment.start,
                      children: [
                        Text(
                          widget.osItem.title,
                          style: getTitleStyle().copyWith(fontSize: 26),
                        ),
                        Text(
                          widget.osItem.subTitle,
                          style: getSubtitleStyle().copyWith(
                            color: subTitleColor,
                          ),
                          maxLines: 2,
                          overflow: TextOverflow.ellipsis,
                        ),
                      ],
                    ),
                  ),
                ),
                // close icon
                Positioned(
                  top: 10,
                  left: 20,
                  child: SafeArea(
                    child: GestureDetector(
                      onTap: () {
                        Get.back();
                      },
                      child: CircleAvatar(
                        radius: 15,
                        backgroundColor: Colors.white,
                        child: Icon(Icons.close),
                      ),
                    ),
                  ),
                ),
              ],
            ),
          ),

          // down area
          Expanded(
            flex: 60,
            child: Container(
              padding: EdgeInsets.all(10),
              color: Colors.black,
              child: Column(
                children: [
                  Expanded(
                    child: Container(
                      margin: EdgeInsets.all(5),
                      padding: EdgeInsets.only(
                        left: 10,
                        right: 10,
                        top: 20,
                        bottom: 10,
                      ),
                      decoration: BoxDecoration(
                        color: cardColor,
                        borderRadius: BorderRadius.circular(20),
                      ),
                      child: Column(
                        crossAxisAlignment: CrossAxisAlignment.start,
                        children: [
                          Text("Enter Prompt", style: getTitleStyle()),
                          Expanded(
                            child: TextField(
                              controller: promptController,
                              decoration: InputDecoration(
                                hintText: "Write Your Prompt Here...",
                                hintStyle: getSubtitleStyle(),

                                border: InputBorder.none,
                              ),
                              style: getSubtitleStyle(),
                              expands: true,
                              scrollPhysics: ClampingScrollPhysics(),
                              maxLines: null,
                            ),
                          ),
                        ],
                      ),
                    ),
                  ),

                  Expanded(
                    child: Row(
                      children: widget.osItem.imageBehaildText.map((
                        behindText,
                      ) {
                        int index = widget.osItem.imageBehaildText.indexOf(
                          behindText,
                        );
                        return Expanded(
                          child: getImageCard(
                            imagePath: pickedImageList[index],
                            ontap: (isImage) async {
                              if (isImage) {
                                setState(() {
                                  pickedImageList[index] = null;
                                });
                              } else {
                                SelectImageFrom res =
                                    await customImageSourceSelectionDialog();
                                if (res != SelectImageFrom.unSelected) {
                                  XFile? pickedImageFile =
                                      await ImagePickerServices()
                                          .pickSingleImage(
                                            choseFrom:
                                                SelectImageFrom.camera ==
                                                    res
                                                ? ImageSource.camera
                                                : ImageSource.gallery,
                                          );
                                  if (pickedImageFile != null) {
                                    setState(() {
                                      pickedImageList[index] =
                                          pickedImageFile.path;
                                    });
                                  }
                                }
                              }
                            },
                            label: behindText,
                          ),
                        );
                      }).toList(),
                    ),
                  ),
                ],
              ),
            ),
          ),
          SizedBox(height: 100),
        ],
      ),
    );
  }
}
