// it's our default code what we get in main file when we create a new project.
import 'dart:async';

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
class HomePage extends StatefulWidget {
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
        child: ElevatedButton(onPressed: (){
          // Navigator.push(context, MaterialPageRoute(builder: (context)=>second_secrren())); // to push another screen to the stack
          // Navigator.pushReplacement(context, MaterialPageRoute(builder: (context)=>second_secrren())); // to replace the current screen by the given screen
          // Navigator.pop(context); // pop current screen
          // Navigator.pop(context, "Hello from Second Screen!"); // pop current screen and send an message
          Navigator.pushAndRemoveUntil(context, MaterialPageRoute(builder: (context)=>second_secrren()), (Route<dynamic>route)=>false); // remove all previous screen and push given screen.

        }, child: Center(child: Text("go"))),
      ),
    );
  }
}


class second_secrren extends StatelessWidget{
  second_secrren(){
    Timer(Duration(seconds: 2),(){});
  }
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      body: Container(
        color: Colors.green,
        child: Center(child: Text("hey, i am second screen!")),
      ),
    );
  }
}

