import 'package:flutter/material.dart';
import 'package:get/get.dart';
import 'package:momo/core/asset_manager/assets/images.dart';
import 'package:momo/core/util/constants/all_enums.dart';
import 'package:momo/core/widgets/bottom_button.dart';
import 'package:momo/core/widgets/custom_Image_type_selection_dialog.dart';
import 'package:momo/core/widgets/get_started.dart';
import 'package:momo/data/model/explore/explore_item_model.dart';
import 'package:momo/data/model/one_shot/oneshot_item_model.dart';
import 'package:momo/data/model/one_shot/oneshot_model.dart';

class GetThisPack extends StatefulWidget {
  final bool isExplore;
  final EItemModel? eItem;
  final OSItemModel? oneShotItem;
  const GetThisPack({
    super.key,
    this.isExplore = true,
    this.eItem,
    this.oneShotItem,
  });
  @override
  _GetThisPackState createState() => _GetThisPackState();
}

class _GetThisPackState extends State<GetThisPack> {
  final ScrollController _scrollController = ScrollController();
  double _opacity = 0.0;
  double _imageScale = 1.0; // Scale for bounce effect

  @override
  void initState() {
    super.initState();

    _scrollController.addListener(() {
      setState(() {
        if (_scrollController.offset < 0) {
          _imageScale =
              1 +
              ((_scrollController.offset).clamp(-100, 0)).abs().toDouble() /
                  1000;
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
                              colors: [Colors.black, Colors.transparent],
                            ),
                          ),
                        ),
                        Positioned(
                          bottom: 0,
                          left: 0,
                          right: 0,
                          child: Column(
                            children: [
                              Text(
                                widget.isExplore
                                    ? widget.eItem!.title
                                    : widget.oneShotItem!.title,
                                style: TextStyle(
                                  color: Colors.white,
                                  fontSize: 28,
                                  fontWeight: FontWeight.w800,
                                ),
                              ),
                              Text(
                                "${widget.isExplore ? widget.eItem!.example.length : widget.oneShotItem!.example.length} Photos",
                                style: TextStyle(
                                  color: Colors.white,
                                  fontSize: 18,
                                ),
                              ),
                              SizedBox(height: 20),
                            ],
                          ),
                        ),
                      ],
                    ),
                  ),
                ),
              ),
              Expanded(child: Container(color: Colors.black)),
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
              ontap: () async {
                debugPrint("check");
                Get.to(()=>GetStarted(imageType: ImageType.single,));
              },
            ),

            appBar: AppBar(
              scrolledUnderElevation: 0,
              elevation: 0,
              backgroundColor: Colors.black.withAlpha(_opacity == 1 ? 255 : 0),
              foregroundColor: Colors.white,
              leading: IconButton(
                onPressed: () {
                  Get.back();
                },
                icon: Icon(Icons.cancel, size: 35),
              ),
              centerTitle: true,
              title: Opacity(opacity: _opacity, child: Text("Suit",),),
            ),

            body: CustomScrollView(
              physics: BouncingScrollPhysics(),
              controller: _scrollController,
              slivers: [
                SliverToBoxAdapter(
                  child: Column(
                    children: [
                      SizedBox(height: 400),

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
                                Container(
                                  
                                  
                                  padding: EdgeInsets.symmetric(
                                      vertical: 4,
                                      horizontal: 4

                                    ),
                                  decoration: BoxDecoration(
                                    color: Colors.white,

                                      borderRadius: BorderRadius.circular(10),
                                  ),
                                  
                                  
                                  child: Text(
                                    "SNEAK PEEK",
                                    style: TextStyle(
                                      fontWeight: FontWeight.w700,
                                    ),
                                    
                                  ),
                                ),
                              ],
                            ),
                            SizedBox(height: 8),
                            Text(
                              // widget.isExplore
                              //     ? 
                                  widget.eItem!.details,
                                  // : widget.oneShotItem!.details,
                              style: TextStyle(color: Colors.white70),
                            ),
                            SizedBox(height: 8),
                            Text(
                              'Styles & Avatars',
                              style: TextStyle(
                                color: Colors.white,
                                fontSize: 18,
                                fontWeight: FontWeight.bold,
                              ),
                            ),

                            ListView.builder(
                              padding: EdgeInsets.symmetric(vertical: 20),
                              physics: NeverScrollableScrollPhysics(),
                              shrinkWrap: true,
                              itemCount: 
                              // widget.isExplore
                              //     ? 
                                  widget.eItem!.spacificaton.length,
                                  // : widget.oneShotItem!.spacificaton.length,
                              itemBuilder: (_, index) {
                                return Row(
                                  spacing: 10,
                                  mainAxisSize: MainAxisSize.min,
                                  children: [
                                    Icon(Icons.circle, color: Colors.grey, size: 10,),
                                    Expanded(
                                      child: Text(
                                        // widget.isExplore?
                                            widget.eItem!.spacificaton[index],
                                            // : widget
                                            //       .oneShotItem!
                                            //       .spacificaton[index],
                                        style: TextStyle(color: Colors.white70),
                                      ),
                                    ),
                                  ],
                                );
                              },
                            ),

                            Text(
                              'Example Outputs',
                              style: TextStyle(
                                color: Colors.white,
                                fontSize: 18,
                                fontWeight: FontWeight.bold,
                              ),
                            ),
                          ],
                        ),
                      ),
                    ],
                  ),
                ),

                SliverGrid.builder(
                  gridDelegate: SliverGridDelegateWithFixedCrossAxisCount(
                    crossAxisCount: 2,
                    childAspectRatio: 1 / 1.3,
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
                                  begin:
                                      Alignment.bottomCenter, // start at bottom
                                  end: Alignment.topCenter,
                                  // transform: GradientRotation(4),
                                  colors: [
                                    Colors.black, // bottom color
                                    Colors.transparent, // top color
                                    Colors.transparent, // top color
                                  ],
                                ),
                              ),
                            ),
                          ],
                        ),
                      ),
                    );
                  },
                ),

                SliverToBoxAdapter(child: SizedBox(height: 100)),
              ],
            ),
          ),

          //
        ],
      ),
    );
  }
}
