// it's our default code what we get in main file when we create a new project.
import 'dart:ffi';

import 'package:flutter/material.dart';

void main() {
  runApp(MyApp());
}

class MyApp extends StatelessWidget{ // we use StatelessWidget when we did't should any changes in runtime.
  const MyApp({Key? key}) : super(key: key);

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
      home:HomePage(),
    );
  }
}

// class DeashBoardScreen extends StatefulWidget{
//   @override
//   Widget build(BuildContext context) {
//     return Scaffold(
//         appBar: AppBar(
//           title: Text("Deashboard"),
//         ),
//         body: Container(
//           color: Colors.blueGrey,
//         ),
//     );
//   }
class HomePage extends StatefulWidget
{

  @override
  State<StatefulWidget> createState()=>HomePageState();
}
class HomePageState extends State<HomePage>{
  @override
  Widget build(BuildContext context) {
    return Scaffold(
        appBar: AppBar(
          title: Text("Deashboards"),
        ),
      body: Container(
        child: Column(
          children:
          [
            header(),
            mid(),
            buttom(),
          ],
        ),
      ),
    );
  }
}

class header extends StatelessWidget{
  @override
  Widget build(BuildContext context) {
    return Expanded(
        flex: 2,
        child: Container(
          width: double.infinity,
          height: double.infinity,
          color: Colors.green,
          child: Center(
            child: Text("hell i am header part"),
          ),
        )
    );
  }
}

class mid extends StatelessWidget{
  @override
  Widget build(BuildContext context) {
    return Expanded(
        flex: 2,
          child: Container(
            width: double.infinity,
            height: double.infinity,
            color: Colors.orange,
        child: Center(
            child: Text("hell i am midel part"),
          ),
        )
    );
  }
}

class buttom extends StatelessWidget{
  @override
  Widget build(BuildContext context) {
    return Expanded(
        flex: 2,
          child: Container(
            width: double.infinity,
            height: double.infinity,
            color: Colors.grey,
        child: Center(
            child: Text("hell i am buttom part"),

          ),
        )
    );
  }
}