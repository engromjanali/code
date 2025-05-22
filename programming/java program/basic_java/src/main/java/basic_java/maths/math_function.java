package basic_java.maths;
public class math_function{
    public static void main (String [] args){
        double i = Math.abs(90.99);//abs mean the methos always provide a positive value.
        double s = Math.sqrt(35);
        double g = Math.pow(s, 8);
        double pi =Math.PI;
        double log = Math .log(1);
        double exp = Math .exp(1);
        double max= Math.max(90,99);
        double min = Math.min(90,546);
        double ceil = Math.ceil(89.90);//90 upper integer value of grapchart// but if we input integer value that's return same value.
        double floor = Math.floor(89.98);//89 lower integer value of grapchart// but if we input integer value that's return same value.


        System.out.println(i);
        System.out.println(s);
        System.out.println(g);
        System.out.println(pi);
        System.out.println(log);
        System.out.println(exp);
        System.out.println(max);
        System.out.println(min);
        System.out.println(ceil);
        System.out.println(floor);
        


        
    }
}
