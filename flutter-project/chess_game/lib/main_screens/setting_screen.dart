import 'package:chess_game/providers/authantication_provider.dart';
import 'package:flutter/material.dart';
import 'package:provider/provider.dart';

import '../constants.dart';

class SettingScreen extends StatefulWidget {
  const SettingScreen({super.key});

  @override
  State<SettingScreen> createState() => _SettingScreenState();
}

class _SettingScreenState extends State<SettingScreen> {
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        leading: IconButton(onPressed: (){Navigator.pop(context);}, icon: Icon(Icons.arrow_back)),
        backgroundColor: Colors.orange,
        title: Text("Setting Screen", style: TextStyle(fontSize: 20, color:  Colors.white),),

        actions: [
          // logout button
          IconButton(
            onPressed: () {
              context
                  .read<AuthenticationProvider>()
                  .signOutUser()
                  .whenComplete(() {
                // navigate to the login screen
                Navigator.pushNamedAndRemoveUntil(
                    context, Constants.signInScreen, (route) => false);
              });
            },
            icon: const Icon(Icons.logout),
          ),
        ],
      ),
      body: Center(
        child: Text("setting Screen"),
      ),
    );

  }
}