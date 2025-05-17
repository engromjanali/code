import 'package:bbpi/ui_helper_method.dart';
import 'package:flutter/material.dart';

class InfoDeskScreen extends StatefulWidget {
  const InfoDeskScreen({super.key});

  @override
  State<InfoDeskScreen> createState() => _InfoDeskScreenState();
}

class _InfoDeskScreenState extends State<InfoDeskScreen> {
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      body: Container(
        height: double.infinity,
        width: double.infinity,
        color: Colors.black,
        child: Padding(
          padding: EdgeInsets.all(4),
          child: GridView.count(
            crossAxisCount: 2,
            childAspectRatio: 0.8,
            children: [
              getItemType(label: "Teachres Tree", ontap: (){},),
              getItemType(label: "All Cr Info", ontap: (){},),
              getItemType(label: "Others Aditionl Sactor", ontap: (){},),
              getItemType(label: "", ontap: (){},),
              getItemType(label: "", ontap: (){},),
              getItemType(label: "", ontap: (){},),
              getItemType(label: "", ontap: (){},),
              getItemType(label: "", ontap: (){},),
            ],
          ),    
        ),
      ),
    );
  }
}