import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * Author: 王俊超
 * Date: 2016-01-05 16:16
 * All Rights Reserved !!!
 */
public class Main2 {
    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
        Scanner sc = new Scanner(Main.class.getClassLoader().getResourceAsStream("data.txt"));
        while (sc.hasNext()) {
            int n = sc.nextInt();
            String[] input = new String[n];
            for (int i = 0; i < n; i++) {
                input[i] = sc.next();
            }
            String rs = "";
            String goal = sc.next();
            int m = sc.nextInt();
            int count = 0;
            ArrayList<String> arrayList = new ArrayList<String>();
            for (int i = 0; i < input.length; i++) {
                if (input[i].length() == goal.length() && !input[i].equals(goal)) {
                    if (Equle(input[i], goal)) {
                        count++;
                        arrayList.add(input[i]);
                    }
                }
            }
            Collections.sort(arrayList);

            System.out.println(arrayList);

            System.out.println(count);
            if (arrayList.size() >= m) {
                System.out.println(arrayList.get(m - 1));
            }
        }
    }

    public static boolean Equle(String strA, String StrB) {
        int[] A = new int[26];
        int[] B = new int[26];
        for (int i = 0; i < strA.length(); i++) {
            A[strA.charAt(i) - 'a']++;
            B[StrB.charAt(i) - 'a']++;
        }
        for (int i = 0; i < A.length; i++) {
            if (A[i] != B[i]) {
                return false;
            }
        }
        return true;
    }
}
