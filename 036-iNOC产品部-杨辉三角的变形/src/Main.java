import java.util.Arrays;
import java.util.Scanner;

/**
 * Author: 王俊超
 * Date: 2015-12-24 16:41
 * All Rights Reserved !!!
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
//        Scanner scanner = new Scanner(Main.class.getClassLoader().getResourceAsStream("data.txt"));
        while (scanner.hasNext()) {
            int input = scanner.nextInt();
            System.out.println(findIndex(input));
        }

        scanner.close();
    }

    private static int findIndex(int n) {
        if (n <= 2) {
            return -1;
        }
        int[][] arr = {new int[2 * n - 1], new int[2 * n - 1], new int[2 * n - 1]};

        arr[0][0] = 1;
        arr[1][0] = 1;
        arr[1][1] = 1;
        arr[1][2] = 1;

        for (int i = 2; i < n; i++) {
            int curr = i % 3;
            int prev = (i - 1) % 3;

            int last = 2 * i; // 最后一个下标

            arr[curr][0] = 1; // 设置第一个值
            arr[curr][1] = i; // 设置第二个值
            arr[curr][last] = 1; // 设置倒数第一个值
            arr[curr][last - 1] = i; // 设置倒数第二个值

            for (int j = 2; j <= last - 2; j++) {
                arr[curr][j] = arr[prev][j - 2] + arr[prev][j - 1] + arr[prev][j];
            }
        }

        int curr = (n - 1) % 3;

        for (int i = 0; i < arr[curr].length; i++) {
            if (arr[curr][i] % 2 == 0) {
                return i + 1;
            }
        }

        return -1;
    }
}
