import 'package:flutter/material.dart';
import 'package:get/get.dart';
import 'package:momo/core/helper/assets/images.dart';
import 'package:momo/core/util/constants/all_enums.dart';
import 'package:momo/core/util/constants/constants.dart';
import 'package:momo/core/widgets/bottom_button.dart';
import 'package:momo/core/widgets/custom_Image_type_selection_dialog.dart';

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
      body: Stack(
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
                          Images.myPhoto, // Replace with your image path
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
            bottomNavigationBar: getBottomRoundedButton(
              label: "Get This Pack",
              ontap :()async{
                SelectImageFrom res =await  customImageTypeSelectionDialog();
                debugPrint(res.toString());
              }
            ),
      
            appBar: AppBar(
              scrolledUnderElevation: 0,
              elevation: 0,
              backgroundColor:Colors.black.withAlpha(_opacity==1?255:0),
              foregroundColor:Colors.white,
              leading: IconButton(
                onPressed: (){
                  Get.back();
                }, 
                icon: Icon(Icons.cancel, size: 35,),
              ),
              title: Opacity(
                opacity: _opacity,
                child: Text(
                  "Suit",
                ),
              ),
            ),
      
            body: CustomScrollView(
              controller: _scrollController,
              slivers: [
                
                 SliverToBoxAdapter(
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
                   
                       
                   
                    ],
                                     ),
                                   
                                     SizedBox(height: 100),
                               ],
                             ),
                           ),
                                     ]
                                   ),
                 ),
      
                 SliverGrid.builder(
                  gridDelegate: SliverGridDelegateWithFixedCrossAxisCount(
                    crossAxisCount: 2,
                      childAspectRatio: 1/1.3,
                  ),
                  itemCount: 20,
                  itemBuilder: (BuildContext context, int index) {  
                    return Padding(
                                    padding: const EdgeInsets.all(8.0),
                                    child: ClipRRect(
                                      borderRadius: BorderRadiusGeometry.circular(10),
                                      child: Stack(
                                        fit: StackFit.expand,
                                        clipBehavior: Clip.hardEdge,
                                        children: [
                   Image.asset(
                     Images.myPhoto, // Replace with your image path
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
                                        ],
                                      ),
                                    )
                                  );
                  },
                  
                 ),
      
      
      
                  SliverToBoxAdapter(
                    child: SizedBox(height: 100,),
                  )
              ]
            ),
          )
      
      
      //     
      
      
        ],
      ),
    );
  }
}

// class OptimizedNestedSliverList extends StatelessWidget {
//   const OptimizedNestedSliverList({super.key});

//   final List<Map<String, List<String>>> sections = const [
//     {'Section 1': ['Item 1.1', 'Item 1.2']},
//     {'Section 2': ['Item 2.1', 'Item 2.2', 'Item 2.3']},
//     {'Section 3': ['Item 3.1', 'Item 3.2']},
//     {'Section 4': ['Item 4.1', 'Item 4.2', 'Item 4.3']},
//     {'Section 5': ['Item 5.1', 'Item 5.2', 'Item 5.3']},
//     {'Section 6': ['Item 6.1', 'Item 6.2', 'Item 6.3']},
//     {'Section 8': ['Item 7.1', 'Item 7.2', 'Item 7.3']},
//     {'Section 9': ['Item 7.1', 'Item 7.2', 'Item 7.3']},
//     {'Section 10': ['Item 10.1', 'Item 10.2', 'Item 10.3']},
//     {'Section 11': ['Item 11.1', 'Item 11.2', 'Item 11.3']},
//     {'Section 12': ['Item 12.1', 'Item 12.2', 'Item 12.3']},
//     {'Section 13': ['Item 13.1', 'Item 13.2', 'Item 13.3']},
//     {'Section 14': ['Item 14.1', 'Item 14.2', 'Item 14.3']},
//     {'Section 15': ['Item 15.1', 'Item 15.2', 'Item 15.3']},
//     {'Section 16': ['Item 16.1', 'Item 16.2', 'Item 16.3']},
//     {'Section 17': ['Item 17.1', 'Item 17.2', 'Item 17.3']},
//     {'Section 18': ['Item 18.1', 'Item 18.2', 'Item 18.3']},
//     {'Section 19': ['Item 19.1', 'Item 19.2', 'Item 19.3']},
//     {'Section 20': ['Item 20.1', 'Item 20.2', 'Item 20.3']},
//     {'Section 21': ['Item 21.1', 'Item 21.2', 'Item 21.3']},
//     {'Section 22': ['Item 22.1', 'Item 22.2', 'Item 22.3']},
//     {'Section 23': ['Item 23.1', 'Item 23.2', 'Item 23.3']},
//     {'Section 24': ['Item 24.1', 'Item 24.2', 'Item 24.3']},
//     {'Section 25': ['Item 25.1', 'Item 25.2', 'Item 25.3']},
//     {'Section 26': ['Item 26.1', 'Item 26.2', 'Item 26.3']},
//   ];

//   @override
//   Widget build(BuildContext context) {
//     return Scaffold(
//       appBar: AppBar(title: const Text('Optimized Lazy Nested List')),
//       body: !false? CustomScrollView(
        
//         // in here for multiple list of sliverlist we did not spacify height/expanded that's why we can smothly see one by one as list. and for invisible sliverlist it initially build only one child where listview build many. you will not see pexal issue unlike listview.
//         slivers: [
//           // Build each section (title + children) as its own sliver group,
//           // not lazy
//           for (final section in sections) ...[
//             // Section title
//             SliverToBoxAdapter(
//               child: Container(
//                 padding: const EdgeInsets.all(12),
//                 color: Colors.blue.shade100,
//                 child: Text(
//                   section.keys.first,
//                   style: const TextStyle(
//                     fontSize: 18,
//                     fontWeight: FontWeight.bold,
//                   ),
//                 ),
//               ),
//             ),

//             // Section children (lazy built)
//             SliverList(
//               delegate: SliverChildBuilderDelegate(
//                 (context, index) {
//                   final item = section.values.first[index];
//                   print("Building ${section.keys.first} -> $item");
//                   return Column(
//                     children: [
//                       Card(child: ListTile(title: Text(item))),
//                       ListView.builder(
//                         physics: NeverScrollableScrollPhysics(),
//                         shrinkWrap: true,
//                         itemCount: 10,
//                         itemBuilder: (context, index){
//                           return Text("sdfsd");
//                         }
//                       )
//                     ],
//                   );
//                 },
//                 childCount: section.values.first.length,
//               ),
//             ),

//           ]
//         ],
//       ) 
//       :
//       SingleChildScrollView(
//         child: Column(
//           children:
//             List.generate(30,(index){
//               return
//               SizedBox(
//                 height: 2000,
//                 child: ListView.builder(
//                       // shrinkWrap: true,
//                       // physics: NeverScrollableScrollPhysics(),
//                       itemBuilder: (context , index2){
//                         print("$index.$index2");
//                         return Card(child: Text("$index.$index2", style: TextStyle(fontSize: 30),));
//                       },
//                       itemCount: 1000,
//                     ),
//               );
//             }),
//         ),
//       )
//     );
//   }
// }
