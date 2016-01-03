import java.util.Scanner;

/**
 * Author: 王俊超
 * Date: 2016-01-03 13:58
 * Declaration: All Rights Reserved !!!
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
//        Scanner scanner = new Scanner(Main.class.getClassLoader().getResourceAsStream("data.txt"));
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            System.out.print(serpentineMatrix(n));
        }

        scanner.close();
    }

    /**
     * 蛇形矩阵
     *
     * @param n 矩阵行数
     * @return 矩阵输出结果
     */
    private static String serpentineMatrix(int n) {

        StringBuilder builder = new StringBuilder();


        for (int i = 1; i <= n; i++) {
            // 每一行的第一个元素是(i-1)*i/2+1
            // 每一行的元素个数是n-i
            // 初始间隔是i+1，之后每一个间隔比上一个间隔多1，之后的每个元素是前一个元素加上间隔
            for (int j = 1, start = (i - 1) * i / 2 + 1, step = i + 1; j <= n - i + 1; j++, start += step, step++) {
                builder.append(start).append(' ');
            }

            // 设置换行符
            builder.setCharAt(builder.length()-1, '\n');

        }


        return builder.toString();
    }
}
