import java.util.Scanner;

/**
 * Author: 王俊超
 * Date: 2015-12-24 17:18
 * All Rights Reserved !!!
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
//        Scanner scanner = new Scanner(Main.class.getClassLoader().getResourceAsStream("data2.txt"));
        while (scanner.hasNext()) {

            String n = scanner.next();
            String m = scanner.next();
            // 【1】方法一
            System.out.println(add(n, m));

            // 【2】方法二
//            BigInteger bi1 = new BigInteger(n);
//            BigInteger bi2 = new BigInteger(m);
//            System.out.println(bi1.add(bi2));
        }

        scanner.close();
    }

    /**
     * 大整数相加，n、m都为自然数
     *
     * @param ns 数字
     * @param ms 数字
     * @return 结果
     */
    private static String add(String ns, String ms) {


        // ns是否为正数
        boolean pn = ns.charAt(0) != '-';
        // ms是否为正数
        boolean pm = ms.charAt(0) != '-';

        int[] n;
        int[] m;
        if (pn) {
            n = getNumber(ns);
        } else {
            n = getNumber(ns.substring(1));
        }

        if (pm) {
            m = getNumber(ms);
        } else {
            m = getNumber(ms.substring(1));
        }


        // 两者同号
        if (pn == pm) {
            // 进行计算
            int[] r = add(m, n);
            String rs = toNumber(r);

            // 根据需要添加负号
            if (pn) {
                return rs;
            } else {
                return "-" + rs;
            }
        } else {
            // ns的绝对值比大于等于ms
            if (compare(n, m) >= 0) {
                int[] r = minus(n, m);
                String rs = toNumber(r);
                // ns为正数，ms为负数
                if (pn) {
                    return rs;
                } else {
                    return "-" + rs;
                }
            }
            // ns的绝对值比小于ms
            else {
                int[] r = minus(m, n);
                String rs = toNumber(r);

                // ns为正数，ms为负数
                if (pn) {
                    return "-" + rs;

                } else {
                    return rs;
                }
            }
        }
    }

    /**
     * 两个整数相加
     *
     * @param m 整数
     * @param n 整数
     * @return 结果
     */
    private static int[] add(int[] m, int[] n) {

//        System.out.println(Arrays.toString(n) +"\n"+ Arrays.toString(m));

        // 保证n不小于m
        if (m.length > n.length) {
            int[] t = m;
            m = n;
            n = t;
        }

        // 结果的最大长度
        int[] r = new int[n.length + 1];
        // 来自低位的进位
        int c = 0;

        for (int i = 0; i < m.length; i++) {
            r[i] = m[i] + n[i] + c;
            c = r[i] / 10;
            r[i] %= 10;
        }

        // 计算余下的部分
        for (int i = m.length; i < n.length; i++) {
            r[i] = n[i] + c;
            c = r[i] / 10;
            r[i] %= 10;
        }

//        System.out.println(Arrays.toString(n) +"\n"+ Arrays.toString(m) + "\n" + Arrays.toString(r));

        // 最后还有进位
        if (c != 0) {
            r[r.length - 1] = c;
            return r;
        }
        // 没有进位
        else {
            int[] ret = new int[r.length - 1];
            System.arraycopy(r, 0, ret, 0, ret.length);
            return ret;
        }
    }


    /**
     * 比较两个整数是否相等，下标由小到大表示由低位到高位，忽略最高有效位上的前导0
     *
     * @param m 整数
     * @param n 整数
     * @return m > n返回1，m = n返回0，m < n返回-1
     */
    private static int compare(int[] m, int[] n) {

        if (m == null && n == null) {
            return 0;
        }
        // null最小
        if (m == null) {
            return -1;
        }

        if (n == null) {
            return 1;
        }

        int lastM = m.length - 1;
        int lastN = n.length - 1;

        // 找m的最高有效位的位置，至少有一位
        while (lastM >= 1 && m[lastM] == 0) {
            lastM--;
        }
        // 找n的最高有效位的位置，至少有一位
        while (lastN >= 1 && n[lastN] == 0) {
            lastN--;
        }

        // m的数位比n多，说明m比n大
        if (lastM > lastN) {
            return 1;
        }
        // m的数位比n少，说明m比n小
        else if (lastM < lastN) {
            return -1;
        } else {
            // 位数一样，比较每一个数位上的值，从高位到低位进行比较
            for (int i = lastM; i >= 0; i--) {
                if (m[i] > n[i]) {
                    return 1;
                } else if (m[i] < n[i]) {
                    return -1;
                }
            }

            return 0;
        }
    }


    /**
     * 做减法n-m，保证n大于等于m
     *
     * @param n 整数
     * @param m 整数
     * @return 结果
     */
    private static int[] minus(int[] n, int[] m) {

        n = format(n);
        m = format(m);

        int[] r = new int[n.length];

        // 当前位被借位
        int c = 0;
        int t;
        for (int i = 0; i < m.length; i++) {
            t = n[i] - c - m[i];
            // 当前位够减
            if (t >= 0) {
                r[i] = t;
                // 没有进行借位
                c = 0;
            }
            // 不够减
            else {
                r[i] = t + 10;
                // 进行借位
                c = 1;
            }
        }

        // 还有借位
        for (int i = m.length; c != 0 && i < n.length; i++) {
            t = n[i] - c;
            // 当前位够减
            if (t >= 0) {
                r[i] = t;
                // 没有进行借位
                c = 0;
            }
            // 不够减
            else {
                r[i] = t + 10;
                // 进行借位
                c = 1;
            }
        }

        return format(r);
    }


    /**
     * 将整数字符串表示成整数数组【包含符号位】
     *
     * @param n 整数字符串
     * @return 整数数组 下标从小到大表示数位的从低到高
     */
    private static int[] getNumber(String n) {
        int[] r = new int[n.length()];
        for (int i = 0; i < r.length; i++) {
            r[i] = n.charAt(n.length() - i - 1) - '0';
        }

        return r;
    }

    /**
     * 将整数进行格式化，去掉高位的前导0
     *
     * @param r 整数
     * @return 结果
     */
    private static int[] format(int[] r) {
        int t = r.length - 1;
        // 找最高有效位
        while (t > 0 && r[t] == 0) {
            t--;
        }

        int[] nr = new int[t + 1];
        System.arraycopy(r, 0, nr, 0, nr.length);
        return nr;

    }


    /**
     * 将数组表示的整数转换成字符串
     *
     * @param r 整数
     * @return 字符串表示的整数
     */
    private static String toNumber(int[] r) {
        if (r == null) {
            return null;
        }

        StringBuilder b = new StringBuilder(r.length);

        for (int i = r.length - 1; i >= 0; i--) {
            b.append(r[i]);
        }

        return b.toString();
    }
}
