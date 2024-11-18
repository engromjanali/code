//String
// Stringbuffer.
//StrinfBuilder


package basic_java;

public class string {
    public static void main(String[] args) {
        String s1 = "romjan";
        StringBuffer s2 = new StringBuffer(s1);
        s2.reverse();
        System.out.println(s2);

        //StringBuffer to string
        //toString method()

        String s3  = s2.reverse().toString();
        System.out.println(s3);
        
        //StringBuilder method : 
        StringBuilder str = new StringBuilder(s3);
        str.reverse();
        System.out.println(str);

        str.append(" ali");
        str.append( " age ");
        str.append(19);

        System.out.println(str);

        str.delete(0, 7);
        System.out.println(str);


        
    }
}



