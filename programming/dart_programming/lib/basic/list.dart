void main()
{
  List li;
  li = List.empty();
  List l =[12,12,4,23,6,5,6];
  List<int> ll =[12,12,3];// with data type
  List<dynamic> lll =[12,12,4,"kjh",23,6,5,64,6,5645,4,2,5,1,3];// with dynamic type
  l.add(123333334); // insert in last.
  l.addAll(ll); // the "ll" hole lsit will be insert in last.
  l.insert(2, 1234); // the 1234 will be insert in 2nd position
  l.insertAll(2, ll); // the hole "ll" list insert in 2nd position

  print(l);
  l.replaceRange(0,3, [0,1,2]); //replace first-3-1 will be replace by the list. for exter element of list argument will be inserted and for less will be remove.
  print(l);

  l.length;
  // l.remove(12); // remove fast given value/element. i mean 12.
  // l.removeLast(); // remove fast element.
  // l.removeLast(12); // remove fast given value/element. i mean 12.
  // l.removeAt(12); // remove last 12
  // l.removeRange(2,6); // remove from (2nd index - before element of 6th index), 2,3,4,5 indexs.
  l.fillRange(5, 7,11);  // set 11 in from (2nd index - before element of 6th index), 5,6 indexs.
  print(lll);
  print(li.length);

  l.reversed; // return reverse list but main list won't reverse.
}