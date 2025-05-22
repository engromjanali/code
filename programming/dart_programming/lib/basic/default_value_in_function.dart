// requerid paramiter we have to write in before optional paramiter.
void main()
{
  fun("romjan");
  fun("romjan", LastName : "ali");
}
void fun(String FirstName, {String LastName = "", int age=123}){
  print(FirstName+ " "+ LastName);
}