void main(){
  final name ;
  final String name1 ;
  final dynamic name2 ; // we can initiate when decleare either after any time for fast time.
  // final var name3 ; //Invalid
  name = "romjan";
  // name = "kapil"// invalid because we already assign a value.

  const k = "romajn";  // it's work like final but we must have to initial when decleared.
  // k = "kapil"; // Invalid
  final List l = [1, 3, 234 ]; // we can't reassign here.
  l.add(353);
  l[2] = 7979;
  print(l);
  //  l = [25345,3463];// invalid
  const ll = [1,2,3,4];
  ll.reversed;
  // ll.add(4324); // Invalid but we don't get compile time error, get runtime error.
  // ll = [435,34,34];// Invalid compole error
  print(ll);
}