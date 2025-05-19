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