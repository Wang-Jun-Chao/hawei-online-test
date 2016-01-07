import java.util.Scanner;

/**
 * Author: 王俊超
 * Date: 2016-01-06 14:48
 * All Rights Reserved !!!
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
//        Scanner scanner = new Scanner(Main.class.getClassLoader().getResourceAsStream("data.txt"));
        while (scanner.hasNext()) {
            String input = scanner.next();
            int n = scanner.nextInt();
            System.out.println(getStringByBytes(input, n));
        }

        scanner.close();
    }

    private static String getStringByBytes(String s, int n) {

        StringBuilder builder = new StringBuilder();

        for (int i = 0, prev = 0, b = 0; i < s.length(); i++) {
            char c = s.charAt(i);


            if (c < 128) {
                b++;
            } else {
                b += 2;
            }

            if (b == n) {
                builder.append(s.substring(prev, i + 1)).append('\n');
                prev = i + 1;
                b = 0;
            } else if(b > n){
                builder.append(s.substring(prev, i)).append('\n');
                prev = i;
                b = 0;
            }

        }

        return builder.substring(0, builder.length() - 1);
    }
}
