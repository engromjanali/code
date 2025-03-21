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
  List colorArr = [
    Colors.red,
    Colors.green,
    Colors.grey,
    Colors.yellow,
    Colors.blue,
    Colors.orange
  ];
  Widget build(BuildContext context) {
    return Scaffold(
        appBar: AppBar(
          title: Text("Deashboards"),

        ),
      body: Container(
        // child: GridView.count(
        //   crossAxisCount: 3, // each row allocate 3 box(size will be genarated auto).
        //   mainAxisSpacing: 11,
        //   crossAxisSpacing: 11,
        //   children: [
        //     Container(
        //       color: Colors.green,
        //       height: 30,
        //       width: 30,
        //     ),
        //     Container(
        //       color: Colors.green,
        //       height: 30,
        //       width: 30,
        //     ),
        //     Container(
        //       color: Colors.green,
        //       height: 30,
        //       width: 30,
        //     ),
        //     Container(
        //       color: Colors.green,
        //       height: 30,
        //       width: 30,
        //     ),
        //     Container(
        //       color: Colors.green,
        //       height: 30,
        //       width: 30,
        //     ),
        //   ],
        // ),

      //   child: GridView.extent(
      //   maxCrossAxisExtent: 100, // every box size is(100x100) will be set in each row as possible.
      //   mainAxisSpacing: 11,
      //   crossAxisSpacing: 11,
      //   children: [
      //     Container(
      //       color: Colors.green,
      //       height: 30,
      //       width: 30,
      //     ),
      //     Container(
      //       color: Colors.green,
      //       height: 30,
      //       width: 30,
      //     ),
      //     Container(
      //       color: Colors.green,
      //       height: 30,
      //       width: 30,
      //     ),
      //     Container(
      //       color: Colors.green,
      //       height: 30,
      //       width: 30,
      //     ),
      //     Container(
      //       color: Colors.green,
      //       height: 30,
      //       width: 30,
      //     ),
      //   ],
      // ),
        child: GridView.builder(
          itemBuilder:   (context, index) {
           return  Container(
             color: colorArr[index],
             child: Text("hello how are you?"),
           );
          },
          itemCount: colorArr.length,
          gridDelegate: SliverGridDelegateWithFixedCrossAxisCount(
            crossAxisCount: 4,
            crossAxisSpacing: 11,
            mainAxisSpacing: 11,
            mainAxisExtent: 200
          ),
          // gridDelegate: SliverGridDelegateWithMaxCrossAxisExtent(
          //   maxCrossAxisExtent: 100,
          //   mainAxisExtent:200,// default maxCrossAxisExtent, mainAxisExtent allow only for GridView.builder
          //   // crossAxisSpacing: 11,
          //   // mainAxisSpacing: 11,
          // ),
        ),
      ),
    );
  }

}

