import java.util.Scanner;

/**
 * Author: 王俊超
 * Date: 2015-12-27 16:30
 * Declaration: All Rights Reserved !!!
 */
public class Main {
    public static void main(String[] args) {
        //Scanner scanner = new Scanner(System.in);
        Scanner scanner = new Scanner(Main.class.getClassLoader().getResourceAsStream("data.txt"));

        // 记数负数的个数
        int m = 0;

        int n = 0;
        double avg = 0;

        while (scanner.hasNext()) {
            int i = scanner.nextInt();

            if (i < 0) {
                m++;
            } else if (i > 0) {
                avg += i;
                n++;
            }
        }
        scanner.close();

        System.out.printf("%d\n%g", m, (n == 0 ? 0 : avg / n));
    }
}
