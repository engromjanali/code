void main()
{
  // for loop
  for(int i =0; i<=10; i++)
  {
    print("Hello Romjan Ali : $i");
  }

  // while loop
  int i = 0;
  while(i!=10)
  {
    print(i);
    i+=1;
  }
  // for each
  List<int> l = [12,123,214,12];
  l.add(10);
  l.forEach((x)=> print(x)); // x is int element here.
  for(int i =0; i<l.length; i++)
  {
    print("hello ${l[i]}");
  }
  // for each loop as for in loop
  for(int x in l){
    print(x);
  }
}