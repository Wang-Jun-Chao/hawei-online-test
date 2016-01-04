import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * Author: 王俊超
 * Date: 2016-01-03 19:07
 * Declaration: All Rights Reserved !!!
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
//        Scanner scanner = new Scanner(Main.class.getClassLoader().getResourceAsStream("data.txt"));
        while (scanner.hasNext()) {
            int row = scanner.nextInt();
            int col = scanner.nextInt();
            int[][] matrix = new int[row][col];
            for (int i = 0; i < row * col; i++) {
                matrix[i / col][i % col] = scanner.nextInt();
            }

            System.out.print(mazeWayfinding(matrix));
        }

        scanner.close();
    }

    private static String mazeWayfinding(int[][] matrix) {
        List<String> result = new ArrayList<>();
        boolean[][] visited = new boolean[matrix.length][matrix[0].length];
        boolean[] find = new boolean[1];
        wayfinding(matrix, 0, 0, visited, find, result);

        StringBuilder builder = new StringBuilder();
        for (String s : result) {
            builder.append(s).append('\n');
        }

//        return builder.substring(0, builder.length() - 1);
        return builder.toString();
    }

    /**
     * 找迷宫路径
     *
     * @param matrix  迷宫
     * @param x       当前的行号
     * @param y       当前的列号
     * @param visited 标记某个位置是否被访问过了
     * @param find    是否已经找到
     * @param result  路径标识
     */
    private static void wayfinding(int[][] matrix, int x, int y, boolean[][] visited, boolean[] find, List<String> result) {
        // 如果已经找到
        if (find[0]) {
            return;
        }

        // 位置超出了迷宫或者当前不置不可走，或者已经被访问过了
        if (x < 0 || x >= matrix.length || y < 0 || y >= matrix[0].length
                || matrix[x][y] == 1 || visited[x][y]) {
            return;
        }

        // 到达终点
        // 如果已经到达右下角，并且右下角的位置可以走
        if (x == matrix.length - 1 && y == matrix[0].length - 1 && matrix[x][y] == 0) {
            find[0] = true;
            visited[x][y] = true;
            // 添加坐标的
            result.add("(" + x + "," + y + ")");
        }
        // 末到终点
        else {
            // 标记坐标为(x, y)位置已经被访问过了
            visited[x][y] = true;
            result.add("(" + x + "," + y + ")");

            // 向前走
            wayfinding(matrix, x, y + 1, visited, find, result);
            // 如果已经找到就结束
            if (find[0]) {
                return;
            }

            // 向上走
            wayfinding(matrix, x - 1, y, visited, find, result);
            // 如果已经找到就结束
            if (find[0]) {
                return;
            }

            // 向后走
            wayfinding(matrix, x, y - 1, visited, find, result);
            // 如果已经找到就结束
            if (find[0]) {
                return;
            }

            // 向下走
            wayfinding(matrix, x + 1, y, visited, find, result);
            // 如果已经找到就结束
            if (find[0]) {
                return;
            }

            // 还原
            visited[x][y] = false;
            result.remove(result.size() - 1);
        }


    }
}
