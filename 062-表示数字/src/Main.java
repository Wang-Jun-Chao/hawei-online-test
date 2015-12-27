import java.util.Scanner;

/**
 * Author: 王俊超
 * Date: 2015-12-25 17:04
 * All Rights Reserved !!!
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
//        Scanner scanner = new Scanner(Main.class.getClassLoader().getResourceAsStream("data.txt"));
        while (scanner.hasNext()) {
            String input = scanner.nextLine();
            System.out.println(markNumber(input));
        }

        scanner.close();
    }

    private static String markNumber(String s) {


        boolean marked = false;

        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (!marked && c >= '0' && c <= '9') {
                builder.append('*');
                marked = true;
            } if (i > 0 && marked && (c< '0' || c > '9')) {
                builder.append('*');
                marked = false;
            }
            builder.append(c);
        }

        if (marked) {
            builder.append('*');
        }

        return builder.toString();
    }
}
