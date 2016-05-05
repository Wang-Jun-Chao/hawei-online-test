import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Author: 王俊超
 * Time: 2016-05-05 16:31
 * CSDN: http://blog.csdn.net/derrantcm
 * Github: https://github.com/Wang-Jun-Chao
 * Declaration: All Rights Reserved !!!
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
//        Scanner scanner = new Scanner(Main.class.getClassLoader().getResourceAsStream("data.txt"));
        while (scanner.hasNext()) {

            // 可以被5整除的数的和
            int five = 0;
            // 可以被3整除的数的和，不包括同时可以被5整除的数
            int three = 0;
            List<Integer> list = new ArrayList<>();

            int num = scanner.nextInt();
            for (int i = 0; i < num; i++) {
                int v = scanner.nextInt();

                if (v % 5 == 0) {
                    five += v;
                } else if (v % 3 == 0) {
                    three += 3;
                } else {
                    list.add(v);
                }
            }

            System.out.println(divide(five, three, list));
        }

        scanner.close();
    }

    /**
     * 找出一种方法将list中的元素分成两个部分，分别与m，n相加，得x，y。使得x=y，如果找到这种方法返回true，否则返回false
     *
     * @param m    初始值
     * @param n    初始值
     * @param list 集合
     * @return true可以找对应方法，false无对应方法
     */
    private static boolean divide(int m, int n, List<Integer> list) {

        int other = 0;
        for (int i : list) {
            other += i;
        }

        // 和为偶数才可能划分
        if ((m + n + other) % 2 == 0) {
            // 两个数之间的差
            int diff = Math.abs(m - n);

            // 差与余下数的和相等，则可以划分
            if (diff == other) {
                return true;
            }
            // 差比余下数的和在，则不可以划分
            else if (diff > other) {
                return false;
            } else {
                int sum = (m - n + other) / 2;

                return canFind(list, sum);

            }
        }

        return false;
    }

    /**
     * 在list中能否找到一组数据使用得其和是sum
     *
     * @param list 整数集合
     * @param sum  和
     * @return true：可以找到，false：不可以找到
     */
    private static boolean canFind(List<Integer> list, int sum) {

//        System.out.println(sum + " " + list);

        int count = (int) Math.pow(2, list.size());

        int[] mark = new int[list.size()];

        for (int i = 0; i < count; i++) {
            int val = 0;
            for (int j = 0; j < mark.length; j++) {
                if (mark[j] == 1) {
                    val += list.get(j);
                }
            }

            if (val == sum) {
                return true;
            }

            inc(mark);
        }
        return false;
    }

    /**
     * 二进制加一操作，二进制数用数组表示，从左到右是低位到高位
     *
     * @param mark 等待加一的二进制数组
     */
    private static void inc(int[] mark) {
        int carry;
        int idx = 0;
        do {
            mark[idx]++;
            carry = mark[idx] / 2;
            mark[idx] %= 2;
            idx++;
        } while (carry > 0 && idx < mark.length);
    }
}
