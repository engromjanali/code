import 'dart:ui';

import 'package:flutter/material.dart';
import 'package:font_awesome_flutter/font_awesome_flutter.dart';
import 'package:meal_hisab/bazer/bazer_screen.dart';
import 'package:meal_hisab/constants.dart';
import 'package:meal_hisab/diposite/diposite.dart';
import 'package:meal_hisab/edit_info.dart';
import 'package:meal_hisab/fand/fand.dart';
import 'package:meal_hisab/meal/meal.dart';
import 'package:meal_hisab/member/member_screen.dart';
import 'package:meal_hisab/mess/mess_screen.dart';
import 'package:meal_hisab/notice_and_announcement.dart';

class HomeScreen extends StatefulWidget {
  const HomeScreen({super.key});

  @override
  State<HomeScreen> createState() => _HomeScreenState();
}

class _HomeScreenState extends State<HomeScreen> {

  DrawerItem DrawerItemGroup = DrawerItem.Home;

  bool visibleCurrent = false;
  bool visibleNew = false;
  bool visibleConfirm = false;

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        backgroundColor: Colors.grey,
        
        actions: [
          
          IconButton(
            onPressed: (){},
            icon: Icon(Icons.notifications),
          ),
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
                    TextSpan(text: "Id No : "),
                    TextSpan(text: "10203040"),
                    TextSpan(text: "  "),
                    TextSpan(text: "(Member)"),

                  ]
                ),
              ),
              currentAccountPicture: CircleAvatar(
                backgroundColor: Colors.blue,
                backgroundImage: NetworkImage(
                  'https://media.licdn.com/dms/image/v2/D5603AQHLNWai9JVADg/profile-displayphoto-shrink_800_800/B56ZabNxZLGkAc-/0/1746360801482?e=1752105600&v=beta&t=LQU-OyXoCMujQ7QcE7WOjy3JqqurI-BwlDIgshNtmOQ', // Replace with your image URL or Asset
                ),
              ),
              decoration: BoxDecoration(
                color: Colors.grey,
              ),
            ),
           
            getItems(
              icon: Icons.home, 
              label: "Home",
              selected: DrawerItemGroup==DrawerItem.Home, 
              ontap: () {
                Navigator.pop(context);
                DrawerItemGroup = DrawerItem.Home;
                setState(() {
                
                });
              },
            ),
            getItems(
              icon: FontAwesomeIcons.a, 
              label: "Meal",
              selected: DrawerItemGroup==DrawerItem.Meal,
              ontap: () {
                Navigator.pop(context);
                DrawerItemGroup = DrawerItem.Meal;
                setState(() {
                
                });
              },
            ),
            getItems(
              icon: FontAwesomeIcons.peopleGroup, 
              label: "Members",
              selected: DrawerItemGroup==DrawerItem.Members,
              ontap: () {
                Navigator.pop(context);
                DrawerItemGroup=DrawerItem.Members;
                setState(() {
                
                });
              },
            ),
            getItems(icon: Icons.assessment, 
              label: "Fand",
              selected: DrawerItemGroup==DrawerItem.Fand, 
              ontap: () {
                Navigator.pop(context);
                DrawerItemGroup=DrawerItem.Fand;
                setState(() {
                
                });
              },
            ),
            getItems(icon: Icons.assessment, 
              label: "Diposite",
              selected: DrawerItemGroup==DrawerItem.Diposite, 
              ontap: () {
                Navigator.pop(context);
                DrawerItemGroup=DrawerItem.Diposite;
                setState(() {
                
                });
              },
            ),
            getItems(
              icon: Icons.announcement, 
              label: "Notice & Announcements",
              selected: DrawerItemGroup ==DrawerItem.Notice_And_Announcements,
              ontap: () {
                Navigator.pop(context);
                DrawerItemGroup =DrawerItem.Notice_And_Announcements;
                setState(() {
                
                });
              },
            ),
            getItems(
              icon: Icons.payment, 
              label: "Bazer",
              selected: DrawerItemGroup == DrawerItem.Bazer,
              ontap: () {
                Navigator.pop(context);
                DrawerItemGroup=DrawerItem.Bazer;
                setState(() {
                
                });
              },
            ),
            getItems(
              icon: Icons.other_houses_sharp, 
              label: "Mess",
              selected: DrawerItemGroup == DrawerItem.Mess,
              ontap: () {
                Navigator.pop(context);
                DrawerItemGroup=DrawerItem.Mess;
                setState(() {
                
                });
              },
            ),
            getItems(
              icon: Icons.settings, 
              label: "Settings",
              selected: DrawerItemGroup ==DrawerItem.Settings,
              ontap: () {
                Navigator.pop(context);
                DrawerItemGroup = DrawerItem.Settings;
                setState(() {
                
                });
              },
            ),
          ],
        ),
      ),
      
      body:
      DrawerItemGroup == DrawerItem.Meal ? MealScreen()
      :
      DrawerItemGroup == DrawerItem.Members ? MemberScreen()
      :
      DrawerItemGroup == DrawerItem.Fand ? FandScreen()
      :
      DrawerItemGroup == DrawerItem.Notice_And_Announcements ? NoticeAndAnnouncementScreen()
      :
      DrawerItemGroup == DrawerItem.Bazer ? BazerScreen()
      :
      DrawerItemGroup == DrawerItem.Settings ? SettingScreen()
      :
      DrawerItemGroup == DrawerItem.Diposite ? DipositeScreen()
      :
      DrawerItemGroup == DrawerItem.Mess ? MessScreen()
      :
      Container(  // home Screen
        height: double.infinity,
        width: double.infinity,
        color: Colors.black,
      )

    );
  }
}




