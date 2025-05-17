import 'package:flutter/material.dart';
import 'package:meal_hisab/home.dart';
import 'package:meal_hisab/ui_helper/ui_helper.dart';

class AddRefund extends StatefulWidget {
  const AddRefund({super.key});

  @override
  State<AddRefund> createState() => _AddRefundState();
}

class _AddRefundState extends State<AddRefund> {
  final formKey = GlobalKey<FormState>();

  FocusNode focusDiscreption = FocusNode();
  FocusNode focusAmount = FocusNode();

  String discreption = ""; 
  String amount = ""; 


  @override
  Widget build(BuildContext context) {
    return Expanded(
      child: Container(
        color: Colors.red.shade50,
        child: Form(
          key: formKey,
          child: SingleChildScrollView(
            scrollDirection: Axis.vertical,
            child: Column(
              children: [
                Padding(
                  padding: const EdgeInsets.all(8.0),
                  child: TextFormField(
                    maxLines: 5,
                    textInputAction: TextInputAction.newline,
                    autofocus: true,
                    focusNode: focusDiscreption,
                    onFieldSubmitted: (value){
                      FocusScope.of(context).requestFocus(focusAmount);
                    },
                    validator: (value) {
                      if(value.toString().trim()==""){
                        return "";
                      }
                      return null;
                    },
                    onChanged: (value) {
                      amount = value.trim();
                    },
                    decoration: FromFieldDecoration(
                      hintText: "Write About The Diposite",
                      label: "Discreption",
                    )
                  ),
                ),
            
                Padding(
                  padding: const EdgeInsets.all(8.0),
                  child: TextFormField(
                    maxLines: 1,
                    textAlign: TextAlign.center,
                    textInputAction: TextInputAction.done,
                    keyboardType: TextInputType.number,
                    focusNode: focusAmount,
                    onFieldSubmitted: (value){
                      FocusScope.of(context).unfocus();
                    },
                    validator: (value) {
                      if(value.toString().trim()==""){
                        return "";
                      }
                      return null;
                    },
                    onChanged: (value) {
                      amount = value.trim();
                    },
                    decoration: FromFieldDecoration(
                      hintText: "How Much?",
                      label: "Amount",
                    )
                  ),
                ),
            
                SizedBox(
                  height: 50,
                ),
            
                getButton(
                  label: "Submit", 
                  ontap: (){
            
                  },
                ),
            
                
              ],
            ),
          ),
        ),
      ),
    );
  }
}