import 'dart:async';
import 'package:flutter/material.dart';



Widget currentItemIndicator(int itemCount, int currentItem , {EdgeInsets margin =const EdgeInsets.symmetric(vertical: 10) }) {

  return Row(
        mainAxisAlignment: MainAxisAlignment.center,
        children: List.generate(itemCount, (index) {
          return AnimatedContainer(
            curve: Curves.ease,
            duration: const Duration(milliseconds: 400),
            height: 3,
            width: 200 / itemCount,
            decoration: BoxDecoration(
              color: currentItem == index ? Colors.white : Colors.grey,
              borderRadius: index == 0
                  ? const BorderRadius.only(
                      topLeft: Radius.circular(2),
                      bottomLeft: Radius.circular(2),
                    )
                  : 
                  (index == currentItem - 1)? 
                  const BorderRadius.only(
                          topRight: Radius.circular(2),
                          bottomRight: Radius.circular(2),
                        )
                      : 
                      BorderRadius.circular(0),
            ),
          );
        }),
      );      

}
