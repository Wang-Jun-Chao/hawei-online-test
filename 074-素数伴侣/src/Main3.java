import java.util.*;

/**
 * Author: 王俊超
 * Date: 2016-01-06 12:00
 * Declaration: All Rights Reserved !!!
 */


public class Main3 {


    public static void main(String[] args) {
        Scanner in = new Scanner(Main2.class.getClassLoader().getResourceAsStream("data.txt"));
//        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {
            int n = in.nextInt();
            int[] arr = new int[n];
            int index = 0;
            while (index < n) {
                arr[index++] = in.nextInt();
            }
            System.out.println(getBestPrimePartnerCount(arr, n));
        }
        in.close();
    }

    static int getBestPrimePartnerCount(int[] arr, int n) {
        if (arr == null || n == 0 || n % 2 != 0) {
            return 0;
        }
        int[] dp = new int[n + 1];

        int cnt = 0;

        for (int i = n - 2; i > -1; i--) {
            for (int j = n - 1; j > i; j--) {
                cnt = isPrime(arr[i] + arr[j]) ? (dp[i + 1] - dp[j - 1] + dp[j + 1] + 1) : dp[i + 1];
                dp[i] = (cnt > dp[i]) ? cnt : dp[i];
            }
        }

        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(dp));

        return dp[0];
    }

    static boolean isPrime(int n) {
        if (n == 2) {
            return true;
        }
        boolean isPrime = true;
        for (int j = 2; j <= (int) Math.sqrt(n); j++) {
            if (n % j == 0) {
                isPrime = false;
                break;
            }
        }
        return isPrime;
    }
}
