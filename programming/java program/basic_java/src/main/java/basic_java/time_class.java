package basic_java;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class time_class {
    public static void main(String[] args) {

        LocalTime time =LocalTime.now();
        System.out.println(time);

        DateTimeFormatter formatters = DateTimeFormatter.ofPattern("hh:mm:ss");//for show melesecond( "hh:mm:ss.ss")
        String x = time.format(formatters);
        System.out.println("time = "+ x);
    }
}
