import "dart:collection";
void main(List<String> args) {
  Map mp = Map();
  mp = {"name" :"romjan","age": 21};
  
  Map<String,int> mp1 = {"romjan" : 677844, "kapil": 677829, "siam": 677652};

  Map<String,String> mp2 = {"name" :"romjan","institute": "BBPI"};
  
  Map<String, dynamic> mp3 = {"name" :"romjan","age": 21};

  // access---
  mp["sayed"] = 788000;
  print(mp);

}