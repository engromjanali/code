import 'package:flutter/material.dart';

Widget getAiProfile({required Function() onTap}) {
  return Expanded(
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
                borderRadius: BorderRadius.circular(50),
              ),
              child: Icon(Icons.person, size: 50, color: Colors.grey),
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
                  borderRadius: BorderRadius.circular(50),
                ),
                child: Icon(Icons.add, size: 20, color: Colors.black),
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
              fontWeight: FontWeight.w600,
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
              fontWeight: FontWeight.w600,
            ),
            textAlign: TextAlign.center,
            maxLines: 2,
            overflow: TextOverflow.ellipsis,
          ),
        ),

        ElevatedButton.icon(
          style: ElevatedButton.styleFrom(backgroundColor: Colors.white),
          onPressed: onTap,
          icon: Icon(Icons.add_circle, color: Colors.black),
          label: Text("Add Photos"),
        ),
        SizedBox(height: 20),
      ],
    ),
  );
}
