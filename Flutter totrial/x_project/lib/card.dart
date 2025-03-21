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
              mainAxisAlignment: MainAxisAlignment.center,
              crossAxisAlignment: CrossAxisAlignment.start,
              children: [
                Card(
                  color: Colors.grey,
                  shadowColor: Colors.red,
                  elevation: 10, // shado in under like 3d
                  surfaceTintColor: Colors.white,// color mixing
                  child: Padding(
                    padding: const EdgeInsets.fromLTRB(5,0,5,0),
                    child: Text("hello romjan,\nhow are you?",style: style_font().text18(color: Colors.black),),
                  ),
                ),
                Card(
                  shadowColor: Colors.red,
                  elevation: 10, // shado in under like 3d
                  child: Padding(
                    padding: const EdgeInsets.fromLTRB(5,0,5,0),
                    child: Text("I'm fine and you?,",style: style_font().text18(),),
                  ),
                ),
                Card(
                  shadowColor: Colors.red,
                  elevation: 10, // shado in under like 3d
                  child: Padding(
                    padding: const EdgeInsets.fromLTRB(5,0,5,0),
                    child: Text("yeah, i am fine also\n so, what are you doing now days?",style: style_font().text18(color: Colors.black),),
                  ),
                ),
              ],
        ),
      ),
    );
  }
}

