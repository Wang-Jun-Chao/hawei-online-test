import java.util.Arrays;
import java.util.Scanner;

/**
 * Author: 王俊超
 * Date: 2016-01-06 10:43
 * Declaration: All Rights Reserved !!!
 */
public class Main {
    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
        Scanner scanner = new Scanner(Main.class.getClassLoader().getResourceAsStream("data.txt"));
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = scanner.nextInt();
            }

            System.out.println(countPrimePairs(arr));
        }

        scanner.close();
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

    /**
     * 利用动态规划解题，dp[i]表示0-i最多有的伴侣数；
     * 当v[i]+v[j]为素数。dp[i]+dp[j] = dp[i-1]+dp[j-1]+1;
     * 由于伴侣数成对出现，必然只能在i-1和j-1的基础上出现一对。
     * 当v[i]+v[j]不为素数。dp[i]=dp[i-1]
     *
     * @param v
     * @return
     */
    private static int countPrimePairs(int[] v) {
        int[] dp = new int[v.length + 1];

        for (int i = 2; i < dp.length; i++) {
            for (int j = 1; j < i; j++) {
                int cnt = isPrime(v[i - 1] + v[j - 1]) ? (dp[i - 1] + dp[j - 1] - dp[j] + 1) : dp[i - 1];
                dp[i] = Math.max(cnt, dp[i]);
            }
        }

        System.out.println(Arrays.toString(v));
        System.out.println(Arrays.toString(dp));

        return dp[dp.length - 1];
    }
}
