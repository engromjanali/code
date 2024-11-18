public class student{
    String name;
    int id ;
    static String campus = "BBPI";//static variable.
    student(String n , int i ){
        name = n;
        id = i;

    }
    void desplay(){
        System.out.println("name : "+name);
        System.out.println("id : "+ id );
        System.out.println("campus : "+ campus);
    }
}