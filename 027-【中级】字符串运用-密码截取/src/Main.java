import java.util.Scanner;

/**
 * Author: 王俊超
 * Date: 2015-12-24 10:57
 * Declaration: All Rights Reserved !!!
 */
public class Main {
    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
        Scanner scanner = new Scanner(Main.class.getClassLoader().getResourceAsStream("data.txt"));
        while (scanner.hasNext()) {
            String input = scanner.nextLine();
            System.out.println(longestPalindrome(input));
        }

        scanner.close();
    }

    /**
     * 这道题本质是求字符串中的最大回文字串的长度
     * 动态规划法，
     * 假设dp[ i ][ j ]的值为true，表示字符串s中下标从 i 到 j 的字符组成的子串是回文串。那么可以推出：
     * dp[ i ][ j ] = dp[ i + 1][ j - 1] && s[ i ] == s[ j ]。
     * 这是一般的情况，由于需要依靠i+1, j -1，所以有可能 i + 1 = j -1, i +1 = (j - 1) -1，
     * 因此需要求出基准情况才能套用以上的公式：
     * a. i + 1 = j -1，即回文长度为1时，dp[ i ][ i ] = true;
     * b. i +1 = (j - 1) -1，即回文长度为2时，dp[ i ][ i + 1] = （s[ i ] == s[ i + 1]）。
     * 有了以上分析就可以写出代码了。需要注意的是动态规划需要额外的O(n^2)的空间。
     *
     * @param s 待求字符串
     * @return 最大回文字串的长度
     */
    private static int longestPalindrome(String s) {

        // 不考虑非法输入的情况，比如null

        int maxLen = 0;
        int len = s.length();
        boolean[][] t = new boolean[len][len];

        // 单个字符串都是回文
        for (int i = 0; i < len; i++) {
            t[i][i] = true;
            maxLen = 1;
        }

        for (int i = 0; i < len - 1; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                t[i][i + 1] = true;
                maxLen = 2;
            }
        }

        // 求长度大于2的子串是否是回文串
        for (int gap = 3; gap <= len; gap++) {
            for (int i = 0, j; (j = i + gap - 1) <= len - 1; i++) {
                if (s.charAt(i) == s.charAt(j)) {
                    t[i][j] = t[i+1][j-1];
                    if (t[i][j] && gap >= maxLen) {
                        maxLen = gap;
                        System.out.println(s.substring(i, j + 1));
                    }
                } else {
                    t[i][j] = false;
                }
            }
        }




        return maxLen;
    }
}
