import 'package:flutter/material.dart';
import 'package:get/get.dart';
import 'package:get/get_core/src/get_main.dart';
import 'package:momo/prsentation/screens/get_this_pack.dart';
import 'package:momo/core/widgets/image_card.dart';

class SeeAllPage extends StatefulWidget{
  const SeeAllPage({super.key});

  @override
  State<SeeAllPage> createState()=> _SeeAllPageState();
}

class _SeeAllPageState extends State<SeeAllPage>{
  @override
  void setState(VoidCallback fn) {
    // TODO: implement setState
    super.setState(fn);
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      backgroundColor: Colors.black,
      appBar: AppBar(
        foregroundColor: Colors.white,
        title: Text("Linkedin", style:  TextStyle(fontSize: 22, fontWeight: FontWeight.w600, color: Colors.white),),
        backgroundColor: Colors.black,
      ),
      body: Column(
        children: [
          Expanded(
            child: GridView.builder(
              itemCount: 6,
              gridDelegate: SliverGridDelegateWithFixedCrossAxisCount(
                crossAxisCount: 2,
                childAspectRatio: 1/1.3,
            
              ),
              itemBuilder: (context, index){
                return getImageCard();
              }
            ),
          )
        ],
      ),
    );

  }
}