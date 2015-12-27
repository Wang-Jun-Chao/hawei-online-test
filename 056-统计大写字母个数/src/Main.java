import java.util.Scanner;

/**
 * Author: 王俊超
 * Date: 2015-12-25 15:16
 * All Rights Reserved !!!
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
//        Scanner scanner = new Scanner(Main.class.getClassLoader().getResourceAsStream("data.txt"));
        while (scanner.hasNext()) {
            String input = scanner.nextLine();
            System.out.println(count(input));
        }

        scanner.close();
    }

    private static int count(String s) {
        int result = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c >= 'A' && c <= 'Z') {
                result++;
            }
        }

        return result;
    }
}
