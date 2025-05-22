import 'package:flutter/material.dart';
import 'package:font_awesome_flutter/font_awesome_flutter.dart';

class MessengerScreen extends StatefulWidget{
  const MessengerScreen({super.key});

  @override
  State<MessengerScreen> createState()  =>_MessengerScreenState();
}

class _MessengerScreenState extends State<MessengerScreen>{

  List<Map<String, dynamic>> users = [
  {"name": "Romjan", "lastMsg": "Hi there", "time": "4:00 PM", "isActive": true},
  // {"name": "Afran", "lastMsg": "Okay", "time": "3:50 PM", "isActive": false},
  // {"name": "Afran", "lastMsg": "Okay", "time": "3:50 PM", "isActive": false},
  // {"name": "Afran", "lastMsg": "Okay", "time": "3:50 PM", "isActive": false},
  // {"name": "Afran", "lastMsg": "Okay", "time": "3:50 PM", "isActive": false},
  // {"name": "Afran", "lastMsg": "Okay", "time": "3:50 PM", "isActive": false},
  // {"name": "Afran", "lastMsg": "Okay", "time": "3:50 PM", "isActive": false},
  {"name": "Afran", "lastMsg": "Okay", "time": "3:50 PM", "isActive": false},
  {"name": "Afran", "lastMsg": "Okay", "time": "3:50 PM", "isActive": false},
  {"name": "Afran", "lastMsg": "Okay", "time": "3:50 PM", "isActive": true},
  {"name": "Afran", "lastMsg": "Okay", "time": "3:50 PM", "isActive": true},
  {"name": "Afran", "lastMsg": "Okay", "time": "3:50 PM", "isActive": false},
  {"name": "Afran", "lastMsg": "Okay", "time": "3:50 PM", "isActive": true},
  {"name": "Afran", "lastMsg": "Okay", "time": "3:50 PM", "isActive": true},
  {"name": "Afran", "lastMsg": "Okay", "time": "3:50 PM", "isActive": false},
  // {"name": "Afran", "lastMsg": "Okay", "time": "3:50 PM", "isActive": false},
  // {"name": "Afran", "lastMsg": "Okay", "time": "3:50 PM", "isActive": false},
  // {"name": "Afran", "lastMsg": "Okay", "time": "3:50 PM", "isActive": false},
  // {"name": "Afran", "lastMsg": "Okay", "time": "3:50 PM", "isActive": false},
  // {"name": "Afran", "lastMsg": "Okay", "time": "3:50 PM", "isActive": false},
  // Add more...
];



  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text("Messenger"),
        actions: [
          IconButton(onPressed: (){}, icon: Icon(Icons.group_add_rounded)),
          IconButton(onPressed: (){}, icon: Icon(FontAwesomeIcons.facebook)),
        ],
      ),
      body: Container(
        child: Column(
          children: [
            // SizedBox(height: 20,),
            // Row(children: [ Text("Messenger")]),
            Container(
              height: 90,
              padding: EdgeInsets.symmetric(horizontal: 8, vertical: 6),
              child: Row(
                children: [
                  Padding(
                      padding: const EdgeInsets.symmetric(horizontal: 6),
                      child: Column(
                        children: [
                          Stack(
                            children: [
                              CircleAvatar(
                                radius: 28,
                                backgroundColor: Colors.blueGrey,
                                child: Text("your \nprofile \nphoto", style: TextStyle(fontSize: 10),), // First letter
                              ),
                              Positioned(
                                bottom: -5,
                                right: -5,
                                child: Card(
                                  child: Container(
                                    decoration: BoxDecoration(
                                      shape: BoxShape.circle,
                                      color: Colors.white,
                                    ),
                                    child: Icon(Icons.add, size: 25,)),
                                )
                              ),
                            ],
                          ),
                          SizedBox(height: 4),
                          Text("Your name",
                            style: TextStyle(fontSize: 12),
                          )
                        ],
                      ),
                    ),
                Expanded(
                  child: ListView.builder(
                  scrollDirection: Axis.horizontal,
                  itemCount: users.length,
                  
                  itemBuilder: (context, index) {
                    final user = users[index];
                    return Padding(
                      padding: const EdgeInsets.symmetric(horizontal: 6),
                      child: Column(
                        children: [
                          Stack(
                            children: [
                              CircleAvatar(
                                radius: 28,
                                backgroundColor: Colors.blueGrey,
                                child: Text(user['name'][0]), // First letter
                              ),
                              if (user['isActive'])
                                Positioned(
                                  bottom: 2,
                                  right: 2,
                                  child: Container(
                                    width: 20,
                                    height: 20,
                                    decoration: BoxDecoration(
                                      color: Colors.green,
                                      shape: BoxShape.circle,
                                      border: Border.all(color: Colors.white, width: 2),
                                    ),
                                  ),
                                ),
                            ],
                          ),
                          SizedBox(height: 4),
                          Text(
                            user['name'],
                            style: TextStyle(fontSize: 12),
                          )
                        ],
                      ),
                    );
                  },
                                  ),
                ),
                ],
              ),
            ),
               
            Expanded(child: ListView.builder(
              itemBuilder: (context, index){
                return Card(
                  color: Colors.white30,
                  child: ListTile(
                    contentPadding: EdgeInsets.symmetric(horizontal: 5,),
                    leading: CircleAvatar(
                      radius: 30,
                      backgroundColor: Colors.blue,
                      child: Text("${index+1}"),
                    ),
                    title: Text("Name"),
                    subtitle: Text("Last Messages 20:20 PM"),
                    trailing: Icon(Icons.abc),
                    onTap: () {
                      
                    },
                    onLongPress: () {
                      
                    },
                  ),
                );
              },
              itemCount: 50,
            ), 
            ),
            Container(
              padding: EdgeInsets.all(5),
              child: Row(
                mainAxisAlignment: MainAxisAlignment.spaceAround,
                children: [
                  InkWell(
                    
                    onTap: () {
                      
                    },
                    child: Column(
                      children: [
                        Icon(Icons.message),
                        Text("Chats")
                      ],
                    ),
                  ),
                  InkWell(
                    onTap: () {
                      
                    },
                    child: Column(
                      children: [
                        Icon(Icons.amp_stories),
                        Text("Storis")
                      ],
                    ),
                  ),
                  InkWell(
                    onTap: () {
                      
                    },
                    child: Column(
                      children: [
                        Icon(Icons.menu_rounded),
                        Text("Menu")
                      ],
                    ),
                  ),
                ],
              ),
            )
          ],
        ),
      ),
    );
  }
  
}