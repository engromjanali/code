import 'dart:convert';

import 'package:http/http.dart' as http;
import 'package:http/http.dart';
import 'package:weather_application/core/model/weather_model.dart';
import 'package:weather_application/core/util/constats/constants.dart';
class HomeServices {


  Future<WModel> getWatherInfo({required String location})async{
    Response response =await http.get(Uri.parse("http://api.weatherapi.com/v1/current.json?key=${Constants.apiKey}&q=${location}&aqi=no"));
    if(response.statusCode == 200){
      return WModel.fromJson(Map<String,dynamic>.from(jsonDecode(response.body)));
    }
    else{
      throw "Somthing Want Wrong";
    }
  }



}