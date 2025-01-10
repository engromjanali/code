void main(){
  int x = 10;
  int y = 15;
  var opration = '+';
  switch(opration)
  {
    case '+':
      print(x=y);
      print("added");
      return;
    case '-':
      print(x-y);
      print("subtract");
      return;
    case '*':
      print(x*y);
      print("pultipli");
      return;
    default :
      print(y/x);
      print("divid");
  }
}