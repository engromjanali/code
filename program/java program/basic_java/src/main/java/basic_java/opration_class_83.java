package basic_java;
import java.util.ArrayList;
import java.util.Scanner;

public class opration_class_83 {
    

    public static void main(String[] args) {
        Scanner input= new Scanner(System.in);
        // ArrayList dclearation and creation.
        ArrayList<Integer>number = new ArrayList<>();
        ArrayList<Integer>number1 = new ArrayList<>();
       

        // Array size print in initialization stage.
        System.out.println("size = "+ number.size());

        // thare are to method to add the element in the ArrayList.
        // 1. number.add(index,element)
        // 2. number.add(element)

        number.add(677844);
        number.add(677829);
        number.add(677828);
        number.add(3,677845);
       


        // array list check empty or not empty:
        boolean x = number.isEmpty();
        System.out.println("the number is empty : " + x);

        //find element
        boolean y = number.contains(677844);
        System.out.println(y);

        //find index
        int z =number.indexOf(677845); 
        System.out.println(z);

        //lastIndexof() method  # from an multypole same element find last element.
        z = number.lastIndexOf(677829);
        System.out.println(z);


        //replase a element from AraryList
        number.set(1,22);
        System.out.println(number);

        //get method : to print the spacific elementby index number.
        int g = number.get(0);
        System.out.println(g);
        System.out.println(number.get(1)); 

        // addAll method
        number1.addAll(number);
        System.out.println(number1);

        // equals method:
        boolean result = number.equals(number1);
        System.out.println(result);

        // equals but case_cencitive ignore korba.

        /*
        result = number.equalsIgnoreCase(number1);
        System.out.println(result);
        */

        //contains() method:  # mean : b  in a 
        String a ="ro";
        String b ="rom";
        boolean contains_method = a.contains(b);
        System.out.println(contains_method);

        //concat method()
        String fast_name , last_name,full_name;
        fast_name = "md romjan";
        last_name = " ali";
        
        full_name = fast_name.concat(last_name); // like, full_name = fast_name + last_name;
        System.out.println(full_name);

        //toUpperCase()
        String upper = full_name.toUpperCase();
        System.out.println(upper);
        
        //toLowerCase()
        String lower = full_name.toLowerCase();
        System.out.println(lower);

        //startWith method:  // are fast name started by "ro" 
        boolean chack = fast_name.startsWith("ro");
        System.out.println(chack);

        //endWith method:  //are last name end by  "li"
        chack = last_name.endsWith("li");
        System.out.println(chack);

        // charAt method  # return the charecter of index.
        String country = "my country is bangldesh!";
        char ch = country.charAt(5);
        System.out.println(ch);

        //trim method:# fast and last spaces will be removed of a string.
        String asd = "   lkjdlf dlkfdlk     ldjflsd   ";
        String as = asd.trim();
        System.out.println(as);


        //codepointAt:  # provide us a asceo value:
        String asg="abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        int m = asg.length();
        for(int fm = 0;fm<m;fm++ ){
            char mnb =asg.charAt(fm);
            System.out.print(mnb);
            System.out.println(" = "+ asg.codePointAt(fm));
        }
        int xx = asg.codePointAt(0);
        System.out.println(xx);
        
        // replace('i','j') method
        String gg = "j-am-romjan-ali!";
        String ggg=gg.replace('j','i');//gg won't change that's why we have to use a variable
        System.out.println(ggg);

        //split() method
        String []s3 = gg.split("-");// we can split by ("_")("-")(" ")('c')
        for ( String asp : s3){
            System.out.println(asp);
        }
        //StringBuffer   # stringBuffer is most fexiable method.
        String r = "md romjan ali ";
        StringBuffer asif = new StringBuffer(r);
        asif.append("i am a student. my age is ");
        
        asif.append(19);
        System.out.println(asif);

        asif.delete(9,14);
        System.out.println(asif);

        //asif.reverse();
        //System.out.println(asif);

        asif.setLength(9);//we can set the length
        System.out.println(asif);


        

    }
}
