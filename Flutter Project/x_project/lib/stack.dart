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
      body: Container(
          child: Stack( // child can't go out of stack sized

            children: [
              Container(   // here stack gain full size of container, so stack size is this container size.
                color: Colors.green,
                width: 370,
                height: 600,
              ),
              Positioned(
                top: 20,
                child: Container(
                  height: 500,
                  width: 360,
                  color: Colors.orange,
                ),
              ),
              Positioned( //  here child start from x=10,y=20.
                top: 10,
                left: 20,
                child: Container(
                  height: 300,
                  width: 330,
                  color: Colors.red,
                  child: Stack(
                    children: [
                      Positioned( // here height/width dose not matter if we use all position. the child take parent's size exiting positioned.
                        top: 10,
                        left: 10,
                        right: 10,
                        bottom: 10,
                        child: Container(
                          color: Colors.grey,
                          height: 500,
                          width: 500,
                        ),
                      )
                    ],
                  ),
                ),
              )
            ],
          ),
      ),
    );
  }

}

