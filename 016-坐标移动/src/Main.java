import java.util.Scanner;

/**
 * Author: 王俊超
 * Date: 2015/12/22 15:24
 * All Rights Reserved !!!
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
//        Scanner scanner = new Scanner(Main.class.getClassLoader().getResourceAsStream("data.txt"));
        while (scanner.hasNext()) {
            String input = scanner.nextLine();
            System.out.println(move(input));
        }

        scanner.close();
    }

    private static String move(String input) {
        String[] steps = input.split(";");
        int[] result = new int[2];

        for (String step : steps) {
            move(step, result);
        }


        return result[0] + "," + result[1];
    }

    private static void move(String input, int[] result) {

        if (input.matches("(A|D|W|S)[0-9]{1,2}")) {
            // 方向
            char direction = input.charAt(0);
            // 步数
            int step = Integer.parseInt(input.substring(1));
            switch (direction) {
                case 'A':
                    result[0] -= step;
                    break;
                case 'D':
                    result[0] += step;
                    break;
                case 'W':
                    result[1] += step;
                    break;
                case 'S':
                    result[1] -= step;
                    break;
            }
        }
    }
}
