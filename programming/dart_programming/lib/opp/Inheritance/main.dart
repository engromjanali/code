import 'Person.dart';

class child extends Person {
  int? age = 20;
  
  // access element() of parent class by "super" keyword.
  // method "overwrite" mean display has in both class.
  void display1(){
    super.name = "romjan";
    super.display();
    print("Age : $age");
  }
  
  // child(int roll , this.age ) : super(roll); // if we create constryctor in parent class we have to write like that.
}
void main(){
  // child ch = child(67547, 30);
  child ch = child();
  ch.display();
  ch.display1();
}