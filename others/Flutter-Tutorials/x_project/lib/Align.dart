import 'package:flutter/material.dart';

class Align_widget extends StatefulWidget {
  const Align_widget({super.key});

  @override
  State<Align_widget> createState() => _Align_widgetState();
}

class _Align_widgetState extends State<Align_widget> {
  @override
  Widget build(BuildContext context) {
    return Padding(
      padding: const EdgeInsets.all(8.0),
      child: Column(
        mainAxisAlignment: MainAxisAlignment.center,
        crossAxisAlignment: CrossAxisAlignment.center,
        children: [
          TextField(),
          Align(
            alignment: Alignment.centerRight,
            child: TextButton(onPressed: (){}, child: Text("Forgot password?")),
          ),
        ],
      ),
    );
  }
}