import java.util.Scanner;

/**
 * Author: 王俊超
 * Date: 2015-12-24 17:18
 * All Rights Reserved !!!
 */
public class Main {
    public static void main(String[] args) {
        //Scanner scanner = new Scanner(System.in);
        Scanner scanner = new Scanner(Main.class.getClassLoader().getResourceAsStream("data.txt"));
        while (scanner.hasNext()) {
            String n = scanner.nextLine();
            String m = scanner.nextLine();
            System.out.println(add(n, m));
        }

        scanner.close();
    }

    private static String add(String n, String m) {

        char[] x = n.toCharArray();
        char[] y = n.toCharArray();



        int minLen = x.length < y.length ? x.length : y.length;

        int carry = 0;

        for (int i = 1; i <= minLen; i++) {
            int sum = (carry + x[x.length - i] - '0' + y[y.length - i] - '0');
            carry = sum / 10;

        }

        return null;
    }
}
