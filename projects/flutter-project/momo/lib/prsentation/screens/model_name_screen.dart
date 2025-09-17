import 'package:flutter/material.dart';
import 'package:get/get.dart';
import 'package:momo/core/util/constants/colors.dart';
import 'package:momo/core/util/constants/text_style.dart';
import 'package:momo/core/widgets/bottom_button.dart';

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
      backgroundColor: Colors.black,
      appBar: AppBar(),
      body: Padding(
        padding: const EdgeInsets.all(8.0),
        child: Column(
          spacing: 20,
          crossAxisAlignment: CrossAxisAlignment.start,
          children: [
            Padding(
              padding: const EdgeInsets.symmetric(vertical: 20.0),
              child: Text("Name Your AI Model", style: getTitleStyle().copyWith(fontSize: 26)),
            ),
            Text(
              "This information will improve your selection of medl images for the generation of your photos.",
              style: getSubtitleStyle().copyWith(fontSize: 18),
            ),
            Container(
              padding: EdgeInsets.all(2),
              decoration: BoxDecoration(
                color: cardColor,
                borderRadius: BorderRadius.circular(10),
              ),
              child: TextField(
                controller: nameController,
                autocorrect: false,
                decoration: InputDecoration(
                  border: InputBorder.none,
                  hint: Text(
                    "Type Your Model Name..,",
                    style: getSubtitleStyle(),
                  ),
                  suffixIcon:nameController.text.isNotEmpty? IconButton(
                    onPressed: () {
                      nameController.clear();
                    },
                    icon: Icon(Icons.cancel),
                    color: Colors.white,
                  ):null,
                ),
                style: getTitleStyle(),
                onChanged: (value) {
                  setState(() {});
                },
              ),
            ),
            Spacer(),
            if (nameController.text.isNotEmpty)
              getBottomRoundedButton(label: "Continue", ontap: () {
                // Get.to(()=>s);
              },
              margin: EdgeInsets.only(bottom: 20)),
          ],
        ),
      ),
    );
  }
}
