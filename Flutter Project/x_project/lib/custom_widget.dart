// it's our default code what we get in main file when we create a new project.
import 'package:flutter/material.dart';
import 'package:x_project/widgets/reactangle_button.dart';

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
        height: double.infinity,
        width: double.infinity ,
        color: Colors.grey,
        child: Column(
          children: [
            reactangle_button(btnName: "play", icon: Icon(Icons.play_arrow),),
            SizedBox(
              height: 10,
            ),
            reactangle_button(btnName: "stop", icon: Icon(Icons.play_arrow, color: Colors.red,), btnStyle: TextStyle(color: Colors.green),bgColor:Colors.orange.shade100, shadoColor: Colors.red,),
            reactangle_button(btnName: "again",callback: (){print("hello programmers how are you?");}, icon: Icon(Icons.password, color: Colors.red,), btnStyle: TextStyle(color: Colors.green),bgColor:Colors.orange.shade100, shadoColor: Colors.red,),
          ],
        ),
      ),
    );
  }
}

