// type of  button :
// 1. text button(flat Button) //no shado
// 2. Elevated Button (Raised Button) // normal Button with shado/elition
// 3. Outlined Button // flat with outline/border


import 'package:flutter/material.dart';

void main() {
  runApp(const MyApp());
}

class MyApp extends StatelessWidget {
  const MyApp({super.key});

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: 'Flutter Demo',
      theme: ThemeData(

        colorScheme: ColorScheme.fromSeed(seedColor: Colors.grey),
        useMaterial3: true,
      ),
      debugShowCheckedModeBanner : false,
      home: const MyHomePage(title: 'Flutter page created by romjan'),
    );

  }
}

class MyHomePage extends StatefulWidget {
  const MyHomePage({super.key, required this.title});

  final String title;

  @override
  State<MyHomePage> createState() => _MyHomePageState();
}

class _MyHomePageState extends State<MyHomePage> {
  int _counter = 0;

  void _incrementCounter() {
    setState(() {
      _counter++;
    });
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        backgroundColor: Theme.of(context).colorScheme.inversePrimary,
        title: Text(widget.title),

      ),
      body:Center(
        child: Container(
          height: 100,
          width: 200,
          color: Colors.grey,

          // TextButton --------------------------------------------------------
          // child: TextButton(
          //   child: Text("click me!"),
          //   onPressed: (){
          //     print("you have clicked in the button");
          //   },
          //   onLongPress: (){
          //     print("long prased here");
          //   },
          //   ),

          // ElevatedButton ----------------------------------------------------
          // child: Center(
          //   child: ElevatedButton(
          //     child:Text("Elevation Button"),
          //     onPressed: (){
          //       print("ElevatedButton prassed");
          //     },
          //     onLongPress: (){
          //       print("long Prassed ElevatedButton");
          //     },),
          // )

          // OutlinedButton-----------------------------------------------------
          // child: Center(
          //   child: OutlinedButton(
          //     child:Text("OutLined Button"),
          //     onPressed: (){
          //       print("OutLined prassed");
          //     },
          //     onLongPress: (){
          //       print("long Prassed OutLinedButton");
          //     },),
          // )

        ),
      )
    );
  }
}
