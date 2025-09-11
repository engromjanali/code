import 'package:cloud_firestore/cloud_firestore.dart';
import 'package:flutter/material.dart';
import 'package:online_class/constants.dart';

class WaitingApproveScreen extends StatelessWidget {
  final String roomId;
  const WaitingApproveScreen({super.key, required this.roomId});

  @override
  Widget build(BuildContext context) {
    return StreamBuilder(
      stream: FirebaseFirestore
        .instance
        .collection(Constants.room)
        .doc(roomId)
        .collection(Constants.waitingList)
        .where(Constants.status , isEqualTo: Constants.waiting)
        .snapshots(),


      builder: (context , snapshot){
      final waitingUser = snapshot.data?.docs??[];

        return Scaffold(
          backgroundColor: Colors.white,
          appBar: AppBar(
            backgroundColor: Colors.white,
            title: Text(
              "List of Waiting For Approval",
              style : TextStyle(
                color: Colors.black,
                fontSize: 18
              ),
            )
          ),

          body: waitingUser.isEmpty? Center(
            child: Text("Waiting List Are Empty."),
          )
          :
          ListView.builder(
            itemCount: waitingUser.length,
            itemBuilder: (context, index){
              final data = waitingUser[index].data();
              return ListTile(
                title: Text(data["name"]),
                trailing: Row(
                  mainAxisSize: MainAxisSize.min,
                  children: [
                    IconButton(
                      onPressed: (){

                      }, 
                      icon: Icon(Icons.add_task_sharp, color: Colors.green,)
                    ),
                    IconButton(
                      onPressed: (){

                      }, 
                      icon: Icon(Icons.highlight_remove_sharp, color: Colors.red)
                    ),
                  ],
                ),
              );
            },
          )
        );
      },
    );
  }
}