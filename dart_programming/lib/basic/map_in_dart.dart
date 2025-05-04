import "dart:collection";
void main(List<String> args) {
  Map mp = Map();
  mp = {"name" :"romjan","age": 21};
  
  Map<String,int> mp1 = {"romjan" : 677844, "kapil": 677829, "siam": 677652};

  Map<String,String> mp2 = {"name" :"romjan","institute": "BBPI"};
  
  Map<String, dynamic> mp3 = {"name" :"romjan","age": 21};
  Map<int, dynamic> mp4 = {677844:"romjan",677829:"kapil"};
  mp3.remove("age");

  // access---
  mp["sayed"] = 788000;
  print(mp);
  print(mp4[677844]);
  print(mp1["677811"]);
  print(mp4.containsKey(677844)); // return bool value the key exist or not 
  print(mp4.containsValue("romjan ali")); // return bool value the value exist or not 

}


// update few method 
void main() {
  Map<String, int> scores = {
    'Alice': 90,
    'Bob': 85,
  };

  // Update Bob's score
  scores['Bob'] = 95;

  print(scores); // Output: {Alice: 90, Bob: 95}

  // 1. Using update() method:
  scores.update('Bob', (value) => value + 5); // Adds 5 to Bob's current score

  // 2. You can also provide a default value if the key doesn't exist:
  scores.update('Charlie', (value) => value + 10, ifAbsent: () => 70);

}
