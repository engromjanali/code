import 'package:flutter/material.dart';
import 'package:get/get_core/src/get_main.dart';
import 'package:get/route_manager.dart';
import 'package:momo/core/screens/setting_screen.dart';

class MyProfile extends StatefulWidget {
  const MyProfile({super.key});

  @override
  State<MyProfile> createState() => _MyProfileState();
}

class _MyProfileState extends State<MyProfile> {
  bool isAiProfile = true;

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      backgroundColor: Colors.black,
      appBar: AppBar(
        backgroundColor: Colors.black,
        foregroundColor: Colors.white,
        actions: [
          IconButton(
            onPressed: () {
              Get.to(()=>SettingScreen());
            }, 
            icon: const Icon(Icons.settings),
          )
        ],
        title: const Text("My Profile"),
      ),
      body: Column(
        children: [
          Divider(color: Colors.grey.withAlpha(50)),
          const SizedBox(height: 20),

          /// Options button with sliding animation
          Container(
            height: 50,
            width: double.maxFinite,
            margin: const EdgeInsets.symmetric(vertical: 20, horizontal: 30),
            decoration: BoxDecoration(
              color: Colors.grey.withAlpha(50),
              borderRadius: BorderRadius.circular(10),
            ),
            child: Stack(
              children: [
                /// Sliding highlight
                AnimatedAlign(
                  alignment:
                      isAiProfile ? Alignment.centerLeft  : Alignment.centerRight,
                  duration: const Duration(milliseconds: 500),
                  curve: Curves.linear,
                  child: Container(
                    width: MediaQuery.of(context).size.width / 2 - 30, // half size
                    height: 50,
                    decoration: BoxDecoration(
                      color: Colors.grey.withAlpha(150),
                      borderRadius: BorderRadius.circular(10),
                    ),
                  ),
                ),

                /// Options Row
                Row(
                  children: [
                    Expanded(
                      child: GestureDetector(
                        onTap: () {
                          setState(() {
                            isAiProfile = true;
                          });
                        },
                        child: Container(
                          color: Colors.transparent,
                          child: Center(
                            child: Text(
                              "Ai Profile",
                              style: TextStyle(
                                color: Colors.white,
                                fontSize: 18,
                                fontWeight: FontWeight.w600,
                              ),
                            ),
                          ),
                        ),
                      ),
                    ),
                    Expanded(
                      child: GestureDetector(
                        onTap: () {
                          setState(() {
                            isAiProfile = false;
                          });
                        },
                        child: Container(
                          color: Colors.transparent,
                          child: Center(
                            child: Text(
                              "One Shot",
                              style: TextStyle(
                                color: Colors.white,
                                fontSize: 18,
                                fontWeight: FontWeight.w600,
                              ),
                            ),
                          ),
                        ),
                      ),
                    ),
                  ],
                ),

              ],
            ),
          ),

          // make it a section 
          isAiProfile? Expanded(
            child: Column(
              mainAxisAlignment: MainAxisAlignment.center,
              children: [
                Stack(
                  children: [
                    Container(
                      height: 100,
                      width: 100,
                      decoration: BoxDecoration(
                        color: Colors.grey.withAlpha(50),
                        border: Border.all(color: Colors.grey.withAlpha(100), width: 1),
                        borderRadius: BorderRadius.circular(50)
                      ),
                      child: Icon(Icons.person,size: 50, color: Colors.grey,),
                    ),
                    Positioned(
                      right: 8,
                      bottom: 8,
                      child: Container(
                        height: 20,
                        width: 20,
                        decoration: BoxDecoration(
                          color: Colors.grey.withAlpha(150),
                          // border: Border.all(color: Colors.grey, width: 1),
                          borderRadius: BorderRadius.circular(50)
                        ),
                        child: Icon(Icons.add,size: 20, color: Colors.black,),
                      ),
                    ),
                  ],
                ),

                Padding(
                  padding: const EdgeInsets.symmetric(vertical: 20, horizontal: 40),
                  child: Text(
                    "Upload your photos to start using the app",
                    style: TextStyle(
                      color: Colors.white,
                      fontSize: 30,
                      fontWeight: FontWeight.w600
                    
                    ),
                    textAlign: TextAlign.center,
                    maxLines: 2,
                    overflow: TextOverflow.ellipsis,
                  ),
                ),

                Padding(
                  padding: const EdgeInsets.symmetric(vertical: 20, horizontal: 40),
                  child: Text(
                    "You need to take this step only once",
                    style: TextStyle(
                      color: Colors.white70,
                      fontSize: 18,
                      fontWeight: FontWeight.w600
                    
                    ),
                    textAlign: TextAlign.center,
                    maxLines: 2,
                    overflow: TextOverflow.ellipsis,
                  ),
                ),

                ElevatedButton.icon(
                  style: ElevatedButton.styleFrom(
                    backgroundColor: Colors.white
                  ),
                  onPressed: (){}, 
                  icon: Icon(Icons.add_circle, color: Colors.black,),
                  label: Text("Add Photos"),
                ),
                SizedBox(height: 20,)
              ],
            )
          )
          :
          Expanded(
            child: Column(
              mainAxisAlignment: MainAxisAlignment.center,
              children: [
                Icon(Icons.image, color: Colors.grey, size: 50,),

                Padding(
                  padding: const EdgeInsets.symmetric(vertical: 20, horizontal: 40),
                  child: Text(
                    "You haven't created a \'One Shot\' yet",
                    style: TextStyle(
                      color: Colors.white,
                      fontSize: 30,
                      fontWeight: FontWeight.w600
                    
                    ),
                    textAlign: TextAlign.center,
                    maxLines: 2,
                    overflow: TextOverflow.ellipsis,
                  ),
                ),

               

                ElevatedButton.icon(
                  style: ElevatedButton.styleFrom(
                    backgroundColor: Colors.white,
                    padding: EdgeInsets.all(20)
                  ),
                  onPressed: (){}, 
                  label: Text("Discover"),
                ),
                SizedBox(height: 20,)
              ],
            )
          )
        ],
      ),
    );
  }
}
