import 'dart:convert';

import 'package:ai_application/ui_helper_method.dart';
import 'package:flutter/material.dart';
import 'package:font_awesome_flutter/font_awesome_flutter.dart';

  Future showPlan(BuildContext context) {
    return showModalBottomSheet(
      isScrollControlled: true,
      // scrollControlDisabledMaxHeightRatio: 0.8,
      showDragHandle: true,
      useSafeArea: true,
      anchorPoint: Offset(0.5, 1.0),
      context: context, 
      builder: (context){
        return SizedBox(
          height: MediaQuery.of(context).size.height * 0.7,
          child: xyz(),
        );
    });
  }


var titleList = [
  "GPT- 4.0",  
  "GPT- 4.0", 
  "Dall E 8.0", 
  "Claude 3.5 Sonnet V2",
  "GPT- 4.0",  
  "GPT- 4.0", 
  "Dall E 8.0", 
  "Claude 3.5 Sonnet V2",
  ];
var iconList = [
  FontAwesomeIcons.openai, 
  FontAwesomeIcons.openai, 
  FontAwesomeIcons.dumbbell, 
  Icons.star,
  FontAwesomeIcons.openai, 
  FontAwesomeIcons.openai, 
  FontAwesomeIcons.dumbbell, 
  Icons.star,
  ];
var subtitleList = [
  "Developed by OpenAI. Used for conversation, coding help, writing, and brainstorming. Works like a smart assistant that understands natural language.",
  "Developed by OpenAI. Used for conversation, coding help, writing, and brainstorming. Works like a smart assistant that understands natural language.",
  "AI image generator by OpenAI.  Creates images from text prompts (e.g., “a cat in space”).Useful for design, art, and creative projects.",
  "AI-powered writing assistant. Helps correct grammar, spelling, and writing style. Great for students, professionals, and content creators.",
  "Developed by OpenAI. Used for conversation, coding help, writing, and brainstorming. Works like a smart assistant that understands natural language.",
  "Developed by OpenAI. Used for conversation, coding help, writing, and brainstorming. Works like a smart assistant that understands natural language.",
  "AI image generator by OpenAI.  Creates images from text prompts (e.g., “a cat in space”).Useful for design, art, and creative projects.",
  "AI-powered writing assistant. Helps correct grammar, spelling, and writing style. Great for students, professionals, and content creators."
  ];

class xyz extends StatefulWidget {
  const xyz({super.key});

  @override
  State<xyz> createState() => _xyzState();
}

class _xyzState extends State<xyz> {
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      // appBar: AppBar(),
      body: Column(
        children: [
          SizedBox(
            height: 10,
          ),
          Padding(
            padding: const EdgeInsets.symmetric(horizontal: 8),
            child: Row(
              mainAxisAlignment: MainAxisAlignment.spaceBetween,
              children: [
                Row(
                  spacing: 5,
                  children: [
                    Icon(Icons.star_half_sharp),
                    Text("Model", style: TextStyle(fontSize: 18, fontWeight: FontWeight.w700),)
                  ],
                ), 
                getRoundedButton(),
              ],
            ),
          ),
          Padding(
            padding: const EdgeInsets.symmetric(horizontal: 4),
            child: Text.rich(
              TextSpan(
                style: TextStyle(fontSize: 16,), 
                children: [
                  TextSpan(
                    text: "Skills are only available in selected models ",
                  ),
                  TextSpan(
                    text: "configure Skils",
                    style: TextStyle(color: Colors.purpleAccent, fontWeight: FontWeight.w600),
                  ),
                ]
              )
            ),
          ),
          Expanded(
            child: ListView.builder(
              itemCount: titleList.length,
              itemBuilder: (context, index){
                bool selected = false;
                return StatefulBuilder(
                  builder: (context, setLocalState){
                    return Padding(
                      padding: const EdgeInsets.all(8.0),
                      child: Container(
                        decoration: BoxDecoration(
                          color:selected? Colors.blue.withAlpha(50): null,
                          borderRadius: BorderRadius.circular(10)
                        ),
                        child: ListTile(
                          onTap: () {
                            setLocalState((){
                              selected = !selected;
                        
                            });
                          },
                          title: Row(
                            spacing: 10,
                            children: [
                              Icon(iconList[index]),
                              Text(titleList[index])
                            ],
                          ),
                          
                          subtitle: Text("${subtitleList[index]}"),
                        ),
                      ),
                    );
                  }
                );
              }
            )
          )
        ],
      ),
    );
  }
} 