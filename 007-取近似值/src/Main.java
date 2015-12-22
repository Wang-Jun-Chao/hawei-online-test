import java.util.Scanner;

/**
 * Author: 王俊超
 * Date: 2015/12/21 16:27
 * All Rights Reserved !!!
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNext()) {
            float input = scanner.nextFloat();
            System.out.println(floatToNearInt(input));
        }

        scanner.close();
    }

    private static int floatToNearInt(float f) {
        return (int) ((f*10 + 5)/10);
    }
}
