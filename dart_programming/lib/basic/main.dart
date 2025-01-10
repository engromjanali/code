void  main(){
  Person p = Person();
  p.name = "romjan ali";
  p.father_name = "karim";

  p.display();
}
class Person{
  String? name="";
  String? father_name=""; 
  
  void display(){
    print("$name");
    print("$father_name\n");
  }
}