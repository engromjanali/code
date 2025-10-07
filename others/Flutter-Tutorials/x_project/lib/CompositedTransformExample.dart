import 'package:flutter/material.dart';

void main() => runApp(MyApp());

class MyApp extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      home: CompositedTransformExample(),
    );
  }
}

class CompositedTransformExample extends StatefulWidget {
  @override
  _CompositedTransformExampleState createState() => _CompositedTransformExampleState();
}

class _CompositedTransformExampleState extends State<CompositedTransformExample> {
  final LayerLink _layerLink = LayerLink();
  OverlayEntry? _overlayEntry;


  /// this is the 2nd widget what will be show as pop up,
  /// when we call this function,
  /// CompositedTransformFollower always binded with CompositedTransformTarget, i mean if the target widget move the follower widget will move with target,
  /// আপনি একটি বাসে ভ্রমণ করছেন আর আপনার হাতে একটি বেলুন বাঁধা
  /// আপনি যতই সামনে-পিছনে করুন, বেলুনটি সবসময় আপনার হাতের সাথেই থাকবে

  void _showOverlay(BuildContext context) {
    if (_overlayEntry != null) return; // already showing

    _overlayEntry = OverlayEntry(
      builder: (context) => Positioned(
        width: 200,
        child: CompositedTransformFollower(
          link: _layerLink, // this link binded both widget wach other,
          showWhenUnlinked: false, // otherwise it's keep showing even when we  dispose target widget or move to otherpage. 
          offset: const Offset(0, 50), // target থেকে ৫০px নিচে
          child: Material(
            elevation: 8,
            borderRadius: BorderRadius.circular(12),
            child: Container(
              padding: EdgeInsets.all(12),
              color: Colors.amber,
              child: Text("🎈 আমি তোমার সাথে বাঁধা!আমি তোমার সাথে বাঁধা!আমি তোমার সাথে বাঁধা!আমি তোমার সাথে বাঁধা!আমি তোমার সাথে বাঁধা!আমি তোমার সাথে বাঁধা!", style: TextStyle(fontSize: 16)),
            ),
          ),
        ),
      ),
    );

    Overlay.of(context).insert(_overlayEntry!);
  }

  void _hideOverlay() {
    _overlayEntry?.remove();
    _overlayEntry = null;
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(title: Text("LayerLink Demo 🎈")),
      body: Center(
        child: CompositedTransformTarget(
          link: _layerLink, // this link binded both widget wach other, 
          child: ElevatedButton(
            onPressed: () {
              if (_overlayEntry == null) {
                _showOverlay(context);
              } else {
                _hideOverlay();
              }
            },
            child: Text("Show / Hide Follower"),
          ),
        ),
      ),
    );
  }
}
