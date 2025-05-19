import 'package:animate_do/animate_do.dart';
import 'package:flutter/material.dart';
import 'package:meal_hisab/helper/ui_helper.dart';

class MessCreate extends StatefulWidget {
  const MessCreate({super.key});

  @override
  State<MessCreate> createState() => _MessCreateState();
}

class _MessCreateState extends State<MessCreate> {
  
  @override
  void initState() {
    // TODO: implement initState
    super.initState();
    // WidgetsBinding it is a class of randering,frame,layout ETC
    // instance create a instance of the class
    // addPostFrameCallback, the function will be called after fully building the screen.
    // (_) here will be given a duration but we dont't need the duration that's why we are ignoring using  underscore.
    WidgetsBinding.instance.addPostFrameCallback((_){
      // showMessageDialog(
      //   context: context, 
      //   title: "Note:", 
      //   Discreption: "To Create your own mess, \nyou have to leave from previous mess. \nif you was joined yet.",
      // );
    });
  }
  
  @override
  Widget build(BuildContext context) {
    return Expanded(
      child: Padding(
        padding: const EdgeInsets.all(4.0),
        child: Column(
          spacing: 10,
          children: [
            const Text("Welcome \nYou are going to create your own mess", textAlign: TextAlign.center,),
            
            FadeInUp(
              duration: Duration(milliseconds: 100),
              child: Container(
                padding: EdgeInsets.all(10),
                decoration: BoxDecoration(
                  border: Border(bottom: BorderSide(color: Colors.grey)),
                  color: Colors.amber,
                  borderRadius: BorderRadius.circular(10)
                ),
                child: TextFormField(
                onChanged: (value){
                  // email = value.trim();
                },
                validator: (value) {
                  if (value == null || value.isEmpty) {
                    return 'Email is required';
                  }
                  final pattern = RegExp(r'^[\w-\.]+@([\w-]+\.)+[\w-]{2,4}$');
                  if (!pattern.hasMatch(value)) {
                    return 'Enter a valid email';
                  }
                  return null;
                },
                keyboardType: TextInputType.text,
                textInputAction: TextInputAction.next,
                decoration: InputDecoration(
                  label: Text("Mess Name"),
                  border: InputBorder.none,
                                
                ),
              ),
              ),
            ),
        
            FadeInUp(
              duration: Duration(milliseconds: 300),
              child: Container(
                padding: EdgeInsets.all(10),
                decoration: BoxDecoration(
                  border: Border(bottom: BorderSide(color: Colors.grey)),
                  color: Colors.amber,
                  borderRadius: BorderRadius.circular(10)
                ),
                child: TextFormField(
                onChanged: (value){
                  // email = value.trim();
                },
                validator: (value) {
                  if (value == null || value.isEmpty) {
                    return 'Email is required';
                  }
                  final pattern = RegExp(r'^[\w-\.]+@([\w-]+\.)+[\w-]{2,4}$');
                  if (!pattern.hasMatch(value)) {
                    return 'Enter a valid email';
                  }
                  return null;
                },
                keyboardType: TextInputType.text,
                textInputAction: TextInputAction.next,
                decoration: InputDecoration(
                  label: Text("Mess Address"),
                  border: InputBorder.none,
                                
                ),
              ),
              ),
            ),
        
            FadeInUp(
              duration: Duration(milliseconds: 600),
              child: Container(
                padding: EdgeInsets.all(10),
                decoration: BoxDecoration(
                  border: Border(bottom: BorderSide(color: Colors.grey)),
                  color: Colors.amber,
                  borderRadius: BorderRadius.circular(10)
                ),
                child: TextFormField(
                onChanged: (value){
                  // email = value.trim();
                },
                validator: (value) {
                  if (value == null || value.isEmpty) {
                    return 'Owner name required';
                  }
                  final pattern = RegExp(r'^[\w-\.]+@([\w-]+\.)+[\w-]{2,4}$');
                  if (!pattern.hasMatch(value)) {
                    return 'Enter a valid email';
                  }
                  return null;
                },
                keyboardType: TextInputType.text,
                textInputAction: TextInputAction.next,
                decoration: InputDecoration(
                  label: Text("Mess Owner Name"),
                  border: InputBorder.none,
                                
                ),
              ),
              ),
            ),
        
            FadeInUp(
              duration: Duration(milliseconds: 900),
              child: Container(
                padding: EdgeInsets.all(10),
                decoration: BoxDecoration(
                  border: Border(bottom: BorderSide(color: Colors.grey)),
                  color: Colors.amber,
                  borderRadius: BorderRadius.circular(10)
                ),
                child: TextFormField(
                onChanged: (value){
                  // email = value.trim();
                },
                validator: (value) {
                  if (value == null || value.isEmpty) {
                    return 'Email is required';
                  }
                  final pattern = RegExp(r'^[\w-\.]+@([\w-]+\.)+[\w-]{2,4}$');
                  if (!pattern.hasMatch(value)) {
                    return 'Enter a valid email';
                  }
                  return null;
                },
                keyboardType: TextInputType.text,
                textInputAction: TextInputAction.next,
                decoration: InputDecoration(
                  label: Text("Mess Owner Id"),
                  border: InputBorder.none,
                                
                ),
              ),
              ),
            ),
        
            FadeInUp(
              duration: Duration(milliseconds: 1200),
              child: Container(
                padding: EdgeInsets.all(10),
                decoration: BoxDecoration(
                  border: Border(bottom: BorderSide(color: Colors.grey)),
                  color: Colors.amber,
                  borderRadius: BorderRadius.circular(10)
                ),
                child: TextFormField(
                onChanged: (value){
                  // email = value.trim();
                },
                validator: (value) {
                  if (value == null || value.isEmpty) {
                    return 'Email is required';
                  }
                  final pattern = RegExp(r'^[\w-\.]+@([\w-]+\.)+[\w-]{2,4}$');
                  if (!pattern.hasMatch(value)) {
                    return 'Enter a valid email';
                  }
                  return null;
                },
                keyboardType: TextInputType.text,
                textInputAction: TextInputAction.next,
                decoration: InputDecoration(
                  label: Text("Autrority Phone"),
                  border: InputBorder.none,
                                
                ),
              ),
              ),
            ),

            FadeInUp(
              duration: Duration(milliseconds: 1500),
              child: Container(
                padding: EdgeInsets.all(10),
                decoration: BoxDecoration(
                  border: Border(bottom: BorderSide(color: Colors.grey)),
                  color: Colors.amber,
                  borderRadius: BorderRadius.circular(10)
                ),
                child: TextFormField(
                onChanged: (value){
                  // email = value.trim();
                },
                validator: (value) {
                  if (value == null || value.isEmpty) {
                    return 'Email is required';
                  }
                  final pattern = RegExp(r'^[\w-\.]+@([\w-]+\.)+[\w-]{2,4}$');
                  if (!pattern.hasMatch(value)) {
                    return 'Enter a valid email';
                  }
                  return null;
                },
                keyboardType: TextInputType.text,
                textInputAction: TextInputAction.next,
                decoration: InputDecoration(
                  label: Text("Autrority Email"),
                  border: InputBorder.none,
                                
                ),
              ),
              ),
            ),

            getMaterialButton(
              label: "Create", 
              ontap:(){
            
              }
            )
        
          ],
        ),
      ),  
    );
  }
}