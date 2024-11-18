package basic_java;

import java.util.ArrayList;
import java.util.Iterator;

public class array_list {
    public static void main(String[] args) {
        // ArrayList dclearation and creation.
        ArrayList<Integer>number = new ArrayList<>();
        // Array size print in initialization stage.
        System.out.println("size = "+ number.size());

        // thare are to method to add the element in the ArrayList.
        // 1. number.add(index,element)
        // 2. number.add(element)

        number.add(677844);
        number.add(677829);
        number.add(677828);
        number.add(3,677845);
        // fast way

        for(int x : number){
            System.out.println(x);
        }

        // 2nd way

        System.out.println("\n"+number);
        System.out.println("after initialize, size = "+number.size());

        // 3 rd way;
        Iterator it = number.iterator();
        while( it .hasNext()){
            System.out.println(it.next());
        }

        //removeing by  index and all ;
        number.remove(0);
        System.out.println(number.size());

        // the every element will be remove.
        number.removeAll(number);
        //another method
        number.clear();
        System.out.println(number.size());

        // array list check empty or not empty:
        boolean x = number.isEmpty();
        System.out.println("the number is empty : " + x);
        

    }
}

