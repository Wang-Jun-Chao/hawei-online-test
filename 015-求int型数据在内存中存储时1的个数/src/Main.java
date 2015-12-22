import java.util.Scanner;

/**
 * Author: 王俊超
 * Date: 2015/12/22 14:25
 * All Rights Reserved !!!
 */
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNext()) {
            int input = scanner.nextInt();
            System.out.println(countOnes(input));
        }

        scanner.close();
    }

    private static int countOnes(int input) {
        int result = 0;

        while (input != 0) {
           result += input & 1;
            input >>>= 1;
        }

        return result;
    }
}
