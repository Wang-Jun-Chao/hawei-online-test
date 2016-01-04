import java.util.Scanner;

/**
 * Author: 王俊超
 * Date: 2016-01-04 09:13
 * Declaration: All Rights Reserved !!!
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
//        Scanner scanner = new Scanner(Main.class.getClassLoader().getResourceAsStream("data.txt"));
        while (scanner.hasNext()) {
            String reg = scanner.nextLine();
            String str = scanner.nextLine();

            System.out.println(match(reg, str));
        }

        scanner.close();
    }

    private static boolean match(String reg, String str) {
        return match(reg, 0, str, 0);
    }

    private static boolean match(String reg, int i, String str, int j) {

        // 正则式已经到达末尾了
        if (i >= reg.length()) {
            return j >= str.length();
        }

        // 匹配串已经到达末尾了
        if (j >= str.length()) {
            return i >= str.length();
        }

        // 两个都没有到末尾
        boolean result = false;
        switch (reg.charAt(i)) {
            case '*':
                // 匹配一个字符
                result = match(reg, i, str, j + 1);
                if (result) {
                    return true;
                }
                // 不匹配字符
                result = match(reg, i + 1, str, j);

                if (result) {
                    return true;
                }

                // 只匹配一个字符
                result = match(reg, i + 1, str, j + 1);

                break;
            case '?':
                result = match(reg, i + 1, str, j + 1);
                break;
            default:
                if (reg.charAt(i) == str.charAt(j)) {
                    result = match(reg, i + 1, str, j + 1);
                }
        }


        return result;
    }
}
