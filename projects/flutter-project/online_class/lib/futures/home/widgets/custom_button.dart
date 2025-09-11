import 'package:flutter/material.dart';
import 'package:flutter/widgets.dart';

class CustomButton extends StatefulWidget{
  final String text;
  final Function() onTap;
  const CustomButton({super.key, required this.text, required this.onTap});

  State<CustomButton> createState()=> _CustomButtonState();

}

class _CustomButtonState extends State<CustomButton>{

  @override
  Widget build(BuildContext context){
    return Padding(
        padding: EdgeInsets.symmetric(vertical: 5, horizontal: 20),
        child: SizedBox(
          width: double.maxFinite,
          child: ElevatedButton(
            onPressed: widget.onTap,
            
            style: ElevatedButton.styleFrom(
              backgroundColor: Colors.blue,
              shape: RoundedRectangleBorder(
                borderRadius: BorderRadiusGeometry.circular(10)
              )
            ), 
            child: Text(
              widget.text,
              style: TextStyle(color: Colors.white,fontSize: 20, fontWeight: FontWeight.w600),),
          ),
        ),
      );
  }

}