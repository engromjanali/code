// it's our default code what we get in main file when we create a new project.
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
        decoration: BoxDecoration(
          // gradient: LinearGradient(
          //   colors: [Colors.red, Colors.green],
          //   // colors: [Color(0xffff9a9e),Color(0xfffad0c4),Color(0xffff9a9e)], // here color code is "0x" + "00-ff (represent opacity)" + "ff9a9e (color hex code)"
          //   begin: FractionalOffset(1.0 , 0.0),//(x,y) (0.0-1.0)
          //   end : FractionalOffset(0.0 , 1.0),//(x,y) (0.0-1.0)
          //   stops: [0.0,0.6]// remember how many color you have used.
          //
          // ),
          gradient: RadialGradient(
            // colors: [Colors.red, Colors.green],
            colors: [Color(0xffff9a9e),Color(0xfffad0c4),Color(0xffff9a9e)], // here color code is "0x" + "00-ff (represent opacity)" + "ff9a9e (color hex code)"
            center: Alignment.bottomCenter,
            // stops: [0.5,0.9]// remember how many color you have used.
          )
          
        ),
      ),
    );
  }

}

