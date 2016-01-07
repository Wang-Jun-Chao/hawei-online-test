import java.util.Scanner;

/**
 * Author: 王俊超
 * Date: 2016-01-06 15:31
 * All Rights Reserved !!!
 */
public class Main2 {
    public static void main(String[] args) {
        int[][] a = {{3, 8}, {8, 0}};
        int[][] b = {{9, 0}, {18, 9}};

        int x = a.length, y = a[0].length, z = 2;
//        Scanner scanner = new Scanner(System.in);
        Scanner scanner = new Scanner(Main.class.getClassLoader().getResourceAsStream("data.txt"));

        while (scanner.hasNextInt()) {
            x = scanner.nextInt();
            y = scanner.nextInt();
            z = scanner.nextInt();
            a = new int[x][y];
            b = new int[y][z];
            int[][] c = new int[x][z];
            for (int j = 0; j < x; j++) {
                for (int i = 0; i < y; i++) {
                    a[j][i] = scanner.nextInt();
                }
            }

            for (int j = 0; j < y; j++) {
                for (int i = 0; i < z; i++) {
                    b[j][i] = scanner.nextInt();
                }
            }

            MatrixMultiple(a, b, c);
        }
        scanner.close();
    }

    private static void MatrixMultiple(int[][] a, int[][] b, int[][] c) {
        int x = a.length, y = a[0].length, z = c[0].length;

        for (int k = 0; k < z; k++) {
            for (int j = 0; j < x; j++) {
//              int sum = 0;
                for (int i = 0; i < y; i++) {
                    c[j][k] += a[j][i] * b[i][k];
                }
//              c[j][k] = sum;
//              System.out.println(sum);
            }
        }
        printMatrix(c);
    }

    static void printMatrix(int[][] m) {
        for (int j = 0; j < m.length; j++) {
            for (int i = 0; i < m[0].length; i++) {
                if (i == m[0].length - 1)
                    System.out.print(m[j][i]);
                else
                    System.out.print(m[j][i] + " ");
            }
            System.out.println();
        }

    }
}
