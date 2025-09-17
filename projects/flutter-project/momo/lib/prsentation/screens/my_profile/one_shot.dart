import 'package:flutter/material.dart';
import 'package:momo/core/controller/c_home.dart';
import 'package:momo/main.dart';
import 'package:provider/provider.dart';

Widget getOneShot({required Function() onTap}) {
  return Expanded(
    child: Column(
      mainAxisAlignment: MainAxisAlignment.center,
      children: [
        Icon(Icons.image, color: Colors.grey, size: 50),

        Padding(
          padding: const EdgeInsets.symmetric(vertical: 20, horizontal: 40),
          child: Text(
            "You haven't created a \'One Shot\' yet",
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

        ElevatedButton.icon(
          style: ElevatedButton.styleFrom(
            backgroundColor: Colors.white,
            padding: EdgeInsets.all(20),
          ),
          onPressed: onTap,
          label: Text("Discover"),
        ),
        SizedBox(height: 20),
      ],
    ),
  );
}
