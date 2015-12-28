import java.util.Arrays;
import java.util.Scanner;

/**
 * Author: 王俊超
 * Date: 2015-12-27 14:12
 * Declaration: All Rights Reserved !!!
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
//        Scanner scanner = new Scanner(Main.class.getClassLoader().getResourceAsStream("data.txt"));
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int[] array = new int[n];
            for (int i = 0; i < n; i++) {
                array[i] = scanner.nextInt();
            }
            int tag = scanner.nextInt();
            System.out.println(arrToStr(sort(array), tag));
        }

        scanner.close();
    }

    private static String arrToStr(int[] a, int tag) {

        StringBuilder builder = new StringBuilder();

        if (tag == 1) {
            for (int i = a.length - 1; i >= 0; i--) {
                builder.append(a[i]).append(' ');
            }
        } else {
            for (int i : a) {
                builder.append(i).append(' ');
            }
        }


        return builder.substring(0, builder.length() - 1);
    }

    private static int[] sort(int[] a) {

        for (int i = 0; i < a.length; i++) {
            int idx = i;
            int tmp;
            for (int j = i + 1; j < a.length; j++) {
                if (a[idx] - a[j] > 0) {
                    idx = j;
                }
            }

            tmp = a[i];
            a[i] = a[idx];
            a[idx] = tmp;
        }

        return a;
    }
}
