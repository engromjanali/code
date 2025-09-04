import 'package:ai_application/botton_sheet.dart';
import 'package:ai_application/helper_method.dart';
import 'package:ai_application/history_screen.dart';
import 'package:ai_application/ui_helper_method.dart';
import 'package:flutter/material.dart';
import 'package:font_awesome_flutter/font_awesome_flutter.dart';

class HelloScreen extends StatelessWidget {
  const HelloScreen({super.key});

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      body: SafeArea(
        child: Column(
          children: [
            Padding(
              padding: const EdgeInsets.symmetric(horizontal: 10),
              child: Row(
                mainAxisAlignment: MainAxisAlignment.spaceBetween,
                children: [
              
                  // menu button 
                  IconButton(
                    onPressed: (){
                      Navigator.push(context, MaterialPageRoute(builder: (context)=>HistoryScreen()));
                    }, 
                    icon: Icon(Icons.menu), iconSize: 25, 
                  ),
        
                  Container(
                    
                  ),
                  
                  Row(
                    spacing: 10,
                    children: [
              
              
                      // upgrade button 
                      GestureDetector(
                        onTap: () {
                          showPlan(context);
                          // Navigator.push(context, MaterialPageRoute(builder: (context)=>xyz()));
                        },
                        child: getRoundedButton(),
                      ),
              
              
              
                      // notification button 
                      Container(
                        height: 40,
                        width: 40,
                        decoration: BoxDecoration(
                          color: Colors.grey.shade100,
                          shape: BoxShape.circle,
                          border: Border.all(
                            color: Colors.grey
                          )
                        ),
                        child: Center(
                          child: Stack(
                            // clipBehavior: Clip.none,
                            children: [
                              Center(
                                child: IconButton(
                                  onPressed: (){
                                
                                  }, 
                                  icon: Icon(Icons.notifications_active_outlined),
                                  iconSize: 25,
                                ),
                              ),
                              Positioned(
                                right: 5,
                                top: 5,
                                
                                child: Container(
                                  height: 12,
                                  width: 12,
                                  decoration: BoxDecoration(
                                    color: Colors.red,
                                    shape: BoxShape.circle,
                                  ),
                                ),
                              )
                            ],
                          ),
                        ),
                      ),
              
              
                      // edit button
                      IconButton(
                        onPressed: (){
              
                        },
                        icon: FaIcon(FontAwesomeIcons.edit),
                      )
              
                    ],
                  )
                ],
              ),
            ),
        
            SizedBox(
              height: 100,
            ),
        
            Padding(
              padding: const EdgeInsets.all(18.0),
              child: Text(
                "Hey, Mask!.  👋  How can i assist you today?",
                style: TextStyle(
                  fontSize: 30,
                  fontWeight: FontWeight.w600,
                  
                ),
                textAlign: TextAlign.center,
              ),
            ),
        
        
            Padding(
              padding: const EdgeInsets.symmetric(vertical: 10, horizontal: 30),
              child: Text(
                "Your persional AI assistent is ready to help-- \nask me anything, anytime.?",
                overflow: TextOverflow.fade,
                style: TextStyle(
                  fontSize: 16,
                  fontWeight: FontWeight.w600,
                  
                ),
                textAlign: TextAlign.center,
              ),
            ),
        
        
        
            Spacer(),
        
            // input section 
            Container(
              margin: EdgeInsets.all(10),
              decoration: BoxDecoration(
                border: Border.all(color: Colors.deepPurple),
                borderRadius: BorderRadius.circular(10)
              ),
              child: TextField(
                // onTapOutside: (event) {
                //   FocusScope.of(context).unfocus();
                // },
                decoration: InputDecoration(
        
        
                  hintText: "Type your text here...",
        
        
                  prefixIcon: IconButton(
                    onPressed: (){}, 
                    icon: Icon(Icons.link),
                  ),
                  
                  suffixIcon: Row(
                    mainAxisSize: MainAxisSize.min,
                    children: [
                      IconButton(
                        onPressed: (){}, 
                        icon: Icon(Icons.mic),
                        splashRadius: 40,
                      ),
                      IconButton(
                        onPressed: (){}, 
                        icon: Icon(Icons.send_rounded),
                      ),
                    ],
                  ),
                  border: InputBorder.none),
                ),
            ),
        
            isKeyboardOpen(context)? SizedBox(
              height: 50,
              child: Center(
                child: Row(
                  children: [
                    Expanded(
                      child: ListView.builder(
                        itemCount: 6,
                        scrollDirection: Axis.horizontal,
                        itemBuilder: (context, index){
                          return Padding(
                            padding: const EdgeInsets.symmetric(vertical: 4),
                            child: getSuggestionRoundedButton(icon: FontAwesomeIcons.openai, text: "GPT 4.0"),
                          );
                        }
                      ),
                    ),
                    IconButton(onPressed: (){}, icon: Icon(Icons.access_time_rounded))
                  ],
                ),
              ),
            )
            :
            SizedBox.shrink()
          ],
        ),
      ),
    );
  }
}