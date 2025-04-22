import 'package:flutter/material.dart';
import 'package:flutter_inappwebview/flutter_inappwebview.dart';
import 'package:font_awesome_flutter/font_awesome_flutter.dart';
import 'package:web_view/application_page.dart';
import 'package:web_view/service_provider.dart';
import 'package:web_view/webViewScreen.dart';

class homePage extends StatefulWidget {
  const homePage({super.key});

  @override
  State<homePage> createState() => _homePageState();
}

class _homePageState extends State<homePage> {
  ServiceProvider s = ServiceProvider();

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text("All In One"),
        backgroundColor: Colors.red,
      ),
      body: Container(
        padding: EdgeInsets.all(4),
        child: Column(
          children: [
            SizedBox(height: 10,),
            Text("Welcome\n Chose your applications!", textAlign: TextAlign.center,),
            SizedBox(height: 20,),
            SizedBox(
              width: double.infinity,
              height: 100,
              child: BuildApplicationsType(label: "Google", iconData: FontAwesomeIcons.google, onTap: () {
                Navigator.push(context, MaterialPageRoute(builder: (context)=>WebViewScreen()));
              }),
            ),
            SizedBox(
              height: 10,
            ),
            Expanded(
              child: GridView.count(
                crossAxisCount: 2,
                children: [
                  BuildApplicationsType(label: "Facebook", iconData: FontAwesomeIcons.facebook, onTap: () { 
                    s.setUrl(url: "https://www.facebook.com/");
                    Navigator.push(context, MaterialPageRoute(builder: (context)=>ApplicationPage()));
                  }),
                  BuildApplicationsType(label: "Instagram", iconData: FontAwesomeIcons.instagram, onTap: () { 
                    s.setUrl(url: "https://www.instagram.com/"); 
                    Navigator.push(context, MaterialPageRoute(builder: (context)=>ApplicationPage()));
                  }),
                  BuildApplicationsType(label: "x", iconData: FontAwesomeIcons.x, onTap: () { 
                    s.setUrl(url: "https://x.com/");
                    Navigator.push(context, MaterialPageRoute(builder: (context)=>ApplicationPage()));
                  }),
                  BuildApplicationsType(label: "Telegram", iconData: FontAwesomeIcons.telegram, onTap: () { 
                    s.setUrl(url: "https://web.telegram.org/"); 
                    Navigator.push(context, MaterialPageRoute(builder: (context)=>ApplicationPage()));
                  }),
                  BuildApplicationsType(label: "Teams", iconData: FontAwesomeIcons.skype, onTap: () {  
                    s.setUrl(url: "https://teams.live.com/v2");
                    Navigator.push(context, MaterialPageRoute(builder: (context)=>ApplicationPage()));
                  }),
                  BuildApplicationsType(label: "Messenger", iconData: Icons.messenger, onTap: () { 
                    s.setUrl(url: "https://www.messenger.com/"); 
                    Navigator.push(context, MaterialPageRoute(builder: (context)=>ApplicationPage()));
                  }),
                  BuildApplicationsType(label: "Github", iconData: FontAwesomeIcons.github, onTap: () { 
                    s.setUrl(url: "https://www.github.com/"); 
                    Navigator.push(context, MaterialPageRoute(builder: (context)=>ApplicationPage()));
                  }),
                  BuildApplicationsType(label: "Youtube", iconData: FontAwesomeIcons.youtube, onTap: () {  
                    s.setUrl(url: "https://www.youtube.com/");
                    Navigator.push(context, MaterialPageRoute(builder: (context)=>ApplicationPage()));
                  }),
                ],
              ),
            ),
          ],
        )
      ),
    );
  }
}



Widget BuildApplicationsType({required String label, required IconData iconData,required Function() onTap}){
  return InkWell(
    onTap: onTap,
    child: Card(
      child: Column(
        mainAxisAlignment: MainAxisAlignment.center,
        crossAxisAlignment: CrossAxisAlignment.center,
        children: [
          Icon(iconData),
          SizedBox(height: 20,),
          Text("$label", textAlign: TextAlign.center, style: TextStyle(color: Colors.black, fontSize: 18),),
        ],
      ),
    ),
  );
}