import java.util.Scanner;

/**
 * Author: 王俊超
 * Date: 2015-12-23 10:52
 * Declaration: All Rights Reserved !!!
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
//        Scanner scanner = new Scanner(Main.class.getClassLoader().getResourceAsStream("data.txt"));
        int num;
        while (scanner.hasNextInt() && (num = scanner.nextInt()) != 0) {
            System.out.println(bottle(num));
        }
        scanner.close();
    }

    private static int bottle(int num) {
        final int BASE = 3;

        if (num < BASE - 1 ) {
            return 0;
        }

        int result = 0;


        while (num > BASE - 1) {
            // 本次喝的饮料数
            int drink = num / BASE;
            // 总共喝的饮料
            result += drink;
            // 手上目前有的瓶子
            num = num % BASE + drink;
        }

        if (num == BASE - 1) {
            // 如果还有两个瓶子，那就可以再向老板借一瓶，喝完就有三个瓶子
            // 又可以换一瓶，又多喝了一瓶
            result++;
        }

        return result;
    }
}
