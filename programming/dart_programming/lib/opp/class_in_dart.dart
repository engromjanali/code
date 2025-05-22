// Dart does not allow multiple constructors in the traditional 
// sense like some other languages (e.g., C++ or Java). However, Dart 
// provides named constructors, which allow you to define multiple 
// ways to create an object using different constructor names.
class Person {
  String? name;
  String? fatherName;
  String? Email;

  // Default constructor
  Person();

  // Named constructor
  Person.withoutFather(this.name , this.Email) {
    fatherName = "Unknown";
  }
  Person.copyConstructor(Person obj) {
    name = obj.name;
    fatherName = obj.fatherName;
  }
  void copyFrom(Person other) {
    this.name = other.name;
    this.fatherName = other.fatherName;
  }
  Person.set_data({this.name = "No Name", this.fatherName, required this.Email}); // if we white the paramiter of constructor in 2nd bracket, we can use required keyword, for this constractor we must have to pass value, and for unnecessary we can decleare default value,
  void display() {
    print("Name: $name");
    print("Father's Name: $fatherName\n");
  }
}

void main() {
  // Using the default constructor
  Person p1 = Person();
  p1.name = "romjan ali";
  p1.fatherName = "karim";
  
  // Using the named constructor
  Person p2 = Person.copyConstructor(p1);
  Person p3 = Person.withoutFather("kapil","xyz.@gmail.com");
  Person p4 = Person();
  p4.copyFrom(p1);
  p4.name = "sakib";

  Person px = Person.set_data(name: "romjan",Email:  "romjanali01673@gmail.com");
  px.display();

  p1.display();
  p2.display();
  p3.display();
  p4.display();
}
