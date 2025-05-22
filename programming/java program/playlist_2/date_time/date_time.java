//package date_time;



import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class date_time {
    public static void main(String[] args) {

        LocalTime time =LocalTime.now();
        LocalDate date = LocalDate.now();
        System.out.println(time);

        DateTimeFormatter formatters = DateTimeFormatter.ofPattern("hh:mm:ss");//for show melesecond( "hh:mm:ss.ss")
        String x = time.format(formatters);
        DateTimeFormatter formatters1 = DateTimeFormatter.ofPattern("dd-MM-yyyy");//for show melesecond( "hh:mm:ss.ss")
        String y = date.format(formatters1);
        System.out.println("time = "+ x);
        System.out.println("date = "+ y);
    }
}