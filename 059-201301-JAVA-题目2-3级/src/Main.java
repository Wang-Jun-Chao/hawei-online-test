import java.util.Arrays;
import java.util.Scanner;

/**
 * Author: 王俊超
 * Date: 2015-12-25 16:31
 * All Rights Reserved !!!
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
//        Scanner scanner = new Scanner(Main.class.getClassLoader().getResourceAsStream("data.txt"));
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            System.out.println(count(n, m));
        }

        scanner.close();
    }

    private static int count(int n, int m) {

        int[][] path = new int[n + 1][m + 1];

        for (int i = 0; i < path[0].length; i++) {
            path[0][i] = 1;
        }

        for (int i = 0; i < path.length; i++) {
            path[i][0] = 1;
        }

        for (int i = 1; i < path.length; i++) {
            for (int j = 1; j < path[0].length; j++) {
                path[i][j] = path[i - 1][j] + path[i][j - 1];
            }
        }

        return path[n][m];
    }
}
