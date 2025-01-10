class Person{
  String? _Name; // privete variable. Encapsulation
  int? _roll; 
  Person(this._Name,this._roll);
  
  // access element by greater and seter 
  String? get name => _Name;
  int? get roll => _roll;

  set setName(String? name){
    _Name = name;
  }
  set setAge(int? roll){
    _roll = roll;
  }
}