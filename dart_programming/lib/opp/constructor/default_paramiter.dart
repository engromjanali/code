class Person {
  String? name;
  String? fatherName;
  String? Email;

  // Default constructor
  Person();

  // default paramiter --------------------------------------------------------------
  // here default "name" is "no Name" and "fatherName" is null.
  // if we can call the constructor without passing arguments.
  // but here for "Email" we used required keyword that's why we must pass "Email" argument.
  // call syntex : Person p = Person.set_data(name: "romjan", Email : "romjanali01673@gmail.com");
  Person.set_data({this.name = "No Name", this.fatherName, required this.Email}); 
  // Person.set_data(this.name, {this.fatherName, required this.Email}); // it's valid also ( necessary write first then unnecessary).
  void display() {
    print("Name: $name");
    print("Father's Name: $fatherName\n");
  }
}

void main() {
  // Using the default constructor
  Person p1 = Person();

  Person px = Person.set_data(name: "romjan",Email:  "romjanali01673@gmail.com");
  px.display();
  p1.display();
}
