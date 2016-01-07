import java.util.Scanner;

/**
 * Author: 王俊超
 * Date: 2016-01-06 15:03
 * All Rights Reserved !!!
 */
public class Main2 {
    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
        Scanner sc = new Scanner(Main.class.getClassLoader().getResourceAsStream("data.txt"));
        while (sc.hasNext()) {
            String str = sc.next();
            int leng = sc.nextInt();
            int sum = 0;
            int flag = 0;
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < str.length(); i++) {
                if (sum == leng) {
                    break;
                }
                if (sum > leng) {
                    flag = 1;
                    break;
                }
                if (String.valueOf(str.charAt(i)).getBytes().length == 1) {
                    sum += 1;
                } else {
                    sum += 2;
                }
                sb.append(str.charAt(i));
            }
            if (flag == 1) {
                System.out.println(sb.substring(0, sb.length() - 1));
            } else {
                System.out.println(sb);
            }
        }

    }
}
