import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
/**
 * Author: 王俊超
 * Date: 2016-01-04 14:55
 * All Rights Reserved !!!
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
//        Scanner scanner = new Scanner(Main.class.getClassLoader().getResourceAsStream("data.txt"));
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            String[] names = new String[n + 1];
            Map<String, Integer> map = new HashMap<>(n);

            for (int i = 0; i < n; i++) {
                names[i] = scanner.next();
                map.put(names[i], 0);
            }


            names[n] = "Invalid";
            map.put(names[n], 0);

            int v = scanner.nextInt();

            while ((--v) >= 0) {
                String s = scanner.next();
                if (map.containsKey(s)) {
                    map.put(s, map.get(s) + 1);
                } else {
                    map.put(names[n], map.get(names[n]) + 1);
                }
            }

            StringBuilder builder = new StringBuilder();
            for (String s: names                 ) {
                builder.append(s).append(" : ").append(map.get(s)).append('\n');
            }

            System.out.print(builder.toString());

        }

        scanner.close();
    }
}
