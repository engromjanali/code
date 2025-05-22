public class variable {
    String name;
    int id ;
            /*
             * id and name id a instance variable.
             * a variable that's declared indide the class but outside any method that's called instance variable.
             * is not declared as static.
             */
    static  String university;
    /* 
    university is a static/class variable variable.
    avariable that's declared as static or class variable.
    it can't be dec;ared as local variable. 
     */

    variable(String n , int i){
            /* "n" and "i" is a local variable.
                a variable that's declared inside the method is called local variable.
                local variable is declared indide method, constractor or block.
            */ 

        name = n;
        id = i;
    }
    void Display(){
        System.out.println("name : "+name);
        System.out.println("id :" + id);
        System.out.println("university : "+ university);
    }

}