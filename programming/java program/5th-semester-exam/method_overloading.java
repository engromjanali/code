class romjan{
    int result(int mark){
        System.out.println("result : "+ mark);
        return 0;
    }
    float result(float mark){
        System.out.println("result : "+ mark);
    return 0.0f;
    }
    void result (String gread){
        System.out.println("result : "+ gread);
    }
}
public class method_overloading {
    public static void main(String[] args) {
     romjan r  = new romjan();
     r.result(677844);
     r.result(99.5f);
     r.result("A+");   
    }    
}
