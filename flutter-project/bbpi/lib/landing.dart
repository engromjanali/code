import 'dart:async';

import 'package:bbpi/home_screen.dart';
import 'package:flutter/material.dart';

class LandingScreen extends StatefulWidget {
  const LandingScreen({super.key});

  @override
  State<LandingScreen> createState() => _LandingScreenState();
}

class _LandingScreenState extends State<LandingScreen> {

  @override
  void initState(){
    super.initState();

    Timer(Duration(milliseconds: 1500),(){
      Navigator.pushReplacement(context, MaterialPageRoute(builder: (context)=>HomeScreen()));
    });
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      body: Container(
        color: Colors.black,
        child: Center(
          // child: Text("BBPI...", style: TextStyle(fontSize: 36),),
          child: Column(
            mainAxisAlignment: MainAxisAlignment.center,
            crossAxisAlignment: CrossAxisAlignment.center,
            children: [
              RichText(
                text: TextSpan(
                  style: TextStyle(
                    color: const Color.fromARGB(255, 20, 101, 223),
                    fontSize: 40,
                  ),
                  children: [
                    TextSpan(text: "welcome\n",), // following the default style
                    TextSpan(text: "to\n", style: TextStyle(color: const Color.fromARGB(255, 243, 15, 167), fontWeight: FontWeight.bold, fontSize: 30, fontStyle: FontStyle.italic,)), // override style
                    TextSpan(text: "BBPI",style: TextStyle(color: const Color.fromARGB(255, 243, 15, 167), fontWeight: FontWeight.bold, fontSize: 30, fontStyle: FontStyle.italic,),), 
                  ]
                ),
              ),
            ], 
          ),
        ),
      ),
    );
  }

  Widget getWelcome({required BuildContext context}){
    return AnimatedContainer(
      duration: Duration(seconds: 5),
      height: 180,
      width: 100,
      color: Colors.amber,
    );
  }
}