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

        textTheme: TextTheme(
          headlineMedium: TextStyle(fontSize: 20, fontWeight: FontWeight.normal, color: Colors.black, fontStyle: FontStyle.italic),
          headlineSmall: TextStyle(fontSize: 14, fontWeight: FontWeight.normal, color: Colors.black),
        )
      ),
      home:HomePage(),
    );
  }
}


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
          children: [

            Text("hello dir sir/mam how are you?", style: Theme.of(context).textTheme.headlineMedium),
            Text("hay, it's me md romjan ali.", style: Theme.of(context).textTheme.headlineMedium!.copyWith(color: Colors.orange)),//if we need any type of changes we can override with "copywith(). remember we have to use "!" sign.
            Text("how can i help you sir?", style: Theme.of(context).textTheme.headlineSmall),
            Text("hello programmers ", style: style_font().text18()),
            Text("hello programmers ", style:style_font().text18(color: Colors.orange)),
            Text("hello programmers ", style: style_font().text14()),
          ],
        ),
      ),
    );
  }

}

