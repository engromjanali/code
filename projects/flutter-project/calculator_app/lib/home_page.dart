import 'package:flutter/material.dart';
import 'package:math_expressions/math_expressions.dart';


class MyHomePage extends StatefulWidget {
  const MyHomePage({super.key, required this.title});

  final String title;

  @override
  State<MyHomePage> createState() => _MyHomePageState();
}

class _MyHomePageState extends State<MyHomePage> {

  List button = [
    "AC", "+/-", "x!", "C",
    "π", "√", "x²", "xʸ",
    "(", ")", "%", "/",
    "1", "2", "3", "*",
    "4", "5", "6", "-",
    "7", "8", "9", "+",
    ".", "0", "=",
  ];
  dynamic input = "";
  dynamic input_result ="";


  TextEditingController a = TextEditingController();

  @override
  Widget build(BuildContext context) {
    final screenSize = MediaQuery
        .of(context)
        .size;
    return Scaffold(
      appBar: AppBar(
        backgroundColor: Theme
            .of(context)
            .colorScheme
            .inversePrimary,
        title: Text(widget.title),
      ),
      body: Container(
        // padding: EdgeInsets.all(30),
        // padding: const EdgeInsets.all(10),
        color: Colors.black,
        height: double.infinity,
        width: double.infinity,
        child: Hero(
          tag: "1",
          child: Column(
            mainAxisAlignment: MainAxisAlignment.end,
            crossAxisAlignment: CrossAxisAlignment.end,
            children: [
              Container(
                height: (screenSize.height * 0.259), //25.9% and rest 21.1% take menu bar
                child: Container(
                  width: double.infinity,
                  color: Color(0xffe2ebf0),
                  padding: const EdgeInsets.all(10),
                  child: Column(
                    crossAxisAlignment: CrossAxisAlignment.end,
                    mainAxisAlignment: MainAxisAlignment.end,
                    children: [
                      SingleChildScrollView(
                        reverse: true,
                        scrollDirection: Axis.horizontal,
                        child: Text("$input",
                          style: TextStyle(fontSize: 30,),
                          textAlign: TextAlign.end,),
                      ),
                      Expanded(
                        child: SingleChildScrollView(
                          scrollDirection: Axis.vertical,
                          reverse: true,
                          child: Text("$input_result",
                            style: TextStyle(fontSize: 35, color: Colors.black, fontWeight: FontWeight.w500),
                            textAlign: TextAlign.end,),
                        ),
                      ),
                    ],
                  ),
                ),
              ),
              Divider(
                color: Colors.white54,
                thickness: 3,
                height: screenSize.height * .015, //01.50%
              ),
              Wrap(
                children: button.map((value) =>
                    SizedBox(
                      width: value == '=' ? screenSize.width / 2 : screenSize
                          .width / 4,
                      height: (screenSize.height * 0.60) / 7, // 60%/7
                      child: get(value),
                    )
                ).toList(),
              ),
              SizedBox(
                height: screenSize.height * .015, //01.50%
              ),
            ],
          ),
        ),
      ),
    );
  }

  Widget get(value) {
    return Padding(
      padding: EdgeInsets.all(5),
      child: Material(
        clipBehavior: Clip.hardEdge,
        shadowColor: Colors.white,
        elevation: 5,
        shape: OutlineInputBorder(
          borderSide: const BorderSide(
            color: Colors.grey,
          ),
          borderRadius: BorderRadius.circular(15),
        ),
        color: getBtnColor(value),
        child: InkWell(
            splashColor: Colors.grey,
            onTap: () {
              setState(() {
                buttonHandle(value);
                input_result = preprocessExpression(input_result);
              });
            },
            child: Center(
              child: Text(value, style: TextStyle(fontSize: 30),),)),
      ),
    );
  }


  String preprocessExpression(String input) {
    // Handle "10(10)" → "10*(10)"
    input = input.replaceAllMapped(RegExp(r'(\d)\('), (match) => '${match[1]}*(');

    // Handle "(10)(10)" → "(10)*(10)"
    // Handle "(10)10" → "(10)*10"
    input = input.replaceAllMapped(RegExp(r'\)(\d|\()'), (match) => ')*${match[1]}');
    // handel +. -> +0.
    // handel -. -> +0.
    // handel x. -> +0.
    // handel /. -> +0.
    // handel ). -> +0.
    input = input.replaceAllMapped(RegExp(r'(\(|\+|\-|x|\/)\.'), (match) => '${match[1]}0.');
    // Handle "100%50" → "100%*50"
    input = input.replaceAllMapped(RegExp(r'\%(\d)'), (match) => '%*${match[1]}');
    // handel "* -> x"
    input = input.replaceAll(RegExp(r'\*'), 'x');

    return input;
  }

