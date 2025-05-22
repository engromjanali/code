package basic_java;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class date_class {
    public static void main(String[] args) {
        Date date = new Date ();
        //System.out.println(date);
        DateFormat datefor = new SimpleDateFormat("dd/MM/yyyy");//"dd/MM/yyyy" MM must be uppercase. 
        String d_date = datefor.format(date);
        System.out.println(d_date);
    }
}
