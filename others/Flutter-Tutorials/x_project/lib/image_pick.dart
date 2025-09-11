import 'dart:io';
import 'package:flutter/material.dart';
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

