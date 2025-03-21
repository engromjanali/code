import 'package:flutter/material.dart';

void main() => runApp(MyApp());

class MyApp extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      home: OnOffSwitch(),
    );
  }
}

class OnOffSwitch extends StatefulWidget {
  @override
  _OnOffSwitchState createState() => _OnOffSwitchState();
}

class _OnOffSwitchState extends State<OnOffSwitch> {
  bool isOn = false;

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(title: Text('On/Off Button Example')),
      body: Center(
        child: Row(
          mainAxisAlignment: MainAxisAlignment.center,
          children: [
            Text(isOn ? 'ON' : 'OFF', style: TextStyle(fontSize: 18)),
            Switch(
              value: isOn,
              onChanged: (val) {
                setState(() {
                  isOn = val;
                });
              },
            ),
          ],
        ),
      ),
    );
  }
}
