import 'package:bbpi/facebook.dart';
import 'package:bbpi/info_desk.dart';
import 'package:bbpi/messenger.dart';
import 'package:bbpi/related_club_or_org.dart';
import 'package:bbpi/student_login.dart';
import 'package:bbpi/ui_helper_method.dart';
import 'package:flutter/material.dart';
import 'package:font_awesome_flutter/font_awesome_flutter.dart';

class HomeScreen extends StatefulWidget {
  const HomeScreen({super.key});

  @override
  State<HomeScreen> createState() => _HomeScreenState();
}

class _HomeScreenState extends State<HomeScreen> {
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      body: Padding(
        padding: EdgeInsets.all(4),
        child: Container(
          height: double.infinity,
          width: double.infinity,
          child : GridView.count(
            crossAxisCount: 2,
            crossAxisSpacing: 6,
            mainAxisSpacing: 10,
            reverse: false, // default false.
            childAspectRatio: 1.2,
            
            children: [

              getItemType(icon:Icons.group, label:  "Student Portal", ontap: (){}),
              getItemType(icon:Icons.admin_panel_settings_sharp, label:"Administrator portal", ontap: (){}),
              getItemType(icon:Icons.group, label:  "Student Portal", ontap: (){}),
              getItemType(icon:Icons.notifications, label: "Administrator\nPublic Notice", ontap: (){Navigator.push(context,MaterialPageRoute(builder: (context) => FacebookScreen()));}),
              getItemType(icon:Icons.notifications, label: "Others\nPublic Notice", ontap: (){}),
              getItemType(icon: FontAwesomeIcons.usersLine, label:  "Information Desk", ontap: (){
                Navigator.push(context, MaterialPageRoute(builder: (context) => InfoDeskScreen()));
              }),
              getItemType(label: "About BBPI", ontap: (){}),
              getItemType(label: "Related Club/Org", ontap: (){Navigator.push(context, MaterialPageRoute(builder: (context)=> RelatedClubOrOrgScreen()));}),
              getItemType(label: "Cr Info", ontap: (){}),
              getItemType(icon: Icons.computer,label: "Student login", ontap: (){Navigator.push(context, MaterialPageRoute(builder: (context)=>StudentLoginScreen()));}, description: "hello it's me md romjan ali "),
              getItemType(icon: Icons.computer,label: "Messenger", ontap: (){Navigator.push(context, MaterialPageRoute(builder: (context)=>MessengerScreen()));}, description: "hello it's me md romjan ali "),
            ],
          ),
        ),
      ),
    );
  }

}