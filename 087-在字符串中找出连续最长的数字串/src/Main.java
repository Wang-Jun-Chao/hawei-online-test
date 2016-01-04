import java.util.Scanner;

/**
 * Author: 王俊超
 * Date: 2016-01-04 11:13
 * Declaration: All Rights Reserved !!!
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
//        Scanner scanner = new Scanner(Main.class.getClassLoader().getResourceAsStream("data.txt"));
        while (scanner.hasNext()) {
            String input = scanner.nextLine();
            System.out.println(maxNum(input));
        }

        scanner.close();
    }

    private static String maxNum(String s) {

        int max = 0;
//        int idx = 0;
        int cur = 0;
        String result = "";

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c >= '0' && c <= '9') {
                cur++;
                if (max < cur) {
                    max = cur;
//                    idx = i;
                    result = s.substring(i - max + 1, i + 1);
                } else if (max == cur) {
                    result += s.substring(i - max + 1, i + 1);
                }
            } else {
                cur = 0;
            }
        }

        return result + "," + max;
    }
}
