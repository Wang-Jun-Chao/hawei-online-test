import java.util.Arrays;
import java.util.Scanner;

/**
 * Author: 王俊超
 * Date: 2015-12-25 16:04
 * All Rights Reserved !!!
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
//        Scanner scanner = new Scanner(Main.class.getClassLoader().getResourceAsStream("data.txt"));
        while (scanner.hasNext()) {
            String input = scanner.nextLine();
            System.out.println(ipCheck(input));
        }

        scanner.close();
    }

    private static String ipCheck(String s) {
        final String YES = "YES";
        final String NO = "NO";

        String[] ss = s.split("\\.");

        if (ss.length != 4) {
            return NO;
        }

        for (int i = 0; i < ss.length; i++) {
            try {
                int num = Integer.parseInt(ss[i]);
                if (num < 0 || num > 255) {
                    return NO;
                }
            } catch (Exception ex) {
                return NO;
            }
        }

        return YES;
    }
}
