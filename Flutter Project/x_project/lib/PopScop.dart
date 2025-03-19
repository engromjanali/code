import 'dart:math';


import 'package:flutter/material.dart';
import 'package:x_project/animatedCrossFade.dart';
// import 'package:stockfish/stockfish.dart';

class GameScreen extends StatefulWidget {
  const GameScreen({super.key});

  @override
  State<GameScreen> createState() => _GameScreenState();
}

class _GameScreenState extends State<GameScreen> {

  @override
  Widget build(BuildContext context) {
    return PopScope(
      canPop: false, // Prevents the back button from automatically popping the screen
      onPopInvoked: (didPop) async {
        if (!didPop) {
          bool? leave = await _showExitConfirmDialog(context);
          if (leave == true) {
            await Future.delayed(const Duration(microseconds: 200)).whenComplete(() {
              Navigator.pop(context);
            });
          }
        }
      },
      child: Scaffold(
        appBar: AppBar(
          automaticallyImplyLeading: false, // Hides the back button
          backgroundColor: Colors.orange,
          title: Text("romjan developer!"),
          actions: [
            IconButton(
              onPressed: (){
              }, 
              icon: const Icon(Icons.start ,color: Colors.white,),
            ),
            
            IconButton(
              onPressed: (){
              }, 
              icon: const Icon(Icons.rotate_90_degrees_ccw ,color: Colors.white,),
            ),
          ],
        ),
        body: Container(),
        ),
    );
  }

  Future<bool?> _showExitConfirmDialog(BuildContext context) async{
    return showDialog<bool>(
      context: context,
      builder: (context)=> AlertDialog(
        title:Text("Leave Geame",textAlign: TextAlign.center),
        content: Text("Are you sure to leave this game? ",textAlign: TextAlign.center),
        actions: [
          TextButton(onPressed: (){
            Navigator.of(context).pop(false); // return false with dispose the dialog
          }, 
          child: const Text("Cancel")),
          TextButton(onPressed: (){
            Navigator.of(context).pop(true); // return true with dispose the dialog 
          }, 
          child: const Text("Yes")),
        ],
      ));
  }
}
