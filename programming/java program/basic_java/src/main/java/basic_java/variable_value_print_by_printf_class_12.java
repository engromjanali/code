/*
    printf  and format spacifair
    
    if we want to print variable value we can use "printf"  demo in under:

    %b  for boolian
    %c for charecter
    %d for short         # ponno sonkar jonno d
    %d for integer 
    %f for float        # %f for decimal value
    %f for double

    # %f   # for default 6 charecter 
    # %.3f # for 3 decimal value
    # %.2f # for 2 decimal value


 */
package basic_java;


public class variable_value_print_by_printf_class_12 {
    public static void main(String[] args){
        
        boolean b ;
        char c ;
        short s;
        int i ;
        float f;
        double d;
        b = true;
        c ='R';
        s = 9870;
        i = 9800;
        f = 78.88f;
        d = 86.99;
                
        
        System.out.printf("boolean b = %b", b); //%b mean b will be print in place of %b.
        System.out.printf("charecter c = %c",c);
        System.out.printf("sort b = %d", s);
        System.out.printf("integer i = %d", i);
        System.out.printf("float f = %f", f);
        System.out.printf("bouble d = %f",d);
        System.out.printf("bouble d = %.2f",d);
        
        
    }
    
}
