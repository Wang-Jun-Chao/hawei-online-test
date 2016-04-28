import java.util.Scanner;

/**
 * Author: 王俊超
 * Date: 2015-12-24 13:55
 * All Rights Reserved !!!
 */
public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String str = "";

        while (scanner.hasNext()) {
            str = scanner.next();
            if (str.contains(".")) {
                System.out.println(ipToInt(str));
            } else {
                System.out.println(intToIp(str));
            }
        }

        scanner.close();
    }

    private static String intToIp(String str) {
        String result = "";
        Long input = Long.parseLong(str);
        for (int i = 3; i >= 0; i--) {
            result = (input & 0x000000FF) + "." + result;
            input >>>= 8;
        }
        return result.substring(0, result.length() - 1);
    }

    private static long ipToInt(String str) {
        String[] array;
        long result = 0;
        array = str.split("[.]");
        for (String s : array) {
            result = (result << 8) + Integer.parseInt(s);
        }
        return result;
    }

}
