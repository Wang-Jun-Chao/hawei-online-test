import java.util.LinkedList;
import java.util.Scanner;

/**
 * Author: 王俊超
 * Date: 2016-05-06 07:35
 * CSDN: http://blog.csdn.net/derrantcm
 * Github: https://github.com/Wang-Jun-Chao
 * Declaration: All Rights Reserved !!!
 */
public class Main {
    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
        Scanner scanner = new Scanner(Main.class.getClassLoader().getResourceAsStream("data2.txt"));
        while (scanner.hasNextLine()) {
            String input = scanner.nextLine();
            System.out.println(solve(input));
        }

        scanner.close();
    }

    /**
     * 进行24点运算，假设输入的牌都是合法的
     *
     * @param input 输入的牌
     * @return 结果
     */
    private static String solve(String input) {

        // 有王
        if (input.contains("joker") || input.contains("JOKER")) {
            return "ERROR";
        }

        String[] parts = input.split("(\\s)+");

        // 不是四个牌
        if (parts.length != 4) {
            return "ERROR";
        }

        int[] ints = new int[parts.length];
        for (int i = 0; i < ints.length; i++) {
            ints[i] = convert(parts[i]);
        }

        String[] r = {""};
        boolean result = point24(ints, r);

        // 有结果
        if (result) {
            return r[0];

        }

        return "ERROR";
    }

    /**
     * 4个[1, 13]的能否通过加减乘除，得到数字为24
     *
     * @param opd 四个元素的数组
     * @param r   用于保存结果
     * @return true，可以组成24，false不可以组成24
     */
    private static boolean point24(int[] opd, String[] r) {

        char[] opt = {'+', '+', '+'};
        char[] all = {'+', '-', '*', '/'};
        return point24(opd, opt, all, 0, r);
    }

    /**
     * @param opd
     * @param opt
     * @param all
     * @param n
     * @param r
     * @return
     */
    private static boolean point24(int[] opd, char[] opt, char[] all, int n, String[] r) {

        // 处理最后一个数字
        if (n == opd.length - 1) {

        } else {
            for (int i = n; i < opd.length; i++) {
                for (int j = 0; j < all.length; j++) {
//                    opd[]
                }
            }
        }


        return false;
    }

    /**
     * 4个[1, 10]的能否通过加减乘除，得到数字为24
     *
     * @param arr    能够使用的操作数、操作符的数组
     * @param used   已经使用的操作数、操作符标记数组
     * @param numCnt 操作数的个数
     * @param optCnt 操作符的个数
     * @param list   求得的逆波兰式
     * @param result 用于保存结果
     * @param rst    保存中间结果，有满足24的就停止计算
     */
    private static void to24(int[] arr, boolean[] used, int numCnt, int optCnt,
                             LinkedList<Integer> list, boolean[] rst, String[] result) {


        // 如果已经找到答案就不进行操作了
        if (rst[0]) {
            return;
        }
        // 已经完成了，计算结果
        if (numCnt == 4 && optCnt == 4) {
            caluclate(list, rst, result);
        }
        // 还要构造逆波兰式
        else if (numCnt > optCnt) {

            for (int i = 0; i < arr.length; i++) {
                // 如果arr[i]还没有被使用过，或者arr[i]是运算符
                if (!used[i] || arr[i] < 0 || arr[i] > 10) {
                    // 如果是数字
                    if (arr[i] >= 0 && arr[i] <= 10) {
                        list.add(arr[i]);
                        numCnt++;
                        used[i] = true;

                        to24(arr, used, numCnt, optCnt, list, rst, result);

                        // 找到了一个答案就返回
                        if (rst[0]) {
                            return;
                        }

                        list.removeLast();
                        numCnt--;
                        used[i] = false;

                    }
                    // 如果是操作符，则放入arr[i]之前，操作数必须比操作符多两个
                    else if (numCnt + 1 > optCnt) {
                        list.add(arr[i]);
                        optCnt++;
                        used[i] = true;

                        to24(arr, used, numCnt, optCnt, list, rst, result);

                        // 找到了一个答案就返回
                        if (rst[0]) {
                            return;
                        }
                        list.removeLast();
                        optCnt--;
                        used[i] = false;
                    }
                }
            }

        }


    }

    /**
     * 计算逆波兰式的值
     *
     * @param list   逆波兰式
     * @param rst    用于保存计算结果
     * @param result 用于保存结果
     */
    private static void caluclate(LinkedList<Integer> list, boolean[] rst, String[] result) {
//        LinkedList<Double> stack = new LinkedList<>();

        System.out.println(list);
        int i = 0;
        double[] opd = new double[4];
        int j = 0;
        int[] opt = new int[3];


        for (int v : list) {

            // 如果是数字
            if (v >= 0 && v < 14) {
                opd[i] = v;
                i++;
            }
            // 如是操作符
            else {
                opt[j] = v;
                j++;

            }
        }

        double v = calculate(opd[0], opd[1], opt[0]);
        v = calculate(v, opd[2], opt[1]);
        v = calculate(v, opd[3], opt[2]);


        rst[0] = v == 24.0;

        if (rst[0]) {

            result[0] = "" + opd[0] + opt[0] + opd[1] + opt[1] + opd[2] + opt[2] + opd[3];

//            Deque<String> s = new LinkedList<>();
//
//            for (int i : list) {
//                // 如果是数字
//                if (i > 0 && i < 14) {
//                    // 将数字转换成牌，再处理
//                    s.addLast(convert(i));
//                    System.out.print(convert(i));
//                }
//                // 如果是运算符
//                else {
//                    String y = s.removeLast();
//                    String x = s.removeLast();
//                    s.addLast(x + ((char) i) + y);
//                    System.out.print((char) i);
//                }
//            }
//
//            System.out.println();
//
//            result[0] = s.removeLast();


        }
    }

    /**
     * 将牌转换成对应的数值
     *
     * @param s 牌
     * @return 数值
     */
    private static int convert(String s) {

        if (s.length() == 1) {
            char c = s.charAt(0);
            if (c >= '1' && c <= '9') {
                return c - '0';
            }

            switch (c) {
                case 'J':
                    return 11;
                case 'Q':
                    return 12;
                case 'K':
                    return 13;
                case 'A':
                    return 1;
                default:
                    // do nothing
            }

        } else {
            switch (s) {
                case "10":
                    return 10;
                default:
                    // do nothing
            }
        }

        return 0;
    }

    /**
     * 将数值转换成牌
     *
     * @param i 数值
     * @return 牌
     */
    private static String convert(int i) {
        if (i >= 2 && i <= 10) {
            return "" + i;
        }

        switch (i) {
            case 1:
                return "A";
            case 11:
                return "J";
            case 12:
                return "Q";
            case 13:
                return "K";
            default:
                // do nothing
        }

        return "0";
    }

    private static double calculate(double a, double b, int opt) {
        switch (opt) {
            case '+':
                return a + b;
            case '-':
                return a - b;
            case '*':
                return a * b;
            case '/':
                return a / b;
            default:
                // do nothing
        }

        throw new RuntimeException("输入错误：" + ((char) opt));
    }

}
