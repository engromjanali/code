// vallu of five box of area 

public class student{
    String name , gender ,fathers_name , home_town;
    int age , phone , roll;


    void setinfo(String n,int r, String h){
        name = n;
        roll = r;
        home_town = h;
    }


    void desplay(){
        System.out.println("name : "+name);
        System.out.println("father name: " + fathers_name);
        System.out.println("gender : "+ gender);
        System.out.println("age : "+ age);
        System.out.println("roll : "+ roll);
        System.out.println("home town : " + home_town);
        System.out.println("contact number : +880"+ phone);
        System.out.println();
    
    }
}