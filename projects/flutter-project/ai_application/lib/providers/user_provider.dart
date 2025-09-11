
import 'dart:convert';

import 'package:flutter/material.dart';
import 'package:flutter/widgets.dart';
import 'package:http/http.dart' as http;
class UserProvider extends ChangeNotifier{
  List<Map<String, dynamic>> _userList =[];
  List<Map<String, dynamic>> get  getUserList => _userList;

  bool _isLoading = false;

  // get function ---------------------
  bool get isloading => _isLoading;

  // set function ------------------
  void setIsLoading(bool value){
    _isLoading = value;
    notifyListeners(); 
  }


  Future<void> getUserListFromServer()async{
    setIsLoading(true);
    final response = await http.get(Uri.parse("https://dummyjson.com/users"));
    try {
      
      if(response.statusCode ==200){
        _userList = (jsonDecode(response.body)["users"] as List<dynamic>)
        .map((x){
          return x as Map<String, dynamic>;
        }).toList();
      }
      else{
        debugPrint("data FAtch error: ${response.statusCode}");
      }

    } catch (e) {
      
    }finally{
      setIsLoading(false);
    }
  }

  Future<void> updateAUserData({
    required int id,
    required Map<String,dynamic> map, 
    required Function(String,) callback,
  })async{
    setIsLoading(true);
    try {
      final response =await http.put(
        Uri.parse("https://dummyjson.com/users/$id"),
        body: map
      );
      if(response.statusCode ==200){
        _userList[_userList.indexWhere((x)=>x["id"] == id)] = jsonDecode(response.body);
        debugPrint("updated");
        
        callback("Updation Successfully" ,);
      }
      else{
        callback("Failed");
      }
    } catch (e) {
      debugPrint("Updated error $e");
    }finally{
      setIsLoading(false);
    }
  }

  Future<void> deleteAUser({
    required BuildContext context,
    required int id,
    // required Function(String) responceMessage,
  })async{
    setIsLoading(true);
    try {
      final responese = await http.delete(Uri.parse("https://dummyjson.com/users/$id"));
      if(responese.statusCode == 200) {
          _userList.removeWhere((e) => e["id"] == id);
            debugPrint("removed");
            setIsLoading(false);
            ScaffoldMessenger.of(context).showSnackBar(SnackBar(content: Text("200")));
        // responceMessage("User Removed Successfully.");
      } else {
        // responceMessage("Failed.");
      }
    } catch (e) {
      debugPrint("Delete Error $e");
      setIsLoading(false);
    }
  }
}