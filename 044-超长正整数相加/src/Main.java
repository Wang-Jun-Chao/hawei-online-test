import java.math.BigInteger;
import java.util.Scanner;

/**
 * Author: 王俊超
 * Date: 2015-12-24 17:18
 * All Rights Reserved !!!
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
//        Scanner scanner = new Scanner(Main.class.getClassLoader().getResourceAsStream("data.txt"));
        while (scanner.hasNext()) {

            // 【1】下面这段代码的运行结果与【2】完全一样就是通不过，不知道为什么
//            String n = scanner.nextLine();
//            String m = scanner.nextLine();
//            System.out.println(add(n, m));


            // 【2】
            BigInteger bi1 = scanner.nextBigInteger();
            BigInteger bi2 = scanner.nextBigInteger();
            System.out.println(bi1.add(bi2));
        }

        scanner.close();
    }

    private static String add(String n, String m) {

        // 较短的字符串的长度
        String min = n.length() <= m.length() ? n : m;
        String max = n.length() > m.length() ? n : m;

        // 较长的字符串
        char[] longer = max.toCharArray();


        int carry = 0;

        // 两个数相加
        for (int i = 1; i <= min.length(); i++) {
            int sum = (carry + longer[longer.length - i] - '0' + min.charAt(min.length() - i) - '0');
            carry = sum / 10;
            longer[longer.length - i] = (char) (sum % 10 + '0');
        }

        // 如果还有进位就要继续相加
        for (int i = longer.length - min.length() - 1; i >= 0 && carry != 0; i--) {
            int sum = (carry + longer[i]  - '0');
            carry = sum / 10;
            longer[i] = (char) (sum % 10 + '0');
        }

        if (carry == 0) {
            return new String(longer);
        } else {
            return "1" + new String(longer);
        }
    }
}
