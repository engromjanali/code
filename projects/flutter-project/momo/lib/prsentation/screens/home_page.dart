import 'package:flutter/material.dart';
import 'package:font_awesome_flutter/font_awesome_flutter.dart';
import 'package:momo/core/controller/c_home.dart';
import 'package:momo/prsentation/screens/explore_or_oneshot_screen.dart';
import 'package:momo/prsentation/screens/my_profile/my_profile.dart';
import 'package:provider/provider.dart';

class HomePage extends StatefulWidget {
  const HomePage({super.key});

  @override
  State<HomePage> createState() => _HomePageState();
}

class _HomePageState extends State<HomePage> {

  List<Widget> pages = [
    ExploreAndOneShotScreen(isExplore: true),
    ExploreAndOneShotScreen(isExplore: false),
    MyProfile(),
  ];

  @override
  Widget build(BuildContext context) {
    CHome cHome = context.watch<CHome>();
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
          currentIndex: cHome.getCurrentPageNo,
          // type: BottomNavigationBarType.fixed,
          backgroundColor: Colors.transparent, // <-- set black color
          selectedItemColor: Colors.white, // selected icon/text color
          unselectedItemColor: Colors.white70,
          elevation: 0,
          onTap: (val) {
            cHome.setCurrentPage(val);
          },
          items: [
            BottomNavigationBarItem(
              icon: Icon(Icons.explore),
              label: "Explore",
            ),
            BottomNavigationBarItem(
              icon: Icon(FontAwesomeIcons.image),
              label: "One Shot",
            ),
            BottomNavigationBarItem(
              icon: Icon(Icons.person),
              label: "My profile",
            ),
          ],
        ),
      ),
      body: pages[cHome.getCurrentPageNo],
    );
  }
}




