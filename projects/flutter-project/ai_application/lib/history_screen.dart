import 'package:flutter/material.dart';

class HistoryScreen extends StatelessWidget {
  const HistoryScreen({super.key});

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text("History"),
        actions: [
          Padding(
            padding: const EdgeInsets.only(right: 10),
            child: CircleAvatar(
              radius: 20,
              backgroundImage: NetworkImage("https://scontent.fzyl2-2.fna.fbcdn.net/v/t39.30808-6/490295869_1342466350336950_1132803492906371083_n.jpg?_nc_cat=102&ccb=1-7&_nc_sid=6ee11a&_nc_ohc=cBWtCIqEZvQQ7kNvwH_k4t7&_nc_oc=Adn1X_-r_Uh5PzjZN-v_5y_duowUN_VcDvyd9TT0uiWerYG16H2scIvnpTavev9UxI8&_nc_zt=23&_nc_ht=scontent.fzyl2-2.fna&_nc_gid=XoIwul_edtU1UTD9e2j2zA&oh=00_AfYB9H4w0a1ytI_yVsuwDxh8ZFK8g0mfRWGbnwOj_HNC7A&oe=68BF0A87")
            ),
          ),
        ],
      ),
      body: SafeArea(
        
        child:Column(
          children: [

            // search bar 
            Container(
              padding: EdgeInsets.all(5),
              margin: EdgeInsets.all(20),
              decoration: BoxDecoration(
                // color: Colors.amber,
                border: Border.all(
                  color: Colors.grey
                ),
                borderRadius: BorderRadius.all(Radius.circular(10))
              ),
        
              child: TextField(
                onTapOutside: (event) {
                  FocusScope.of(context).unfocus();
                },
                decoration: InputDecoration(
                
                
                  hintText: "Search your old result...",
                
                  // search icon
                  prefixIcon: IconButton(
                    onPressed: (){}, 
                    icon: Icon(Icons.search),
                  ),
                  
                  suffixIcon: Row(
                    mainAxisSize: MainAxisSize.min,
                    children: [
                      IconButton(
                        onPressed: (){}, 
                        icon: Icon(Icons.tune),
                      ),
        
                      IconButton(
                        onPressed: (){}, 
                        icon: Icon(Icons.mic),
                      ),
                    ],
                  ),
                  border: InputBorder.none,
                ),
              ),
            ),
        
            

            Expanded(
              child: ListView.builder(
                itemCount: 20,
                itemBuilder: (context, index){
                  return Padding(
                    padding: const EdgeInsets.all(8.0),
                    child: getCustomTile(),
                  );
                }
              ),
            ),
        
         
          ],
        ),
      ),
    );
  }
}


Widget getDividerV(){
  return Container(
    color:Colors.grey,
    // height: 10,
    width: 1,
    margin: EdgeInsets.symmetric(horizontal: 5),
  );
}

Widget getDividerH(){
  return Container(
    color:Colors.grey,
    height: 1,
    // width: 10,
    margin: EdgeInsets.symmetric(vertical: 5),
  );
}


Widget getCustomTile(){
  return Container(
              padding: EdgeInsets.all(10),
              margin: EdgeInsets.all(2),
              width: double.infinity,

              decoration: BoxDecoration(
                border: Border.all(color: Colors.grey),
                borderRadius: BorderRadius.circular(10),
                
              ),
              child: IntrinsicHeight(
                child: Row(
                  children: [
                
                
                    // leading 
                    Column(
                      mainAxisSize: MainAxisSize.min,
                      spacing: 5,
                      children: [
                        CircleAvatar(
                          radius: 20,
                          child: Text("A", style: TextStyle(fontSize: 25),),
                        ),
                        Text("Ai Chat")
                      ],
                    ),
                
                    getDividerV(),
                
                    // body
                    Expanded(
                      child: Column(
                        children: [
                          Expanded(
                            child: Text(
                              "Hi, i need help with designing a chatbot interface. can you help me? i want it to",
                              maxLines: 3,
                              style: TextStyle(fontSize: 16),
                            ),
                          ),
                          Row(
                            children: [
                              Icon(Icons.access_time_sharp),
                              Text("${"12:12 pm"}"),
                              SizedBox(
                                width: 10,
                              ),
                              Icon(Icons.date_range),
                              Text("04 april,2024")
                            ],
                          ),
                        ],
                      ),
                    ),
                
                
                    // trealing 
                    Container(
                      padding: EdgeInsets.all(5),
                      decoration: BoxDecoration(
                        
                        color: Colors.purpleAccent.withAlpha(50),
                        borderRadius: BorderRadius.circular(10)
                        
                      ),
                      child: IntrinsicWidth(
                        child: Column(
                          mainAxisSize: MainAxisSize.min,
                          spacing: 5,
                          children: [
                            Icon(Icons.share, color: Colors.blue,),
                            getDividerH(),
                            Icon(Icons.delete_outline, color: Colors.red,)
                          
                          ],
                        ),
                      ),
                    ),
                      
                
                  ],
                ),
              ),
            );
}