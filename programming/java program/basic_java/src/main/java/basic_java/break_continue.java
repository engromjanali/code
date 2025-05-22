package basic_java;

public class break_continue {
    public static void main(String [] args){
        
        int i ;
        for ( i = 1 ; i <=100; i =i +3){
            if ( i == 10){
                continue;
            }
            else if  ( i >14 ){
                break;
            }
            System.out.println(i);
            
        }
    }
}
