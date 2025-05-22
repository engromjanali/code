public class method_overloading{

    void add (int a ,int b){
        System.out.println(a*b);
    }
    void add (double a , double b){
        System.out.println(a*b);
    }
    void add (double a , double b, double c ){
        double result = (a*b*c);

        System.out.println(result);
    }
    public static void main(String[] args) {
        method_overloading obb = new method_overloading();
        obb.add(87,45);
        obb.add(546.6,56);
        obb .add(54, 65456536.76, 536);

    }

}