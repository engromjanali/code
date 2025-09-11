import 'package:flutter/material.dart';

class TabBarScreen extends StatefulWidget {
  const TabBarScreen({super.key});

  @override
  State<TabBarScreen> createState() => _TabBarScreenState();
}

class _TabBarScreenState extends State<TabBarScreen> {
  @override
  Widget build(BuildContext context) {
    return DefaultTabController(
      length: 4,
      child: Scaffold(
        appBar: AppBar(
          title: Text("my app xyz"),
          bottom: TabBar(
            tabAlignment: TabAlignment.center,
            
            isScrollable: true,
            tabs: [
              Tab(icon: Icon(Icons.abc), text: "add",),
              Tab(icon: Icon(Icons.abc), text: "add",),
              Tab(icon: Icon(Icons.abc), text: "add",),
              Tab(icon: Icon(Icons.abc), text: "add",),
            ],
          ),
        ),
        body: Column(
          children: [
            Container(
              color: Colors.amber,
              height: 200,
            ),
            Expanded(
              child: TabBarView(children: [
                screen1(),
                screen2(),
                screen3(),
                screen4(),
              ]),
            ),
          ],
        ),
      ),
      );
  }
}

class screen1 extends StatelessWidget {
  const screen1({super.key});

  @override
  Widget build(BuildContext context) {
    return Container(
      child: Center(
        child: Text(
        "screen 1"
        ),
      ),
    );
  }
}
class screen2 extends StatelessWidget {
  const screen2({super.key});

  @override
  Widget build(BuildContext context) {
    return Container(
      child: SingleChildScrollView(
        child: Column(
          children: [
            Center(
              child: Text(
              "screen 2"
              ),
            ),
            Container(
              color: Colors.red,
              height: 200,
            ),
            Container(
              color: Colors.green,
              height: 200,
            ),
            Container(
              color: Colors.red,
              height: 200,
            ),
            Container(
              color: Colors.green,
              height: 200,
            ),
            Container(
              color: Colors.red,
              height: 200,
            ),
            Container(
              color: Colors.green,
              height: 200,
            ),
            Container(
              color: Colors.red,
              height: 200,
            ),
            Container(
              color: Colors.green,
              height: 200,
            ),
            Container(
              color: Colors.red,
              height: 200,
            ),
            Container(
              color: Colors.green,
              height: 200,
            ),
          ],
        ),
      ),
    );
  }
}
class screen3 extends StatelessWidget {
  const screen3({super.key});

  @override
  Widget build(BuildContext context) {
    return Container(
      child: Center(
        child: Text(
        "screen 3"
        ),
      ),
    );
  }
}
class screen4 extends StatelessWidget {
  const screen4({super.key});

  @override
  Widget build(BuildContext context) {
    return Container(
      child: Center(
        child: Text(
        "screen 4"
        ),
      ),
    );
  }
}


// 2.-----------.-----------.-----------.-----------.-----------.-----------.-----------.-----------.-----------
// custom
import 'package:cloud_firestore/cloud_firestore.dart';
import 'package:firebase_auth/firebase_auth.dart';
import 'package:flutter/material.dart';
import 'package:flutter/rendering.dart';
import 'package:flutter/scheduler.dart';
import 'package:font_awesome_flutter/font_awesome_flutter.dart';
import 'package:intl/intl.dart';
import 'package:mess_management/constants.dart';
import 'package:mess_management/fund/clear_fund.dart';
import 'package:mess_management/fund/fand_list.dart';
import 'package:mess_management/fund/fund_entry.dart';
import 'package:mess_management/helper/helper_method.dart';
import 'package:mess_management/helper/ui_helper.dart';
import 'package:mess_management/model/fund_model.dart';
import 'package:mess_management/providers/authantication_provider.dart';
import 'package:mess_management/providers/fund_provider.dart';
import 'package:mess_management/providers/mess_provider.dart';
import 'package:mess_management/ui_helper/ui_helper.dart';
import 'package:provider/provider.dart';

class FundScreen extends StatefulWidget {
  const FundScreen({super.key});

  @override
  State<FundScreen> createState() => _FundScreenState();
}


class _SliverTabBarDelegate extends SliverPersistentHeaderDelegate {
  final TabBar _tabBar;

  _SliverTabBarDelegate(this._tabBar);

  @override
  double get minExtent => _tabBar.preferredSize.height;
  @override
  double get maxExtent => _tabBar.preferredSize.height;

  @override
  Widget build(BuildContext context, double shrinkOffset, bool overlapsContent) {
    return Container(
      color: Colors.white, // Optional: background color
      child: _tabBar,
    );
  }

  @override
  bool shouldRebuild(covariant SliverPersistentHeaderDelegate oldDelegate) => false;
}

class _FundScreenState extends State<FundScreen> with SingleTickerProviderStateMixin {
  TabController? _tabController;

