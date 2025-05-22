package basic_java;
public class two_decimal_number {
    public static void main(String[] args) {
        double number = 123.456789;

        // Format to two decimal places
        String formattedNumber = String.format("%.2f", number);

        System.out.println("Formatted number: " + formattedNumber);
    }
}