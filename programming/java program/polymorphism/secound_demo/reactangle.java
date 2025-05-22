package secound_demo;
public class reactangle extends shape{
    double width, height;
    reactangle(double width,double height){
        this.height = height;
        this.width = width;
    }
    double area (){
        System.out.print("the are of reactangle : "+ height*width);
        return 0;
    }
}
