import 'dart:async';

import 'package:flutter/material.dart';

class InformationDesk extends StatefulWidget {
  const InformationDesk({super.key});

  @override
  State<InformationDesk> createState() => _InformationDeskState();
}

class _InformationDeskState extends State<InformationDesk> {
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      body: Padding(
        padding: EdgeInsets.all(4),
        child: GridView.count(
          crossAxisCount: 2,
          children: [],
          mainAxisSpacing: 8,
          crossAxisSpacing: 6,
          
        ) ,
      ),
    );
  }
}