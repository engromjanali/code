// it's our default code what we get in main file when we create a new project.
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
  @override
  Widget build(BuildContext context) {
    return Scaffold(
        appBar: AppBar(
          title: Text("Deashboards"),

        ),
      body: Center(
        child: Column(
          mainAxisAlignment: MainAxisAlignment.center,
          children: [
            ElevatedButton(
              onPressed: () async{
                DateTime? date = await showDatePicker(
                  // fieldHintText: "mm/dd/YYYY",
                  fieldLabelText: "Enter Date (MM/DD/YYYY)", // defalut "Enter Date"
                  context: context,
                  initialDate: DateTime.now(),
                  firstDate : DateTime(2000,12,30,12,59,59),
                  lastDate: DateTime(2050),
                  initialDatePickerMode: DatePickerMode.day,
                  initialEntryMode:DatePickerEntryMode.calendar,
                  // helpText: "Set Date", // default "Select date"
                );
                if(date!=null){
                  print("date : $date");
                }
              }, child: Text("take date"),
            ),

            SizedBox(
              height: 10,
            ),

            ElevatedButton(
              onPressed: () async{
                TimeOfDay? time = await showTimePicker(
                  context: context,
                  initialTime: TimeOfDay(hour: 14, minute: 55,),
                  initialEntryMode: TimePickerEntryMode.dial,
                  helpText: "Set Time",
                );
                if(time!=null){
                  print("time : $time");
                }
              }, child: Text("time date"),
            ),
          ],
        ),
      ),
    );
  }

}

