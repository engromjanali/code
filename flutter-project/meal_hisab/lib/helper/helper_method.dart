import 'dart:io';
import 'package:flutter/material.dart';
import 'package:image_cropper/image_cropper.dart';
import 'package:image_picker/image_picker.dart';

// pick an image 
Future<File?> pickedImage({ required bool fromCamera, required BuildContext context, required Function(String) onFail })async{
  File ? fileImage;
  if(fromCamera){
    try{
      final takenPhoto = await ImagePicker().pickImage(source: ImageSource.camera);
      if(takenPhoto!=null){
        fileImage = File(takenPhoto.path);
      }
    }catch (e){
      onFail(e.toString());
    }
  }
  else{
    try{
      final choosenImage = await ImagePicker().pickImage(source: ImageSource.gallery);
      if(choosenImage!=null){
        fileImage = File(choosenImage.path);
      }
    }catch(e){
      onFail(e.toString());
    }
  }
  if(fileImage==null){
    onFail("Image Selection Failed!\n Try Again.");
  }
  return fileImage;
}


class CropAspectRatioPresetCustom implements CropAspectRatioPresetData {
  @override
  (int, int)? get data => (2, 3);

  @override
  String get name => '2x3 (customized)';
}

Future<File?> cropImage(BuildContext context, String path)async{
  CroppedFile? croppedFile = await ImageCropper().cropImage(
    sourcePath: path,
    compressFormat: ImageCompressFormat.jpg,
    maxHeight: 500,
    maxWidth: 500,
    compressQuality: 100,
    uiSettings: [
      AndroidUiSettings(
        toolbarTitle: 'Cropper',
        toolbarColor: Colors.deepOrange,
        toolbarWidgetColor: Colors.white,
        initAspectRatio: CropAspectRatioPreset.square,
        lockAspectRatio: false,
        aspectRatioPresets: [
          CropAspectRatioPreset.original,
          CropAspectRatioPreset.square,
          CropAspectRatioPreset.ratio4x3,
          CropAspectRatioPresetCustom(),
        ],
      ),
      IOSUiSettings(
        title: 'Cropper',
        aspectRatioPresets: [
          CropAspectRatioPreset.original,
          CropAspectRatioPreset.square,
          CropAspectRatioPreset.ratio4x3,
          CropAspectRatioPresetCustom(),
        ],
      ),

      WebUiSettings(
        context: context,
        presentStyle: WebPresentStyle.dialog,
        size: const CropperSize(
          width: 520,
          height: 520,
        ),
      ),
    ],
  );
  if(croppedFile!= null) return File(croppedFile.path);
  return null;
}

// TimeOfDay to String time
String formatTimeOfDay(TimeOfDay time) {
  final hour = time.hourOfPeriod == 0 ? 12 : time.hourOfPeriod;
  final minute = time.minute.toString().padLeft(2, '0');
  final period = time.period == DayPeriod.am ? 'AM' : 'PM';
  return '$hour:$minute $period';
}

void add_in_bazer_List(List<Map<String, dynamic>> list, Map<String,dynamic> map){
  list.add(map);
}

// email validator
bool validateEmail(String email){
  final pattern = RegExp(r'^[\w-\.]+@([\w-]+\.)+[\w-]{2,4}$');
  return pattern.hasMatch(email);
}
// phone number validator
// ^(?:\+88|88)? → allows optional country code +88 or 88.
// 01[2-9] → valid operator codes (e.g., 013 to 019).
// \d{8}$ → exactly 8 digits after the operator code (total 11 digits).
bool numberVAladator(String phone){
  final pattern = RegExp(r'^(?:\+88|88)?01[2-9]\d{8}$');
  return pattern.hasMatch(phone);
}