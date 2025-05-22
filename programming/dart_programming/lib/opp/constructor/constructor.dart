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

  // named constructor
  Person.copyConstructor(Person obj) {
    name = obj.name;
    fatherName = obj.fatherName;
  }

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

  p1.display();
  p2.display();

}
