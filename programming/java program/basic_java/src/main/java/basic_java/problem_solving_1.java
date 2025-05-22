package basic_java;
public class problem_solving_1{
    double height,width,depth;

    problem_solving_1(double h, double w,double d){
        height = h;
        depth = d;
        width = w;

    }

    void display(){
        double vol = height*width*depth;
        System.out.println(vol);


    }
    public static void main(String[] args) {
        
    
        problem_solving_1 box1 = new problem_solving_1(10,10,10);
        problem_solving_1 box2 = new problem_solving_1(54, 43, 545);
        problem_solving_1 box4 = new problem_solving_1(54, 43, 54);
        problem_solving_1 box3 = new problem_solving_1(4, 43, 45);
        problem_solving_1 box5 = new problem_solving_1(54, 3, 595);
        box1.display();
        box2.display();
        box4.display();
        box3.display();
        box5.display();
    }
}
