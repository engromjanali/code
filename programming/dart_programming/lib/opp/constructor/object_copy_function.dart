import 'static_instance_provide.dart';

class Person {
  String? name;
  String? fatherName;
  String? Email;

  // Default constructor
  Person();

  void copyFrom(Person other) {
    this.name = other.name;
    this.fatherName = other.fatherName;
  }
  void display() {
    print("Name: $name");
    print("Father's Name: $fatherName\n");
  }
}

void main(){

  Person p1 = Person();
  p1.name = "romjan ali";
  p1.fatherName = "karim";

  Person p2 = Person();
  p2.copyFrom(p1);

  p1.display();
  p2.display();

  ServiceProvider s = ServiceProvider.getInstance();
  ServiceProvider s1 = ServiceProvider.instance;
  s.setUrl(url: "sdf");
  print(s.getUrl());
  print(s1.getUrl());
}

