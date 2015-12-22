import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

/**
 * Author: 王俊超
 * Date: 2015-12-22 19:10
 * Declaration: All Rights Reserved !!!
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            // 读取输入的数字数
            int num = scanner.nextInt();
            // 存放输入的数字
            Set<Integer> set = new TreeSet<>();
            while ((--num) >= 0) {
                set.add(scanner.nextInt());
            }

            System.out.print(setToString(set));
        }
    }

    private static String setToString(Set<Integer> set) {
        StringBuilder builder = new StringBuilder(128);
        for (Integer i : set) {
            builder.append(i).append("\n");
        }

        return builder.toString();
    }
}
