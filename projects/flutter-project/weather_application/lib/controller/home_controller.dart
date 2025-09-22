import 'package:flutter/material.dart';
import 'package:weather_application/core/model/weather_model.dart';
import 'package:weather_application/core/util/constats/constants.dart';
import 'package:weather_application/controller/home_services.dart';

class CHome extends ChangeNotifier {

  HomeState _state = HomeState.initial;
  
  List<String> _disabledDisticList = ["Brahmanbaria"];
  List<String> _disticsList = ["Cumilla", "Brahmanbaria", "Feni", "Dhaka", "Chattogram", "Habiganj"];
  List<String> _disabledCountryList = ["Brahmanbaria"];
  List<String> _countryList = ["Bangladesh", "India", "Nepal", "Us", "Canada", "Englend"];
  WModel? _wModel;  


  List<String> get disabledDisticList  =>_disabledDisticList;
  List<String> get disticsList         =>_disticsList;

  List<String> get disabledCountryList =>_disabledCountryList;
  List<String> get countryList         =>_countryList;

  HomeState get currentState => _state;

  void setCurrentState(HomeState state){
    _state = state;
    notifyListeners();
  }

  void setWModel(WModel wModel){
    _wModel = wModel;
    notifyListeners();
  }

  void getWatherData(String distic, String country)async{
    setCurrentState(HomeState.loading);
    try {
      HomeServices homeServices = HomeServices();
      WModel data =  await homeServices.getWatherInfo(location: "$distic, $country");
      setWModel(data);
      print(data.toJson());
      
    } catch (e) {
      debugPrint(e.toString());
      setCurrentState(HomeState.error);
    }
    setCurrentState(currentState==HomeState.loading?  HomeState.loaded : currentState);
  }
}