void main()
{
  int? roll;
  roll ??= 677844; // note we have write it without any space like that "??="
}

void issueBook(String member, String book, {DateTime? datetime}) {
  datetime ??= DateTime.now(); // Assign default value if datetime is null
  print('Book issued to on $datetime');
}