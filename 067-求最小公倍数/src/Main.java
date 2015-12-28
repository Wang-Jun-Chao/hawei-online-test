import java.util.Scanner;

/**
 * Author: 王俊超
 * Date: 2015-12-28 13:51
 * All Rights Reserved !!!
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
//        Scanner scanner = new Scanner(Main.class.getClassLoader().getResourceAsStream("data.txt"));
        while (scanner.hasNext()) {
            int m = scanner.nextInt();
            int n = scanner.nextInt();

            System.out.println(m / gcd(m, n) * n);
        }

        scanner.close();
    }

    private static int gcd(int max, int min) {
        int tmp;
        if (max < min) {
            tmp = max;
            max = min;
            min = tmp;
        }

        while (max % min != 0) {
            tmp = min;
            min = max % min;
            max = tmp;
        }

        return min;
    }
}
