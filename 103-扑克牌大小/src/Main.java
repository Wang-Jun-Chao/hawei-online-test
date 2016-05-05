import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Author: 王俊超
 * Time: 2016-05-05 14:09
 * CSDN: http://blog.csdn.net/derrantcm
 * Github: https://github.com/Wang-Jun-Chao
 * Declaration: All Rights Reserved !!!
 */
public class Main {

    private static enum Type {
        // 个子
        SINGLE,
        // 对子
        PAIR,
        // 三个
        TRIPLE,
        // 四个
        QUADRUPLE,
        // 顺子
        STRAIGHT,
        // 对王
        JOKER,
        // 错误情况
        ERROR
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
//        Scanner scanner = new Scanner(Main.class.getClassLoader().getResourceAsStream("data.txt"));
        while (scanner.hasNextLine()) {
            String input = scanner.nextLine();
            String[] parts = input.split("-");
            System.out.println(compare(parts[0], parts[1]));
        }
        scanner.close();
    }

    /**
     * 比较两手牌的大小，保证两手牌不相等
     *
     * @param s 第一手牌
     * @param t 第二手牌
     * @return 较大的牌，或者无法比较
     */
    private static String compare(String s, String t) {

        int[] sr = {0};
        int[] tr = {0};

        Type st = getType(s, sr);
        Type tt = getType(t, tr);

        // 谁是王炸谁大
        if (st == Type.JOKER) {
            return s;
        }

        if (tt == Type.JOKER) {
            return t;
        }

        // 两个炸弹
        if (st == Type.QUADRUPLE && tt == Type.QUADRUPLE) {
            if (sr[0] > tr[0]) {
                return s;
            } else if (sr[0] < tr[0]) {
                return t;
            }
        }
        // 只有一个炸弹
        if (st == Type.QUADRUPLE) {
            return s;
        }

        if (tt == Type.QUADRUPLE) {
            return t;
        }

        // 没有王炸和炸弹，相同的才能比较
        if (st == tt) {
            if (sr[0] > tr[0]) {
                return s;
            } else if (sr[0] < tr[0]) {
                return t;
            }
        }


        return "ERROR";
    }

    /**
     * 判断牌的类型，顺子已经从小到大排列
     *
     * @param s 牌
     * @param r 返回牌类型的值
     * @return 类型
     */
    private static Type getType(String s, int[] r) {

        // 判断是不是对王
        if (s.contains("joker") && s.contains("JOKER")) {
            return Type.JOKER;
        }

        // 判断牌的种类
        int kind = 0;
        String[] parts = s.split("(\\s)+");

        Map<String, Integer> map = new HashMap<>();

        for (String str : parts) {
            if (map.containsKey(str)) {
                map.put(str, map.get(str) + 1);
            } else {
                map.put(str, 1);
            }
        }

        // 全部都是个子
        if (map.size() == parts.length) {
            int[] num = convert(parts);

            int max = num[0];
            boolean straight = true;
            for (int i = 1; i < num.length; i++) {
                // 记录个子中的较大的值
                if (max < num[i]) {
                    max = num[i];
                }

                // 判断是否是顺子
                if (num[i] <= num[i - 1]) {
                    straight = false;
                    break;
                }
            }

            // 记录最大值
            r[0] = max;
            // 是顺子（不小于5张牌）
            if (straight && parts.length >= 5) {
                return Type.STRAIGHT;
            } else {
                return Type.SINGLE;
            }
        }
        // 有对子，三个，或者炸弹
        else {
            // 记录是对子，三个，或者炸弹
            int type = 0;
            // 记录牌面值
            int value = 0;

            for (Map.Entry<String, Integer> e : map.entrySet()) {
                // 比type高一阶
                if (e.getValue() > type) {
                    type = e.getValue();
                    value = convert(e.getKey());
                }
                // 同一阶，就记录牌面值较大的
                else if (e.getValue() == type) {
                    int temp = convert(e.getKey());
                    if (temp > value) {
                        value = temp;
                    }
                }

                r[0] = value;

                if (type == 2) {
                    return Type.PAIR;
                } else if (type == 3) {
                    return Type.TRIPLE;
                } else if (type == 4) {
                    return Type.QUADRUPLE;
                }
            }
        }

        return Type.ERROR;
    }

    /**
     * 将一副牌转换成数字
     *
     * @param poke 牌
     * @return 数字
     */
    private static int[] convert(String[] poke) {
        int[] result = new int[poke.length];
        for (int i = 0; i < poke.length; i++) {
            result[i] = convert(poke[i]);
        }

        return result;
    }

    private static int convert(String s) {

        if (s.length() == 1) {
            char c = s.charAt(0);
            if (c >= '3' && c <= '9') {
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
                    return 14;
                case '2':
                    return 15;
                default:
                    // do nothing
            }

        } else {
            switch (s) {
                case "10":
                    return 10;
                case "joker":
                    return Integer.MAX_VALUE - 1;
                case "JOKER":
                    return Integer.MAX_VALUE;
                default:
                    // do nothing
            }
        }

        throw new RuntimeException("输入错误");
    }


}
