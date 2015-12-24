import java.util.Scanner;

/**
 * Author: 王俊超
 * Date: 2015-12-23 16:58
 * All Rights Reserved !!!
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
//        Scanner scanner = new Scanner(Main.class.getClassLoader().getResourceAsStream("data.txt"));
        while (scanner.hasNext()) {
            String s1 = scanner.nextLine();
            String s2 = scanner.nextLine();
            System.out.println(mergeStr(s1, s2));
        }

        scanner.close();
    }

    private static String mergeStr(String m, String n) {
        char[] chars = new char[m.length() + n.length()];

        // 拷贝字符串
        for (int i = 0; i < m.length(); i++) {
            chars[i] = m.charAt(i);
        }
        for (int i = 0; i < n.length(); i++) {
            chars[i + m.length()] = n.charAt(i);
        }

        // 对奇数位下标和偶数位下标进行排序
        sort(chars, 0);
        sort(chars, 1);
        for (int i = 0; i < chars.length; i++) {
            chars[i] = convert(chars[i]);
        }
        return new String(chars);
    }

    private static void sort(char[] chars, int beg) {
        for (int i = beg; i < chars.length; i += 2) {
            int idx = i;
            char tmp;
            for (int j = i + 2; j < chars.length; j += 2) {
                if (chars[idx] > chars[j]) {
                    idx = j;
                }
            }

            tmp = chars[i];
            chars[i] = chars[idx];
            chars[idx] = tmp;

        }
    }

    private static char convert(char c) {
        char[] mask = {'0', '8', '4', 'C', '2', 'A', '6', 'E', '1', '9', '5', 'D', '3', 'B', '7', 'F'};
        if ( c >= '0' && c <= '9') {
            return mask[c - '0'];
        } else if (c >= 'a' && c <= 'f') {
            return mask[c - 'a' + 10];
        } else if (c >= 'A' && c <= 'F') {
            return mask[c - 'A' + 10];
        }

        return c;
    }
}
