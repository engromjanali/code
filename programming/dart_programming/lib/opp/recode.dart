void main(){
  var res = arth(10, 10);
  print(res.$1);
  print(res.$2);
  print(res.$3);
}

(int,int,int) arth(int a, int b){
  return (a+b, a-b,a*b);
}