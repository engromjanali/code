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
  call_back()
  {
    print("you have clicked!!");
  }
  VoidCallback? callback(){
    print("hello developer");
  }
  @override
  Widget build(BuildContext context) {
    return Scaffold(
        appBar: AppBar(
          title: Text("Deashboard"),
        ),
        body: Container(
          color: Colors.blueGrey,
          child:Column(
            children: [
              ElevatedButton(onPressed: call_back, child: Text("click here")),
              ElevatedButton(onPressed: (){call_back(); }, child: Text("click here")),
              ElevatedButton(onPressed: (){callback(); }, child: Text("click here")),
              ElevatedButton(onPressed: (){callback(); print("welcome"); }, child: Text("click here")),
              ElevatedButton(onPressed: call_back, child: Text("click here")),
            ],
          ),
        ),
    );
  }
}