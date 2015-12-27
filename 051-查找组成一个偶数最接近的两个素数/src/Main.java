import java.util.Scanner;

/**
 * Author: 王俊超
 * Date: 2015-12-25 09:52
 * Declaration: All Rights Reserved !!!
 */
public class Main {
    public static void main(String[] args) {
        //Scanner scanner = new Scanner(System.in);
        Scanner scanner = new Scanner(Main.class.getClassLoader().getResourceAsStream("data.txt"));
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            System.out.println(findPrimeNumber(n));

        }


        scanner.close();
    }

    private static String findPrimeNumber(int n) {

        int[] a = new int[4];

        int i = n - 1;
        int idx = 0;
        // 找小于的n的两个质数，有可能只找到一个
        while (i >= 2 && idx < 2) {
            if (isPrime(i)) {
                // 保证小的在前，大的在后
                a[1 - idx] = i;
                idx++;
            }

            i--;
        }


        i = n + 1;

        // 说明在n之前有两个最接近n的质数，那就可只要在[n+1, n]之间再找两个质数，有可能没有两个
        if (idx == 2) {

            while (i <= 2 * n && idx < 4) {
                if (isPrime(i)) {
                    a[idx] = i;
                    idx++;
                }

                i++;
            }

            // [n+1, n]无质数
            if (idx == 2) {
                return a[0] + " " + a[1];
            }
            // [n+1, n]只有一个质数
            else if (idx == 3) {
                // a[2]离n的距离比前两个远
                if (n - a[0] <= a[2] - n) {
                    return a[0] + " " + a[1];
                } else {
                    return a[1] + " " + a[2];
                }
            }
            // [n+1, n]有两个质数
            else {
                // 取左边两个
                if (n - a[0] <= a[2] - n) {
                    return a[0] + " " + a[1];
                }
                // 取右边两个
                else if (n - a[1] >= a[3] - n) {
                    return a[2] + " " + a[3];
                }
                // 取中间两个
                else {
                    return a[1] + " " + a[2];
                }
            }
        }
        // 在[2, n-1]之间只有一个质数或者没有
        else {
            while (i <= Integer.MAX_VALUE && idx < 2) {
                if (isPrime(i)) {
                    a[idx] = i;
                    idx++;
                }

                i++;
            }

            return a[0] + " " + a[1];
        }
    }

    private static boolean isPrime(int n) {
        if (n < 2) {
            return false;
        }

        int sqrt = (int) Math.sqrt(n);

        for (int i = 2; i <= sqrt; i++) {
            if (n % i == 0) {
                return false;
            }
        }

        return true;
    }
}
