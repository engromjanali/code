package secound_demo;
public class tryangle extends shape{
    double height , base;
    tryangle(double height, double base){
        this.base = base;
        this.height = height;
    }
    double area(){
        System.out.println("the area of tryangle : "+ 0.5 *base*height );
        return 0;
    }
}
