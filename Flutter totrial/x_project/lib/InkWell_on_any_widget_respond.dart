
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
        body:InkWell(
          onTap: (){print("you have clicked on container");},
          onLongPress: (){print("you longPrassed on container");},
          child: Container(
            height: 300,
            width: 200,
          
            child: Column(
              // mainAxisAlignment (top to down)
              mainAxisAlignment : MainAxisAlignment.spaceEvenly, //  |  A  B  C  |
              // mainAxisAlignment : MainAxisAlignment.spaceAround, //  | A   B   C |
              // mainAxisAlignment : MainAxisAlignment.spaceBetween, // |A    B    C|
              // mainAxisAlignment : MainAxisAlignment.center, //       |    ABC    |
              // mainAxisAlignment : MainAxisAlignment.start, //        |ABC        |
              // mainAxisAlignment : MainAxisAlignment.end,  //         |        ABC|
          
              // crossAxisAlignment (left to right)
              // crossAxisAlignment: CrossAxisAlignment.center, // default as center if we use container
              // crossAxisAlignment: CrossAxisAlignment.stretch, // |--------| ont for text, for button types.
              crossAxisAlignment: CrossAxisAlignment.start, //  start from left
              // crossAxisAlignment: CrossAxisAlignment.end, //  start from right
          
              children: [

                InkWell(
                  onTap: (){print("you have clicked on A");},
                  child: Text("A",style: TextStyle(fontSize: 28, color: Colors.red, fontWeight: FontWeight.w800)),
                ),
                InkWell(
                    onTap: (){print("you have clicked on B");},
                    child: Text("B",style: TextStyle(fontSize: 28, color: Colors.red, fontWeight: FontWeight.w800))),
                InkWell(
                    onTap: (){print("you have clicked on C");},
                    child: Text("C",style: TextStyle(fontSize: 28, color: Colors.red, fontWeight: FontWeight.w800))),
                InkWell(
                    onTap: (){print("you have clicked on D");},
                    child: Text("D",style: TextStyle(fontSize: 28, color: Colors.red, fontWeight: FontWeight.w800))),
                InkWell(
                    onTap: (){print("you have clicked on E");},
                    child: Text("E",style: TextStyle(fontSize: 28, color: Colors.red, fontWeight: FontWeight.w800))),
                ElevatedButton(child: Text("click"), onPressed: (){print("you have clicked on ElevatedButton");}),
              ],
            ),
          ),
        )
    );
  }
}
