import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class string_to_date {

    public static void main(String[] args) {
        String dateString = "2024-04-17";

        // Create a DateTimeFormatter object with the desired format
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        // Parse the string into a LocalDate object
        LocalDate date = LocalDate.parse(dateString, dtf);

        // Print the LocalDate object
        System.out.println("Date: " + date);
    }
}
