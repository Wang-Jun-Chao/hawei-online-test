import java.util.Scanner;

/**
 * Author: 王俊超
 * Date: 2015-12-25 09:04
 * Declaration: All Rights Reserved !!!
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
//        Scanner scanner = new Scanner(Main.class.getClassLoader().getResourceAsStream("data.txt"));
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            System.out.println(getSequeOddNum(n));
        }

        scanner.close();
    }

    /**
     * n个连续奇数之和
     * 简单说明：
     * 如果n是奇数，则从n^2-(n-1),n^2-(n-3)...n^2-(2),n^2-(0),n^2+(2)...n^2+(n-3),n^2+(n-1) 一共有n个数，和为n^3
     * 如果n是偶数，则从n^2-(n-1),n^2-(n-3)...n^2-(1),n^2+(1)...n^2+(n-3),n^2+(n-1) 一共有n个数，和为n^3
     *
     * @param n
     * @return
     */
    private static String getSequeOddNum(int n) {

        int lo = n * n - (n - 1);
        int hi = n * n + (n - 1);

        StringBuilder builder = new StringBuilder();
        for (int i = lo; i <= hi; i += 2) {
            builder.append(i).append('+');
        }

        return builder.substring(0, builder.length() - 1);
    }
}
