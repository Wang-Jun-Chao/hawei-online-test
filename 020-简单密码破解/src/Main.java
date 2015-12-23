import java.util.Scanner;

/**
 * Author: 王俊超
 * Date: 2015-12-23 10:39
 * Declaration: All Rights Reserved !!!
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
//        Scanner scanner = new Scanner(Main.class.getClassLoader().getResourceAsStream("data.txt"));
        while (scanner.hasNext()) {
            String input = scanner.nextLine();
            System.out.println(encrypt(input));
        }

        scanner.close();
    }

    private static String encrypt(String input) {

        // 掩码表
        final char[][] mask = {
                {'2', '2', '2', '3', '3', '3', '4', '4', '4', '5', '5', '5', '6', '6', '6', '7', '7', '7', '7', '8', '8', '8', '9', '9', '9', '9'},
                {'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', 'a'}

        };

        char[] chars = input.toCharArray();

        for (int i = 0; i < chars.length; i++) {
            // 如果是小写字母，就要转变成数字符
            if (chars[i] >= 'a' && chars[i] <= 'z') {
                chars[i] = mask[0][chars[i] - 'a'];
            } else if (chars[i] >= 'A' && chars[i] <= 'Z') {
                chars[i] = mask[1][chars[i] - 'A'];
            }
        }


        return new String(chars);
    }
}
