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
        color: Colors.orange,
          child: InkWell(
            onTap: (){
              Navigator.pushReplacement(context, MaterialPageRoute(builder: (context)=>second_sereen()));
              print("pressed");
              },
        child: Hero(
          tag: "01673",
            child: Container(height: 300, width: 300, color:Colors.orange, child: Image.asset("assets/images/developer_photo.jpg", height: 100,width: 100, fit: BoxFit.fill,)),
          ),
        ),
      ),
    );
  }
}


class second_sereen extends StatefulWidget{
  @override
  State<second_sereen> createState() => _second_sereenState();
}

class _second_sereenState extends State<second_sereen> {
  @override
  Widget build(BuildContext context) => Scaffold(
    body: Container(
      child: Center(
            child: InkWell(
                onTap: (){Navigator.pushReplacement(context, MaterialPageRoute(builder: (context)=>HomePage()));},
        child: Hero(
            tag: "01673",
                child: Container(height: 100, width: 100, color:Colors.orange, child: Image.asset("assets/images/developer_photo.jpg"))),),
      ),
    ),
  );
}