  Color getBtnColor(value) {
    if (RegExp(r'^(\d)+$').hasMatch(value)) {
      return Colors.white;
    }
    if (value == '+' || value == '-' || value == '*' || value == '/') {
      return Colors.red.shade100;
    }
    if (value == 'AC' || value == 'C') {
      return value == 'AC' ? Colors.red : Colors.red.shade300;
    }
    if (value == '.') return Colors.grey;
    if (value == '=') return Colors.green.shade100;
    // "AC", "+/-", "x!", "C",
    // "π", "√", "x²", "xʸ",
    // "(", ")", "%", "/",
    // "1" ,"2", "3", "*",
    // "4", "5", "6", "-",
    // "7", "8", "9", "+",
    // ".", "0", "=",
    return Colors.orange.shade300;
  }

  buttonHandle(value) {
    if (RegExp(r'^(\d)+$').hasMatch(value)|| value=='+' || value=='-' || value=='*' || value=='(' || value==')' || value=='x2/' || value=='/' || value=='/') {
      if(input_result.length<=500){
        input_result=input_result+value;
      }
      else showMessage(context);
    }
    if (value == "AC") {
      input = "";
      input_result = "";
    }
    if (value == "C") {
      input_result = input_result.substring(0, input_result.length == 0 ? 0 : input_result.length - 1);
    }
    if (value == "π") {
      input_result += "π";
      // input_result += "3.1416";
    }
    if (value == ".") {
      input_result += ".";
    }
    if (value == "x²") {
      // input_result = input_result+("\u00B2");
      input_result = input_result+("^2");
    }
    if (value == "xʸ") {
      input_result = input_result+("^");
    }
    if (value == "%") {
      input_result = input_result+("%");
    }
    if (value == "x!") {
      input_result = input_result+("!");
    }
    if (value == "+/-") {
      List<String> charList = input_result.split('');
      bool flag = true;
      for(int i=charList.length; i>0; i--){
        switch(charList[i-1]){
          case '+':
            flag = false;
            charList[i-1]='-';
            break;// loop will be break.
            return;
          case '-':
            flag = false;
            charList[i-1]='+';
            if(i==1) charList[i-1]=''; // if the operator is in front of string erase it because default "+"
            break;// loop will be break.
            return;
        }
      }
      if(flag) charList.insert(0, "-");// if there are no operator insert '-' in front.
      input_result = charList.join("");
    }
    if (value == "√") {
      // input_result = input_result+("√");
      input_result = input_result+("√(");
    }
    if(value=='='){
      // Auto add right parenthesis in last
      int left_parenthesis=0;
      int right_parenthesis=0;

      for(int i=0; i<input_result.length; i++){
        if(input_result[i]=="(") left_parenthesis++;
        if(input_result[i]==")") right_parenthesis++;
      }
      if(left_parenthesis>right_parenthesis){
        int add_right_paranthacis= left_parenthesis-right_parenthesis;
        while(add_right_paranthacis>0){
          add_right_paranthacis--;
          input_result+=')';
        }
      }// end

      input = input_result+"="; // input will move up
      input_result = calculate(); // assign result here.
    }
  }

  dynamic calculate(){ // infix to result
    try{
      input_result = input_result.replaceAll('√', 'sqrt'); // '√' replace to 'sqrt'
      input_result = input_result.replaceAll('%', '/100'); // '%' replace to '1/100*' // example 345 * (1/100) * 20 (it's mean 20% of 345)
      input_result = input_result.replaceAll('x', '*'); // 'x' replace to '*' // example 345 x 1 = 345 * 1

      ContextModel cm = ContextModel();
      cm.bindVariable(Variable('π'), Number(3.1416));
      // cm.bindVariable(Variable('π'), Number(pi));
      var exp = Parser().parse(input_result);  // infix to postfix
      var evaluation = exp.evaluate(EvaluationType.REAL, cm); // postfix to result

      if(evaluation % 1==0) {
        // fun();
        return evaluation.toInt().toString();
      }
      else return evaluation.toString();
    }catch(e) {
      print("hii  -------------\n $e");
      return "Error!";
    }
  }

  void showMessage(BuildContext context){
    showDialog(context: context, builder: (BuildContext context){
      return AlertDialog(
        title: Text("alert"),
        content: Text("Maximum Calculate Digit-50!"),
        actions: [TextButton(onPressed: (){
          Navigator.pop(context);
        },
          child: Text("Ok"),
        ),
        ],
      );
    },
    );
  }
}
