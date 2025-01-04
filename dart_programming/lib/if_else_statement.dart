void main()
{
  int a = 10;
  int b = 20;
  
  bool res;
  res = a==10 && b==20 ; // and
  print(res);
  res = a==10 || b==20; // or
  print(res);
  res = !(a==10); //not
  print(res);
  if(b==a)
  {
    print ("A are equals to B");
  }
  else if(a<b)
  {
    print("A is less then B");
  }
  else{
    print("B is less then A");
  }

}
