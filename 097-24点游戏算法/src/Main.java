import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * Author: 王俊超
 * Date: 2016-05-04 12:09
 * CSDN: http://blog.csdn.net/derrantcm
 * Github: https://github.com/Wang-Jun-Chao
 * Declaration: All Rights Reserved !!!
 */
public class Main {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
//        Scanner scanner = new Scanner(Main.class.getClassLoader().getResourceAsStream("data.txt"));
        while (scanner.hasNext()) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            int c = scanner.nextInt();
            int d = scanner.nextInt();

            System.out.println(game24Points(a, b, c, d));

        }
        scanner.close();
    }

    // a, b, c, d都在[1, 10]内

    /**
     * 4个[1, 10]的能否通过加减乘除，得到数字为24
     *
     * @param a 第一个数字
     * @param b 第二个数字
     * @param c 第三个数字
     * @param d 第四个数字
     * @return true，可以组成24，false不可以组成24
     */
    private static boolean game24Points(int a, int b, int c, int d) {
        int[] arr = {a, b, c, d, '+', '-', '*', '/'};
        boolean[] used = new boolean[arr.length];
        LinkedList<Integer> list = new LinkedList<Integer>();

        boolean[] rst = {false};

        // 构造组合的逆波兰表达式
        for (int i = 0; i < 4; i++) {
            used[i] = true;
            list.add(arr[i]);
            to24(arr, used, 1, 0, list, rst);

            if (rst[0]) {
                return true;
            }

            // 现场还原
            list.removeLast();
            used[i] = false;
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
     * @param rst    保存中间结果，有满足24的就停止计算
     */
    private static void to24(int[] arr, boolean[] used, int numCnt, int optCnt,
                             LinkedList<Integer> list, boolean[] rst) {


        // 如果已经找到答案就不进行操作了
        if (rst[0]) {
            return;
        }
        // 已经完成了逆波兰式的构造
        if (numCnt > optCnt && numCnt + optCnt == 7) {
            calInversePoland(list, rst);
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

                        to24(arr, used, numCnt, optCnt, list, rst);

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

                        to24(arr, used, numCnt, optCnt, list, rst);

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
     * @param list 逆波兰式
     * @param rst  用于保存计算结果
     */
    private static void calInversePoland(LinkedList<Integer> list, boolean[] rst) {
        LinkedList<Double> stack = new LinkedList<>();

        for (int v : list) {

            // 如果是数字
            if (v >= 0 && v <= 10) {
                stack.add((double)v);
            } else {
                double a = stack.removeLast();
                double b = stack.removeLast();
                double c = 0;
                switch ((char) v) {
                    case '+':
                        c = a + b;
                        break;
                    case '-':
                        c = a - b;
                        break;
                    case '*':
                        c = a * b;
                        break;
                    case '/':
                        // 除数不能为0
                        if (a == 0) {
                            return;
                        }
                        c = b / a;
                        break;
                }

                stack.add(c);
            }
        }



        rst[0] = stack.getFirst() == 24.0;
    }

}
