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
class HomePageState extends State<HomePage> with SingleTickerProviderStateMixin{ // extend "SingleTickerProviderStateMixin" Mixin class by "with" keyword.
  late Animation animation; // for size
  late Animation color_animation; // for color
  late AnimationController animation_controller; // object or AnimationController


  @override
  void initState() {
    // TODO: implement initState
    super.initState();
    // we write the following line in a function or like that otherwise we get compile error
    animation_controller = AnimationController(vsync: this, duration: Duration(seconds: 5), lowerBound: 0.5); // lowerBound '0.5' mean process will be started from 1/2 (half)
    animation = Tween(begin: 10.0, end: 300.0).animate(animation_controller); // for double value we have to use "Tween".
    color_animation = ColorTween(begin:Colors.red, end:Colors.green).animate(animation_controller); // for hax-code of Color used "ColorTween".

    animation_controller.addListener((){ // here we are help of Listener printing value to check and calling "setState".
      print(animation.value);
      setState(() {
      });
    });

    animation_controller.forward(); // we are starting AnimationController here
    // for reverse beging value will be high and end value will be low.
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
        appBar: AppBar(
          title: Text("Deashboards"),

        ),
      body: Center(
        child: Container(
          height: animation.value,
          width: animation.value,
          color: color_animation.value,
        ),
      ),
    );
  }
}

