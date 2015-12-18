import java.util.Scanner;

/**
 * Author: 王俊超
 * Date: 2015-12-18 10:40
 * Declaration: All Rigths Reserved !!!
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 是否还有其它的行，一次可以测试多行
        while (scanner.hasNext()) {
            String input = scanner.nextLine();
            System.out.println(findLastWordLength(input));
        }

        scanner.close();
    }

    public static int findLastWordLength(String input) {
        // 最后一个字母的位置
        int last = input.length() - 1;

        // 找最后一个字母出现的位置
        while (last >= 0 && input.charAt(last) == ' '){
            last--;
        }

        // 找最后一个字母之前的第一个空白字符
        int pos = last - 1;
        while (pos >= 0 && input.charAt(pos) != ' '){
            pos--;
        }

        return last - pos;
    }
}
