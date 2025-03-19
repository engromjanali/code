

import 'package:flutter/material.dart';
import 'package:x_project/ui_helper/style_font.dart';

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
      body:ListView(
        // scrollDirection: Axis.horizontal, // default is vertical
        // reverse: true,  for vertical start from bottom and element will be reverse also. and for horizontal start from right.
        children:  arrNames.map((val) => Container(
          child: Text(val, style: style_font().text14(),),
        )).toList(),
      )
      
    );
  }
}
