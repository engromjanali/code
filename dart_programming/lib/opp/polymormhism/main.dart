class Animal {
  void makeSound() {
    print('Animal makes a sound');
  }
}

class Cat extends Animal {
  @override
  void makeSound() {
    print('Meow');
  }
  void speed(){
    print("speed 10km/h");
  }
}

class Dog extends Animal {
  @override
  void makeSound() {
    print('bow');
  }
  void speed(){
    print("speed 30km/h");
  }
}

void main() {
  Animal animal = Animal();
  animal.makeSound(); // Output: Animal makes a sound

  Animal cat = Cat();
  cat.makeSound(); // Output: Meow
  Dog dog = Dog();// here we can't access speed function because we create object using parent class.
  dog.makeSound(); // Output: bow
  
  // to access exter function of child class we have to create object using child class.
  Cat cat1 = Cat();
  cat1.speed();
  

  List<Animal> animals = [Cat(), Dog()];
  animals[0].makeSound();
  animals[1].makeSound();
  
}
