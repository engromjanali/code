
import 'package:flutter/material.dart';

class HomeScreen extends StatefulWidget {
  const HomeScreen({super.key});

  @override
  State<HomeScreen> createState() => _HomeScreenState();
}

class _HomeScreenState extends State<HomeScreen> {


  @override
  void initState() {
    super.initState();
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        leading: IconButton(
         icon: const Icon(Icons.arrow_back, color: Colors.white,),
          onPressed: (){
            // show dialog if sure
            Navigator.pop(context);
          },
        ),
        backgroundColor: Colors.orange,
        title: Text("romjan developer!"),
        actions: [
          IconButton(
            onPressed: (){}, 
            icon: const Icon(Icons.start ,color: Colors.white,),
          ),
          
          IconButton(
            onPressed: (){}, 
            icon: const Icon(Icons.rotate_90_degrees_ccw ,color: Colors.white,),
          ),
          
        ],
      ),
      body: Center(

      ),
    );
  }
}
