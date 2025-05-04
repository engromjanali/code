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