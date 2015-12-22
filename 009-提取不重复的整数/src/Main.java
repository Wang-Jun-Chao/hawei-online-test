import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Scanner;

/**
 * Author: 王俊超
 * Date: 2015/12/21 16:56
 * All Rights Reserved !!!
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNext()) {
            int input = scanner.nextInt();
            System.out.println(extractNumber(input + ""));
        }

        scanner.close();
    }

    private static String extractNumber(String numStr) {
        StringBuilder builder = new StringBuilder();

        HashSet<Character> set = new LinkedHashSet<>();
        for (int i = numStr.length() - 1; i >= 0; i--) {
            set.add(numStr.charAt(i));
        }

        for (Character c : set) {
            builder.append(c);
        }

        // 如果第一个字符是0
        if (builder.charAt(0) == '0') {
            return builder.substring(1, builder.length());
        }

        return builder.toString();
    }
}
