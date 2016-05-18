import java.util.Scanner;

/**
 * Author: 王俊超
 * Date: 2016-01-04 09:31
 * Declaration: All Rights Reserved !!!
 */
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
//        Scanner scanner = new Scanner(Main.class.getClassLoader().getResourceAsStream("data.txt"));
        while (scanner.hasNext()) {
            String a = scanner.nextLine();
            String b = scanner.nextLine();
            System.out.println("1/" + (stringDistance(a.toCharArray(), b.toCharArray()) + 1));
        }

        scanner.close();
    }

    /**
     * 很经典的可使用动态规划方法解决的题目，和计算两字符串的最长公共子序列相似。
     * <p>
     * 设Ai为字符串A(a1a2a3 … am)的前i个字符（即为a1,a2,a3 … ai）
     * 设Bj为字符串B(b1b2b3 … bn)的前j个字符（即为b1,b2,b3 … bj）
     * <p>
     * 设 L(i,j)为使两个字符串和Ai和Bj相等的最小操作次数。
     * 当ai==bj时 显然 L(i,j) = L(i-1,j-1)
     * 当ai!=bj时
     * <p>
     * 若将它们修改为相等，则对两个字符串至少还要操作L(i-1,j-1)次
     * 若删除ai或在bj后添加ai，则对两个字符串至少还要操作L(i-1,j)次
     * 若删除bj或在ai后添加bj，则对两个字符串至少还要操作L(i,j-1)次
     * 此时L(i,j) = min( L(i-1,j-1), L(i-1,j), L(i,j-1) ) + 1
     * <p>
     * 显然，L(i,0)=i，L(0,j)=j, 再利用上述的递推公式，可以直接计算出L(i,j)值。
     * </pre>
     *
     * @param a
     * @param b
     * @return
     */
    private static int stringDistance(char[] a, char[] b) {
        int[][] len = new int[a.length + 1][b.length + 1];

        for (int i = 0; i < len.length; i++) {
            len[i][0] = i;
        }

        for (int j = 0; j < len[0].length; j++) {
            len[0][j] = j;
        }

        for (int i = 1; i < len.length; i++) {
            for (int j = 1; j < len[0].length; j++) {
                if (a[i - 1] == b[j - 1]) {
                    len[i][j] = len[i - 1][j - 1];
                } else {
                    len[i][j] = Math.min(Math.min(len[i - 1][j], len[i - 1][j - 1]), len[i][j - 1]) + 1;
                }
            }
        }

        return len[len.length - 1][len[0].length - 1];
    }
}
