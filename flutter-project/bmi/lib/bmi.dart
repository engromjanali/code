import 'package:flutter/material.dart';

void main() {
  runApp(const MyApp());
}

class MyApp extends StatelessWidget {
  const MyApp({super.key});

  // This widget is the root of your application.
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: 'Flutter Demo',
      theme: ThemeData(
        // This is the theme of your application.
        //
        // TRY THIS: Try running your application with "flutter run". You'll see
        // the application has a purple toolbar. Then, without quitting the app,
        // try changing the seedColor in the colorScheme below to Colors.green
        // and then invoke "hot reload" (save your changes or press the "hot
        // reload" button in a Flutter-supported IDE, or press "r" if you used
        // the command line to start the app).
        //
        // Notice that the counter didn't reset back to zero; the application
        // state is not lost during the reload. To reset the state, use hot
        // restart instead.
        //
        // This works for code too, not just values: Most code changes can be
        // tested with just a hot reload.
        colorScheme: ColorScheme.fromSeed(seedColor: Colors.red),
        useMaterial3: true,
      ),
      home: const MyHomePage(title: 'Flutter Demo Home Page'),
    );
  }
}

class MyHomePage extends StatefulWidget {
  const MyHomePage({super.key, required this.title});

  // This widget is the home page of your application. It is stateful, meaning
  // that it has a State object (defined below) that contains fields that affect
  // how it looks.

  // This class is the configuration for the state. It holds the values (in this
  // case the title) provided by the parent (in this case the App widget) and
  // used by the build method of the State. Fields in a Widget subclass are
  // always marked "final".

  final String title;

  @override
  State<MyHomePage> createState() => _MyHomePageState();
}

class _MyHomePageState extends State<MyHomePage> {
  dynamic result = "";
  var feet= TextEditingController();
  var inch= TextEditingController();
  var weight= TextEditingController();
  bool bmi_or_bmr = true;

  @override
  Widget build(BuildContext context) {
    // This method is rerun every time setState is called, for instance as done
    // by the _incrementCounter method above.
    //
    // The Flutter framework has been optimized to make rerunning build methods
    // fast, so that you can just rebuild anything that needs updating rather
    // than having to individually change instances of widgets.
    return Scaffold(
      appBar: AppBar(
        // TRY THIS: Try changing the color here to a specific color (to
        // Colors.amber, perhaps?) and trigger a hot reload to see the AppBar
        // change color while the other colors stay the same.
        backgroundColor: Theme.of(context).colorScheme.inversePrimary,

        // Here we take the value from the MyHomePage object that was created by
        // the App.build method, and use it to set our appbar title.
        title: Text(widget.title),
      ),
      body: Container(
        width: double.infinity,
        height: double.infinity,
        color: Colors.red.shade50,
        child: Stack(
          children: [
          Padding(
            padding: EdgeInsets.all(10),
            child: Column(
              mainAxisAlignment: MainAxisAlignment.center,
              crossAxisAlignment: CrossAxisAlignment.start,
              children: [
                Text("Enter Your Height here : ",style: TextStyle(fontSize: 20),),
                SizedBox(height: 10,),
                Row(
                    children: [
                      Expanded(
                        child: TextField(
                          controller: feet,
                          keyboardType: TextInputType.number,
                          decoration: InputDecoration(
                            label: Text("Height (Feet)",style: TextStyle(color: Colors.red),),
                            hintText: "Feet",
                            enabledBorder: OutlineInputBorder(
                                gapPadding: 0,
                                borderSide: BorderSide(
                                  color: Colors.grey,
                                  width: 2,
                                )
                            ),
                            focusedBorder: OutlineInputBorder(
                                gapPadding: 0,
                                borderSide: BorderSide(
                                  color: Colors.deepPurple,
                                  width: 2,
                                )
                            ),

                          ),
                        ),
                      ),
                      SizedBox(
                        width: 10,
                      ),
                      Expanded(
                        child: TextField(
                          controller: inch,
                          keyboardType: TextInputType.number,
                          decoration: InputDecoration(
                            label: Text("Height (Inches)",style: TextStyle(color: Colors.red),),
                            hintText: "Inches",
                            enabledBorder: OutlineInputBorder(
                                gapPadding: 0,
                                borderSide: BorderSide(
                                  color: Colors.grey,
                                  width: 2,
                                )
                            ),
                            focusedBorder: OutlineInputBorder(
                                gapPadding: 0,
                                borderSide: BorderSide(
                                  color: Colors.deepPurple,
                                  width: 2,
                                )
                            ),

                          ),
                        ),
                      ),
                    ],
                ),
                SizedBox(height: 10,),
                Text("Enter Your Weight here:",style: TextStyle(fontSize: 20),),
                SizedBox(height: 10,),
                TextField(
                  controller: weight,
                  keyboardType: TextInputType.number,
                  decoration: InputDecoration(
                    label: Text("Weight (Kg)",style: TextStyle(color: Colors.red),),
                    hintText: "Enter Your Weight Here in \"Kg\"",
                    enabledBorder: OutlineInputBorder(
                        gapPadding: 0,
                        borderSide: BorderSide(
                          color: Colors.grey,
                          width: 2,
                        )
                    ),
                    focusedBorder: OutlineInputBorder(
                        gapPadding: 0,
                        borderSide: BorderSide(
                          color: Colors.deepPurple,
                          width: 2,
                        )
                    ),

                  ),
                ),
                SizedBox(height: 10,),
                Row(
                  mainAxisAlignment: MainAxisAlignment.center,
                  children: [
                    ElevatedButton(onPressed: (){
                      if(inch.text.toString()!="" && weight.text.toString()!="" && feet.text.toString()!=""){
                        var kg = double.parse(weight.text.toString());
                        var ft = double.parse(feet.text.toString());
                        var inc = double.parse(inch.text.toString());
                        var mtr = (ft*0.3048) + (inc*0.0254);
                        setState((){
                          result = (kg/(mtr * mtr));
                          if(result<18.5){
                            result = result.toStringAsFixed(2) +" (Underweight)";
                          }
                          else if(result<24.9)
                          {
                            result =result.toStringAsFixed(2) +" (Normal weight)";
                          }
                          else if(result<29.9){
                            result =result.toStringAsFixed(2) +" (Overweight)";
                          }
                          else{
                            result =result.toStringAsFixed(2) +" (Obesity)";
                          }
                          });
                        }
                      else {
                        setState(() {
                          result = "please fill the all required blanks!!";
                        });
                      }
                    }, child: Text("Calculate")),
                  ],
                ),
                SizedBox(height: 50,),
                Row(
                  mainAxisAlignment: MainAxisAlignment.center,
                  children: [
                    Text(result.toString(), style: TextStyle(color: Colors.orange, fontSize: 20),),
                  ],
                ),
              ],
            ),
          ),
            Positioned(
                top: 10,
                left: 20,
                child: Row(
                  children: [
                    Text(bmi_or_bmr ? "BMI": "BMR", style: TextStyle(color: Colors.purpleAccent),),
                    Switch(
                      value: bmi_or_bmr,
                      onChanged: (val){
                        bmi_or_bmr = val;
                        setState(() {

                        });
                      },
                    ),
                    Text(bmi_or_bmr ? "BMR": "BMI", style: TextStyle(color: Colors.purpleAccent),),
                  ],
                )
            ),
          ]
        ),
      )
    );
  }
}
