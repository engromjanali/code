// for eatch loop 

package basic_java;

public class for_eatch_loop {
    public static void main(String[] args) {
        int [] number ={10,20,30,40,50};
        String [] name = { "romjan ", "kupil", "jahid ", "sakib", "sayed"};
// number 1
        for( int x : number ){
            System.out.println(x);
        }
// number 2
        for ( String y : name){
            System.out.println(y);
        }
}
}

