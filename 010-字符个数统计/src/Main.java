import java.util.Scanner;

/**
 * Author: 王俊超
 * Date: 2015/12/21 17:06
 * All Rights Reserved !!!
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int[] arr = new int[128];
            String input = scanner.nextLine();
            countChar(arr, input);
            System.out.println(countCharNum(arr));
        }

        scanner.close();
    }

    private static void countChar(int[] arr, String input) {
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (c <= 127) {
                arr[c]++;
            }
        }
    }

    private static int countCharNum(int[] arr) {
        int result = 0;
        for (int i : arr) {
            if (i != 0) {
                result++;
            }
        }

        return result;
    }
}
