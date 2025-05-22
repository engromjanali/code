public class substring {
    public static String removeWhiteSpace(String str) {
        // Remove leading whitespaces
        int start = 0;
        while (start < str.length() && Character.isWhitespace(str.charAt(start))) {
            start++;
        }

        // Remove trailing whitespaces
        int end = str.length() - 1;
        while (end >= 0 && Character.isWhitespace(str.charAt(end))) {
            end--;
        }

        // Return the substring without leading and trailing whitespaces
        return str.substring(start, end + 1);
    }

    public static void main(String[] args) {
        String input = "   Hello, World!   ";
        String result = removeWhiteSpace(input);
        System.out.println("Original string: \"" + input + "\"");
        System.out.println("String after removing leading and trailing whitespaces: \"" + result + "\"");
    }
}
