import java.util.Scanner;

/**
 * Author: 王俊超
 * Date: 2015/12/23 13:51
 * All Rights Reserved !!!
 */
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String str = scanner.nextLine();

            // 剔除输入串中的非英文字母字符
            // 同时按输入的顺序和字母顺序串成一个字符串
            StringBuilder builder = new StringBuilder();
            for (int i = 0; i < 26; i++) {
                for (int j = 0; j < str.length(); j++) {
                    if (str.charAt(j) == (i + 'a') || str.charAt(j) == (i + 'A')) {
                        builder.append(str.charAt(j));
                    }
                }
            }
            StringBuilder result = new StringBuilder();
            int k = 0;
            for (int i = 0; i < str.length(); i++) {
                if (!isLetter(str.charAt(i))) {
                    result.append(str.charAt(i));
                } else {
                    result.append(builder.charAt(k));
                    k++;
                }
            }

            System.out.println(result);
        }

        scanner.close();
    }

    private static boolean isLetter(char c) {
        return c >= 'a' && c <= 'z' || c >= 'A' && c <= 'Z';
    }
}
