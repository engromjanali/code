import 'package:flutter/material.dart';
import 'package:meal_hisab/ui_helper/ui_helper.dart';

class MemberScreen extends StatefulWidget {
  const MemberScreen({super.key});

  @override
  State<MemberScreen> createState() => _MemberScreenState();
}

class _MemberScreenState extends State<MemberScreen> {
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      body: Container(
        color: Colors.red,
        child: Padding(
          padding: const EdgeInsets.all(8.0),
          child: Column(
            mainAxisAlignment: MainAxisAlignment.start,
          
            children: [
              SingleChildScrollView(
                scrollDirection: Axis.horizontal,
                child: Row(
                  spacing: 10,
                  children: [
                    getMenuItems(
                      label: "Members", 
                      ontap: (){
              
                      },
                    ),
                  ],
                ),
              ),
              
              Column(
                children: [

                  Card(
                    child: ListTile(
                      contentPadding: EdgeInsets.only(left: 10),
                      leading: CircleAvatar(
                        child: Text(""),
                        backgroundColor: Colors.amber,
                      ),
                      title: Text("Md Romjan Ali"),
                      subtitle: Text("12345678   (Member)"),
                      trailing: PopupMenuButton(
                        icon: Icon(Icons.more_vert),
                        itemBuilder: (BuildContext context) {  
                           return [
                              PopupMenuItem(
                                onTap: (){

                                },
                                value: 1,
                                child: Row(
                                  children: [
                                    Icon(Icons.transfer_within_a_station_sharp),
                                    Text("Transfer Owner"),
                                  ],
                                ),
                              ),
                              PopupMenuItem(
                                onTap: ()async{
                                  bool? a = await showConfirmDialog(context: context, title: "Do You Want to Transfer The Ownership?");
                                  if(a??false){
                                    debugPrint("YES--------------");
                                  }
                                  else{
                                    debugPrint("NO--------------");
                                  }
                                },
                                value: 1,
                                child: Row(
                                  children: [
                                    Icon(Icons.highlight_remove_outlined),
                                    Text("kick"),
                                  ],
                                ),
                              ),
                              PopupMenuItem(
                                onTap: (){

                                },
                                value: 1,
                                child: Row(
                                  children: [
                                    Icon(Icons.do_not_disturb_alt_outlined),
                                    Text("Hold"),
                                  ],
                                ),
                              ),
                           ];
                        },
                      ),
                    ),
                  ),

                ],
              )
              
            ],
          ),
        ),
      ),
    );
  }
}