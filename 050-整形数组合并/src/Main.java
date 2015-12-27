import java.util.Arrays;
import java.util.Scanner;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 * Author: 王俊超
 * Date: 2015-12-25 09:23
 * Declaration: All Rights Reserved !!!
 */
public class Main {
    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
        Scanner scanner = new Scanner(Main.class.getClassLoader().getResourceAsStream("data.txt"));
        while (scanner.hasNext()) {
//            int m = scanner.nextInt();
//            int[] a = new int[m];
//            for (int i = 0; i < m; i++) {
//                a[i] = scanner.nextInt();
//            }
//
//            int n = scanner.nextInt();
//            int[] b = new int[n];
//            for (int i = 0; i < n; i++) {
//                b[i] = scanner.nextInt();
//            }
//
//            System.out.println(mergeArray(a, b));

            int m = scanner.nextInt();
            SortedSet<Integer> set = new TreeSet<>();
            for (int i = 0; i < m; i++) {
                set.add(scanner.nextInt());
            }

            int n = scanner.nextInt();
            for (int i = 0; i < n; i++) {
                set.add(scanner.nextInt());
            }

            for (Integer i : set) {
                System.out.print(i);
            }
        }

        scanner.close();
    }

    private static String mergeArray(int[] a, int[] b) {
        int[] c = new int[a.length + b.length];
        Arrays.sort(a);
        Arrays.sort(b);

        int ap = 0;
        int bp = 0;
        int cp = 0;

        while (ap < a.length && bp < b.length) {
            if (a[ap] < b[bp]) {
                c[cp] = a[ap];
                ap++;
            } else if (a[ap] > b[bp]) {
                c[cp] = b[bp];
                bp++;
            } else {
                c[cp] = a[ap];
                ap++;
                bp++;
            }
            cp++;
        }


        for (int i = ap; i < a.length; i++) {
            if (a[i] != c[cp - 1]) {
                c[cp] = a[i];
                cp++;
            }
        }

        for (int i = bp; i < b.length; i++) {
            if (b[i] != c[cp - 1]) {
                c[cp] = b[i];
                cp++;
            }
        }

//        System.out.println(Arrays.toString(c));

        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < cp; i++) {
            builder.append(c[i]);
        }

        return builder.toString();
    }
}
