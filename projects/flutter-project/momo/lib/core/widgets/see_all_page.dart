import 'package:flutter/material.dart';
import 'package:get/get.dart';
import 'package:get/get_core/src/get_main.dart';
import 'package:momo/data/model/explore/explore_item_model.dart';
import 'package:momo/data/model/explore/explore_model.dart';
import 'package:momo/core/widgets/get_this_pack.dart';
import 'package:momo/core/widgets/image_card.dart';

class SeeAllPage extends StatefulWidget {
  final ExploreModel? explore;
  final ExploreModel? oneShot;
  final bool isExplore;
  const SeeAllPage({
    super.key,
    this.explore,
    this.oneShot,
    this.isExplore = true,
  });

  @override
  State<SeeAllPage> createState() => _SeeAllPageState();
}

class _SeeAllPageState extends State<SeeAllPage> {
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
        title: Text(
          widget.isExplore ? widget.explore!.title : widget.oneShot!.title,
          style: TextStyle(
            fontSize: 22,
            fontWeight: FontWeight.w600,
            color: Colors.white,
          ),
        ),
        backgroundColor: Colors.black,
      ),
      body: Column(
        children: [
          Expanded(
            child: GridView.builder(
              itemCount:widget.explore!.items.length ,
              gridDelegate: SliverGridDelegateWithFixedCrossAxisCount(
                crossAxisCount: 2,
                childAspectRatio: 1 / 1.3,
              ),
              itemBuilder: (context, index) {
                return getImageCard(
                  label: widget.isExplore
                      ? EItemModel.fromMap(widget.explore!.items[index]).title
                      : EItemModel.fromMap(widget.oneShot!.items[index]).title,
                  numberOfPhoto: EItemModel.fromMap(widget.explore!.items[index]).example.length,
                );
              },
            ),
          ),
        ],
      ),
    );
  }
}
