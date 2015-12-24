import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * Author: 王俊超
 * Date: 2015-12-24 10:05
 * Declaration: All Rights Reserved !!!
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
//        Scanner scanner = new Scanner(Main.class.getClassLoader().getResourceAsStream("data.txt"));
        while (scanner.hasNext()) {
            String input = scanner.nextLine();
            System.out.println(quickSort(input));
        }

        scanner.close();
    }

    private static String quickSort(String s) {
        char[] chars = s.toCharArray();
        quickSort(chars, 0, chars.length - 1);
        return new String(chars);
    }

    private static void quickSort(char[] chars, int beg, int end) {
        if (beg < end) {
            int lo = beg;
            int hi = end;
            char pivot = chars[lo];

            while (lo < hi) {
                while (lo < hi && chars[hi] >= pivot) {
                    hi--;
                }

                chars[lo] = chars[hi];

                while (lo < hi && chars[lo] <= pivot) {
                    lo++;
                }

                chars[hi] = chars[lo];
            }

            chars[lo] = pivot;

            quickSort(chars, beg, lo - 1);
            quickSort(chars, lo + 1, end);

        }
    }
}
