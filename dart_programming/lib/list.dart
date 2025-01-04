void main()
{
  List l =[12,12,4,23,6,5,64,6,5645,4,2,5,1,3];
  l.add(123333334);
  l.length;
  // l.remove(12); // remove fast given value/element. i mean 12.
  // l.removeLast(); // remove fast element.
  // l.removeLast(12); // remove fast given value/element. i mean 12.
  // l.removeAt(12); // remove last 12
  // l.removeRange(2,6); // remove from (2nd index - before element of 6th index), 2,3,4,5 indexs.
  l.fillRange(5, 7,11);  // set 11 in from (2nd index - before element of 6th index), 5,6 indexs.
  print(l);
}