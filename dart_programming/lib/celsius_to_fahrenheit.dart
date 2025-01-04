import 'dart:io';
void  main()
{
  stdout.write("Enter the number as celsius : ");
  double celsius = double.parse(stdin.readLineSync()!);
  double fahrenheit = celsius*(9/5) + 32;
  print((fahrenheit));
}