import java.util.Scanner;

/**
 * Author: 王俊超
 * Date: 2015-12-27 16:40
 * Declaration: All Rights Reserved !!!
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
//        Scanner scanner = new Scanner(Main.class.getClassLoader().getResourceAsStream("data.txt"));
        while (scanner.hasNext()) {
            double d = scanner.nextDouble();
            System.out.printf("%.1f", getCubeRoot(d));
        }

        scanner.close();
    }

    private static double getCubeRoot(double x) {

        double x0;
        double x1 = x;
        do {
            x0 = x1;
            x1 = 2.0 / 3.0 * x0 + x / 3.0 / (x0 * x0);
        } while (Math.abs(x1 - x0) > 0.000001);

        return x1;
    }
}
