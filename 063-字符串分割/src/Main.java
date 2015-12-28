import java.util.Arrays;
import java.util.Scanner;

/**
 * Author: 王俊超
 * Date: 2015-12-27 16:18
 * Declaration: All Rights Reserved !!!
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
//        Scanner scanner = new Scanner(Main.class.getClassLoader().getResourceAsStream("data.txt"));
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            String[] arr = new String[n];

            for (int i = 0; i < arr.length; i++) {
                arr[i] = scanner.next();
            }

            System.out.println(convert(arr));
        }

        scanner.close();
    }

    private static String convert(String[] arr) {

        StringBuilder builder = new StringBuilder(128);
        for (String s : arr) {
            int pos = 8;

            while (pos <= s.length()) {
                builder.append(s.substring(pos - 8, pos)).append('\n');
                pos += 8;
            }


            if (pos > s.length()) {
                builder.append(s.substring(pos - 8, s.length()));
            }

            for (int i = s.length(); i < pos; i++) {
                builder.append('0');
            }

            builder.append('\n');
        }
        return builder.substring(0, builder.length() - 1);
    }
}
