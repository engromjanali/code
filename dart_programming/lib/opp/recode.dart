void main(){
  print(arth(10, 5));
}

(int,int,int) arth(int a, int b){
  return (a+b, a-b,a*b);
}