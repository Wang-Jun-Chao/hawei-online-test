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

    /**
     * 使用牛顿迭代法求立方根
     * 已知利用牛顿迭代法求方程F（x）=0的解的公式为X[n+1] = X[n] - F(X[n])/F'(X[n]),
     * 其中x[n]为第n次利用此公式求得值。
     * 假如函数F(X) = X^m - a, 则根据牛顿迭代法第n+1次求方程F(x) = 0的解为X[n+1]，
     * 且X[n+1] = (1-1/m)*X[n] +a/(n*X[n]^(m-1))  -  (X[n]*X[n]*X[n]+a)/3*X[n]*X[n]。
     *
     * @param x
     * @return
     */
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
