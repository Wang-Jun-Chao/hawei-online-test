import java.util.Scanner;

/**
 * Author: 王俊超
 * Date: 2016-01-03 20:44
 * Declaration: All Rights Reserved !!!
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
//        Scanner scanner = new Scanner(Main.class.getClassLoader().getResourceAsStream("data.txt"));
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            System.out.println(findPrime(n));
        }

        scanner.close();
    }

    private static String findPrime(int n) {

        for (int i = n / 2; i >= 2; i--) {
            if (isPrime(i) && isPrime(n - i)) {
                return i + "\n" + (n - i);
            }
        }

        return null;
    }

    private static boolean isPrime(int n) {
        if (n < 2) {
            return false;
        }

        int sqrt = (int) Math.sqrt(n);

        for (int i = 2; i <= sqrt; i++) {
            if (n % i == 0) {
                return false;
            }
        }

        return true;
    }
}