class SettingScreen extends StatefulWidget {
  const SettingScreen({super.key});

  @override
  State<SettingScreen> createState() => _SettingScreenState();
}

class _SettingScreenState extends State<SettingScreen> {
  bool visibleCurrent = false;
  bool visibleNew = false;
  bool visibleConfirm = false;

  FocusNode FocusNodeCurrent = FocusNode();
  FocusNode FocusNodeNew = FocusNode();
  FocusNode FocusNodeConfirm = FocusNode();

  String currentPass="";
  String newPass="";
  String confirmPass="";



GlobalKey<FormState> formKey = GlobalKey<FormState>(); 


  bool valid(){
    if(formKey.currentState!.validate()){
      formKey.currentState!.save();
      if( newPass == confirmPass){
        return true;
      }
      else{
        // show in snack new pass & confirm pass dosenot matching.
      }
    }
    return false;
  }

  @override
  void dispose() {
    // TODO: implement dispose
    FocusNodeCurrent.dispose();
    FocusNodeNew.dispose();
    FocusNodeConfirm.dispose();
    
    super.dispose();
  }


  @override
  Widget build(BuildContext context) {
    return  Scaffold(
        body : Container(
          color: Colors.grey,
          height: double.infinity,
          width: double.infinity,
          child: ListView(
            children: [
              getItem(label: "Edit Profile", icon: Icons.edit, ontap: (){Navigator.push(context, MaterialPageRoute(builder: (context)=>EditInfo()));} ),
              getItem(label: "Security", icon: Icons.security, ontap: (){
                return showModalBottomSheet(
                  isScrollControlled: true,
                  context: context, 
                  builder: (BuildContext content){
                    return StatefulBuilder(builder: (BuildContext context, StateSetter setModalState){
                      return Container(
                      decoration: BoxDecoration(
                        borderRadius: BorderRadius.only(topLeft: Radius.circular(20), topRight: Radius.circular(20)),
                      ),
                      height: 500,
                      width: double.infinity,
                      child: SingleChildScrollView(
                       scrollDirection: Axis.vertical,
                        child: Form(
                          key: formKey,
                          child: Column(
                            children: [
                              SizedBox(
                                height: 20,
                              ),
                              Container(
                                padding: EdgeInsets.symmetric(horizontal: 10),
                                decoration: BoxDecoration(
                                  borderRadius: BorderRadius.circular(10),
                                  color: Colors.grey.shade300,
                                  border: Border(bottom: BorderSide(color: Colors.black))
                                ),
                                margin: EdgeInsets.all(10),
                                child: TextFormField(
                                  focusNode: FocusNodeCurrent,
                                  onFieldSubmitted: (value) {
                                    FocusScope.of(context).requestFocus(FocusNodeNew);
                                  },
                                  onChanged: (value){
                                    currentPass = value.trim();
                                  },
                                  validator: (value) {
                                    if(currentPass.length<8){
                                      return "password at least 8 character";
                                    }
                                    if(value.toString().contains(" ")){
                                      return "Space are Not Allowed";
                                    }
                                    return null;
                                  },
                                  keyboardType: TextInputType.text,
                                  textInputAction: TextInputAction.next,
                                  obscureText: visibleCurrent,
                                  decoration: InputDecoration(
                                    label: Text("Current Password"),
                                    border: InputBorder.none,
                                    suffixIcon:
                                    IconButton(
                                      onPressed: (){ 
                                        setModalState(() { // the setModalState work in "showModalBottomSheet"
                                          setState(() { // the setstate work in main page
                                            
                                          });
                                          visibleCurrent = !visibleCurrent;
                                        });
                                      }, 
                                      icon: visibleCurrent? Icon(Icons.visibility) : Icon(Icons.visibility_off),
                                    ),
                                  ),
                                ),
                              ),
                              Container(
                                padding: EdgeInsets.symmetric(horizontal: 10),
                                decoration: BoxDecoration(
                                  borderRadius: BorderRadius.circular(10),
                                  color: Colors.grey.shade300,
                                  border: Border(bottom: BorderSide(color: Colors.black))
                                ),
                                margin: EdgeInsets.all(10),
                                child: TextFormField(
                                  focusNode: FocusNodeNew,
                                  onFieldSubmitted: (value){
                                    FocusScope.of(context).requestFocus(FocusNodeConfirm);
                                  },
                                  textInputAction: TextInputAction.next,
                                  obscureText: visibleNew,
                                  keyboardType: TextInputType.text,
                                  onChanged: (value){
                                    newPass = value.trim();
                                  },
                                  validator: (value) {
                                    if(newPass.length<8){
                                      return "password at least 8 character";
                                    }
                                    if(value.toString().contains(" ")){
                                      return "Space are Not Allowed";
                                    }
                                    return null;
                                  },
                                  decoration: InputDecoration(
                                    label: Text("New Password"),
                                    border: InputBorder.none,
                                    suffixIcon:
                                    IconButton(
                                      onPressed: (){ 
                                        setModalState(() { // the setModalState work in "showModalBottomSheet"
                                          setState(() { // the setstate work in main page
                                            
                                          });
                                          visibleNew = !visibleNew;
                                        });
                                      }, 
                                      icon: visibleNew? Icon(Icons.visibility) : Icon(Icons.visibility_off),
                                    ),
                                  ),
                                ),
                              ),
                              Container(
                                padding: EdgeInsets.symmetric(horizontal: 10),
                                decoration: BoxDecoration(
                                  borderRadius: BorderRadius.circular(10),
                                  color: Colors.grey.shade300,
                                  border: Border(bottom: BorderSide(color: Colors.black))
                                ),
                                margin: EdgeInsets.all(10),
                                child: TextFormField(
                                  focusNode: FocusNodeConfirm,
                                  onFieldSubmitted: (value){
                                    FocusScope.of(context).unfocus();
                                  },
                                  textInputAction: TextInputAction.done,
                                  obscureText: visibleConfirm,
                                  keyboardType: TextInputType.text,
                                  onChanged: (value){
                                    confirmPass = value.trim();
                                  },
                                  validator: (value) {
                                    if(confirmPass.length<8){
                                      return "password at least 8 character";
                                    }
                                    if(value.toString().contains(" ")){
                                      return "Space are Not Allowed";
                                    }
                                    return null;
                                  },
                                  decoration: InputDecoration(
                                    label: Text("Confirm Password"),
                                    border: InputBorder.none,
                                    suffixIcon:
                                    IconButton(
                                      onPressed: (){ 
                                        setModalState(() { // the setModalState work in "showModalBottomSheet"
                                          setState(() { // the setstate work in main page
                                            
                                          });
                                          visibleConfirm = !visibleConfirm;
                                        });
                                      }, 
                                      icon: visibleConfirm? Icon(Icons.visibility) : Icon(Icons.visibility_off),
                                    ),
                                  ),
                                ),
                              ),
                              SizedBox(
                                height: 20,
                              ),
                              TextButton(
                                onPressed: (){}, 
                                child: Text("Forgot Passwprd?", style: TextStyle(color: Colors.blue, fontSize: 16),
                                ),
                              ),
                              SizedBox(
                                height: 20,
                              ),
                              getButton(label: "Submit", ontap: (){
                                valid();
                                print(currentPass);
                                print(newPass);
                                print(confirmPass);
                              }),
                            ],
                          ),
                        ),
                      ),
                    );
                    });
                });
              },
              ),
              getItem(label: "Logout", icon: Icons.logout, ),
            ],
          ),
        ),
    );
  }
}

