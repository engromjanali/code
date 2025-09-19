import 'package:flutter/material.dart';
import 'package:get/get.dart';
import 'package:get/get_connect/http/src/utils/utils.dart';
import 'package:image_picker/image_picker.dart';
import 'package:momo/core/helper/assets/images.dart';
import 'package:momo/core/util/constants/colors.dart';
import 'package:momo/core/util/constants/text_style.dart';
import 'package:momo/core/util/services/image_picker.dart';
import 'package:momo/core/widgets/bottom_button.dart';
import 'package:momo/core/widgets/get_raw_image_card.dart';
import 'package:momo/data/model/one_shot/oneshot_item_model.dart';

class PhotosWithPrompt extends StatefulWidget {
  final OSItemModel osItem;
  const PhotosWithPrompt({super.key, required this.osItem});

  @override
  State<PhotosWithPrompt> createState() => _PhotosWithPromptState();
}

class _PhotosWithPromptState extends State<PhotosWithPrompt> {
  List<String?> pickedImageList = [];

  @override
  void initState() {
    pickedImageList.addAll(
      widget.osItem.imageBehaildText.map((x) => null).toList(),
    );
    // TODO: implement initState
    super.initState();
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
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
                          "Park Vives",
                          style: getTitleStyle().copyWith(fontSize: 26),
                        ),
                        Text(
                          "Bright, natural look with soft sunlight and relaxed outdoor vibes.",
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
                        return StatefulBuilder(
                          builder: (context, setLocalState) {
                            return Expanded(
                              child: getImageCard(
                                imagePath: pickedImageList[index],
                                ontap: (isImage) async {

                                  if(isImage){
                                    setLocalState((){
                                      pickedImageList[index] = null;
                                    });
                                  }
                                  else{ 
                                      ImagePickerServices ipServices =
                                          ImagePickerServices();
                                      XFile? pickedImageFile = await ipServices
                                          .pickSingleImage();
                                      if (pickedImageFile != null) {
                                        setLocalState((){
                                          pickedImageList[index] = pickedImageFile.path;
                                        });
                                      }
                                  }
                                },
                                label: behindText,
                              ),
                            );
                          }
                        );
                      }).toList(),
                    ),
                  ),

                  getBottomRoundedButton(
                    label: "Continue * 10",
                    margin: EdgeInsets.only(bottom: 20, top: 10),
                    ontap: () {},
                  ),
                ],
              ),
            ),
          ),
        ],
      ),
    );
  }
}
