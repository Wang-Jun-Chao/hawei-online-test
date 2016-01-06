import java.util.Scanner;

/**
 * Author: 王俊超
 * Date: 2015/12/23 13:51
 * All Rights Reserved !!!
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
//        Scanner scanner = new Scanner(Main.class.getClassLoader().getResourceAsStream("data.txt"));
        while (scanner.hasNext()) {
            String input = scanner.nextLine();
            System.out.println(sort(input));
        }

        scanner.close();
    }

    private static String sort(String s) {

//        System.out.println(s);

        char[] chars = new char[s.length()];
        int len = 0;
        // 收集所有的字母
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (isLetter(c)) {
                chars[len] = c;
                len++;
            }
        }
//        System.out.println(new String (chars, 0, len));
        // 对收集到的字母进行排序，必须使用稳定性排序方法
        for (int i = 0; i < len; i++) {
            int idx = i;
            char tmp;
            for (int j = i + 1; j < len; j++) {
                if (compare(chars[idx], chars[j]) > 0) {
                    idx = j;
                }
            }


            tmp = chars[idx];

            // 将chars[i...(j-1)]的字符向后移动一个位置
            for (int j = idx - 1; j >= i ; j--) {
                chars[j + 1] = chars[j];
            }

            chars[i] = tmp;
        }


        // 向chars数组中填充未收集的字符，并且设置好位置
        // len指向chars数组中最后一个字母的位置
        len--;
        for (int i = s.length() -1; i >= 0; i--) {
            char c = s.charAt(i);
            // 如果i位置是字母就放置字母
            if (isLetter(c)) {
                chars[i] = chars[len];
                len--;
            }
            // 如果不是字母就放置原来的字符
            else {
                chars[i] = c;
            }
        }
        return new String(chars);
    }

    /**
     * 排序比较准则
     *
     * @param a 字母a
     * @param b 字母b
     * @return
     */
    private static int compare(char a, char b) {
        a = toLowerCase(a);
        b = toLowerCase(b);

        return a - b;

    }

    /**
     * 字母转成小写
     *
     * @param c
     * @return
     */
    private static char toLowerCase(char c) {
        if (c >= 'A' && c <= 'Z') {
            return (char) ('a' + c - 'A');
        }

        return c;
    }

    /**
     * 判断是否是字母
     * @param c
     * @return
     */
    private static boolean isLetter(char c) {
        return c >= 'A' && c <= 'Z' || c >= 'a' && c <= 'z';
    }
}
