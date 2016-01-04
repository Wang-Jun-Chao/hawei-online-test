import java.util.Scanner;

/**
 * Author: 王俊超
 * Date: 2016-01-03 20:56
 * Declaration: All Rights Reserved !!!
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
//        Scanner scanner = new Scanner(Main.class.getClassLoader().getResourceAsStream("data.txt"));
        while (scanner.hasNext()) {
            int m = scanner.nextInt();
            int n = scanner.nextInt();

            System.out.println(findWays(m, n));
        }

        scanner.close();
    }

    private static int findWays(int m, int n) {
        int[] result = {0};
        for (int i = 1; i <= n; i++) {
            findWays2(m, m - i + 1, 1, i, result);
        }
        return result[0];
    }

    /**
     * 有n个变量，其和为m，求有多少种解法，每个解的变量按从大到小取值，最小为1
     *
     * @param m      第i个变量实际可以取的最大值
     * @param curMax 可以取的最大值
     * @param i      第i个变量
     * @param n      总计有n个变量
     * @param result 结果统计
     */
    private static void findWays2(int m, int curMax, int i, int n, int[] result) {
        if (m > 0 && m <= curMax && i == n) {
            result[0]++;
            return;
        }

        if (m < 1 || curMax < 1 || i > n) {
            return;
        }


        for (int v = curMax; v > 0; v--) {
            findWays2(m - v, v, i + 1, n, result);
        }
    }
}
