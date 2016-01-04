import java.util.Scanner;

/**
 * Author: 王俊超
 * Date: 2016-01-04 09:44
 * Declaration: All Rights Reserved !!!
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
//        Scanner scanner = new Scanner(Main.class.getClassLoader().getResourceAsStream("data.txt"));
        while (scanner.hasNext()) {
            int b = scanner.nextInt();
            System.out.println(countBit(b));
        }

        scanner.close();
    }

    private static int countBit(int b) {
        int max = 0;
        int cur = 0;
        b &= 0xFF;
        for (int i = 0, and = 1; i < 8; i++) {
            // 如果第i位为1
            if ((b & and) != 0) {
                cur++;
                if (cur > max) {
                    max = cur;
                }
            } else {
                cur = 0;
            }

            and <<= 1;
        }

        return max;
    }
}