  final List<String> tabs =const ['Fund Tnx List', 'Add Fund', 'Clear Fand'];
  final List<Icon> icons =const [Icon(Icons.list_alt),Icon(Icons.create),Icon(Icons.clear),];


  @override
  void initState() {
    // TODO: implement initState
    super.initState();
    _tabController = TabController(length: tabs.length, vsync: this);
  }

  @override
  Widget build(BuildContext context) {
    return NestedScrollView(
      floatHeaderSlivers: true,
      headerSliverBuilder: (context, scrollable){
        return [
          SliverAppBar(
            backgroundColor: Colors.grey,
            title: AnimatedBuilder(
              animation: _tabController!,
              builder: (context, child) {
                return Text(tabs[_tabController!.index]);
              },
            ),
            actions: [],
            floating: true,
            snap: true,
            pinned: true,
            bottom: TabBar(
              controller: _tabController,
              isScrollable: true,// must assign otherwise get an error
              tabAlignment: TabAlignment.start,
              labelColor: Colors.black,
              labelStyle: TextStyle(fontWeight: FontWeight.bold),
              unselectedLabelColor: Colors.black,
              unselectedLabelStyle: TextStyle(fontWeight: FontWeight.normal),
              indicatorColor: Colors.black,
              tabs:tabs.map((e)=> Tab(text: e.toString() , icon:icons[tabs.indexOf(e)],)).toList(),
            ),
          ),
          
        ];
      },
      
      body:TabBarView(
        controller: _tabController,
        children: [
          FundList(),
          AddFund(),
          ClearFund(),
        ],
      )
    );
  }
}







3.----------------------------------------------------------------------------------------------------------------------
// appber visble but tabber will be scrollable 

import 'package:flutter/material.dart';

void main() {
  runApp(MaterialApp(
    home: FundScreen(),
    debugShowCheckedModeBanner: false,
  ));
}

class FundScreen extends StatefulWidget {
  const FundScreen({super.key});

  @override
  State<FundScreen> createState() => _FundScreenState();
}

class _FundScreenState extends State<FundScreen>
    with SingleTickerProviderStateMixin {
  late TabController _tabController;

  final List<String> tabs = const ['Fund Tnx List', 'Add Fund', 'Clear Fund'];
  final List<Icon> icons = const [
    Icon(Icons.list_alt),
    Icon(Icons.create),
    Icon(Icons.clear),
  ];

  @override
  void initState() {
    super.initState();
    _tabController = TabController(length: tabs.length, vsync: this);
  }

  @override
  Widget build(BuildContext context) {
    return DefaultTabController(
      length: tabs.length,
      child: Scaffold(
        body: NestedScrollView(
          headerSliverBuilder: (context, innerBoxScrolled) => [
            SliverAppBar(
              pinned: true,
              backgroundColor: Colors.grey.shade300,
              title: AnimatedBuilder(
                animation: _tabController,
                builder: (context, _) => Text(tabs[_tabController.index]),
              ),
              actions: [
                IconButton(onPressed: () {}, icon: Icon(Icons.search)),
                IconButton(onPressed: () {}, icon: Icon(Icons.more_vert)),
              ],
            ),

            // Scroll-away TabBar
            SliverPersistentHeader(
              pinned: false,
              delegate: _SliverTabBarDelegate(
                TabBar(
                  controller: _tabController,
                  isScrollable: true,
                  labelColor: Colors.black,
                  labelStyle: TextStyle(fontWeight: FontWeight.bold),
                  unselectedLabelColor: Colors.grey,
                  indicatorColor: Colors.black,
                  tabs: List.generate(
                    tabs.length,
                    (i) => Tab(
                      text: tabs[i],
                      icon: icons[i],
                    ),
                  ),
                ),
              ),
            ),
          ],
          body: TabBarView(
            controller: _tabController,
            children: List.generate(
              tabs.length,
              (i) => ListView.builder(
                itemCount: 30,
                padding: EdgeInsets.all(10),
                itemBuilder: (context, index) => Card(
                  child: ListTile(
                    title: Text('${tabs[i]} Item ${index + 1}'),
                    subtitle: Text('Subtitle of item ${index + 1}'),
                  ),
                ),
              ),
            ),
          ),
        ),
      ),
    );
  }
}

class _SliverTabBarDelegate extends SliverPersistentHeaderDelegate {
  final TabBar _tabBar;

  _SliverTabBarDelegate(this._tabBar);

  @override
  double get minExtent => _tabBar.preferredSize.height;

  @override
  double get maxExtent => _tabBar.preferredSize.height;

  @override
  Widget build(
      BuildContext context, double shrinkOffset, bool overlapsContent) {
    return Container(
      color: Colors.white, // TabBar background color
      child: _tabBar,
    );
  }

  @override
  bool shouldRebuild(_SliverTabBarDelegate oldDelegate) => false;
}
