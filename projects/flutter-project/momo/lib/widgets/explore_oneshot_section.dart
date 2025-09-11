
import 'package:flutter/material.dart';
import 'package:momo/see_all_page.dart';

Widget getSection(BuildContext context,{required String name,}){
  return Column(
    children: [

  Padding(
            padding: const EdgeInsets.all(8.0),
            child: Row(
              mainAxisAlignment: MainAxisAlignment.spaceBetween,
              children: [
                Text(name, style:  TextStyle(fontSize: 22, fontWeight: FontWeight.w600, color: Colors.white),),
                GestureDetector(
                  onTap: (){
                    Navigator.push(context, MaterialPageRoute(builder: (context) => SeeAllPage()));
                  },
                  child: Text("See All", style:  TextStyle(fontSize: 20, color: Colors.grey),)),
              ],
            ),
          ),
          
          SizedBox(
            height: 210,
            child: ListView.builder(
              scrollDirection: Axis.horizontal,
              itemCount: 20,
              itemBuilder: (context, Index){
                return Padding(
                  padding: const EdgeInsets.all(5.0),
                  child: getSectionItem(),
                );
              }
            ),
          )
    ],
  );

}



Widget getSectionItem(){
  return Stack(
    children: [
      Stack(
        children: [
          Container(
                    height: 200,
                    width: 150,
                    
                    decoration: BoxDecoration(
                      // border: Border.all(color: Colors.green),
                      color: Colors.red,
                      borderRadius: BorderRadius.circular(20),
                    ),
                    child: ClipRRect(
                      borderRadius: BorderRadius.circular(20),
                      child: Image.network(
                        errorBuilder: (context, error, stackTrace) => SizedBox.shrink(),
                        "https://scontent.fzyl2-2.fna.fbcdn.net/v/t39.30808-6/490295869_1342466350336950_1132803492906371083_n.jpg?_nc_cat=102&ccb=1-7&_nc_sid=6ee11a&_nc_ohc=cBWtCIqEZvQQ7kNvwGd4zuJ&_nc_oc=AdmTwxgyDzuaSDcACZWhkRcABno_Mk9syXLenfzH52e2h6UpXcDe2sJlZXlJE6cLRlE&_nc_zt=23&_nc_ht=scontent.fzyl2-2.fna&_nc_gid=sBkegtTmWOaKEyOslcEpBg&oh=00_AfaU4GsxuWYFMbxsBkqGokp2b4q2YmXuZz7AluAPAqZssg&oe=68C0CC87",
                        fit:BoxFit.fill ,
                      ),
                    ),
                  ),
          Container(
                    height: 200,
                    width: 150,
                    
                    decoration: BoxDecoration(
                      gradient: LinearGradient(
                        begin: AlignmentGeometry.topCenter,
                        end: AlignmentGeometry.bottomCenter,
                        colors: [
                          Colors.transparent,
                          Colors.transparent,
                          Colors.black,
                        ],
                      ),
                      borderRadius: BorderRadius.circular(20),
                    ),
                  ),

        ],
      ),

              Positioned(
                bottom: 8,
                left: 0,
                right: 0,
                child: Column(
                  children: [
                    Text("Romjan Ali",textAlign: TextAlign.center, style: TextStyle(fontWeight: FontWeight.w600, fontSize: 18, color: Colors.white),),
                    Text("6 Photos",textAlign: TextAlign.center, style: TextStyle(fontWeight: FontWeight.w500, fontSize: 14, color: Colors.white.withAlpha(200))),

                  ],
                )),
    ],
  );
}

