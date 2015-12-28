import java.util.Scanner;

/**
 * Author: 王俊超
 * Date: 2015-12-27 15:25
 * Declaration: All Rights Reserved !!!
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
//        Scanner scanner = new Scanner(Main.class.getClassLoader().getResourceAsStream("data.txt"));
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = scanner.nextInt();
            }

            System.out.println(lsiEnhance(a));
        }

        scanner.close();
    }


    /**
     * 设f(i)表示L中以ai为末元素的最长递增子序列的长度。则有如下的递推方程：
     * 这个递推方程的意思是，在求以ai为末元素的最长递增子序列时，找到所有序
     * 号在L前面且小于ai的元素aj，即j<i且aj<ai。如果这样的元素存在，那么对
     * 所有aj,都有一个以aj为末元素的最长递增子序列的长度f(j)，把其中最大的
     * f(j)选出来，那么f(i)就等于最大的f(j)加上1，即以ai为末元素的最长递增
     * 子序列，等于以使f(j)最大的那个aj为末元素的递增子序列最末再加上ai；如
     * 果这样的元素不存在，那么ai自身构成一个长度为1的以ai为末元素的递增子序列。
     *
     * @param a 待处理的数组
     * @return 最长递增子序列长度
     */
    private static int lisSimple(int[] a) {
        int n = a.length;
        // 用于存放f(i)值；
        int[] f = new int[n];
        // 以第a1为末元素的最长递增子序列长度为1；
        f[0] = 1;

        for (int i = 1; i < n; i++) {// 循环n-1次
            // f[i]的最小值为1；
            f[i] = 1;
            for (int j = 0; j < i; j++) {// 循环i次
                if (a[j] < a[i] && f[j] > f[i] - 1) {
                    // 更新f[i]的值。
                    f[i] = f[j] + 1;
                }
            }
        }
        // 这个算法有两层循环，外层循环次数为n-1次，内层循环次数为i次，
        // 算法的时间复杂度所以T(n)=O(n2)。
        return f[n - 1];
    }

    /**
     * 在上一种算法中，在计算每一个f(i)时，都要找出最大的f(j)(j < i)来，由于f(j)没有顺序，
     * 只能顺序查找满足aj < ai最大的f(j)，如果能将让f(j)有序，就可以使用二分查找，这样算
     * 法的时间复杂度就可能降到O(nlogn)。于是想到用一个数组B来存储“子序列的”最大递增子
     * 序列的最末元素，即有B[f(j)] = aj在计算f(i)时，在数组B中用二分查找法找到满足
     * j < i且B[f(j)] = aj < ai的最大的j,并将B[f[j]+1]置为ai。
     *
     * @param a
     * @return
     */
    private static int lsiEnhance(int[] a) {

        int n = a.length;
        // 数组B；
        float[] B = new float[n + 1];
        // 把B[0]设为最小
        B[0] = Integer.MIN_VALUE;
        // 初始时，最大递增子序列长度为1的最末元素为a1
        B[1] = a[0];
        // Len为当前最大递增子序列长度，初始化为1；
        int len = 1;
        // p,r,m分别为二分查找的上界，下界和中点；
        int p, r, m;

        for (int i = 1; i < n; i++) {
            p = 0;
            r = len;

            // 二分查找最末元素小于ai+1的长度最大的最大递增子序列；
            while (p <= r) {
                m = (p + r) / 2;
                if (B[m] < a[i]) {
                    p = m + 1;
                } else {
                    r = m - 1;
                }
            }

            // 将长度为p的最大递增子序列的当前最末元素置为ai+1;
            B[p] = a[i];
            if (p > len) {
                // 更新当前最大递增子序列长度；
                len++;
            }


        }

        return len;
    }
}
