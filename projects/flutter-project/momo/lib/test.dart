import 'package:flutter/material.dart';

class SuitPage extends StatefulWidget {
  @override
  _SuitPageState createState() => _SuitPageState();
}

class _SuitPageState extends State<SuitPage> {
  final ScrollController _scrollController = ScrollController();
  double _opacity = 0.0;
  double _imageScale = 1.0; // Scale for bounce effect

  @override
  void initState() {
    super.initState();


    _scrollController.addListener(() {
      setState(() {
        if(_scrollController.offset<0){
          _imageScale = 1 + ((_scrollController.offset).clamp(-100, 0)).abs().toDouble()/1000;
        }

        // Adjust opacity based on scroll position (e.g., 0 to 1 over 400 pixels)
        _opacity = (_scrollController.offset / 290).clamp(0.0, 1.0);
      });
    });
  }

  @override
  void dispose() {
    _scrollController.dispose();
    super.dispose();
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      backgroundColor: Colors.black,
      body: Expanded(
        child: Stack(
          children: [

            // the top image section
            Column(
              children: [
                SizedBox(
                  height: 400,
                  child: Opacity(
                    opacity: 1.0 - _opacity,
                    child: Transform.scale(
                      scale: _imageScale,
                      child: Stack(
                        fit: StackFit.expand,
                        children: [
                          Image.asset(
                            'assets/images/x.jpg', // Replace with your image path
                            fit: BoxFit.cover,
                          ),
                          Container(
                            decoration: BoxDecoration(
                              gradient: LinearGradient(
                                begin: AlignmentGeometry.bottomCenter,
                                end: AlignmentGeometry.topCenter,
                                colors: [
                                  Colors.black, 
                                  Colors.transparent,
                                ]
                              )
                            ),
                          ),
                          Positioned(
                            bottom: 0,
                            left: 0,
                            right: 0,
                            child: Column(
                              children: [
                                Text("Suit" , style: TextStyle(color: Colors.white, fontSize: 28, fontWeight: FontWeight.w800),),
                                Text("6 Photos" , style: TextStyle(color: Colors.white, fontSize: 18),),
                                SizedBox(height: 20,)
                              ],
                            ),
                          )
                        ],
                      ),
                    ),
                  ),
                ),
                Expanded(
                  child: Container(
                    color: Colors.black,
                  ),
                )
              ],
            ),

            // the 2nd hald screen and top widget as stack 
            Scaffold(
              extendBody: true,
              extendBodyBehindAppBar: true,

              backgroundColor: Colors.transparent,

              // get this pack button
              bottomNavigationBar: Container(
                height: 60,
                margin: EdgeInsets.all(20),
                decoration: BoxDecoration(
                  borderRadius: BorderRadius.circular(10),
                  color: Colors.white,
                ),
                alignment: AlignmentGeometry.center,
                child: Text(
                  "Get This Pack", 
                  style: TextStyle(
                    fontSize: 20,
                    fontWeight: FontWeight.bold
                  ),
                ),
              ),




              appBar: AppBar(
                scrolledUnderElevation: 0,
                elevation: 0,
                backgroundColor:Colors.black.withAlpha(_opacity==1?255:0),
                foregroundColor:Colors.white,
                leading: IconButton(
                  onPressed: (){}, 
                  icon: Icon(Icons.cancel, size: 35,),
                ),
                title: Opacity(
                  opacity: _opacity,
                  child: Text(
                    "Suit",
                  ),
                ),
              ),

              body: SingleChildScrollView(
                controller: _scrollController,
                child: Column(
                  children: [

                    SizedBox(
                      height: 400,
                    ),

                  
Container(
              decoration: BoxDecoration(
                color: Colors.black,
                borderRadius: BorderRadius.only(
                  topLeft: Radius.circular(20), 
                  topRight: Radius.circular(20),
                ),
              ),
              padding: EdgeInsets.all(16.0),
              child: Column(
                crossAxisAlignment: CrossAxisAlignment.start,
                children: [
                  Row(
                    children: [
                      Text(
                        'What\'s Inside',
                        style: TextStyle(
                          color: Colors.white,
                          fontSize: 18,
                          fontWeight: FontWeight.bold,
                        ),
                      ),
                      Spacer(),
                      ElevatedButton(
                        onPressed: (){}, 
                        child: Text("SNEAK PEEK", style: TextStyle(fontWeight: FontWeight.w700, ),), 
                        style: ElevatedButton.styleFrom(
                          padding: EdgeInsets.symmetric(horizontal: 5),
                          foregroundColor: Colors.black,

                          shape: RoundedRectangleBorder(
                            
                            borderRadius: BorderRadius.circular(10)
                            ),
                          ),
                        ),
                    ],
                  ),
                  SizedBox(height: 8),
                  Text(
                    'Slide into next-level style with suits that do it all—sharp, smooth, and made to move with you. Whether it\'s boardroom power or rooftop drinks, you\'re covered.',
                    style: TextStyle(color: Colors.white70),
                  ),
                  SizedBox(height: 16),
                  Text(
                    'Styles & Avatars',
                    style: TextStyle(
                      color: Colors.white,
                      fontSize: 18,
                      fontWeight: FontWeight.bold,
                    ),
                  ),
                SizedBox(height: 8),
                Column(
                  crossAxisAlignment: CrossAxisAlignment.start,
                    children: [
                      Text('- Suit & Tie Headshot', style: TextStyle(color: Colors.white70)),
                      Text('- Suit Office Portrait', style: TextStyle(color: Colors.white70)),
                      Text('- Boardroom Suit Snapshot', style: TextStyle(color: Colors.white70)),
                      Text('- Professional Suit Profile', style: TextStyle(color: Colors.white70)),
                      Text('- Professional Suit Selfie', style: TextStyle(color: Colors.white70)),
                      Text('- Suit & Tie Headshot', style: TextStyle(color: Colors.white70)),
                      Text('- Suit Office Portrait', style: TextStyle(color: Colors.white70)),
                      Text('- Boardroom Suit Snapshot', style: TextStyle(color: Colors.white70)),
                      Text('- Professional Suit Profile', style: TextStyle(color: Colors.white70)),
                      Text('- Professional Suit Selfie', style: TextStyle(color: Colors.white70)),
                      Text('- Suit & Tie Headshot', style: TextStyle(color: Colors.white70)),
                      Text('- Suit Office Portrait', style: TextStyle(color: Colors.white70)),

                       SizedBox(
                        height: 500,
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
                          Image.asset(
                            'assets/images/x.jpg', // Replace with your image path
                            fit: BoxFit.fill,
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
                       ),
                   
                    ],
                  ),
                
                  SizedBox(height: 100),
            ],
          ),
        ),
                  ]
                ),
              ),
            )
        
        
        //     
        
        
          ],
        ),
      ),
    );
  }
}