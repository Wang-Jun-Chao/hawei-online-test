import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Author: 王俊超
 * Date: 2015-12-25 08:31
 * Declaration: All Rights Reserved !!!
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
//        Scanner scanner = new Scanner(Main.class.getClassLoader().getResourceAsStream("data.txt"));
        while (scanner.hasNext()) {
            String input = scanner.nextLine();
            System.out.println(argAnalysis(input));
        }

        scanner.close();
    }

    /**
     * 分析参数，【还有另外一种方法，就是直接利用数组来处理，可减少时间复杂度和空间复杂度，处理起来会麻烦一些】
     * @param s
     * @return
     */
    private static String argAnalysis(String s) {

        List<String> list = new ArrayList<>();

        // 表示最后一个"出现的下一个位置，如果没有"就为0
        int prev = 0;
        for (int i = 0; i < s.length(); ) {
            // i开始的第一个双引号
            if (s.charAt(i) == '"') {
                // 添加不包双引号的字符串
                list.add(s.substring(prev, i));

                for (int j = i + 1; j < s.length(); j++) {
                    // 开始的第二个双引号
                    if (s.charAt(j) == '"') {
                        list.add(s.substring(i, j + 1));

                        i = j + 1;
                        prev = i;
                    }
                }
            } else {
                i++;
            }
        }

        // 【1】
//        // 表示没有"
//        if (prev == 0) {
//            list.add(s);
//        }
//        // 还有最后一个没有
//        else if (prev < s.length()) {
//            list.add(s.substring(prev, s.length()));
//        }

        // 【2】，【1】【2】实现同样的效果
        if (prev < s.length()) {
            list.add(s.substring(prev, s.length()));
        }

        // 下面处理空格，双引号引起的字符串不作处理
        int result = 0;
        StringBuilder builder = new StringBuilder();
        for (String t : list) {
            // 如果不以"开始
            if (!t.startsWith("\"")) {
                String[] sts = t.split("\\s+");
                result += sts.length;
                for (String st : sts) {
                    builder.append(st).append('\n');
                }
            } else {
                result++;
                builder.append(t).append('\n');
            }
        }

        return result + "\n" + builder.substring(0, builder.length() - 1);
    }
}
