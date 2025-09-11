import 'package:flutter/material.dart';

class SeeAllPage extends StatefulWidget{
  const SeeAllPage({super.key});

  @override
  State<SeeAllPage> createState()=> _SeeAllPageState();
}

class _SeeAllPageState extends State<SeeAllPage>{
  @override
  void setState(VoidCallback fn) {
    // TODO: implement setState
    super.setState(fn);
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      backgroundColor: Colors.black,
      appBar: AppBar(
        foregroundColor: Colors.white,
        title: Text("Linkedin", style:  TextStyle(fontSize: 22, fontWeight: FontWeight.w600, color: Colors.white),),
        backgroundColor: Colors.black,
      ),
      body: Column(
        children: [
          Expanded(
            child: GridView.builder(
              itemCount: 6,
              gridDelegate: SliverGridDelegateWithFixedCrossAxisCount(
                crossAxisCount: 2,
                childAspectRatio: 1/1.3,
            
              ),
              itemBuilder: (context, index){
                return Padding(
                  padding: const EdgeInsets.all(8.0),
                  child: ClipRRect(
                    borderRadius: BorderRadiusGeometry.circular(10),
                    child: Stack(
                      fit: StackFit.expand,
                      clipBehavior: Clip.hardEdge,
                      children: [
                        Image.network(
                          errorBuilder: (context, error, stackTrace) => SizedBox.shrink(),
                          "https://scontent.fzyl2-2.fna.fbcdn.net/v/t39.30808-6/490295869_1342466350336950_1132803492906371083_n.jpg?_nc_cat=102&ccb=1-7&_nc_sid=6ee11a&_nc_ohc=cBWtCIqEZvQQ7kNvwGd4zuJ&_nc_oc=AdmTwxgyDzuaSDcACZWhkRcABno_Mk9syXLenfzH52e2h6UpXcDe2sJlZXlJE6cLRlE&_nc_zt=23&_nc_ht=scontent.fzyl2-2.fna&_nc_gid=sBkegtTmWOaKEyOslcEpBg&oh=00_AfaU4GsxuWYFMbxsBkqGokp2b4q2YmXuZz7AluAPAqZssg&oe=68C0CC87",
                          fit:BoxFit.fill ,
                        ),
                        Container(
                            decoration: BoxDecoration(
                              gradient: LinearGradient(
                                begin: Alignment.bottomCenter, // start at bottom
                                end: Alignment.topCenter,  
                                // transform: GradientRotation(4),
                                colors: [
                                  Colors.black,    // bottom color
                                  Colors.transparent, // top color
                                  Colors.transparent, // top color
                                ],
                              ),
                            ),
                        ),  
                        Positioned(
                          // top: 250,
                          child: Column(
                                  mainAxisAlignment: MainAxisAlignment.end,
                                  children: [
                                    // Text("MOMO"),
                                    Text("Business", textAlign: TextAlign.center, style: TextStyle(fontWeight: FontWeight.w600, fontSize: 18, color: Colors.white)),
                                    Text("6 photos", textAlign: TextAlign.center, style: TextStyle(fontWeight: FontWeight.w600, fontSize: 16, color: Colors.white)),
                                    SizedBox(height: 20,),
                                ]
                              ),
                        ),


                      ],
                    ),
                  )
                );
              }
            ),
          )
        ],
      ),
    );

  }
}