Widget getItems({required String label, required IconData icon, Function()? ontap ,required bool selected}) {
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


Widget getItem({required String label, required IconData icon, Function()? ontap }){
  return GestureDetector(
    onTap: ontap??(){},
      child: Container(
        margin: EdgeInsets.symmetric(horizontal: 5),
        child: Card(
          child: Padding(
            padding: const EdgeInsets.all(8.0),
            child: Row(
              mainAxisAlignment: MainAxisAlignment.center,
              children: [
                Icon(icon),
                Text(label)
              ]
            ),
          ),
        ),
      ),
  );
}

Widget bazer(){
  return Container(
        color: Colors.grey,
        height: double.infinity,
        width: double.infinity,
        child: ListView(
          children: [
            
          ],
        ),
      );
}


Widget getButton({required String label, required Function() ontap, Icon? icon}){
  return MaterialButton(
    onPressed: ontap,
    shape: RoundedRectangleBorder(
      borderRadius: BorderRadius.circular(50),
    ),
    height: 50,
    color: Colors.grey,
    child: Row(
      mainAxisSize: MainAxisSize.min,
      children: [
        Text("$label", style: TextStyle(fontSize: 25),),
        if (icon != null) ...[
          SizedBox(
            width: 10,
          ),
          icon,
         ],
      ],
    ),);
}





// "editor.codeActionsOnSave": {
//   "source.fixAll": true
// }

