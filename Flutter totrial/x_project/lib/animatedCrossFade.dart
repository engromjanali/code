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
  bool isFast = true;
  @override
  void initState() {
    // TODO: implement initState
    super.initState();

    reload();
  }
  void reload(){
    Timer(Duration(seconds: 4),()
    {
      setState(() {
        isFast = false;
      });
    });
  }
  @override
  Widget build(BuildContext context) {
    return Scaffold(
        appBar: AppBar(
          title: Text("Deashboards"),

        ),
      body: Center(
        child: Container(
          child: Column(
            mainAxisAlignment: MainAxisAlignment.center,
            children: [
              AnimatedCrossFade(
                duration: Duration(seconds: 4),
                sizeCurve:Curves.bounceOut,
                firstCurve: Curves.fastOutSlowIn,
                secondCurve: Curves.linear,

                firstChild: Container(
                  color: Colors.red,
                  width: 300,
                  height: 300,
                ),
                secondChild: Container(
                  color: Colors.green,
                  width: 200,
                  height: 200,
                ),
                crossFadeState: isFast? CrossFadeState.showFirst: CrossFadeState.showSecond,
              ),
              ElevatedButton(onPressed: (){
                if(isFast)
                  {
                    isFast = false;
                    setState(() {

                    });
                  }
                else{
                  isFast = true;
                  setState(() {

                  });
                }
              }, child: Text("press"))
            ],
          ),
        ),
      ),
    );
  }

}

