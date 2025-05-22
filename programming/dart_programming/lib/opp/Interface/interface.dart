class Animal {
  void makeSound() {
    print('Animal makes a sound');
  }
}

class Dog implements Animal {
  @override
  void makeSound() {
    print('Dog barks');
  }
}

void main() {
  Dog dog = Dog();
  dog.makeSound(); // Output: Dog barks
}
