import java.util.Arrays;
import java.util.Scanner;

/**
 * Author: 王俊超
 * Date: 2015-12-24 18:57
 * Declaration: All Rights Reserved !!!
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
//        Scanner scanner = new Scanner(Main.class.getClassLoader().getResourceAsStream("data.txt"));
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int k = scanner.nextInt();
            int[] arr = new int[n];

            for (int i = 0; i < n; i++) {
                arr[i] = scanner.nextInt();
            }

            // 【1】方法一
            System.out.print(getMinK(arr, k));

            // 【2】方法二
//            Arrays.sort(arr);
//            StringBuilder builder = new StringBuilder();
//            for (int i = 0; i < k; i++) {
//                builder.append(arr[i]).append(' ');
//            }
//
//            System.out.print(builder.substring(0, builder.length() - 1));
        }

        scanner.close();
    }

    private static String getMinK(int[] arr, int k) {

        if (k <= 0) {
            return "";
        } else if (k >= arr.length) {
            StringBuilder b = new StringBuilder();
            for (int i : arr) {
                b.append(i).append(' ');
            }

            return b.toString();
        } else {

            int[] min = new int[k];

            for (int i = 0; i < arr.length; i++) {
                if (i < k - 1) {
                    min[i] = arr[i];
                } else if (i == k - 1) {
                    min[i] = arr[i];

                    // 下面要建大堆了
                    for (int j = min.length / 2; j >= 0; j--) {
                        shiftDown(min, j, min.length);
                    }
                } else {
                    if (min[0] > arr[i]) {
                        min[0] = arr[i];
                        shiftDown(min, 0, min.length);
                    }
                }
            }

            Arrays.sort(min);

            StringBuilder b = new StringBuilder();
            for (int i : min) {
                b.append(i).append(' ');
            }
            return b.substring(0, b.length() - 1);
        }
    }


    private static void shiftDown(int[] a, int i, int n) {
        int child;
        int tmp;
        for (tmp = a[i]; 2 * i + 1 < n; i = child) {
            // 左孩子
            child = 2 * i + 1;
            // 找较大的子结点
            if (child + 1 < n && a[child] < a[child + 1]) {
                child++;
            }


            if (tmp < a[child]) {
                a[i] = a[child];
            } else {
                break;
            }
        }

        a[i] = tmp;
    }
}
