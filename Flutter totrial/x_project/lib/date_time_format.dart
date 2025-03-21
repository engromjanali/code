// it's our default code what we get in main file when we create a new project.
import 'package:flutter/material.dart';
import 'package:x_project/ui_helper/style_font.dart';
import 'package:intl/intl.dart';

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
  var datetime = DateTime.now();
  @override
  Widget build(BuildContext context) {
    return Scaffold(
        appBar: AppBar(
          title: Text("Deashboards"),
        ),
      body: Container(
        child: Center(
          child:SingleChildScrollView(
            scrollDirection:Axis.horizontal,
            child: SingleChildScrollView(
              scrollDirection: Axis.vertical,
              child: Padding(
                padding: const EdgeInsets.all(8.0),
                child: Column(
                  crossAxisAlignment: CrossAxisAlignment.start,
                  children: [
                    Text("${datetime.year}",style: style_font().text18(),),
                    Text("${datetime.month}",style: style_font().text18(),),
                    Text("${datetime.day}",style: style_font().text18(),),
                    Text("${datetime.weekday}",style: style_font().text18(),),
                    Text("${datetime.hour}",style: style_font().text18(),),
                    Text("${datetime.minute}",style: style_font().text18(),),
                    Text("${datetime.second}",style: style_font().text18(),),
                    Text("day(1-30) : ${DateFormat("d").format(datetime)}",style: style_font().text18(),),
                    Text("week day sort name: ${DateFormat("E").format(datetime)}",style: style_font().text18(),),
                    Text("week day full-name : ${DateFormat("EEEE").format(datetime)}",style: style_font().text18(),),
                    Text("month sort name: ${DateFormat("LLL").format(datetime)}",style: style_font().text18(),),
                    Text("month full name: ${DateFormat("LLLL").format(datetime)}",style: style_font().text18(),),
                    Text("month number: ${DateFormat("M").format(datetime)}",style: style_font().text18(),),
                    Text("month number/day number: ${DateFormat("Md").format(datetime)}",style: style_font().text18(),),
                    Text("week day sort name, month number/day number: ${DateFormat("MEd").format(datetime)}",style: style_font().text18(),),
                    Text("sort month name: ${DateFormat("MMM").format(datetime)}",style: style_font().text18(),),
                    Text("week_day_sort_name, month_sort_name day_number: ${DateFormat("MMMd").format(datetime)}",style: style_font().text18(),),
                    Text("month number: ${DateFormat("MMMEd").format(datetime)}",style: style_font().text18(),),
                    Text("month number: ${DateFormat("MMMM").format(datetime)}",style: style_font().text18(),),
                    Text("month/day: ${DateFormat("Md").format(datetime)}",style: style_font().text18(),),
                    Text("week_day_sort_name,month_number/day_number: ${DateFormat("MEd").format(datetime)}",style: style_font().text18(),),
                    Text("month_sort_name: ${DateFormat("MMM").format(datetime)}",style: style_font().text18(),),
                    Text("month_sort_name/day_number: ${DateFormat("MMMd").format(datetime)}",style: style_font().text18(),),
                    Text("full_name_month: ${DateFormat("MMMM").format(datetime)}",style: style_font().text18(),),
                    Text("hour:minute 24: ${DateFormat("Hm").format(datetime)}",style: style_font().text18(),),
                    Text("hour:minute:second 24: ${DateFormat("Hms").format(datetime)}",style: style_font().text18(),),
                    Text("hour AM/PM: ${DateFormat("j").format(datetime)}",style: style_font().text18(),),
                    Text("hour:minute AM/PM: ${DateFormat("jm").format(datetime)}",style: style_font().text18(),),
                    Text("hour:minute:second AM/PM: ${DateFormat("jms").format(datetime)}",style: style_font().text18(),),

                  ],
                ),
              ),
            ),
          )
        )
      ),
    );
  }
}
