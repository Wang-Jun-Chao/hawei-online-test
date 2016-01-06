import java.util.Scanner;

/**
 * Author: 王俊超
 * Date: 2016-01-05 17:05
 * All Rights Reserved !!!
 */
public class Main2 {
    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
        Scanner sc = new Scanner(Main.class.getClassLoader().getResourceAsStream("data.txt"));

        while (sc.hasNext()) {
            String str = sc.next();
            String str2 = sc.next();
            StringBuffer sb = new StringBuffer();
            String strx = "";
            for (int i = 0; i < str.length(); i++) {

                if (str.charAt(i) != '.') {
                    strx += str.charAt(i);
                } else {
                    sb.append(Tobin(Integer.toBinaryString(Integer.valueOf(strx))));
                    strx = "";
                }
            }
            sb.append(Tobin(Integer.toBinaryString(Integer.valueOf(strx))));
            System.out.println(Long.parseLong(sb.toString(), 2));

            System.out.println(TobinLong(Long.toBinaryString(Long.valueOf(str2))));

        }
    }

    public static String Tobin(String strA) {
        int len = strA.length();
        String strmx = "";
        if (len == 8) {
            return strA;
        } else {
            for (int i = 0; i < 8 - len; i++) {
                strmx += "0";
            }
        }
        return strmx + strA;
    }


    public static String TobinLong(String strA) {
        int len = strA.length();
        String strmx = "";
        if (len != 32) {
            for (int i = 0; i < 32 - len; i++) {
                strmx += "0";
            }
            strA = strmx + strA;
        }
        StringBuffer sb = new StringBuffer();
        while (strA.length() != 0) {
            sb.append(Integer.valueOf(strA.substring(0, 8), 2) + ".");
            strA = strA.substring(8);
        }
        return sb.substring(0, sb.length() - 1);
    }
}
