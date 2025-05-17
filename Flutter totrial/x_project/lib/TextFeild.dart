// it's our default code what we get in main file when we create a new project.
// ✅ Use TextField if you just need a simple input field without validation.
// ✅ Use TextFormField if you are working with forms and need validation.
import 'package:flutter/material.dart';

void main() {
  runApp(MyApp());
}

class MyApp extends StatelessWidget{ // we use StatelessWidget when we did't should any changes in runtime.
  const MyApp({Key? key}) : super(key: key);

  @override

  Widget build(BuildContext context) {
    // return CupertinoApp()// for IOS
    // return MaterialApp()// for Android
    return MaterialApp(
      debugShowCheckedModeBanner: false,
      title: "hello programmer",
      theme: ThemeData(
        primarySwatch: Colors.green,
        appBarTheme: AppBarTheme(
          backgroundColor: Colors.red, // Explicitly set AppBar color
        ),
        useMaterial3: true,
      ),
      home:HomePage(),
    );
  }
}

// class DeashBoardScreen extends StatefulWidget{
//   @override
//   Widget build(BuildContext context) {
//     return Scaffold(
//         appBar: AppBar(
//           title: Text("Deashboard"),
//         ),
//         body: Container(
//           color: Colors.blueGrey,
//         ),
//     );
//   }
class HomePage extends StatefulWidget
{

  @override
  State<StatefulWidget> createState()=>HomePageState();
}
class HomePageState extends State<HomePage>{
  var text1 = TextEditingController();
  @override
  Widget build(BuildContext context) {
    return Scaffold(
        appBar: AppBar(
          title: Text("Deashboards"),

        ),
      body: Center(
        child: Container(
          width: 200,
          child: Column(
            crossAxisAlignment: CrossAxisAlignment.center,
            mainAxisAlignment: MainAxisAlignment.center,
            children: [
              TextFormField(
              ),
              TextField(
                autofocus: false,
                controller: text1,
                enabled: true,
                obscureText: true,
                obscuringCharacter: '*',
                keyboardType: TextInputType.phone,
                onTapOutside: (event) {// close keyboard
                  FocusScope.of(context).unfocus();
                },
                inputFormatters: [
                  FilteringTextInputFormatter.digitsOnly, // Only allows digits
                ],
                decoration: InputDecoration(
                  label: Text("Name *"),
                  helperText: "helper Text 1",
                  prefix: Icon(Icons.abc),
                  suffix: InkWell(child: Icon(Icons.abc), onTap:() => print("hi ${text1.text.toString()}"),),
                  hintText: "Enter your Name Here...",
                  filled: true,
                  fillColor: Colors.red.shade100,
                  // errorText: "you must have to Enter your Name",
                  border: OutlineInputBorder(// if we use enable/disable/focused border we can ignore normal order
                      borderSide: BorderSide(
                      color:Colors.red,
                      width: 5,
                    ),
                    borderRadius: BorderRadius.only(topLeft: Radius.circular(10), topRight: Radius.circular(10)),
                  ),
                  // enabledBorder: OutlineInputBorder(
                  //   borderSide: BorderSide(
                  //     color : Colors.green,
                  //     width: 5,
                  //   ),
                  //   borderRadius: BorderRadius.only(topLeft: Radius.circular(10), topRight: Radius.circular(10)),
                  // ),
                  //
                  disabledBorder: OutlineInputBorder(
                    borderSide: BorderSide(
                      color : Colors.grey,
                      width: 5,
                    ),
                    borderRadius: BorderRadius.only(topLeft: Radius.circular(10), topRight: Radius.circular(10)),
                  ),
                  //
                  // focusedBorder: OutlineInputBorder(
                  //   borderSide: BorderSide(
                  //     color : Colors.blue,
                  //     width: 5,
                  //   ),
                  //   borderRadius: BorderRadius.only(topLeft: Radius.circular(10), topRight: Radius.circular(10)),
                  // ),

                  errorBorder: OutlineInputBorder(

                  )
                ),

              ),
              SizedBox(
                height: 10,
              ),
              TextField(
                decoration: InputDecoration(
                  border: OutlineInputBorder(// if we use enable/disable/focused border we can ignore normal order
                    borderSide: BorderSide(
                      color:Colors.red,
                      width: 5,
                    ),
                    borderRadius: BorderRadius.only(topLeft: Radius.circular(10), topRight: Radius.circular(10)),
                  ),
                ),
              ),
            ],
          ),
        ),
      ),
    );
  }

}


class MyForm extends StatefulWidget {
  @override
  _MyFormState createState() => _MyFormState();
}

class _MyFormState extends State<MyForm> {
  final _formKey = GlobalKey<FormState>();
  final TextEditingController _controller = TextEditingController();

  @override
  Widget build(BuildContext context) {
    return Form(
      key: _formKey,
      child: Column(
        children: [
          TextFormField(
            controller: _controller,
            onTapOutside: (event) {// close keyboard
              FocusScope.of(context).unfocus();
            },
            decoration: InputDecoration(
              labelText: "Enter Text",
              border: OutlineInputBorder(),
            ),
            validator: (value) {
              if (value == null || value.isEmpty) {
                return "Please enter some text";
              }
              return null;
            },
          ),
          SizedBox(height: 20),
          ElevatedButton(
            onPressed: () {
              if (_formKey.currentState!.validate()) {
                ScaffoldMessenger.of(context).showSnackBar(
                  SnackBar(content: Text("Submitted: ${_controller.text}")),
                );
              }
            },
            child: Text("Submit"),
          ),
        ],
      ),
    );
  }
}