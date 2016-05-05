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
        while (scanner.hasNext()) {
            String input = scanner.next();
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
            } else {
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

        // 没有王炸和炸弹



        return null;
    }

    /**
     * 判断牌的类型，一手牌最多5个
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
        if (map.size() == 5) {
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
            // 是顺子
            if (straight) {
                return Type.STRAIGHT;
            } else {
                return Type.SINGLE;
            }


        }
        // 有一对
        else if (map.size() == 4) {
            for (Map.Entry<String, Integer> e : map.entrySet()) {
                if (e.getValue() == 2) {
                    r[0] = convert(e.getKey());
                    break;
                }
            }

            return Type.PAIR;
        }
        // 有两对，或者三个带两个单牌
        else if (map.size() == 3) {
            int v = 0;
            for (Map.Entry<String, Integer> e : map.entrySet()) {
                if (e.getValue() == 3) {
                    r[0] = convert(e.getKey());
                    // 三个
                    return Type.TRIPLE;
                } else if (e.getValue() == 2) {
                    int i = convert(e.getKey());
                    if (i > v) {
                        v = i;
                    }
                }
            }

            // 说明是两对
            r[0] = v;
            return Type.PAIR;

        }
        // 有炸弹或者三个带一双
        else if (map.size() == 2) {
            int v = 0;
            for (Map.Entry<String, Integer> e : map.entrySet()) {
                // 炸弹
                if (e.getValue() == 4) {
                    r[0] = convert(e.getKey());

                    return Type.QUADRUPLE;
                }
                // 三个带一双
                else if (e.getValue() == 3) {
                    r[0] = convert(e.getKey());
                    return Type.TRIPLE;
                }
            }
        }

        // 其它情况，安排理说没有这个，但是从程序上执行需要
        return Type.ERROR;
    }

//    /**
//     * 查找记录中是否存在指定的值
//     *
//     * @param record 记录的集合
//     * @param s      要查找的值
//     * @param len    查找的最大的索引
//     * @return 查找到的索引，没有找到就返回
//     */
//    private int contain(int[] record, String s, int len) {
//        // 如果是小王
//        if (s.equals("joker")) {
//            int v = Integer.MAX_VALUE - 1;
//            for (int i = 1; i < len * 2; i++) {
//
//            }
//        }
//        // 如果是大王
//        else if (s.equals("JOKER")) {
//
//        }
//        // 如果是其它的值
//        else {
//
//        }
//
//    }

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

    /**
     * 将数字转换成牌面值
     *
     * @param i 数字
     * @return 牌面值
     */
    private static String convert(int i) {
        switch (i) {
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
                return "" + i;
            case 11:
                return "J";
            case 12:
                return "Q";
            case 13:
                return "K";
            case 14:
                return "A";
            case 15:
                return "2";
            case Integer.MAX_VALUE - 1:
                return "joker";
            case Integer.MAX_VALUE:
                return "JOKER";
        }

        throw new RuntimeException("输入错误");
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
