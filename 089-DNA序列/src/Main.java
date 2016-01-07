import java.util.Scanner;

/**
 * Author: 王俊超
 * Date: 2016-01-06 15:18
 * All Rights Reserved !!!
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
//        Scanner scanner = new Scanner(Main.class.getClassLoader().getResourceAsStream("data.txt"));
        while (scanner.hasNext()) {
            String input = scanner.nextLine();
            int n = scanner.nextInt();
            System.out.println(maxRatio(input, n));
        }

        scanner.close();
    }

    /**
     * 初始化两个数组，一个序列数值数组K[N]，一个序列和数组SUM[N]，先遍历一边序列，
     * 为C或者G则K[i]为1，否则则置为0，然后计算连续M个K[I]之和存入SUM就行。
     *
     * @param s
     * @param m
     * @return
     */
    private static String maxRatio(String s, int m) {
        int[] k = new int[s.length()];
        int[] sum = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == 'C' || c == 'G') {
                k[i]++;
            }
        }

        for (int i = 0; i < k.length - m; i++) {
            for (int j = 0; j < m; j++) {
                sum[i] += k[i + j];
            }
        }

        int max = 0;
        int idx = 0;
        for (int i = 0; i < k.length - 1; i++) {
            if (sum[i] > max) {
                max = sum[i];
                idx = i;
            }
        }

        return s.substring(idx, idx + m);
    }
}
