import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Scanner;

/**
 * Author: 王俊超
 * Date: 2015-12-24 10:19
 * Declaration: All Rights Reserved !!!
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
//        Scanner scanner = new Scanner(Main.class.getClassLoader().getResourceAsStream("data.txt"));
        while (scanner.hasNext()) {
            String s1 = scanner.nextLine();
            String s2 = scanner.nextLine();
            System.out.println(encrypt(s1, s2));
        }

        scanner.close();
    }

    private static String encrypt(String mask, String s) {
        HashSet<Character> set = new LinkedHashSet<>(32);
        // 添加掩码中出现了的字母并且除去重复的字母
        for (int i = 0; i < mask.length(); i++) {
            char c = mask.charAt(i);
            if (c >= 'a' && c <= 'z') {
                set.add((char) (c - 'a' + 'A'));
            } else if (c >= 'A' && c <= 'Z') {
                set.add(c);
            }
        }

        // 添加余下的字母
        for (int i = 0; i < 26; i++) {
            set.add((char) ('A' + i));
        }

        // 转换成字符数组，都是用大写表示的
        Character[] convert = set.toArray(new Character[set.size()]);
        char[] result = s.toCharArray();

        for (int i = 0; i < result.length; i++) {
            char c = result[i];

            if (c >= 'a' && c <= 'z') {
                result[i] = (char) (convert[c - 'a'] - 'A' + 'a');
            } else if (c >= 'A' && c <= 'Z') {
                result[i] = convert[c - 'A'];
            }
        }

        return new String(result);
    }
}
