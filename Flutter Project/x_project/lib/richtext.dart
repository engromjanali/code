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
      body: Center(
        child: Container(
          child: RichText(
            text: TextSpan(
              style: TextStyle( // the style will be default style
                color: Colors.grey,
                fontSize: 18,
              ),
            children: <TextSpan>[
              TextSpan(text: "hello ",), // following the default style
              TextSpan(text: "Developer, ", style: TextStyle(color: Colors.blue, fontWeight: FontWeight.bold, fontSize: 30, fontStyle: FontStyle.italic)), // override style
              TextSpan(text: "welcome to ",),
              TextSpan(text: "Flutter.", style: TextStyle(color: Colors.red, fontWeight: FontWeight.w600, fontSize: 30, fontStyle: FontStyle.italic)),
            ]
            ),
          ),
        ),
      ),
    );
  }

}

