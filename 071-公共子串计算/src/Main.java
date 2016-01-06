import java.util.Arrays;
import java.util.Scanner;

/**
 * Author: 王俊超
 * Date: 2016-01-04 15:56
 * All Rights Reserved !!!
 */
public class Main {
    public static void main(String[] args) {
        //Scanner scanner = new Scanner(System.in);
        Scanner scanner = new Scanner(Main.class.getClassLoader().getResourceAsStream("data.txt"));
        while (scanner.hasNext()) {
            String n = scanner.next();
            String m = scanner.next();
            System.out.println(maxSubstringLength(n, m));
            System.out.println(maxSubsequenceLength(n, m));
        }

        scanner.close();
    }

    private static int maxSubstringLength(String a, String b) {
        int aLen = a.length() + 1;
        int bLen = b.length() + 1;
        int max = 0;

        // 初始值默认为0
        int[][] f = new int[aLen][bLen];


        for (int i = 1; i < aLen; i++) {
            for (int j = 1; j < bLen; j++) {
                if (a.charAt(i - 1) == b.charAt(j - 1)) {
                    f[i][j] = f[i - 1][j - 1] + 1;
                } else {
                    f[i][j] = 0;
                }

                if (f[i][j] > max) {
                    max = f[i][j];
                }
            }
        }

        return max;
    }

    /**
     * 动态规划算法
     * <pre>
     * 事实上，最长公共子序列问题也有最优子结构性质。
     * 记:
     * Xi=﹤x1，⋯，xi﹥即X序列的前i个字符 (1≤i≤m)（前缀）
     * 假定Z=﹤z1，⋯，zk﹥∈LCS(X , Y)。
     *
     * 若xm=yn（最后一个字符相同），则不难用反证法证明：该字符必是X与Y的任一最长公共子序列Z（设长度为k）的最后一个字符，
     * 即有zk = xm = yn 且显然有Zk-1∈LCS(Xm-1 , Yn-1)即Z的前缀Zk-1是Xm-1与Yn-1的最长公共子序列。此时，问题化归成
     * 求Xm-1与Yn-1的LCS（LCS(X , Y)的长度等于LCS(Xm-1 , Yn-1)的长度加1）。
     *
     * 若xm≠yn，则亦不难用反证法证明：要么Z∈LCS(Xm-1, Y)，要么Z∈LCS(X , Yn-1)。由于zk≠xm与zk≠yn其中至少有一个必
     * 成立，若zk≠xm则有Z∈LCS(Xm-1 , Y)，类似的，若zk≠yn 则有Z∈LCS(X , Yn-1)。此时，问题化归成求Xm-1与Y的LCS及
     * X与Yn-1的LCS。LCS(X , Y)的长度为：max{LCS(Xm-1 , Y)的长度, LCS(X , Yn-1)的长度}。
     *
     * 由于上述当xm≠yn的情况中，求LCS(Xm-1 , Y)的长度与LCS(X , Yn-1)的长度，这两个问题不是相互独立的：两者都需要求
     * LCS(Xm-1，Yn-1)的长度。另外两个序列的LCS中包含了两个序列的前缀的LCS，故问题具有最优子结构性质考虑用动态规划法。
     * 也就是说，解决这个LCS问题，你要求三个方面的东西：
     *      1、LCS（Xm-1，Yn-1）+1；
     *      2、LCS（Xm-1，Y），LCS（X，Yn-1）；
     *      3、max{LCS（Xm-1，Y），LCS（X，Yn-1）}。
     * 所以解决这个问题的动态转移方程即：
     *      if xm==yn  LCS(Xm,Yn)= LCS（Xm-1，Yn-1）+1;
     *      if xm!=yn LCS(Xm,Yn)=  max{LCS（Xm-1，Yn),LCS（Xm，Yn-1)};
     * </pre>
     *
     * @param a
     * @param b
     * @return
     */
    private static int maxSubsequenceLength(String a, String b) {

        int aLen = a.length() + 1;
        int bLen = b.length() + 1;

        // 初始值默认为0
        int[][] f = new int[aLen][bLen];


        for (int i = 1; i < aLen; i++) {
            for (int j = 1; j < bLen; j++) {
                if (a.charAt(i - 1) == b.charAt(j - 1)) {
                    f[i][j] = f[i - 1][j - 1] + 1;
                } else {
                    f[i][j] = Math.max(f[i - 1][j], f[i][j - 1]);
                }
            }
        }

        return f[aLen - 1][bLen - 1];
    }
}
