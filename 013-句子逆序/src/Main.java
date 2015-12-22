import java.util.Scanner;

/**
 * Author: 王俊超
 * Date: 2015/12/22 13:45
 * All Rights Reserved !!!
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNext()) {
            String input  = scanner.nextLine();
            System.out.println(reverseSentence(input));
        }

        scanner.close();
    }



    private static String reverseSentence(String str) {

        char[] chars = str.toCharArray();

        // 翻转整个句子
        reverse(chars, 0, chars.length - 1);

        for (int i = 0, j; i < chars.length;  i = j + 1) {
            // 找从i位置开始后的第一个非空白字符
            while (i < chars.length && chars[i] ==' ' ) {
                i++;
            }

            j = i + 1;
            // 找i位置之后的第一个空白字符
            while (j < chars.length && chars[j] != ' ') {
                j++;
            }
            reverse(chars, i, j - 1);
        }


        return new String(chars);
    }

    /**
     * 字符数组翻转
     * @param str
     * @param start
     * @param end
     */
    private static void reverse(char[] str, int start, int end) {
        char tmp;
        while (start < end) {
            tmp = str[start];
            str[start] = str[end];
            str[end] = tmp;

            start++;
            end--;
        }
    }
}
