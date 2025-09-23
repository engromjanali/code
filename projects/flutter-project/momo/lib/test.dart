import 'package:flutter/material.dart';
import 'package:momo/core/asset_manager/assets/font_menager.dart';

class test extends StatefulWidget {
  const test({super.key});

  @override
  State<test> createState() => _testState();
}

class _testState extends State<test> {
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      body: Column(
        children: [
          Container(
            height: 300,
            width: 400,
            child: Column(
              children: [
                Text(
                  "Romjan",
                  style: TextStyle(
                    fontFamily: FontMenager.SF_Compact_Rounded,
                    fontWeight: FontWeight.w100,
                  ),
                ),
              ],
            ),
          ),
          Center(
            child: Container(
              color: Colors.amber,
              padding: EdgeInsets.all(10),
              height: 500,
              width: 400,
              child: Center(
                child: Column(
                  children: [
                    Text(
                      "Romjan",
                      style: TextStyle(
                        fontFamily: FontMenager.SF_Compact_Rounded,
                        fontWeight: FontWeight.w100,
                        fontSize: 30,
                      ),
                    ),
                    Text(
                      "Romjan",
                      style: TextStyle(
                        fontFamily: FontMenager.SF_Compact_Rounded,
                        fontWeight: FontWeight.w200,
                        fontSize: 30,
                      ),
                    ),
                    Text(
                      "Romjan",
                      style: TextStyle(
                        fontFamily: FontMenager.SF_Compact_Rounded,
                        fontWeight: FontWeight.w300,
                        fontSize: 30,
                      ),
                    ),
                    Text(
                      "Romjan",
                      style: TextStyle(
                        fontFamily: FontMenager.SF_Compact_Rounded,
                        fontWeight: FontWeight.w400,
                        fontSize: 30,
                      ),
                    ),
                    Text(
                      "Romjan",
                      style: TextStyle(
                        fontFamily: FontMenager.SF_Compact_Rounded,
                        fontWeight: FontWeight.w500,
                        fontSize: 30,
                      ),
                    ),
                    Text(
                      "Romjan",
                      style: TextStyle(
                        fontFamily: FontMenager.SF_Compact_Rounded,
                        fontWeight: FontWeight.w600,
                        fontSize: 30,
                      ),
                    ),
                    Text(
                      "Romjan",
                      style: TextStyle(
                        fontFamily: FontMenager.SF_Compact_Rounded,
                        fontWeight: FontWeight.w700,
                        fontSize: 30,
                      ),
                    ),
                    Text(
                      "Romjan",
                      style: TextStyle(
                        fontFamily: FontMenager.SF_Compact_Rounded,
                        fontWeight: FontWeight.w800,
                        fontSize: 30,
                      ),
                    ),
                    Text(
                      "Romjan",
                      style: TextStyle(
                        fontFamily: FontMenager.SF_Compact_Rounded,
                        fontWeight: FontWeight.w900,
                        fontSize: 30,
                      ),
                    ),
                  ],
                ),
              ),
            ),
          ),
        ],
      ),
    );
  }
}
