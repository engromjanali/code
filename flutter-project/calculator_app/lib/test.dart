import 'package:flutter/material.dart';
import 'package:math_expressions/math_expressions.dart';

void main() {
  runApp(CalculatorApp());
}

class CalculatorApp extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      debugShowCheckedModeBanner: false,
      home: CalculatorScreen(),
    );
  }
}

class CalculatorScreen extends StatefulWidget {
  @override
  _CalculatorScreenState createState() => _CalculatorScreenState();
}

class _CalculatorScreenState extends State<CalculatorScreen> {
  TextEditingController _controller = TextEditingController();
  String output = '';

  String convertSuperscript(String superscript) {
    const Map<String, String> superscriptMap = {
      '⁰': '0', '¹': '1', '²': '2', '³': '3', '⁴': '4', '⁵': '5',
      '⁶': '6', '⁷': '7', '⁸': '8', '⁹': '9'
    };
    return superscript.split('').map((c) => superscriptMap[c] ?? c).join();
  }

  void evaluateExpression() {
    try {
      String modifiedInput = _controller.text
          .replaceAllMapped(RegExp(r'10([⁰¹²³⁴⁵⁶⁷⁸⁹]+)'), (match) => '10^${convertSuperscript(match[1]!)}')
          .replaceAll('²', '^2')
          .replaceAll('³', '^3')
          .replaceAll('ʸ', '^')
          .replaceAll('√', 'sqrt');

      Parser p = Parser();
      Expression exp = p.parse(modifiedInput);
      ContextModel cm = ContextModel();

      double result = exp.evaluate(EvaluationType.REAL, cm);

      String formattedResult = result.abs() > 1e10 ? result.toStringAsExponential(5) : result.toString();

      setState(() {
        output = formattedResult;
      });
    } catch (e) {
      setState(() {
        output = "Error";
      });
    }
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(title: Text('Advanced Calculator')),
      body: Padding(
        padding: const EdgeInsets.all(16.0),
        child: Column(
          mainAxisAlignment: MainAxisAlignment.center,
          children: [
            TextField(
              controller: _controller,
              decoration: InputDecoration(border: OutlineInputBorder(), hintText: 'Enter expression'),
            ),
            SizedBox(height: 10),
            Row(
              mainAxisAlignment: MainAxisAlignment.center,
              children: [
                ElevatedButton(
                  onPressed: () {
                    setState(() {
                      _controller.text += "10ⁿ";  // Insert 10ⁿ
                    });
                  },
                  child: Text("10ⁿ"),
                ),
              ],
            ),
            SizedBox(height: 10),
            ElevatedButton(
              onPressed: evaluateExpression,
              child: Text('Calculate'),
            ),
            SizedBox(height: 10),
            Text('Result: $output', style: TextStyle(fontSize: 20)),
          ],
        ),
      ),
    );
  }
}
