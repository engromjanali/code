import 'package:flutter/material.dart';

class TransformDemo extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(title: Text("Transform Rotate")),
      body: Center(
        child: Container(
          height: 100,
          width: 100,
          color: Colors.red,
          child: ClipRRect( // to remove/hide overflowed area
            child: Transform.rotate(
              angle: 0.5, // রেডিয়ান এ (π রেডিয়ান = 180°)
              child: Container(
                width: 100,
                height: 100,
                color: Colors.blue,
                child: Center(child: Text("Rotate", style: TextStyle(color: Colors.white))),
              ),
            ),
          ),
        ),
      ),
    );
  }
}


// Transform.scale(
//   scale: 1.5, // 1.5x বড়
//   child: Container(
//     width: 100,
//     height: 100,
//     color: Colors.green,
//     child: Center(child: Text("Scale", style: TextStyle(color: Colors.white))),
//   ),
// )


// Transform.translate(
//   offset: Offset(50, -30), // ডানদিকে ৫০px, উপরে ৩০px
//   child: Container(
//     width: 100,
//     height: 100,
//     color: Colors.orange,
//     child: Center(child: Text("Move", style: TextStyle(color: Colors.white))),
//   ),
// )


// Transform(
//   transform: Matrix4.identity()
//     ..rotateZ(0.2)   // Z-axis এ rotate
//     ..scale(1.2)     // scale
//     ..translate(30.0, 20.0), // move
//   alignment: Alignment.center,
//   child: Container(
//     width: 120,
//     height: 120,
//     color: Colors.purple,
//     child: Center(child: Text("Matrix4", style: TextStyle(color: Colors.white))),
//   ),
// )