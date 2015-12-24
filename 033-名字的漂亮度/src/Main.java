import java.util.*;

/**
 * Author: 王俊超
 * Date: 2015-12-24 15:26
 * All Rights Reserved !!!
 */
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
//        Scanner scanner = new Scanner(Main.class.getClassLoader().getResourceAsStream("data.txt"));
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            List<String> list = new ArrayList<>();
            while ((--n) >= 0) {
                list.add(scanner.next());
            }
            System.out.print(count(list));
        }

        scanner.close();
    }

    /**
     * 计算字符的最大可能是漂亮度，计算方式为对字符串的数字按出现频率的调到低排序，最高的赋26，下一个赋25，以此类推
     *
     * @param list
     * @return
     */
    private static String count(List<String> list) {


        StringBuilder builder = new StringBuilder();

        for (String s : list) {
            int result = 0;
            int[] seq = new int[26];

            // 统计每个字母出现的次数，不区分大小写
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                // 如果是小写
                if (c >= 'a' && c <= 'z') {
                    seq[c - 'a']++;
                }
                // 大写
                else {
                    seq[c - 'A']++;
                }
            }

            // 按出现的次序从小到大排序
            Arrays.sort(seq);

            // 计算最大漂亮程度
            for (int i = 0; i < seq.length; i++) {
                result += seq[i] * (i + 1);
            }


            builder.append(result).append('\n');
        }

        return builder.toString();
    }
}
