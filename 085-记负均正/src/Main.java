import java.util.Scanner;

/**
 * Author: 王俊超
 * Date: 2016-01-04 10:00
 * Declaration: All Rights Reserved !!!
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
//        Scanner scanner = new Scanner(Main.class.getClassLoader().getResourceAsStream("data.txt"));
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int ne = 0;
            double sum = 0;
            int nne = 0;

            while ((--n) >= 0) {
                int t = scanner.nextInt();
                if (t < 0) {
                    ne++;
                } else if (t > 0) {
                    sum += t;
                    nne++;
                }
            }

            System.out.printf("%d %.1f\n", ne, sum / nne);
        }

        scanner.close();
    }
}
