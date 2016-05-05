import java.util.Scanner;

/**
 * Author: 王俊超
 * Date: 2016-05-05 10:09
 * CSDN: http://blog.csdn.net/derrantcm
 * Github: https://github.com/Wang-Jun-Chao
 * Declaration: All Rights Reserved !!!
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
//        Scanner scanner = new Scanner(Main.class.getClassLoader().getResourceAsStream("data.txt"));

        while (scanner.hasNext()) {
            int[] arr = new int[10];
            for (int i = 0; i < 10; i++) {
                arr[i] = scanner.nextInt();
            }

            System.out.print(solve(arr));

        }
        scanner.close();
    }

    private static String solve(int[] arr) {
        int[] result = new int[5];

        // 检查行列值
        if (arr[0] < 0 || arr[0] > 9 || arr[1] < 0 || arr[1] > 9) {
            result[0] = -1;
        } else {
            result[0] = 0;
        }

        // 检查交换单元格是否合法
        if (result[0] == 0 && (arr[2] >= 0 && arr[2] < arr[0] && arr[3] >= 0 && arr[3] < arr[1])
                && (arr[4] >= 0 && arr[4] < arr[0] && arr[5] >= 0 && arr[5] < arr[1])) {
            result[1] = 0;
        } else {
            result[1] = -1;
        }

        // 检查插入行是否成功
        if (result[0] == 0 && (arr[6] >= 0 && arr[6] < arr[0])) {
            result[2] = 0;
        } else {
            result[2] = -1;
        }

        // 检查插入列是否成功
        if (result[0] == 0 && (arr[7] >= 0 && arr[7] < arr[1])) {
            result[3] = 0;
        } else {
            result[3] = -1;
        }

        // 检查访问是否成功
        if (result[0] == 0 && (arr[8] >= 0 && arr[8] < arr[0] && arr[9] >= 0 && arr[9] < arr[1])) {
            result[4] = 0;
        } else {
            result[4] = -1;
        }


        StringBuilder b = new StringBuilder();
        for (int i : result) {
            b.append(i).append('\n');
        }

        return b.toString();
    }
}
