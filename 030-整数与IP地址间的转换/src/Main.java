import java.util.Scanner;

/**
 * Author: 王俊超
 * Date: 2015-12-24 13:55
 * All Rights Reserved !!!
 */
public class Main {
    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
        Scanner scanner = new Scanner(Main.class.getClassLoader().getResourceAsStream("data.txt"));
        while (scanner.hasNext()) {
            String s = scanner.next();
            int i = scanner.nextInt();


//            System.out.println(s + "\n" + i);
            System.out.println(ipToInt(s));
            System.out.println(intToIP(i));
        }

        scanner.close();
    }

    private static int ipToInt(String s) {

        int result = 0;

        String[] part = s.split("\\.");

        for (int i = 0; i < part.length; i++) {
            result += Integer.parseInt(part[i]) << (24 - 8 * i);
        }


        return result;
    }

    private static String intToIP(int n) {
        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < 4; i++) {
            int r = (n & (0xFF << (24 - 8 * i))) >> (24 - 8 * i);
            builder.append(r).append('.');
        }

        return builder.substring(0, builder.length() - 1);
    }
}
