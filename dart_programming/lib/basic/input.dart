import "dart:io";
void main()
{
  print("enter your name : ");
  String? name = stdin.readLineSync();
  stdout.write("enter your age : ") ;
  double age = double.parse(stdin.readLineSync()!); // ! the sign was used for don't take null value. and it's syntex we have to use it.
  // var age = int.parse(stdin.readLineSync()!);//2nd way
  print("Enter your father's name : ");
  String? ftr_name = stdin.readLineSync();// ? the sign was used for don't take null value. and it's syntex we have to use it.
  print("welcome $name");
  print("age : $age");
  print("Father's name : $ftr_name");
  stdout.write("hello deal all friends how are you?");
  int i = age.toInt(); // double to int 
  double d = i.toDouble();
  print(i);
}