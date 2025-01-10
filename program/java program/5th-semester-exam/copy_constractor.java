//  Dart does not allow multiple constructors in the traditional
//  sense like some other languages (e.g., C++ or Java).
//  However, Dart provides named constructors,
//  which allow you to define multiple ways to create 
//  an object using different constructor names.

class student{
    int roll;
    public student(int roll){
        this.roll= roll;
    }
    student(student obj){
        roll= obj.roll;
    }
    void get_roll(){
        System.out.println("roll : " + roll);
    }
}

public class copy_constractor{
    public static void main(String[] args) {
        student obj1 = new student(677844);
        obj1.get_roll();
        student obj2 = new student(obj1);
        obj2.get_roll();
    }
}