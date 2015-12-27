import java.util.Scanner;

/**
 * Author: 王俊超
 * Date: 2015-12-24 19:58
 * Declaration: All Rights Reserved !!!
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
//        Scanner scanner = new Scanner(Main.class.getClassLoader().getResourceAsStream("data.txt"));
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            System.out.println(count(n));
        }

        scanner.close();
    }

    private static int count(int n) {

        int result = 0;

        for (int i = 2; i < n; i++) {
            int sum = 1;
            int sqrt = i / 2;
            for (int j = 2; j <= sqrt; j++) {
                if (i % j == 0) {
                    sum += j;
                }
            }

            if (sum == i) {
                result++;
            }
        }

        return result;
    }
}
