import 'package:flutter/material.dart';
import 'package:flutter/services.dart';
import 'package:font_awesome_flutter/font_awesome_flutter.dart';
import 'package:get/get.dart';
import 'package:get/get_connect/http/src/utils/utils.dart';
import 'package:momo/core/util/constants/url.dart';
import 'package:momo/core/helper/launch_url.dart';
import 'package:momo/prsentation/screens/my_profile/setting/screens/faq_screen.dart';
import 'package:momo/prsentation/screens/my_profile/setting/screens/privacy_and_policy.dart';
import 'package:momo/prsentation/screens/my_profile/setting/screens/terms_of_user.dart';

class SettingScreen extends StatefulWidget {
  const SettingScreen({super.key});

  @override
  State<SettingScreen> createState() => _SettingScreenState();
}

class _SettingScreenState extends State<SettingScreen> {
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      backgroundColor: Colors.black,
      appBar: AppBar(
        foregroundColor: Colors.white,
        backgroundColor: Colors.black,
        title: Text(
          "Settings",
          style: TextStyle(fontWeight: FontWeight.w500, color: Colors.white),
        ),
      ),

      body: Column(
        children: [
          Divider(color: Colors.grey.withAlpha(100)),

          // socail media section
          Container(
            padding: EdgeInsets.symmetric(horizontal: 16),
            margin: EdgeInsets.all(10),
            decoration: BoxDecoration(
              color: Colors.grey.withAlpha(50),
              borderRadius: BorderRadius.circular(10),
            ),
            child: Column(
              children: [
                getItem(
                  iconData: FontAwesomeIcons.instagram,
                  label: "Instagram",
                  ontap: () {
                    openUrl(Url.instagram);
                  },
                ),
                getItem(
                  iconData: FontAwesomeIcons.tiktok,
                  label: "Tik-Tok",
                  ontap: () {
                    openUrl(Url.tiktok);
                  },
                  isLastitem: true,
                ),
              ],
            ),
          ),

          SizedBox(height: 30),

          // SETTINGS FUTURES
          Container(
            padding: EdgeInsets.symmetric(horizontal: 16),
            margin: EdgeInsets.all(10),
            decoration: BoxDecoration(
              color: Colors.grey.withAlpha(50),
              borderRadius: BorderRadius.circular(10),
            ),
            child: Column(
              children: [
                getItem(
                  iconData: Icons.restore,
                  label: "Restore Purchase",
                  ontap: () {
                  },
                ),
                getItem(
                  iconData: FontAwesomeIcons.solidCircleQuestion,
                  label: "FAQ",
                  ontap: () {
                    Get.to(() => FaqScreen());
                  },
                ),
                getItem(
                  iconData: Icons.feedback,
                  label: "Feedback",
                  ontap: () {
                    opemMail(to: "engromjanali@gmail.com", subject: "feedback", body: "Write somthing here...");
                  },
                ),
                getItem(
                  iconData: FontAwesomeIcons.solidStar,
                  label: "Rate Us",
                  ontap: () {
                    openUrl("https://console.firebase.google.com/u/0/");
                  },
                ),
                getItem(
                  iconData: FontAwesomeIcons.solidFolder,
                  label: "Terms of Use",
                  ontap: () {
                    Get.to(()=>TermsOfUser());
                  },
                ),
                getItem(
                  iconData: FontAwesomeIcons.solidFolder,
                  label: "Privacy Policy",
                  ontap: () {
                    Get.to(()=>PrivacyPolicy());
                  },
                ),
                getUserIdItem(
                  iconData: Icons.person,
                  trealingIcon: Icons.file_copy,
                  label: "User ID",
                  secondLabel: "483nvidfn10238593",
                  ontap: () {
                    Clipboard.setData(ClipboardData(text: "483nvidfn10238593"));
                    Get.snackbar("Copyed", "", colorText: Colors.white);
                  },
                  isLastitem: true,
                ),
              ],
            ),
          ),
          Text("Version 2.6.1", style: TextStyle(color: Colors.grey.shade500)),
        ],
      ),
    );
  }

  Widget getItem({
    required String label,
    required IconData iconData,
    required Function() ontap,
    bool isLastitem = false,
  }) => Column(
    children: [
      GestureDetector(
        onTap: ontap,
        child: Padding(
          padding: const EdgeInsets.symmetric(vertical: 16),
          child: Row(
            children: [
              FaIcon(iconData, color: Colors.white, size: 20),
              Expanded(
                child: Padding(
                  padding: const EdgeInsets.symmetric(horizontal: 10),
                  child: Text(
                    label, // the text
                    style: TextStyle(color: Colors.white, fontSize: 18),
                  ),
                ),
              ),
              Icon(Icons.keyboard_arrow_right, color: Colors.white, size: 25),
            ],
          ),
        ),
      ),
      if (!isLastitem) Divider(height: 1, color: Colors.grey.withAlpha(50)),
    ],
  );

  Widget getUserIdItem({
    required String label,
    required String secondLabel,
    required IconData trealingIcon,
    required IconData iconData,
    required Function() ontap,
    bool isLastitem = false,
  }) => GestureDetector(
    onTap: ontap,
    child: Column(
      children: [
        Padding(
          padding: const EdgeInsets.symmetric(vertical: 16),
          child: Row(
            children: [
              FaIcon(iconData, color: Colors.white, size: 20),
              Expanded(
                child: Padding(
                  padding: const EdgeInsets.symmetric(horizontal: 10),
                  child: Text(
                    label, // the text
                    style: TextStyle(color: Colors.white, fontSize: 18),
                  ),
                ),
              ),
              SizedBox(
                width: 130,
                child: Text(
                  secondLabel,
                  style: TextStyle(color: Colors.grey.shade500),
                  overflow: TextOverflow.ellipsis,
                ),
              ),
              SizedBox(width: 10),
              Icon(trealingIcon, color: Colors.white, size: 25),
            ],
          ),
        ),
        if (!isLastitem) Divider(height: 1, color: Colors.grey.withAlpha(50)),
      ],
    ),
  );
}
