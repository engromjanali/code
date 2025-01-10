import "dart:io";

// void main()async {
//   print("romjan");
//   await Future.delayed(Duration(seconds: 3));
//   print("ali");
// }

// --------------------------------------------------
Future<int> fun() async{ // for return, we have ot use Future<data_type>
  print("romjan");
  await Future.delayed(Duration(seconds: 1));
  print("ali");
  // return 677844; // fast way
  return Future.value(677844); // 2nd way
}
void main() {
  print("romjan");
  print("ali");
  fun().then((val){ // for receive value we have to follow this syntex 
    print(val);
  });
}
