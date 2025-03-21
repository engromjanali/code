
import 'package:flutter/material.dart';

class MainAuthButton extends StatelessWidget {
  const MainAuthButton({
    super.key,
    required this.label,
    required this.onPressed,
    required this.fontSize,
  });
  final String label;
  final Function() onPressed;
  final double fontSize;

  @override
  Widget build(BuildContext context) {
    return Material(
      elevation: 10, // shado in under like 3d
        color: Colors.blue,
        borderRadius: BorderRadius.circular(10),
      child: MaterialButton(onPressed: onPressed,
      minWidth: double.infinity,
        child: Text(
          label,
          style: TextStyle(
            fontSize: fontSize,
            fontWeight: FontWeight.bold,
            color: Colors.white,
            letterSpacing: 1.5,
          ),
        ),
      ),
    );
  }
}
