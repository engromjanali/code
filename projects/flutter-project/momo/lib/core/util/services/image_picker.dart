import 'dart:io';

import 'package:flutter/material.dart';
import 'package:get/get.dart';
import 'package:image_picker/image_picker.dart';

class ImagePickerServices {
  ImagePicker _picker = ImagePicker();

  ImagePickerServices() {}

  Future<XFile?> pickSingleImage({ImageSource choseFrom = ImageSource.gallery}) async {
    XFile? pickedFile;
    try {
      pickedFile = await _picker.pickImage(source: choseFrom);
    } catch (e) {
      Get.snackbar("Image Picker", "Somthing Want Wrong!");
    }
    return pickedFile;
  }

  Future<List<XFile>?> pickMultipleImage() async {
    try {
      List<XFile> pickedFileList = await _picker.pickMultiImage(limit: 20);
      return pickedFileList;
    } catch (e) {
      Get.snackbar("Image Picker", "Somthing Want Wrong!");
    }
  }

  Future<List<XFile>?> getLostData() async {
    try {
      if (!Platform.isAndroid)
        return null; // may we lost data only android devices.
      LostDataResponse response = await _picker.retrieveLostData();
      if (response.isEmpty) return null;
      debugPrint("lost image found");

      if (response.files != null && response.files!.isNotEmpty) {
        return response.files;
      } else {
        debugPrint("Error: ${response.exception}");
        Get.snackbar("Image Picker", "Picked Image Lost!");
      }
    } catch (e) {
      Get.snackbar("Image Picker", "Somthing Want Wrong!");
    }
  }
}
