import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * Author: 王俊超
 * Time: 2016-05-04 19:00
 * CSDN: http://blog.csdn.net/derrantcm
 * Github: https://github.com/Wang-Jun-Chao
 * Declaration: All Rights Reserved !!!
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
//        Scanner scanner = new Scanner(Main.class.getClassLoader().getResourceAsStream("data.txt"));
        while (scanner.hasNext()) {
            int num = scanner.nextInt();
            int[] arr = new int[num * 2];
            for (int i = 0; i < arr.length; i++) {
                arr[i] = scanner.nextInt();
            }
            String rule = scanner.next();
            System.out.println(estimate(arr, rule));


        }
        scanner.close();
    }

    /**
     * 按照法计算乘法的计算量
     *
     * @param arr  矩阵的大小
     * @param rule 计算法则
     * @return 执行乘法的次数
     */
    private static int estimate(int[] arr, String rule) {

        Deque<Integer> stack = new LinkedList<>();
//        Deque<Character> chars = new LinkedList<>();
//
//        StringBuilder builder = new StringBuilder(rule.length());

        int idxArr = 0;
        int idx = 0;
        int result = 0;
        while (idx < rule.length()) {

            char c = rule.charAt(idx);

            // c不是括号
            if (c != '(' && c != ')') {
                // 如果是第一个字符
                if (idx == 0) {
                    stack.addLast(arr[idxArr]);
                    stack.addLast(arr[idxArr + 1]);

                }
                // 不是第一个字符
                else {
                    // 取前一个字符
                    char prev = rule.charAt(idx - 1);
                    // 如果不是括号就要进行计算
                    if (prev != '(' && prev != ')') {
                        // 第一个矩阵的行数和列数
                        int col = stack.removeLast();
                        int row = stack.removeLast();
                        int col2 = arr[idxArr + 1];
                        result += row * col * col2;

                        stack.add(row);
                        stack.add(col2);
                    }
                    // 如果是括号就要添加到栈中
                    else {
                        stack.addLast(arr[idxArr]);
                        stack.addLast(arr[idxArr + 1]);
                    }

                    // 移动到下一个矩阵
                    idxArr += 2;
                }
            }
            // 处理下一个字符
            idx++;
        }


        // 最后stack中只会剩下一个矩阵，只有行和列
        // 要从后向前计算
        while (stack.size() > 2) {
            int col2 = stack.removeLast();
            int row2 = stack.removeLast();
            int col1 = stack.removeLast();
            int row1 = stack.removeLast();
            stack.addLast(row1);
            stack.addLast(col2);
            result += row1 * col1 * col2;
        }

        return result;
    }

}
