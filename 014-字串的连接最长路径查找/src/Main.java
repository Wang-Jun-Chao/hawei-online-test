import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

/**
 * Author: 王俊超
 * Date: 2015/12/22 13:59
 * All Rights Reserved !!!
 */
public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(System.in);
//        Scanner scanner = new Scanner(Main.class.getClassLoader().getResourceAsStream("data.txt"));

        while (scanner.hasNext()) {
            int num = Integer.parseInt(scanner.nextLine());
            List<String> list = new ArrayList<>(num);

            while ((--num) >= 0) {
                list.add(scanner.nextLine());
            }

            Collections.sort(list);

            for (String s : list) {
                System.out.println(s);
            }
        }

        scanner.close();
    }
}
