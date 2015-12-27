/**
 * Author: 王俊超
 * Date: 2015-12-25 15:08
 * All Rights Reserved !!!
 */
public class KMP {
    // 下面的KMP匹配算法，于
    private static boolean kmpMatch( String s, String sub) {

        int[] next = getNext(sub);

        // 母串的长度
        int m = s.length();
        // 子串的长度
        int n = sub.length();

        int j = 0;
        int i = -1;

        for(; j < m; j++) {
            while (sub.charAt(i + 1) != s.charAt(j) && i >= 0) {
                i = next[i];
            }

            if (sub.charAt(i + 1) == s.charAt(j)) {
                i++;
            }

            if (i == n - 1) {
                return true;
            }
        }

        return false;
    }

    private static int[] getNext(String s) {
        // next[j] 表示当 W[j] 与 S[i] 不匹配时，W 应该滑到哪个位置上。
        int[] next = new int[s.length()];
        next[0] = -1;
        next[1] = 0;
        // j在前
        int i = 0;
        int j = -1;

        while (i < s.length() - 1) {
            if (j == -1 || s.charAt(i) == s.charAt(j)) {

                if (s.charAt(++i) != s.charAt(++j)) {
                    next[i] = j;
                } else {
                    // 回退
                    next[i] = next[j];
                }

            } else {
                // 回退
                j = next[j];
            }
        }

        return next;
    }
}
