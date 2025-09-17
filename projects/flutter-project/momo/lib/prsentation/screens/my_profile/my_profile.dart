import 'package:flutter/material.dart';
import 'package:get/route_manager.dart';
import 'package:momo/core/util/constants/all_enums.dart';
import 'package:momo/core/controller/c_home.dart';
import 'package:momo/main.dart';
import 'package:momo/prsentation/screens/my_profile/ai_prifile/get_started.dart';
import 'package:momo/prsentation/screens/my_profile/setting/setting_screen.dart';
import 'package:momo/prsentation/screens/my_profile/DialogScreen.dart';
import 'package:momo/prsentation/screens/my_profile/ai_prifile/ai_profile.dart';
import 'package:momo/prsentation/screens/my_profile/one_shot.dart';
import 'package:provider/provider.dart';

class MyProfile extends StatefulWidget {
  const MyProfile({super.key});

  @override
  State<MyProfile> createState() => _MyProfileState();
}

class _MyProfileState extends State<MyProfile> {
  bool isAiProfile = true;

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      backgroundColor: Colors.black,
      appBar: AppBar(
        backgroundColor: Colors.black,
        foregroundColor: Colors.white,
        actions: [
          IconButton(
            onPressed: () {
              Get.to(() => SettingScreen());
            },
            icon: const Icon(Icons.settings),
          ),
        ],
        title: const Text("My Profile"),
      ),
      body: Column(
        children: [
          Divider(color: Colors.grey.withAlpha(50)),
          const SizedBox(height: 20),

          /// Options button with sliding animation
          Container(
            height: 50,
            width: double.maxFinite,
            margin: const EdgeInsets.symmetric(vertical: 20, horizontal: 30),
            decoration: BoxDecoration(
              color: Colors.grey.withAlpha(50),
              borderRadius: BorderRadius.circular(10),
            ),
            child: Stack(
              children: [
                /// Sliding highlight
                AnimatedAlign(
                  alignment: isAiProfile
                      ? Alignment.centerLeft
                      : Alignment.centerRight,
                  duration: const Duration(milliseconds: 200),
                  curve: Curves.linear,
                  child: Container(
                    width:
                        MediaQuery.of(context).size.width / 2 - 30, // half size
                    height: 50,
                    decoration: BoxDecoration(
                      color: Colors.grey.withAlpha(150),
                      borderRadius: BorderRadius.circular(10),
                    ),
                  ),
                ),

                /// Options Row
                Row(
                  children: [
                    Expanded(
                      child: GestureDetector(
                        onTap: () {
                          setState(() {
                            isAiProfile = true;
                          });
                        },
                        child: Container(
                          color: Colors.transparent,
                          child: Center(
                            child: Text(
                              "Ai Profile",
                              style: TextStyle(
                                color: Colors.white,
                                fontSize: 18,
                                fontWeight: FontWeight.w600,
                              ),
                            ),
                          ),
                        ),
                      ),
                    ),
                    Expanded(
                      child: GestureDetector(
                        onTap: () {
                          setState(() {
                            isAiProfile = false;
                          });
                        },
                        child: Container(
                          color: Colors.transparent,
                          child: Center(
                            child: Text(
                              "One Shot",
                              style: TextStyle(
                                color: Colors.white,
                                fontSize: 18,
                                fontWeight: FontWeight.w600,
                              ),
                            ),
                          ),
                        ),
                      ),
                    ),
                  ],
                ),
              ],
            ),
          ),

          // make it a section
          isAiProfile
              ? getAiProfile(
                  onTap: ()async {
                    ImageType imageType = await  showImageTypeChosserDialog(context);
                    Get.snackbar(
                      "Image Selected Type", imageType.name,
                      colorText: Colors.white
                    );
                    Get.to(()=>GetStarted(imageType: imageType,));
                  },
                )
              : 
              getOneShot(
                onTap: () {
                  CHome cHome = navigatorKey.currentContext!.read<CHome>();
                  // mean one shot screen
                  cHome.setCurrentPage(1);
                },
              ),
        ],
      ),
    );
  }
}
