import 'package:flutter/material.dart';
import 'package:meal_hisab/home.dart';

class EditInfo extends StatefulWidget {
  const EditInfo({super.key});

  @override
  State<EditInfo> createState() => _EditInfoState();
}

class _EditInfoState extends State<EditInfo> {
  GlobalKey<FormState> FormKey = GlobalKey<FormState>();
  bool checked = false;
  String Fname="";
  String Phone="";
  String Email="";


  void updateInfo(){
    if(FormKey.currentState!.validate()){

    }
  }


  @override
  Widget build(BuildContext context) {
    return Scaffold(
      body: Container(
        // height: double.infinity,
        // width: double.infinity,
        child: Form(
          key: FormKey,
          child: Column(
            children: [
              SizedBox(
                height: 50,
              ),
              Row(
                children: [
                  Padding(
                    padding: const EdgeInsets.all(8.0),
                    child: Text("Do You Want To Edit?", style: TextStyle(fontSize: 25),),
                  ),
                  Checkbox(
                    value: checked, 
                    onChanged: (val){
                    setState(() {
                      checked = !checked;
                    });
                  }),
                ],
              ),
              
             Container(
                padding: EdgeInsets.symmetric(horizontal: 10),
                                  decoration: BoxDecoration(
                                    borderRadius: BorderRadius.circular(10),
                                    color: Colors.grey.shade300,
                                    border: Border(bottom: BorderSide(color: Colors.black))
                                  ),
                                  margin: EdgeInsets.all(10),
                                  child: TextFormField(
                                    enabled: checked,
                                    onChanged: (value){
                                      Fname = value.trim();
                                    },
                                    validator: (value) {
                                      if(Fname.length<4){
                                        return "Name should Contain at least 4 character";
                                      }
                                      return null;
                                    },
                                    keyboardType: TextInputType.text,
                                    textInputAction: TextInputAction.next,
                                    decoration: InputDecoration(
                                      label: Text("Full Name"),
                                      border: InputBorder.none,
                        
                                    ),
                                  ),
                                ),
                  
             Container(
                padding: EdgeInsets.symmetric(horizontal: 10),
                                  decoration: BoxDecoration(
                                    borderRadius: BorderRadius.circular(10),
                                    color: Colors.grey.shade300,
                                    border: Border(bottom: BorderSide(color: Colors.black))
                                  ),
                                  margin: EdgeInsets.all(10),
                                  child: TextFormField(
                                    enabled: checked,
                                    onChanged: (value){
                                      Email = value.trim();
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
                                      label: Text("Email"),
                                      border: InputBorder.none,
                        
                                    ),
                                  ),
                                ),
             Container(
                padding: EdgeInsets.symmetric(horizontal: 10),
                                  decoration: BoxDecoration(
                                    borderRadius: BorderRadius.circular(10),
                                    color: Colors.grey.shade300,
                                    border: Border(bottom: BorderSide(color: Colors.black))
                                  ),
                                  margin: EdgeInsets.all(10),
                                  child: TextFormField(
                                    
                                    enabled: checked,
                                    onChanged: (value){
                                      Phone = value.trim();
                                    },
                                    validator: (value) {
                                      // ^(?:\+88|88)? → allows optional country code +88 or 88.
                                      // 01[2-9] → valid operator codes (e.g., 013 to 019).
                                      // \d{8}$ → exactly 8 digits after the operator code (total 11 digits).
                                      final pattern = RegExp(r'^(?:\+88|88)?01[2-9]\d{8}$');
                                      if (value == null || value.isEmpty) {
                                        return 'Phone number is required';
                                      }
                                      if(!pattern.hasMatch(value.toString())){
                                        return "Enter Valid Phone Number";
                                      }
                                      return null;
                                    },
                                    keyboardType: TextInputType.number,
                                    textInputAction: TextInputAction.next,
                                    decoration: InputDecoration(
                                      label: Text("Phone"),
                                      border: InputBorder.none,
                                      hintText: "Enter Your Phone With Country Code"
                                    ),
                                  ),
                                ),
                                SizedBox(
                                  height: 40,
                                ),
                                getButton(label: "Update", ontap: (){
                                  updateInfo();
                                }),
            ],
          ),
        ),
      ),
    );
  }
}