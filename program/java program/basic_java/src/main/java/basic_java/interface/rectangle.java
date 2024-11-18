/*
    1. interface like a class 
        //how to create a interface 
        public interface A{

        }
    2. interface support multiple inharitance but class doesn't support multiple inharitance.
        class rectangle implements interface_1, interface_2{}
        class rectangle implements class_1, class_2{}  // compile time error // class doesn't support multiple inharitance.

    3. interface have method without body. but class have method with body.
        1. class use the method of interface and create body,
        2. class have to use all method which method have in interface.

        void display(int a); // method of intefa
        
        public void display(int d){  // class use it.
            System.out.println("dfl;sdjfl"+d);
        }

*/

import java.util.Scanner;

public class rectangle implements interface_1, interface_2{
        public void display(int d){
            System.out.println("dfl;sdjfl"+d);
        }
        public static void main(String[] args) {
            Scanner input = new Scanner(System.in);
            int i = input.nextInt();
            rectangle a = new rectangle();
            a.display(i);
        }
    }
