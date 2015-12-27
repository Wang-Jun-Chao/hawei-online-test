import java.util.Scanner;

/**
 * Author: 王俊超
 * Date: 2015-12-24 20:10
 * Declaration: All Rights Reserved !!!
 */
public class Main {
    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
        Scanner scanner = new Scanner(Main.class.getClassLoader().getResourceAsStream("data.txt"));
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            System.out.println(countSeven(n));
        }

        scanner.close();
    }

    private static int countSeven(int n) {
        int result = 0;

        for (int i = 7; i <= n; i++) {
            if (i % 7 == 0) {
                result++;
            } else {
                // 某个数位上有1
                int m = i;
                while (m != 0) {
                    if (m % 10 == 7) {
                        result++;
                        break;
                    } else {
                        m /= 10;
                    }
                }
            }
        }

        return result;
    }
}
