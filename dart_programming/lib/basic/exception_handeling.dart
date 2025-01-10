void main(){
  try{
    int? a;
    int? b;
    int c = a!*b!;
    print(c);
  }catch(e){
    print(e);
  }
}