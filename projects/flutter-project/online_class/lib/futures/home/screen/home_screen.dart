import 'package:flutter/material.dart';
import 'package:font_awesome_flutter/font_awesome_flutter.dart';
import 'package:online_class/futures/home/screen/join_meeting.dart';
import 'package:online_class/futures/home/screen/new_meeting_screen.dart';
import 'package:online_class/core/utlity/ui_helper_method.dart';

class HomeScreen extends StatefulWidget {
  const HomeScreen({super.key});

  @override
  State<HomeScreen> createState() => _HomeScreenState();
}

class _HomeScreenState extends State<HomeScreen> {
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text("Home Screen"),
        foregroundColor: Colors.white,
        backgroundColor: Colors.black,
      ),
      body: Column(
        children: [
          SizedBox(
            height: 5,
          ),
          Row(
            mainAxisAlignment: MainAxisAlignment.spaceAround,
            children: [
              meetFutures(
                Colors.orange, 
                Icons.video_call, 
                "Meet", 
                (){
                  Navigator.push(context, MaterialPageRoute(builder: (context)=>NewMeetingScreen()));
                },
              ),
              meetFutures(
                Colors.blue, 
                Icons.add_box_outlined, 
                "Join", 
                (){
                  Navigator.push(context, MaterialPageRoute(builder: (context)=>JoiningMeetingScreen()));
                },
              ),
              meetFutures(
                Colors.blue, 
                FontAwesomeIcons.calendar, 
                "Shedule", 
                (){},
              ),
              meetFutures(
                Colors.blue, 
                FontAwesomeIcons.share, 
                "Share", 
                (){},
              ),
            ],
          )
        ],
      ),
    );
  }
}