import java.util.*;

/**
 * Author: 王俊超
 * Date: 2016-05-03 07:08
 * CSDN: http://blog.csdn.net/derrantcm
 * Github: https://github.com/Wang-Jun-Chao
 * Declaration: All Rights Reserved !!!
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
//        Scanner scanner = new Scanner(Main.class.getClassLoader().getResourceAsStream("data.txt"));
        while (scanner.hasNext()) {
            // 整数序列I
            int iNum = scanner.nextInt();
            int[] iArr = new int[iNum];
            for (int i = 0; i < iNum; i++) {
                iArr[i] = scanner.nextInt();
            }

            // 规则整数序列R，并且过滤掉了重复数字
            int rNum = scanner.nextInt();
            SortedSet<Integer> rSet = new TreeSet<>();
            for (int i = 0; i < rNum; i++) {
                rSet.add(scanner.nextInt());
            }

            System.out.println(dataClassify(rSet, iArr));
        }

        scanner.close();
    }

    private static String dataClassify(SortedSet<Integer> rSet, int[] iArr) {
        List<Integer> result = new LinkedList<>();
        for (int r : rSet) {
            dataClassify(r, iArr, result);
        }

        StringBuilder builder = new StringBuilder();
        builder.append(result.size()).append(' ');

        for (int i : result) {
            builder.append(i).append(' ');
        }


        return builder.substring(0, builder.length() - 1);
    }

    private static void dataClassify(int r, int[] iArr, List<Integer> result) {

        List<Integer> temp = new LinkedList<>();
        for (int i = 0; i < iArr.length; i++) {
            if (check(r, iArr[i])) {
                temp.add(i);
                temp.add(iArr[i]);
            }
        }

        if (!temp.isEmpty()) {
            result.add(r);
            result.add(temp.size() / 2);
            result.addAll(temp);
        }
    }

    /**
     * 判断r中是否包含j
     *
     * @param r
     * @param i
     * @return
     */
    private static boolean check(int r, int i) {
        return ("" + i).contains("" + r);
    }

}
