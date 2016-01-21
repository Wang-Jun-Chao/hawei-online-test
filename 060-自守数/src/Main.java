import java.util.Scanner;

/**
 * Author: 王俊超
 * Date: 2015-12-25 16:51
 * All Rights Reserved !!!
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
//        Scanner scanner = new Scanner(Main.class.getClassLoader().getResourceAsStream("data.txt"));
            while (scanner.hasNext()) {
            int n = scanner.nextInt();
            System.out.println(calcAutomorphicNumbers(n));
        }

        scanner.close();
    }

    private static int calcAutomorphicNumbers(int n) {

        int result = 0;

        for (int i = 0; i <= n; i++) {
            if (isAutomorphicNumber(i)) {
                result++;
            }
        }


        return result;
    }

    private static boolean isAutomorphicNumber(int n) {

        int s = n * n;

        while (n != 0) {
            if (s % 10 == n % 10) {
                s /= 10;
                n /= 10;
            } else {
                return false;
            }
        }

        return true;
    }
}
