
import 'package:flutter/material.dart';
import 'package:online_class/futures/auth/screen/google_login_screen.dart';
import 'package:online_class/futures/auth/service/auth_method.dart';
import 'package:online_class/futures/home/widgets/custom_button.dart';

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
        title: Text("Settings"),
      ),
      body: Column(
        children: [
          CustomButton(
            onTap: ()async{
              await GoogleSignInService.signOut();
              Navigator.of(context).push(MaterialPageRoute(builder: (context)=>GoogleLoginScreen()));
            },
            text: "Logout", 
          ),
        ],
      ),
    );
  }
}