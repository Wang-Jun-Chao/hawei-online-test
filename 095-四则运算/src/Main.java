import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * Author: 王俊超
 * Time: 2016-05-03 15:32
 * CSDN: http://blog.csdn.net/derrantcm
 * Github: https://github.com/Wang-Jun-Chao
 * Declaration: All Rights Reserved !!!
 */
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
//        Scanner scanner = new Scanner(Main.class.getClassLoader().getResourceAsStream("data.txt"));
        while (scanner.hasNext()) {
            String input = scanner.next();
            input = format(input);
            System.out.println(calculate(input));
        }

        scanner.close();
    }

    /**
     * 进行四则运行
     *
     * @param s 输入一个算术表达式
     * @return 表达式结果
     */
    private static int calculate(String s) {

        // 操作符栈
        Deque<Character> opts = new LinkedList<>();
        // 操作数栈
        Deque<Integer> opds = new LinkedList<>();

        int idx = 0;
        while (idx < s.length()) {
            char c = s.charAt(idx);
            // 如果是数字
            if (c >= '0' && c <= '9') {
                // 计算数字的值
                int opd = 0;
                while (idx < s.length() && s.charAt(idx) >= '0' && s.charAt(idx) <= '9') {
                    opd = opd * 10 + (s.charAt(idx) - '0');
                    idx++;
                }
                opds.addLast(opd);
            }
            // 如果是操作符
            else {



                // 如果是左括号
                if (c == '(' || c == '[' || c == '{') {
                    opts.addLast(c);
                }
                // 如果是右括号
                else if (c == ')' || c == ']' || c == '}') {
                    while (!opts.isEmpty() && opts.getLast() != '(' && opts.getLast() != '[' && opts.getLast() != '{') {
                        calculate(opts, opds);
                    }
                    opts.removeLast();
                }
                // 如果是乘或者除
                else if (c == '*' || c == '/') {
                    while (!opts.isEmpty() && (opts.getLast() == '*' || opts.getLast() == '/')) {
                        calculate(opts, opds);
                    }
                    // 操作符入栈
                    opts.addLast(c);
                } else if (c == '+' || c == '-') {
                    while (!opts.isEmpty() && (opts.getLast() == '*'
                            || opts.getLast() == '/'
                            || opts.getLast() == '+'
                            || opts.getLast() == '-')) {
                        calculate(opts, opds);
                    }
                    // 操作符入栈
                    opts.addLast(c);
                }

                // 处理下一个字符
                idx++;
            }


        }

        while (!opts.isEmpty()) {
            calculate(opts, opds);
        }
        return opds.removeLast();
    }

    /**
     * 求值操作，取opt的最后一个操作符，opds中的最后两个操作数
     *
     * @param opts 操作符栈
     * @param opds 操作数栈
     */
    private static void calculate(Deque<Character> opts, Deque<Integer> opds) {

        // 取操作数栈中的最后一个操作符
        char opt = opts.removeLast();
        // 取操作数
        int v2 = opds.removeLast();
        int v1 = opds.removeLast();

        // 计算
        int v = calculate(v1, v2, opt);
        opds.addLast(v);
    }

    /**
     * 将算术表达式归整，-5*3整理成0-5*3
     *
     * @param s 算术表达式
     * @return 归整后的表达式
     */
    private static String format(String s) {
        // 去掉空格
        String t = s.replaceAll("(\\s)+", "");

        int idx = 0;
        // 对所有的减号进行处理
        while ((idx = t.indexOf('-', idx)) >= 0) {
            // 第一个字符是负号，要规格形式要加上0
            if (idx == 0) {
                t = '0' + t;
            }
            // 如果不是第一个字符
            else {
                char c = t.charAt(idx - 1);
                // 负号前面有括号，需要在前面加0
                if (c == '(' || c == '[' || c == '{') {
                    t = t.substring(0, idx) + '0' + t.substring(idx);
                }
            }

            idx++;
        }

        return t;
    }

    /**
     * 计算 v1 operator v2，operator是加减乘除
     *
     * @param v1       操作数1
     * @param v2       操作数2
     * @param operator 操作符
     * @return 结果
     */
    private static int calculate(int v1, int v2, char operator) {
        switch (operator) {
            case '+':
                return v1 + v2;
            case '-':
                return v1 - v2;
            case '*':
                return v1 * v2;
            case '/':
                return v1 / v2;
            default:
                // do nothing
        }
        return 0;
    }
}
