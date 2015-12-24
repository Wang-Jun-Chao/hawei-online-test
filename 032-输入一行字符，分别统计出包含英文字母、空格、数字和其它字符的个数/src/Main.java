import java.util.Scanner;

/**
 * Author: 王俊超
 * Date: 2015-12-24 14:42
 * All Rights Reserved !!!
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
//        Scanner scanner = new Scanner(Main.class.getClassLoader().getResourceAsStream("data.txt"));
        while (scanner.hasNext()) {
            String input = scanner.nextLine();
            System.out.print(count(input));
        }

        scanner.close();
    }

    private static String count(String s) {
        int[] result = new int[4];

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c >= 'a' && c <= 'z' || c >= 'A' && c <= 'Z') {
                result[0]++;
            } else if (c == ' ') {
                result[1]++;
            } else if (c >= '0' && c <= '9') {
                result[2]++;
            } else {
                result[3]++;
            }
        }

        StringBuilder builder = new StringBuilder();
        for (int i : result) {
            builder.append(i).append('\n');
        }

        return builder.toString();
    }
}
