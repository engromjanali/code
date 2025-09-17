

import 'package:flutter/material.dart';

class CHome extends ChangeNotifier {

  int _currentPage = 0;

  void notify(){
    notifyListeners();
  }

  // get 
  int get getCurrentPageNo =>_currentPage;

  // set 
  void setCurrentPage(int val){
    _currentPage = val;
    notify();
  }
}
