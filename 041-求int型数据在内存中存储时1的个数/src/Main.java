import java.util.Scanner;

/**
 * Author: 王俊超
 * Date: 2015-12-24 20:20
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
        while (n != 0) {
            result += n & 1;
            n >>>= 1;
        }

        return result;
    }
}
