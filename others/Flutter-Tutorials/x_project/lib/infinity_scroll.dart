

import 'dart:math';
import 'package:flutter/material.dart';
import 'package:scrollable_positioned_list/scrollable_positioned_list.dart';

class InfinityScroll extends StatefulWidget {
  const InfinityScroll({super.key});

  @override
  State<InfinityScroll> createState() => _InfinityScrollState();
}

class _InfinityScrollState extends State<InfinityScroll> {
  final ItemScrollController itemScrollController = ItemScrollController();
  final ScrollOffsetController scrollOffsetController =
      ScrollOffsetController();
  final ItemPositionsListener itemPositionsListener =
      ItemPositionsListener.create();
  final ScrollOffsetListener scrollOffsetListener =
      ScrollOffsetListener.create();

  int x = 0;

  bool alreadyLoading = false;

  List<(int, int)> itemList = [];

  @override
  void initState() {
    super.initState();

    for (int i = 0; i < 55; i++) {
      itemList.add((i, Random().nextInt(200) + 100));
    }

    // 🔹 Listen to item positions (which items are visible)
    itemPositionsListener.itemPositions.addListener(() {
      final positions = itemPositionsListener.itemPositions.value;

      // Print all visible indexes
      final visibleIndexes = positions.map((e) => e.index).toList()..sort();
      debugPrint("Visible indexes: $visibleIndexes");

      if (visibleIndexes.isNotEmpty) {
        int lastVisibleIndex = visibleIndexes.last;
        removeData(lastVisibleIndex: visibleIndexes.last);
        loadData(lastVisibleIndex: lastVisibleIndex);
      }
    });
  }

  Future<void> removeData({required int lastVisibleIndex}) async {
    /// Note :
    /// when i call "jumpTo" it's automitically rebuild ScrollablePositionedList, for "scrollTo" to we must have to call setState.
    /// if we use "scrollTo" the duration has passed as argument, we should delay the same Diration to change (state flag)  otherwise we fatch an error,
    
    // // using scrollTo
    // if (lastVisibleIndex > 100 && !alreadyLoading) {
    //   debugPrint("removed few data");
    //   alreadyLoading = true;
    //   Duration duration = Duration(milliseconds: 200);
    //   itemList.removeRange(0, 80); // remove 80 item
    //   itemScrollController.scrollTo(
    //     index: lastVisibleIndex - 80,
    //     duration: duration,
    //     alignment: 1,
    //   );
    //   setState(() {
    //     // Get.snackbar("title", "message ${itemList.length}");
    //   });
    //   await Future.delayed(duration);
    //   alreadyLoading = false;
    // }

    // using "jumpTo"
    if (lastVisibleIndex > 100 && !alreadyLoading) {
      debugPrint("removed few data");
      alreadyLoading = true;

      itemList.removeRange(0, 80); // remove 80 item
      itemScrollController.jumpTo(
        index: lastVisibleIndex - 80,
        alignment: 1,
      );
      alreadyLoading = false;
    }
  }

  Future<void> loadData({required int lastVisibleIndex}) async {
    if (lastVisibleIndex >= itemList.length - 10 && !alreadyLoading) {
      debugPrint("⚡ Near the end! Loading more...");
      alreadyLoading = true;

      int i = itemList.last.$1 + 1;
      int n = i + 10;
      for (; i < n; i++) { // adding 10 item every call
        itemList.add((i, Random().nextInt(200) + 100));
      }

      setState(() {}); // Update UI
      alreadyLoading = false;
    }
  }

  @override
  Widget build(BuildContext context) {
    print("object");
    return Scaffold(
      appBar: AppBar(
        title: Text("Infinity Scroll $x"),
        actions: [
          IconButton(
            onPressed: () {
              setState(() {
                debugPrint("Removed first 20 items");
                itemList.removeRange(0, 20);
              });
            },
            icon: Icon(Icons.cancel),
          ),
        ],
      ),
      body: SizedBox(
        height: 700,
        child: ScrollablePositionedList.builder(
          itemCount: itemList.length,
          itemBuilder: (context, index) {
            x = index;

            return Card(
              child: Container(
                height: itemList[index].$2.toDouble(),
                width: double.maxFinite,
                child: Column(
                  mainAxisAlignment: MainAxisAlignment.center,
                  children: [
                    Text("index: ${itemList[index].$1}"),
                    Text("height: ${itemList[index].$2}"),
                  ],
                ),
              ),
            );
          },
          itemScrollController: itemScrollController,
          scrollOffsetController: scrollOffsetController,
          itemPositionsListener: itemPositionsListener,
          scrollOffsetListener: scrollOffsetListener,
        ),
      ),
    );
  }
}
