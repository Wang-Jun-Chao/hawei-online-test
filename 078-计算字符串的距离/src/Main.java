import java.util.Scanner;

/**
 * Author: 王俊超
 * Date: 2016-01-03 19:58
 * Declaration: All Rights Reserved !!!
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
//        Scanner scanner = new Scanner(Main.class.getClassLoader().getResourceAsStream("data.txt"));
        while (scanner.hasNext()) {
            String a = scanner.nextLine();
            String b = scanner.nextLine();
            System.out.println(stringDistance(a, b));

        }

        scanner.close();
    }

    private static int stringDistance(String a, String b) {
//        System.out.println(stringDistance(a.toCharArray(), 0, b.toCharArray(), 0));
        return stringDistance(a.toCharArray(), b.toCharArray());
    }


    /**
     * 方法一、计算量过大
     * <pre>
     * 两个字符串的距离肯定不超过它们的长度之和（我们可以通过删除操作把两个串都转化为空串）。
     * 虽然这个结论对结果没有帮助，但至少可以知道，任意两个字符串的距离都是有限的。
     * 我们还是应该集中考虑如何才能把这个问题转化成规模较小的同样的问题。
     * 如果有两个串A=xabcdae和B=xfdfa，它们的第一个字符是相同的，只要计算A[2,…,7]=abcdae
     * 和B[2,…,5]=fdfa的距离就可以了。但是如果两个串的第一个字符不相同，
     * 那么可以进行如下的操作（lenA和lenB分别是A串和B串的长度）：
     * 1．删除A串的第一个字符，然后计算A[2,…,lenA]和B[1,…,lenB]的距离。
     * 2．删除B串的第一个字符，然后计算A[1,…,lenA]和B[2,…,lenB]的距离。
     * 3．修改A串的第一个字符为B串的第一个字符，然后计算A[2,…,lenA]和B[2,…,lenB]的距离。
     * 4．修改B串的第一个字符为A串的第一个字符，然后计算A[2,…,lenA]和B[2,…,lenB]的距离。
     * 5．增加B串的第一个字符到A串的第一个字符之前，然后计算A[1,…,lenA]和B[2,…,lenB]的距离。
     * 6．增加A串的第一个字符到B串的第一个字符之前，然后计算A[2,…,lenA]和B[1,…,lenB]的距离。
     *
     * 在这个题目中，我们并不在乎两个字符串变得相等之后的字符串是怎样的。所以，可以将上面6个操作合并为：
     * 1.一步操作之后，再将A[2,…,lenA]和B[1,…,lenB]变成相同字符串。
     * 2.一步操作之后，再将A[1,…,lenA]和B[2,…,lenB]变成相同字符串。
     * 3.一步操作之后，再将A[2,…,lenA]和B[2,…,lenB]变成相同字符串。
     * </pre>
     *
     * @param a
     * @param i
     * @param b
     * @param j
     * @return
     */
    private static int stringDistance(char[] a, int i, char[] b, int j) {

        if (i >= a.length || j >= b.length) {
            return Math.max(a.length - i, b.length - j);
        }

        // 字符相等
        if (a[i] == b[j]) {
            return stringDistance(a, i + 1, b, j + 1);
        } else {
            int d1 = stringDistance(a, i + 1, b, j);
            int d2 = stringDistance(a, i + 1, b, j + 1);
            int d3 = stringDistance(a, i, b, j + 1);

            return Math.min(Math.min(d1, d2), d3) + 1;
        }
    }

    /**
     * 方法二
     * <pre>
     * 很经典的可使用动态规划方法解决的题目，和计算两字符串的最长公共子序列相似。
     *
     * 设Ai为字符串A(a1a2a3 … am)的前i个字符（即为a1,a2,a3 … ai）
     * 设Bj为字符串B(b1b2b3 … bn)的前j个字符（即为b1,b2,b3 … bj）
     *
     * 设 L(i,j)为使两个字符串和Ai和Bj相等的最小操作次数。
     * 当ai==bj时 显然 L(i,j) = L(i-1,j-1)
     * 当ai!=bj时
     *
     *  若将它们修改为相等，则对两个字符串至少还要操作L(i-1,j-1)次
     *  若删除ai或在bj后添加ai，则对两个字符串至少还要操作L(i-1,j)次
     *  若删除bj或在ai后添加bj，则对两个字符串至少还要操作L(i,j-1)次
     *  此时L(i,j) = min( L(i-1,j-1), L(i-1,j), L(i,j-1) ) + 1
     *
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
