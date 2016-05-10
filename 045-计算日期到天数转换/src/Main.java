import java.util.Scanner;

/**
 * Author: 王俊超
 * Date: 2015-12-24 21:46
 * Declaration: All Rights Reserved !!!
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
//        Scanner scanner = new Scanner(Main.class.getClassLoader().getResourceAsStream("data.txt"));
        while (scanner.hasNext()) {
            int year = scanner.nextInt();
            int month = scanner.nextInt();
            int day = scanner.nextInt();

            System.out.println(calculate(year, month, day));
        }

        scanner.close();
    }

    private static int calculate(int year, int month, int day) {

        int[] dayOfMonth = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        // 如果是闰年
        if (year % 4 == 0 && year % 100 != 0 || year % 400 == 0) {
            dayOfMonth[1] = 29;
        }

        if (month < 1 || month > 12 || day < 1 || day > dayOfMonth[month - 1]) {
            return -1;
        }


        for (int i = 0; i < month - 1; i++) {
            day += dayOfMonth[i];
        }

        return day;
    }
}
