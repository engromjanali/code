import 'Persons.dart';

void main(){
  Person p = Person("romjan", 677844);
  p.setName = "rom"; 
  p.setAge = 67; // access by seter
  print("${p.name} ${p.roll}"); // access by geter
}