import 'package:flutter/material.dart';
import 'package:get/get_core/src/get_main.dart';
import 'package:get/get_navigation/get_navigation.dart';
import 'package:momo/core/helper/assets/images.dart';
import 'package:momo/core/util/constants/all_enums.dart';
import 'package:momo/core/util/constants/constants.dart';
import 'package:momo/core/widgets/CustomElevatedButton.dart';



  Future<ImageType> showImageTypeChosserDialog(BuildContext context) async{
    var size = MediaQuery.of(context).size;

    ImageType? res = await Get.dialog(
      // showDialog
      // context: context, 
      // builder: (context){
        // return 
        Dialog(
          child: ClipRRect(
              borderRadius: BorderRadius.circular(20),
              child: Stack(
                // clipBehavior: Clip.none, // to visible on outsite
                children: [
                  SizedBox(
                    height: size.height - 400,
                    width: size.width - 50,
                    child: Column(
                      children: [
                        Expanded(
                          child: Container(
                            color: Colors.black,
                            child: Row(
                              children: [
                                Expanded(
                                  child: SizedBox.expand(
                                    // color: Colors.red,
                                    child: Image.asset(
                                      Images.myPhoto,
                                      fit: BoxFit.fill, 
                                    ),
                                  ),
                                ),
                                Expanded(
                                  child: SizedBox.expand(
                                    // color: Colors.red,
                                    child: Image.asset(
                                      Images.myPhoto,
                                      fit: BoxFit.fill, 
                                    ),
                                  ),
                                ),
                              ],
                            ),
                          ),
                        ),
                        Expanded(child: SizedBox.shrink()),
                      ],
                    ),
                  ),
                  // Text("fsofjs lsdjflsa dflsajdfljsdfjasljasljglsajglsjlgjslkjgslajglsjdldsj"),
                  // Positioned(
                  //   bottom: 0,
                  //   child: Text("fsofjs lsdjflsa dflsajdfljsdfjasljasljglsajglsjlgjslkjgslajglsjdldsj")),
              
                  Positioned(
                    bottom: 0,
                    left: 0,
                    right: 0,
                    top: 0,
                    child: Container(
                      decoration: BoxDecoration(
                        gradient: LinearGradient(
                          begin: AlignmentGeometry.topCenter,
                          end: AlignmentGeometry.bottomCenter,
                          colors: [Colors.transparent, Colors.white,Colors.white],
                        ),
                      ),
                    ),
                  ),
                  Positioned(
                    bottom: 0,
                    left: 0,
                    right: 0,
                    child: Column(
                      crossAxisAlignment: CrossAxisAlignment.center,
                      children: [
                        Text(
                          "Chose Your Profile Type",
                          style: TextStyle(fontSize: 24, fontWeight: FontWeight.w700),
                          textAlign: TextAlign.center,
                        ),
                        Padding(
                          padding: const EdgeInsets.all(8.0),
                          child: Text(
                            "Create a Single profile for yourself or a Couple profile with a partner!",
                            style: TextStyle(fontSize: 14, fontWeight: FontWeight.w600,),
                            textAlign: TextAlign.center,
                          ),
                        ),
                        customElevatedButton(
                          label: "Couple",
                          ontap: () {
                            Get.back(result: ImageType.couple);
                            // Navigator.pop(context, ImageType.couple);
                          },
                          margin: EdgeInsets.symmetric(horizontal: 10),
                        ),
                        customElevatedButton(
                          label: "Single",
                          ontap: () {
                            Get.back(result: ImageType.single);
                            // Navigator.pop(context, ImageType.simge);
                          },
                          backgroundColor: Colors.grey.withAlpha(100),
                          foregroundColor: Colors.black,
                          margin: EdgeInsets.all(10),
                        ),
                      ],
                    ),
                  ),
              
                  Positioned(
                    right: 5,
                    top: 5,
                    child: IconButton(
                      onPressed: (){
                        // Navigator.pop(context);
                        Get.back();
                      }, 
                      icon: Icon(Icons.cancel_rounded),
                    ),
                  )
                ],
              ),
            ),
        ));
      // });

    return res??ImageType.unSelected;
  }

  

