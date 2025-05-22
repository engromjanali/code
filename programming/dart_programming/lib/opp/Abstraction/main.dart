abstract class Shape {
  void draw(); // Abstract method
  void as(){
    print("sdf");
  }
  int fun(){
    return 12;
  }
}
class Circle extends Shape {
  @override
  void draw() { // we must override abstract method.
    print('Drawing a circle');
  }
}

void main() {
  Circle circle = Circle();
  circle.draw(); // Output: Drawing a circle
  circle.as();
}
