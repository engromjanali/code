import 'package:flutter/material.dart';
import 'package:font_awesome_flutter/font_awesome_flutter.dart';
import 'package:momo/explore_or_oneshot_screen.dart';
import 'package:momo/my_profile.dart';


class HomePage extends StatefulWidget {
  const HomePage({super.key});

  @override
  State<HomePage> createState() => _HomePageState();
}

class _HomePageState extends State<HomePage> {
  int _currentPage = 0;
  List<Widget> pages =[
    ExploreAndOneShotScreen(isExplore: true,),
    ExploreAndOneShotScreen(isExplore: false,),
    MyProfile(),
  ];

  @override
  Widget build(BuildContext context){
    return Scaffold(
      extendBody: true,
      backgroundColor: Colors.black,
      bottomNavigationBar: Container(
        decoration: BoxDecoration(
          color: Colors.black.withAlpha(230),
          borderRadius: BorderRadius.only(
            topLeft: Radius.circular(20),
            topRight: Radius.circular(20),
          ),
        ),
        child: BottomNavigationBar(
          currentIndex: _currentPage,
          // type: BottomNavigationBarType.fixed,
            backgroundColor: Colors.transparent, // <-- set black color
            selectedItemColor: Colors.white, // selected icon/text color
            unselectedItemColor: Colors.white70,
            elevation: 0,
          onTap: (val){
            setState(() {
              _currentPage = val;
            });
          },
          items: [
            BottomNavigationBarItem(icon: Icon(Icons.explore), label: "Explore",),
            BottomNavigationBarItem(icon: Icon(FontAwesomeIcons.image,), label: "One Shot",),
            BottomNavigationBarItem(icon: Icon(Icons.person,), label: "My profile",),
          ]
        ),
      ),
      body: pages[_currentPage],
    ) ;
  }
  
  
  
}
