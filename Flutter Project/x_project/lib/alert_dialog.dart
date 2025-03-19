  import 'package:flutter/material.dart';

void showImagePickerDialog(){
    showDialog(
      context: context,
      builder: (context){
        return AlertDialog(
          title: Text("choose from -"),

          content: Column(
            mainAxisAlignment: MainAxisAlignment.center,
            mainAxisSize: MainAxisSize.min,
            children: [
              ListTile(
                leading: Icon(Icons.camera_alt),
                title: Text("Camera"),
              )
            ],
          ),
        );
      }
    );
  }


  Future<bool?> _showExitConfirmDialog(BuildContext context) async{
    return showDialog<bool>(
      context: context,
      builder: (context)=> AlertDialog(
        title:Text("Leave Geame",textAlign: TextAlign.center),
        content: Text("Are you sure to leave this game? ",textAlign: TextAlign.center),
        actions: [
          TextButton(onPressed: (){
            Navigator.of(context).pop(false); // return false with dispose the dialog
          }, 
          child: const Text("Cancel")),
          TextButton(onPressed: (){
            Navigator.of(context).pop(true); // return true with dispose the dialog 
          }, 
          child: const Text("Yes")),
        ],
      ));
  }
