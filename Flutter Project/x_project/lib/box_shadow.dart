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
        body: Container(
          color: Colors.blue.shade50,
          child: Center(
            child: Container(
              height: 150,
              width: 150,
              // color: Colors.red,
              decoration: BoxDecoration(
                color: Colors.red, // if we take decoration we have to use color in decoration not outer site.
                // borderRadius: BorderRadius.only(topLeft: Radius.circular(11), bottomRight: Radius.circular(11.3)),
                // borderRadius: BorderRadius.circular(12.3), // for all corner
                border: Border.all(
                  width: 2,
                  color: Colors.black,
                ),
                  boxShadow : [
                    BoxShadow(
                      blurRadius: 12,
                      color: Colors.green,// default color box/container color not border
                      spreadRadius: 12,

                    )
                  ],
                shape: BoxShape.circle,// if we use shape we can't use borderRadius.
              ),
            ),
          ),
        ),
    );
  }
}

