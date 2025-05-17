import 'package:bbpi/ui_helper_method.dart';
import 'package:flutter/material.dart';

class RelatedClubOrOrgScreen extends StatefulWidget {
  const RelatedClubOrOrgScreen({super.key});

  @override
  State<RelatedClubOrOrgScreen> createState() => _RelatedClubOrOrgScreenState();
}

class _RelatedClubOrOrgScreenState extends State<RelatedClubOrOrgScreen> {
  @override
  Widget build(BuildContext context) {
    return  Scaffold(
      body: Container(
        // color: Colors.green, 
        width: double.infinity,
        height: double.infinity,
        child: Padding(
          padding: EdgeInsets.all(8), 
          child: GridView.count(
            crossAxisCount: 2, 
            children: [
              getItemType(label: "BBPI Programming Club", icon: Icons.priority_high, ontap: (){}),
              getItemType(label: "BBPI Cyber Security Club", ontap: (){}),
              getItemType(label: "BBPI football Club", ontap: (){}),
              getItemType(label: "BBPI English Club", ontap: (){}),
              getItemType(label: "BBPI xyz Club", ontap: (){}),
            ],
          ),
        ),
      ),
    );
  }
}