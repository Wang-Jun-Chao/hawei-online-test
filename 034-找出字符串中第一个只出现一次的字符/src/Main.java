import java.util.*;

/**
 * Author: 王俊超
 * Date: 2015-12-24 15:59
 * All Rights Reserved !!!
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
//        Scanner scanner = new Scanner(Main.class.getClassLoader().getResourceAsStream("data.txt"));
        while (scanner.hasNext()) {
            String input = scanner.nextLine();
            System.out.println(findFirst(input));
        }

        scanner.close();
    }

    private static char findFirst(String s) {

        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            // 如果已经出现过就标记为无效
            if (map.containsKey(c)) {
                map.put(c, Integer.MAX_VALUE);
            } else {
                // 标记第一次出现的下标
                map.put(c, i);
            }
        }


        Collection<Integer> set = map.values();
        int min = Integer.MAX_VALUE;
        // 找最小的下标
        for (int i : set) {
            if (min > i) {
                min = i;
            }
        }

        return min == Integer.MAX_VALUE ? '.' : s.charAt(min);
    }
}
