import 'package:flutter/material.dart';
import 'package:get/get.dart';
import 'package:momo/core/util/constants/all_enums.dart';
import 'package:momo/core/util/constants/colors.dart';
import 'package:momo/core/util/constants/text_style.dart';
import 'package:momo/core/widgets/bottom_button.dart';
import 'package:momo/core/widgets/model_name_screen.dart';

class GenderSelection extends StatefulWidget {
  const GenderSelection({super.key});

  @override
  State<GenderSelection> createState() => _GenderSelectionState();
}

class _GenderSelectionState extends State<GenderSelection> {
  Gender selectedGender = Gender.female;
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      bottomNavigationBar: getBottomRoundedButton(
        label: "Continue",
        ontap: () {
          Get.to(()=>ModelNameScreen());
        },
      ),
      backgroundColor: Colors.black,
      appBar: AppBar(
        backgroundColor: Colors.black,
        foregroundColor: Colors.white,
      ),
      body: Column(
        children: [
          Text("Pick Your Gender", style: getTitleStyleExplore()),
          Text(
            "This Information Will improve your selection of model images for the genartion of your photos",
            style: getTitleStyle().copyWith(color: Colors.grey),
          ),

          Spacer(),
          Column(
            spacing: 10,
            children: [
              getGenderButton(onTap: () {
                setState(() {
                  selectedGender  = Gender.female;
                });
              }, label: "Female",isSelected: selectedGender==Gender.female),
              getGenderButton(onTap: () {
                setState(() {
                  selectedGender  = Gender.male;
                });
              }, label: "Male",  isSelected: selectedGender==Gender.male),
              getGenderButton(onTap: () {
                setState(() {
                  selectedGender  = Gender.other;
                });
              }, label: "Other", isSelected: selectedGender==Gender.other),
            ],
          ),
          Spacer(),
          SizedBox(height: 100),
        ],
      ),
    );
  }

  Widget getGenderButton({required Function() onTap, required String label, required bool isSelected}) {
    return GestureDetector(
      onTap: onTap,
      child: Container(
        padding: EdgeInsets.all(20),
        width: double.infinity,
        decoration: BoxDecoration(
          color: cardColor,
          border: BoxBorder.all(
            color: isSelected? Colors.grey :Colors.grey.withAlpha(100),
          ),
          borderRadius: BorderRadius.circular(10),
        ),
        child: Center(child: Text(label, style: TextStyle(color: isSelected? Colors.white : Colors.grey, fontSize: 18))),
      ),
    );
  }
}
