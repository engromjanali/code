// it's our default code what we get in main file when we create a new project.
import 'package:flutter/material.dart';

void main() {
  runApp(MyApp());
}

class MyApp extends StatelessWidget{ // we use StatelessWidget when we did't should any changes in runtime.
  @override
  Widget build(BuildContext context) {
    // return CupertinoApp()// for IOS
    // return MaterialApp()// for Android
    return MaterialApp(
      debugShowCheckedModeBanner: false,
      title: "hello programmer",
      theme: ThemeData(
        primarySwatch: Colors.green,
        appBarTheme: AppBarTheme(
          backgroundColor: Colors.red, // Explicitly set AppBar color
        ),
        useMaterial3: true,
      ),
      home:DeashBoardScreen(),
    );
  }
}

class DeashBoardScreen extends StatelessWidget{
  @override
  Widget build(BuildContext context) {
    return Scaffold(
        appBar: AppBar(
          title: Text("Deashboard"),
        ),
        body: Center(
          child: CircleAvatar(
            child: Text("Loding..", style: TextStyle(color: Colors.black),), //we can pass here anything it's will be show in center of circle and top. we can pass row,column,image,container, etc.
            backgroundColor: Colors.red,
            backgroundImage: AssetImage("assets/images/developer_photo.jpg"),
            // radius: 30,
            maxRadius: 50, // if we use "maxRadius" or "minRadius" radius we can use jast "radius"
            minRadius: 30,
          ),

        ),
    );
  }
}

