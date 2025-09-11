

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

  var arrNames = ["romjan", "kapil", "siam", "sakib", "sayed", "komolash", "zehan"];

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        backgroundColor: Theme.of(context).colorScheme.inversePrimary,
        title: Text(widget.title),

      ),

      // ListView ------------------------------------------------------------------------------------------------------------------
      // body:ListView(
      //   // scrollDirection: Axis.horizontal, // default is vertical
      //   // reverse: true,  for vertical start from buttom and element will be reverse also. and for horizontal start from right.
      //   children: [
      //     Padding(
      //       padding: const EdgeInsets.all(28.0),
      //       child: Text("Romjan Ali0" ,style:  TextStyle(fontSize: 25)),
      //     ),
      //     Padding(
      //       padding: const EdgeInsets.all(28.0),
      //       child: Text("Romjan Ali" ,style:  TextStyle(fontSize: 25)),
      //     ),
      //     Padding(
      //       padding: const EdgeInsets.all(28.0),
      //       child: Text("Romjan Ali" ,style:  TextStyle(fontSize: 25)),
      //     ),
      //     Padding(
      //       padding: const EdgeInsets.all(28.0),
      //       child: Text("Romjan Ali" ,style:  TextStyle(fontSize: 25)),
      //     ),
      //     Padding(
      //       padding: const EdgeInsets.all(28.0),
      //       child: Text("Romjan Ali" ,style:  TextStyle(fontSize: 25)),
      //     ),
      //     Padding(
      //       padding: const EdgeInsets.all(28.0),
      //       child: Text("Romjan Ali" ,style:  TextStyle(fontSize: 25)),
      //     ),
      //     Padding(
      //       padding: const EdgeInsets.all(28.0),
      //       child: Text("Romjan Ali" ,style:  TextStyle(fontSize: 25)),
      //     ),
      //     Padding(
      //       padding: const EdgeInsets.all(28.0),
      //       child: Text("Romjan Ali" ,style:  TextStyle(fontSize: 25)),
      //     ),
      //     Padding(
      //       padding: const EdgeInsets.all(28.0),
      //       child: Text("Romjan Ali" ,style:  TextStyle(fontSize: 25)),
      //     ),
      //   ],
      // )

      // ListView.builder ----------------------------------------------------------------------------------------------

      // body: ListView.builder(
      //   // reverse: true,
      //   itemExtent: 100,
      //   scrollDirection: Axis.horizontal, //default vertical
      //   itemBuilder: (context, index) {
      //     //first way. ----------------
      //     //   return Text("Romjan Ali", style: TextStyle(fontSize: 25, fontWeight: FontWeight.bold),);
      //     // },
      //     // itemCount: 10, // the text "romjan ali" will be repeat for 10 times.
      //     // second way ----------------
      //     return Text(arrNames[index], style : TextStyle(fontSize: 25, fontWeight: FontWeight.w800),);
      //     },
      //     itemCount : arrNames.length,
      // ),

      // ListView.separated ----------------------------------------------------------------------------------------------

      body: ListView.separated(
        // reverse: true,
        // scrollDirection: Axis.horizontal, //default vertical
        itemBuilder: (context, index) {
          return ListTile(
            leading: Text("${index + 1}"),
            title: Text(arrNames[index]),
            subtitle: Text("Student"),
            trailing: Icon(Icons.add),
          );
        },
        itemCount : arrNames.length,
        separatorBuilder: (context, index) {
          return Divider(height: 10,thickness: 1,color: Colors.red,indent: 10.0,endIndent: 50.80,);// we can pass here any type of widget
        },
      ),
    );
  }
}
