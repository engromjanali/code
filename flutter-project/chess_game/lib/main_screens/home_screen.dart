
import 'dart:math';

import 'package:chess_game/helper/helper_method.dart';
import 'package:chess_game/main_screens/about_screen.dart';
import 'package:chess_game/main_screens/game_time_screen.dart';
import 'package:chess_game/main_screens/setting_screen.dart';
import 'package:chess_game/providers/game_provider.dart';
import 'package:flutter/material.dart';
import 'package:provider/provider.dart';

class HomeScreen extends StatefulWidget {
  const HomeScreen({super.key});

  @override
  State<HomeScreen> createState() => _HomeScreenState();
}

class _HomeScreenState extends State<HomeScreen> {


  @override
  void initState() {
    super.initState();
  }

  @override
  Widget build(BuildContext context) {
    final gameProvider = context.read<GameProvider>();
    return Scaffold(
      appBar: AppBar(
        leading: IconButton(
         icon: const Icon(Icons.arrow_back, color: Colors.white,),
          onPressed: (){
            // show dialog if sure
            Navigator.pop(context);
          },
        ),
        backgroundColor: Colors.orange,
        title: Text("romjan developer!"),
        actions: [
          IconButton(
            onPressed: (){}, 
            icon: const Icon(Icons.start ,color: Colors.white,),
          ),
          
          IconButton(
            onPressed: (){}, 
            icon: const Icon(Icons.rotate_90_degrees_ccw ,color: Colors.white,),
          ),
          
        ],

      ),
      body: Padding(
        padding: EdgeInsets.all(10),
        child: GridView.count(
          crossAxisCount: 2,
          shrinkWrap: true,
          children: [
            buildGameType(
              label: "Play vs Computer", 
              icon: Icons.computer, 
              ontap: (){
                gameProvider.setVsComputer(value: true);
                gameProvider.setOfflinePlay(value: false);

                // Navigate to play vs Computer Screen
                print("play vs computer");
                Navigator.push(context, MaterialPageRoute(builder: (context) =>  const GameTimeScreen()),);
              }
            ),
            buildGameType(
              label: "Play vs Friend",
              icon: Icons.person, 
              ontap: (){
                gameProvider.setVsComputer(value: false);
                gameProvider.setOfflinePlay(value: false);

                // Navigate to play vs Friend Screen
                print("play vs friend");
                Navigator.push(context, MaterialPageRoute(builder: (context) => GameTimeScreen()),);
              }
            ),
            buildGameType(
              label: "Offline Play",
              icon: Icons.person,
              ontap: (){
                gameProvider.setVsComputer(value: false);
                gameProvider.setOfflinePlay(value: true);
                // Navigate to offline play game Screen
                // print("play vs friend");
                Navigator.push(context, MaterialPageRoute(builder: (context) => GameTimeScreen()),);
              }
            ),
            buildGameType(
              label: "Setting", 
              icon: Icons.settings, 
              ontap: (){
                // Navigate to Setting Screen
                print("setting");
                Navigator.push(context, MaterialPageRoute(builder: (context) =>  const SettingScreen()),);
              }
            ),
            buildGameType(
              label: "About", 
              icon: Icons.info, 
              ontap: (){
                // Navigate to About Screen
                print("about");
                Navigator.push(context, MaterialPageRoute(builder: (context) =>  const AboutScreen()),);
              }
            ),
          ],
        ),
      ),
    );
  }

  
}
