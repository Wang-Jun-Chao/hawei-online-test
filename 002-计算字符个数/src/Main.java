import java.util.Scanner;

/**
 * Author: 王俊超
 * Date: 2015-12-18 11:00
 * Declaration: All Rights Reserved !!!
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        /**
         * 注意输入的是两行，第一次读取输入的字符串，第二行才是读取输入的字符，
         * 找第一行中出现的第二行的字符数的个数，不区分大小写
         */

        // 是否还有其它的行，一次可以测试多行
        while (scanner.hasNext()) {
            String input = scanner.next();
            String ch = scanner.next();
            System.out.println(countCharNumber(input, ch));
        }
        scanner.close();
    }

    private static int countCharNumber(String input, String chStr) {

        char ch = 0;
        for (int i = 0; i < chStr.length(); i++) {
            if (chStr.charAt(i) != ' ') {
                ch = chStr.charAt(i);
                break;
            }
        }


        ch = toUppercase(ch);
        int count = 0;
        for (int i = 0; i < input.length(); i++) {
            if (toUppercase(input.charAt(i)) == ch) {
                count++;
            }
        }

        return count;
    }

    /**
     * 将小写字母变成大写字母
     *
     * @param ch 输入的字母
     * @return 如果输入的是小写就变成大写，否则不变
     */
    private static char toUppercase(char ch) {
        if (ch >= 'a' && ch <= 'z') {
            return (char) ('A' + (ch - 'a'));
        }

        return ch;
    }
}
