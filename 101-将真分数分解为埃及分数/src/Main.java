import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * Author: 王俊超
 * Date: 2016-05-05 08:35
 * CSDN: http://blog.csdn.net/derrantcm
 * Github: https://github.com/Wang-Jun-Chao
 * Declaration: All Rights Reserved !!!
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
//        Scanner scanner = new Scanner(Main.class.getClassLoader().getResourceAsStream("data.txt"));
        while (scanner.hasNext()) {
            String real = scanner.next();
//            System.out.println(convert(real));
//            System.out.println(convert2(real));
            System.out.println(convert3(real));
        }
        scanner.close();
    }

    /**
     * 方法一
     * 真分数分解为埃及分数
     * 解题思路
     * <p>
     * 【贪心算法】
     * 设a、b为互质正整数，a < b 分数a/b 可用以下的步骤分解成若干个单位分数之和：
     * 步骤一： 用b 除以a，得商数q1 及余数r1。（r1=b - a*q1）
     * 步骤二：把a/b 记作：a/b=1/(q1+1）+(a-r)/b(q1+1）
     * 步骤三：重复步骤2，直到分解完毕
     * 3/7=1/3+2/21=1/3+1/11+1/231
     * 13/23=1/2+3/46=1/2+1/16+1/368
     * 以上其实是数学家斐波那契提出的一种求解埃及分数的贪心算法，准确的算法表述应该是这样的：
     * 设某个真分数的分子为a，分母为b;
     * 把b除以a的商部分加1后的值作为埃及分数的某一个分母c；
     * 将a乘以c再减去b，作为新的a；
     * 将b乘以c，得到新的b；
     * 如果a大于1且能整除b，则最后一个分母为b/a；算法结束；
     * 或者，如果a等于1，则，最后一个分母为b；算法结束；
     * 否则重复上面的步骤。
     * 备注：事实上，后面判断a是否大于1和a是否等于1的两个判断可以合在一起，及判断b%a是否等于0，最后一个分母为b/a，显然是正确的。
     *
     * @param real 真分数
     * @return 埃及分数
     */
    private static String convert(String real) {

        String[] parts = real.split("/");

        // 分子
        int a = Integer.parseInt(parts[0]);
        // 分母
        int b = Integer.parseInt(parts[1]);
        StringBuilder builder = new StringBuilder(64);
//        System.out.print("[1]" + a + "/" + b + ": ");

        while (b % a != 0) {
            // 求商
            int q = b / a;
            // 余数
            int r = b % a;

            builder.append(1).append('/').append(q + 1).append('+');
            a = a - r;
            b = b * (q + 1);

        }

        builder.append(1).append('/').append(b / a);


        return builder.toString();
    }

    /**
     * 方法二
     * 真分数分解为埃及分数
     * <p>
     * 若真分数的分子a能整除分母b，则真分数经过化简就可以得到埃及分数，
     * 若真分数的分子不能整除分母，则可以从原来的分数中分解出一个分母为b/a+1的埃及分数。
     * 用这种方法将剩余部分反复分解，最后可得到结果。
     *
     * @param real 真分数
     * @return 埃及分数
     */
    private static String convert2(String real) {

        String[] parts = real.split("/");

        // 分子
        int a = Integer.parseInt(parts[0]);
        // 分母
        int b = Integer.parseInt(parts[1]);
        StringBuilder builder = new StringBuilder(64);
//        System.out.print("[2]" + a + "/" + b + ": ");

        while (b % a != 0) {
            // 分解出一个分母为b/a+1的埃及分数
            int c = b / a + 1;
            a = a * c - b;
            b = b * c;

            builder.append(1).append('/').append(c).append('+');
        }

        builder.append(1).append('/').append(b / a);


        return builder.toString();
    }


    /**
     * 方法三
     * 真分数分解为埃及分数
     *
     * @param real 真分数
     * @return 埃及分数
     */
    private static String convert3(String real) {

        String[] parts = real.split("/");

        // 分子
        int a = Integer.parseInt(parts[0]);
        // 分母
        int b = Integer.parseInt(parts[1]);
        StringBuilder builder = new StringBuilder(64);

        int c;
        while (a != 1) {
            if (b % (a - 1) == 0) {
                builder.append("1/").append(b / (a - 1)).append('+');
                a = 1;
            } else {
                c = b / a + 1;
                builder.append("1/").append(c).append('+');
                a = a * c - b;
                b = c * b;
                if (b % a == 0) {
                    b = b / a;
                    a = 1;
                }
            }
        }
        builder.append("1/").append(b);
        return builder.toString();
    }
}
