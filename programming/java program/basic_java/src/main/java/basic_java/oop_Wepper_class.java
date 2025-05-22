package basic_java;

public class oop_Wepper_class {
    public static void main(String[] args) {
        

        ///primitve -> object : 

        int x= 5;
        Integer y = Integer.valueOf(x);
        System.out.println(y);

        Integer z = x;// Integer.valueof(x)  //autoboxing
        System.out.println(z);

        Double d = new Double (12.5);
        System.out.println(d);  

        /// object to primitive : 

        int  i = 100;
        String s = Integer.toString(i);
        System.out.println(s);

        double de= 100.89;
        String se = Double.toString(de);
        System.out.println(se);

        boolean boo = true;
        String sd = Boolean.toString(boo);
        System.out.println(sd);

        String st = "32";
        int ide = Integer.parseInt(st);
        System.out.println(ide);

        String std = "32.90";
        double ides = Double.parseDouble(st);
        System.out.println(ide);

        


    }
}
