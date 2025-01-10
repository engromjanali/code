mixin Fly {
  void fly() {
    print('I can fly!');
  }
  int fun()
  {
    return 10;
  }
}
mixin Fly2 {
  void fly2() {
    print('I can fly2!');
  }
}

class Bird with Fly,Fly2 {
  int?y ;
  @override
  void fly() {
    print("I can fly! oberrided");
    print(fun());
    y = fun();
  }
}

void main() {
  Bird bird = Bird();
  bird.fly(); // I can fly! oberrided
  bird.fly2(); // Output: I can fly!
  print(bird.y);
}