import java.util.Scanner;

/**
 * Author: 王俊超
 * Date: 2015-12-23 10:13
 * Declaration: All Rights Reserved !!!
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
//        Scanner scanner = new Scanner(Main.class.getClassLoader().getResourceAsStream("data.txt"));
        while (scanner.hasNextLine()) {
            String input = scanner.nextLine();
//            System.out.println("|" + reverse(input) + "|");
            System.out.println(reverse(input));
        }

        scanner.close();
    }

    private static String reverse(String s) {
        char[] chars = new char[s.length()];
        int pos = 0;

        // 下面进行字符串的压缩，去掉前导各后面的空格，中间单词间只保留一个空格
        for (int i = 0; i < s.length();) {
            // 从开始的i位置开始找第一个非空白字符
            while (i < s.length() && s.charAt(i) == ' ') {
                i++;
            }
            // 从开始的i位置开始找第一个空白字符
            while (i < s.length() && s.charAt(i) != ' ') {
                chars[pos] = s.charAt(i);
                pos++;
                i++;
            }

            // 此时i位置是一个空白字符，说明i后面还可能有非空白字符
            // 所以需要添加一个空白字符作为分隔
            if (i< s.length()) {
                chars[pos] = ' ';
                pos++;
            }
        }
        // 最后压缩后最后一个字符的位置
        pos--;


//        System.out.println("|" + new String(chars, 0, pos+1) + "|");

        // 将整个个字符串翻转一次
        reverse(chars, 0, pos);

        // 下面找每个单词进行翻转
        for(int i = 0, j; i <= pos; i++) {
            j = i;
            // 找i从开始的第一个空白字符
            while (i <= pos && chars[i] != ' ') {
                i++;
            }

            // 进行单词翻转
            reverse(chars, j, i - 1);
        }

        return new String(chars, 0, pos + 1);
    }

    private static void reverse(char[] arr, int beg, int end) {
        char tmp;
        while (beg < end) {
            tmp = arr[beg];
            arr[beg] = arr[end];
            arr[end] = tmp;
            beg++;
            end--;
        }
    }


}
