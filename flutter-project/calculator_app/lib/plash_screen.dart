import 'dart:async';

import 'package:calculator_app/home_page.dart';
import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';

class plash_screen extends StatefulWidget{
  @override
  State<StatefulWidget> createState() {
    return _plash_screen();
  }
}

class _plash_screen extends State<plash_screen>{
  @override
  void initState() {
    super.initState();
    Timer(Duration(seconds: 2), (){

      Navigator.pushReplacement(context, MaterialPageRoute(builder: (context)=>MyHomePage(title: 'Calculator')));
    });
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      body: Container(
        height: double.infinity,
        width: double.infinity,
        color: Colors.black,
        child: Center(
          child: Hero(
            tag: "1",
            child: Text("loading...", style: TextStyle(color: Colors.orange, fontSize: 50, fontWeight: FontWeight.bold),),
          ),
        ),
      ),
    );
  }
}