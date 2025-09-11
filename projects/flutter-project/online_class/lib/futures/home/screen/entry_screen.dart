import 'package:flutter/material.dart';
import 'package:online_class/futures/auth/screen/google_login_screen.dart';
import 'package:online_class/futures/home/screen/Profile_screen.dart';
import 'package:online_class/futures/home/screen/home_screen.dart';
import 'package:online_class/futures/home/screen/messenger_screen.dart';
import 'package:online_class/futures/home/screen/setting_screen.dart';

class EntryScreen extends StatefulWidget {
  const EntryScreen({super.key});

  @override
  State<EntryScreen> createState() => _EntryScreenState();
}

class _EntryScreenState extends State<EntryScreen> {
  int _selectedPage = 0;

  List<Widget> pageList = [
    HomeScreen(),
    MessageScreen(),
    SettingScreen(),
    ProfileScreen(),
  ];
 
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      bottomNavigationBar: Theme(
        data: Theme.of(context).copyWith(
          primaryColor: Colors.white,
          canvasColor: Colors.black,
        ),

        child: BottomNavigationBar(
          currentIndex: _selectedPage,
          // backgroundColor: Colors.red,
          selectedItemColor: Colors.white,
          unselectedItemColor: Colors.grey,
          onTap: (value) {
            setState(() {
              _selectedPage = value;
            });
          },
          items:[
            BottomNavigationBarItem(icon: Icon(Icons.abc), label: "Home"),
            BottomNavigationBarItem(icon: Icon(Icons.chat_rounded), label: "Chat"),
            BottomNavigationBarItem(icon: Icon(Icons.settings), label: "Setting"),
            BottomNavigationBarItem(icon: Icon(Icons.person), label: "Profile"),
          ]
         ),
      ),
      body: pageList[_selectedPage],
    );
  }
}