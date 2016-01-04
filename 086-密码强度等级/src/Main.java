import java.util.Scanner;

/**
 * Author: 王俊超
 * Date: 2016-01-04 10:08
 * Declaration: All Rights Reserved !!!
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
//        Scanner scanner = new Scanner(Main.class.getClassLoader().getResourceAsStream("data.txt"));
        while (scanner.hasNext()) {
            String s = scanner.nextLine();
            System.out.println(getPwdSecurityLevel(s));
        }

        scanner.close();
    }

    private static String getPwdSecurityLevel(String s) {
        int len = s.length();
        int num = 0;
        int lowerCase = 0;
        int upperCase = 0;
        int ch = 0;
        int score = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c >= '0' && c <= '9') {
                num++;
            } else if (c >= 'A' && c <= 'Z') {
                upperCase++;
            } else if (c >= 'a' && c <= 'z') {
                lowerCase++;
            } else if (c >= 0x21 && c <= 0x2F || c >= 0x3A && c <= 0x40
                    || c >= 0X5B && c <= 0x60 || c >= 0x7B && c <= 0x7E) {
                ch++;
            }
        }

        // 一、密码长度
        if (len <= 4) {
            score += 5;
        } else if (len <= 7) {
            score += 10;
        } else {
            score += 25;
        }

        // 二、字母
        if (lowerCase > 0) {
            score += 10;
        }

        if (upperCase > 0) {
            score += 10;
        }

        // 三、数字
        if (num == 1) {
            score += 10;
        } else if (num > 1) {
            score += 20;
        }

        // 四、符号
        if (ch == 1) {
            score += 10;
        } else if (ch > 1) {
            score += 25;
        }

        if (num > 0 && (upperCase > 0 || lowerCase > 0)) {
            score += 2;
            if (ch > 0) {
                score += 1;

                if (upperCase > 0 && lowerCase > 0) {
                    score += 2;
                }
            }
        }

        if (score >= 90) {
            return "VERY_SECURE";
        } else if (score >= 80) {
            return "SECURE";
        } else if (score >= 70) {
            return "VERY_STRONG";
        } else if (score > 60) {
            return "STRONG";
        } else if (score >= 50) {
            return "AVERAGE";
        } else if (score >= 25) {
            return "WEAK";
        } else {
            return "VERY_WEAK";
        }
    }
}
