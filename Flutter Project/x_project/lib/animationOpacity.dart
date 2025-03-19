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
  var myOpacity = 1.0;
  bool flag = true;

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text("Deashboards"),

      ),
      body: Container(
        width: double.infinity,
        height: double.infinity,
        color: Colors.orange,
        child: Column(
          mainAxisAlignment: MainAxisAlignment.center,
          children: [
            Padding(
              padding: const EdgeInsets.all(8.0),
              child: AnimatedOpacity(
                opacity: myOpacity, // opacity 1 mean full visible
                duration: Duration(seconds: 2),
                curve: Curves.easeInBack,
                child: Container(
                  width: 200,
                  height:200,
                  color: Colors.white,
                ),
              ),
            ),
            ElevatedButton(onPressed: (){
              if(flag){
                flag = false;
                myOpacity = 0;
              }
              else{
                flag = true;
                myOpacity =1.0;
              }
              setState(() {

              });
            }, child: Text("press")),
          ],
        ),

      ),
    );
  }

}

