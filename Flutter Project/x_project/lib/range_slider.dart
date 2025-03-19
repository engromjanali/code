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
  RangeValues values = RangeValues(0,100);
  int a = 23;
  @override
  Widget build(BuildContext context) {
    RangeLabels lavels = RangeLabels(values.start.toString(), values.end.toString());
    return Scaffold(
        appBar: AppBar(
          title: Text("Deashboards"),

        ),
      body: Container(
        child: Center(
          child: RangeSlider(
            divisions: 10,
              min: 0,// default 0
              max: 100, // default 1
              activeColor: Colors.purple,
              inactiveColor: Colors.red.shade100,
              values: values,
              labels: lavels,

              onChanged: (newValues){
                values = newValues; // we can change start and end value
                // values = RangeValues(0, newValues.end); // we can change only end value
                // values = RangeValues(newValues.start,100); // we can change only start value
                setState(() {

                });
          }),
        ),
      ),
    );
  }

}

