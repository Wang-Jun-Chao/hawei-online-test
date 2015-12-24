import java.util.Scanner;

/**
 * Author: 王俊超
 * Date: 2015-12-24 14:13
 * All Rights Reserved !!!
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
//        Scanner scanner = new Scanner(Main.class.getClassLoader().getResourceAsStream("data.txt"));
        while (scanner.hasNext()) {
            double h = scanner.nextDouble();
            System.out.printf("%g\n", getJourney(h));
            System.out.printf("%g\n", getTenthHigh(h));
        }

        scanner.close();
    }

    private static double getTenthHigh(double h) {
        return h / 32;
    }

    private static double getJourney(double h) {

        double up = (Math.pow(0.5, 4) - 1) / (0.5 - 1);
        double down = (Math.pow(0.5, 5) - 1) / (0.5 - 1);

        return h * 0.5 * up + h * down;
    }
}
