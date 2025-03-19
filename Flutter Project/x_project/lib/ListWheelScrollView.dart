// it's our default code what we get in main file when we create a new project.
import 'package:flutter/material.dart';
import 'package:x_project/ui_helper/style_font.dart';

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
  var list = [1,2,3,0,4,5,6,7,8,9];
  @override
  Widget build(BuildContext context) {
    return Scaffold(
        appBar: AppBar(
          title: Text("Deashboards"),

        ),
      body: Container(
        height:double.infinity,
        width: double.infinity,
        color: Colors.red.shade100,
        child: ListWheelScrollView(
          itemExtent: 200, // height of each element
          children: list.map((element)=>
          Padding(
            padding: const EdgeInsets.all(8.0),
            child: Container(
              decoration: BoxDecoration(
                color: Colors.blue,
                borderRadius: BorderRadius.all(Radius.circular(10)),
              ),
              height: 20, // height are not workable.
              width: double.infinity,
              child: Center(child: Text("$element",style: style_font().text18(color: Colors.black),)),
              ),
          ),
          ).toList(),
        ),
      ),
    );
  }
}

