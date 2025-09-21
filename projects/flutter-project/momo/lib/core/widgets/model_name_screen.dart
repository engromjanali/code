import 'package:flutter/material.dart';
import 'package:get/get.dart';
import 'package:momo/core/util/constants/colors.dart';
import 'package:momo/core/util/constants/text_style.dart';
import 'package:momo/core/widgets/bottom_button.dart';
import 'package:momo/prsentation/screens/purchese_screen.dart';

class ModelNameScreen extends StatefulWidget {
  const ModelNameScreen({super.key});

  @override
  State<ModelNameScreen> createState() => _ModelNameScreenState();
}

class _ModelNameScreenState extends State<ModelNameScreen> {
  TextEditingController nameController = TextEditingController();
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      bottomNavigationBar: (nameController.text.isNotEmpty)
          ? getBottomRoundedButton(
              label: "Continue",
              ontap: () {
                Get.to(()=>PurcheseScreen());
              },
              margin: EdgeInsets.only(left: 10, right: 10,bottom: 20),
            )
          : null,
      backgroundColor: Colors.black,
      appBar: AppBar(
        foregroundColor: Colors.white,
        backgroundColor: Colors.black,
      ),
      body: Padding(
        padding: const EdgeInsets.all(8.0),
        child: Column(
          spacing: 20,
          crossAxisAlignment: CrossAxisAlignment.start,
          children: [
            Padding(
              padding: const EdgeInsets.symmetric(vertical: 20.0),
              child: Text(
                "Name Your AI Model",
                style: getTitleStyle().copyWith(fontSize: 26),
              ),
            ),
            Text(
              "This information will improve your selection of medl images for the generation of your photos.",
              style: getSubtitleStyle().copyWith(fontSize: 18),
            ),
            Container(
              padding: EdgeInsets.all(10),
              decoration: BoxDecoration(
                color: cardColor,
                borderRadius: BorderRadius.circular(10),
              ),
              child: TextField(
                controller: nameController,
                autocorrect: false,
                decoration: InputDecoration(
                  border: InputBorder.none,
                  hint: Text("Type Your Model Name", style: getSubtitleStyle()),
                  suffixIcon: nameController.text.isNotEmpty
                      ? IconButton(
                          onPressed: () {
                            nameController.clear();
                          },
                          icon: Icon(Icons.cancel),
                          color: Colors.white,
                        )
                      : null,
                ),
                style: getTextFieldStyle(),
                onChanged: (value) {
                  setState(() {});
                },
              ),
            ),
            Spacer(),
          ],
        ),
      ),
    );
  }
}
