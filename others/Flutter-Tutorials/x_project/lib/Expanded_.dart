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
        body: Column(
          children: [
            Container(
              height: 100,
              color: Colors.yellow,
            ),
            Expanded(
              flex: 2,
              child: Container(
                height: 100,
                color: Colors.red,
              ),
            ),
            Expanded(
              // flex: 1,
              child: Row(
                children: [
                  Expanded(
                    flex:2,
                   child: Container(
                    // height: 100,
                     width: 100,
                    color: Colors.pink,
                    ),
                  ),
                  Expanded(
                    flex:1,
                    child: Container(
                      // height: 100,
                      width: 100,
                      color: Colors.green,
                    ),
                  ),
                  Container(
                    height: 100,
                    width: 100,
                    color: Colors.blue,
                  ),
                ],
              ),
            ),
            Expanded(
              // flex: 1,
              child: Container(
                height: 100,
                color: Colors.grey,
              ),
            ),
          ],
        ),
    );
  }
}

