

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

          body: Padding(
            padding: const EdgeInsets.all(8.0),
            child: SingleChildScrollView(
              child: Column(
                mainAxisAlignment : MainAxisAlignment.spaceEvenly,
                children: [
                  Padding(
                    padding: const EdgeInsets.only(bottom: 8),
                    child: SingleChildScrollView(
                      scrollDirection: Axis.horizontal, // for horizontal scrallView we must have to right this line otherwise we get runtime error.
                      child: Row (
                        children:[
                          Container(
                            margin: EdgeInsets.only(right: 10),
                            height: 130,
                            width: 200,
                            color: Colors.red,
                          ),
                          Container(
                            margin: EdgeInsets.only(right: 10),
                            height: 130,
                            width: 200,
                            color: Colors.black,
                          ),
                          Container(
                            margin: EdgeInsets.only(right: 10),
                            height: 130,
                            width: 200,
                            color: Colors.green,
                          ),
                          Container(
                            margin: EdgeInsets.only(right: 10),
                            height: 130,
                            width: 200,
                            color: Colors.grey,
                          ),
                        ],
                      ),
                    ),
                  ),
                  Container(
                    margin: EdgeInsets.only(bottom: 10),
                    height: 130,
                    color: Colors.black,
                  ),
                  Container(
                    margin: EdgeInsets.only(bottom: 10),
                    height: 130,
                    color: Colors.green,
                  ),
                  Container(
                    margin: EdgeInsets.only(bottom: 10),
                    height: 130,
                    color: Colors.yellow,
                  ),
                  Container(
                    margin: EdgeInsets.only(bottom: 10),
                    height: 130,
                    color: Colors.red,
                  ),
                  Container(
                    margin: EdgeInsets.only(bottom: 10),
                    height: 130,
                    color: Colors.grey,
                  ),
                ],
              ),
            ),
          ),
    );
  }
}
