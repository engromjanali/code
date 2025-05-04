import 'package:flutter/material.dart';

class NavigationDrawerScreen extends StatefulWidget {
  const NavigationDrawerScreen({super.key});

  @override
  State<NavigationDrawerScreen> createState() => _NavigationDrawerScreenState();
}

class _NavigationDrawerScreenState extends State<NavigationDrawerScreen> {
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(),
      bottomNavigationBar: BottomNavigationBar(
        items: [
          BottomNavigationBarItem(icon: Icon(Icons.abc,), label: "s"),
          BottomNavigationBarItem(icon: Icon(Icons.abc), label: 'sdf'),
        ],
        onTap: (index){
          if(index == 0){
            debugPrint("prassed button 1");
          }
          if(index == 1){
            debugPrint("prassed button 2");
          }
        },
      ),
      drawer: Drawer(
        child: ListView(
          children: [
            DrawerHeader(
              child: UserAccountsDrawerHeader(
                decoration: BoxDecoration(color: Colors.green,),
                currentAccountPicture: CircleAvatar(
                  backgroundColor: Colors.amber,
                  child: Image.network("https://scontent.fdac152-1.fna.fbcdn.net/v/t39.30808-1/490295869_1342466350336950_1132803492906371083_n.jpg?stp=dst-jpg_s200x200_tt6&_nc_cat=102&ccb=1-7&_nc_sid=e99d92&_nc_ohc=5isS9v1lToUQ7kNvwEPa55l&_nc_oc=Adks0NZalH2hp2Mxqlx0XIu-LheqDd88Fd1e6Sp6dkes3tEOBjfBr5mypsbpBEuxnjo&_nc_zt=24&_nc_ht=scontent.fdac152-1.fna&_nc_gid=BSF2MaFTvJplOLPDoc6Z0A&oh=00_AfHQY4Zq5WDnhSWyJaAgRZnhaVOiPzicpBIPx8d0JREupg&oe=68165305",fit: BoxFit.cover,),
                ),
                accountName: Text("md romjan ali"),
                accountEmail: Text("romjanali01673@gmail.com----------------------"),
                arrowColor: Colors.red,
                currentAccountPictureSize: Size(40, 40),
                onDetailsPressed: () {
                  // debugPrint("orassed--------------------------");
                },
              ),
            ),
            Text("slkjf"),
            Text("slkjf"),
            Text("slkjf"),
            Text("slkjf"),
            Text("slkjf"),
            Text("slkjf"),
            Text("slkjf"),
            Text("slkjf"),
            Text("slkjf"),
            Text("slkjf"),
            Text("slkjf"),
            Text("slkjf"),
            Text("slkjf"),
            Text("slkjf"),
            Text("slkjf"),
            Text("slkjf"),
            Text("slkjf"),
            Text("slkjf"),
            Text("slkjf"),
            Text("slkjf"),
            Text("slkjf"),
            Text("slkjf"),
            Text("slkjf"),
            Text("slkjf"),
            Text("slkjf"),
            Text("slkjf"),
            Text("slkjf"),
            Text("slkjf"),
            Text("slkjf"),
            Text("slkjf"),
            Text("slkjf"),
            Text("slkjf"),
            Text("slkjf"),
            Text("slkjf"),
            Text("slkjf"),
            Text("slkjf"),
            Text("slkjf"),
            Text("slkjf"),
            Container(
              width:100,
              height: 900,
              color: Colors.amber,
            ),
            Text("slkjf"),
            Text("slkjf"),
            Text("sl------------------------------fghdfghdfhdfhdfhd-----------------------------------kjf"),
            Text("slkjf"),
            Text("slkjf"),
          ],
        ),
      ),
      body: Container(
        color: Colors.amber,
      ),
    );
  }
}