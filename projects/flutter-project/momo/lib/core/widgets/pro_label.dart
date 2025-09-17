import 'package:flutter/material.dart';
import 'package:get/get.dart';
import 'package:get/get_core/src/get_main.dart';
import 'package:momo/prsentation/screens/purchese_screen.dart';
import 'package:momo/prsentation/screens/get_this_pack.dart';

Widget proLabel(){
  return // the pro label.
          Positioned(
            top: 0,
            left: 0,
            right: 0,
            child: SafeArea(
              child: Padding(
                padding: const EdgeInsets.only(top: 0,left: 10, right: 10 ),
                child: Row(
                  
                  mainAxisAlignment: MainAxisAlignment.spaceBetween,
                  children: [
                    Text("   "),
                    Text(
                      "MOMO", 
                      style: TextStyle(
                        color: Colors.white,
                        fontWeight: FontWeight.w900,
                        fontSize: 24
                      ),
                    ),
                    GestureDetector(
                      onTap: () {
                        Get.to(()=>PurcheseScreen());
                      },
                      child: Container(
                        padding: EdgeInsets.all(5),
                        decoration: BoxDecoration(
                          borderRadius: BorderRadius.circular(15),
                          color: Colors.black.withAlpha(200)
                        ),
                        child: Text(
                          "PRO",
                          style: TextStyle(
                            color: Colors.white,
                            fontWeight: FontWeight.w600,
                            fontSize: 16
                          ),
                        
                        ),
                      ),
                    )
                  ],
                ),
              ),
            ),
          );
}