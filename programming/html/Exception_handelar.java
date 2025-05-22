public class Exception_handelar{
    public static void main(String[] args) {
        try{
            int [] arr = new int[3];
            arr[4]= 20;
            System.out.println(arr);

        }catch(ArithmeticException e){ // Arithmetic is sub class. if any how the exception miss the exception it will passed to main class".
                System.out.println(e.getMessage());
            }

        catch(Exception en){  //exception is main class for error handeling. 
                System.out.println(en);
                }

        finally{  // if the system occer an Exception even then the system will print the final block/div.
        System.out.println("program successed");
        }
        System.out.println("success");
}
}
