/*
variable alowed charecter 
    1. A....Z
    2. a....Z
    3. under score ( _ ), dolar sign ( $ )

we can use 31 charecter as a variable name. but batter option use maximum 8 chareacter.  

charecter use by singlae codation ('a')

to take an variable we have write the data type for this variable
as such 
    1. int i = 50;  (rull 1)

    2. int i;     (rull 2 )
       i = 55;

## for folat number we have to mantion "f" in last of the line.
as such 
    float f = 79.99f;

 */
package basic_java;

public class variable_and_data_type {
    public static void main(String[] args){
        
        //boolean b;
        short s;
        int i;
        char c;
        double d;
        float f;
        
        boolean b = true;
      
        c = 'a';
        s = 32677;
        i = 36644;
        d = 50.55;
        f = 66.66f;
             
        
        System.out.println("b ="+ b);
        System.out.println("c = "+ c);
        System.out.println("s = "+ s);
        System.out.println("i = "+ i);
        System.out.println("d = "+ d);
        System.out.println("f = "+ f);
        
    }
}

