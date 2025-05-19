
import 'package:flutter/material.dart';

void main() => runApp(MyApp());

class MyApp extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: 'Slide Pages Demo',
      home: PageSlider(),
    );
  }
}

class PageSlider extends StatelessWidget {
  // it's a built in package, don't require any packages.
  final PageController _controller = PageController();

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text('Slide Pages'),
      ),
      body: PageView(
        controller: _controller,
        scrollDirection: Axis.horizontal,
        children: [
          Container(color: Colors.red, child: Center(child: Text('Page 1', style: TextStyle(fontSize: 24, color: Colors.white)))),
          Container(color: Colors.green, child: Center(child: Text('Page 2', style: TextStyle(fontSize: 24, color: Colors.white)))),
          Container(color: Colors.blue, child: Center(child: Text('Page 3', style: TextStyle(fontSize: 24, color: Colors.white)))),
        ],
      ),
    );
  }
}