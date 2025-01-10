// int 
void main()
{

  String s = "Romajn";// there are no char datatype/class. only string.

  print(s);
  print(s.length);// length of string.
  print(s[3]);//char of string by index
  print(s.toUpperCase());
  print(s.toLowerCase());
  print(s.split("ro"));// split this string as word where has "ro"
  print(s.split(""));// split this string as every single char.
  print(s.contains("o"));// it's return bool value. r has in the string or not. memember it's character sencitive.
  print(s.replaceAll("Ro", "ko"));// it's return bool value. r has in the string or not.// return "Romjan"->"komjan"
  
  
}


