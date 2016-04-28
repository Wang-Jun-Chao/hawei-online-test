import java.util.Scanner;

/**
 * Author: 王俊超
 * Date: 2016-01-06 14:48
 * All Rights Reserved !!!
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
//        Scanner scanner = new Scanner(Main.class.getClassLoader().getResourceAsStream("data.txt"));
        while (scanner.hasNext()) {
            String input = scanner.next();
            int n = scanner.nextInt();
            System.out.println(getStringByBytes(input, n));
        }

        scanner.close();
    }

    private static String getStringByBytes(String s, int n) {
        StringBuilder builder = new StringBuilder();

        for (int i = 0, sum = 0; i < s.length(); i++) {
            if (String.valueOf(s.charAt(i)).getBytes().length == 1) {
                sum += 1;
                builder.append(s.charAt(i));

                if (sum >= n) {
                    break;
                }
            } else {
                sum += 2;
                if (sum >= n) {
                    break;
                }
                builder.append(s.charAt(i));
            }
        }

        return builder.toString();
    }
}
