import 'dart:ffi';

import 'package:flutter/material.dart';
import 'package:flutter/rendering.dart';
import 'package:font_awesome_flutter/font_awesome_flutter.dart';

class StudentHomeScreen extends StatefulWidget {
  const StudentHomeScreen({super.key});

  @override
  State<StudentHomeScreen> createState() => _StudentHomeScreenState();
}

class _StudentHomeScreenState extends State<StudentHomeScreen> {
  int selectedMenuNumber = 0;
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        actions: [
          Icon(Icons.notifications),
          Icon(Icons.messenger),
          SizedBox(width: 10,),
        ],
      ),
      drawer: Drawer(
        child: ListView(
          children:[
            UserAccountsDrawerHeader(
              
              accountName: Text('Md Romjan Ali', textAlign: TextAlign.center,style: TextStyle(fontSize: 18, color: Colors.black, fontWeight: FontWeight.bold, fontStyle: FontStyle.normal),),
              accountEmail: RichText(
                text: TextSpan(
                  style: TextStyle(
                    fontSize: 18,
                    color: Colors.black,
                    fontWeight: FontWeight.bold,
                    fontStyle: FontStyle.italic,
                  ),
                  children: [
                    TextSpan(text: "1502222544"),
                    TextSpan(text: "-",),
                    TextSpan(text: "677844"),
                  ]
                ),
              ),
              currentAccountPicture: CircleAvatar(
                backgroundColor: Colors.blue,
                backgroundImage: NetworkImage(
                  'https://scontent.fdac152-1.fna.fbcdn.net/v/t39.30808-6/490295869_1342466350336950_1132803492906371083_n.jpg?_nc_cat=102&ccb=1-7&_nc_sid=6ee11a&_nc_ohc=5isS9v1lToUQ7kNvwEPa55l&_nc_oc=Adks0NZalH2hp2Mxqlx0XIu-LheqDd88Fd1e6Sp6dkes3tEOBjfBr5mypsbpBEuxnjo&_nc_zt=23&_nc_ht=scontent.fdac152-1.fna&_nc_gid=WyGvyM8WQC7IebWxszy-pg&oh=00_AfFfiUkf-oeAZ_K76eV69AkU4pQ2XhBgWBhgYuVMQav2sQ&oe=6816F347', // Replace with your image URL or Asset
                ),
              ),
              decoration: BoxDecoration(
                color: Colors.grey,
              ),
            ),
           
            getDrawerItems(icon: Icons.home, label: "Home",selected: selectedMenuNumber==0,ontap: () {
              selectedMenuNumber =0;
              setState(() {
                
              });
            },),
            getDrawerItems(icon: FontAwesomeIcons.a, label: "Academic Details",selected: selectedMenuNumber==1,ontap: () {
              selectedMenuNumber =1;
              setState(() {
                
              });
            },),
            getDrawerItems(icon: Icons.assessment, label: "Assignments & Exams",selected: selectedMenuNumber==2,ontap: () {
              selectedMenuNumber =2;
              setState(() {
                
              });
            },),
            getDrawerItems(icon: Icons.announcement, label: "Notice & Announcements",selected: selectedMenuNumber==3,ontap: () {
              selectedMenuNumber =3;
              setState(() {
                
              });
            },),
            getDrawerItems(icon: Icons.payment, label: "Fee Management",selected: selectedMenuNumber==4,ontap: () {
              selectedMenuNumber =4;
              setState(() {
                
              });
            },),
            getDrawerItems(icon: Icons.settings, label: "Settings",selected: selectedMenuNumber==5,ontap: () {
              selectedMenuNumber =5;
              setState(() {
                
              });
            },),
          ],
        ),
      ),

      body:Container(
        child: GridView.count(
          crossAxisCount: 2,
          children: [
             getItem(),
             getItem(),
             getItem(),
          ],
        ),
      )
    );
  }
}



Widget getDrawerItems({required String label, required IconData icon, Function()? ontap ,required bool selected}) {
  return GestureDetector(
    onTap: ontap ?? () {},
    child: Container(
      margin: EdgeInsets.all(5),
      padding: EdgeInsets.symmetric(horizontal: 5, vertical: 5),
      decoration: BoxDecoration(
        color: Colors.grey,
        borderRadius: BorderRadius.circular(5),
      ),
      child: Row(
        mainAxisAlignment: MainAxisAlignment.spaceBetween,
        children: [
          Expanded(  // 💡 Let the whole row use max width if needed
            child: Row(
              children: [
                Icon(icon, size: 25),
                SizedBox(width: 8),
                Expanded(  // 💡 This makes text wrap or ellipsis
                  child: Text(
                    label,
                    style: TextStyle(fontSize: 18),
                    overflow: TextOverflow.ellipsis, // or .fade or .clip
                  ),
                ),
              ],
            ),
          ),
          selected ? Icon(Icons.ads_click, size: 20) : SizedBox.shrink(),
        ],
      ),
    ),
  );
}

Widget getItem(){
  return GestureDetector(
      child: Card(
        child: Column(
          mainAxisAlignment: MainAxisAlignment.center,
          children: [
            Icon(Icons.abc),
            Text("romjan ali")
          ]
        ),
      ),
  );
}