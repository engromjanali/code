class Person {
  String? name;
  String? fatherName;
  String? Email;

  // Default constructor
  Person();

  Person.copyConstructor(Person obj) {
    name = obj.name;
    fatherName = obj.fatherName;
  }
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

  Person p2 = Person.copyConstructor(p1);

  p1.display();
  p2.display();
}
