import java.util.Scanner;

/**
 * Author: 王俊超
 * Date: 2015-12-27 16:40
 * Declaration: All Rights Reserved !!!
 */
public class Main {
    public static void main(String[] args) {
        //Scanner scanner = new Scanner(System.in);
        Scanner scanner = new Scanner(Main.class.getClassLoader().getResourceAsStream("data.txt"));
        while (scanner.hasNext()) {
            double d = scanner.nextDouble();
            System.out.println(getCubeRoot(d));
        }

        scanner.close();
    }

    private static double getCubeRoot(double d) {

        // 结果
        double r = 1;

        int M = 100;
        double x_1 = 1;
        double ii = 1;
        double e = 0;

        for (int n = 1; n <= M; n++) {

            x_1 *= (d - 1);
            ii *= ((4.0 / 3.0 - n) / n);
            e = x_1*ii;

            r += e;
        }

        return r;
    }
}
