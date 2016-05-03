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

            // 规则整数序列R，过滤掉了重复数字，并且按从小到大进行了排序
            int rNum = scanner.nextInt();
            SortedSet<Integer> rSet = new TreeSet<>();
            for (int i = 0; i < rNum; i++) {
                rSet.add(scanner.nextInt());
            }

            System.out.println(dataClassify(rSet, iArr));
        }

        scanner.close();
    }

    /**
     * 将rSet中的数据进行分类
     *
     * @param rSet 数据已经按从小到大进行了排序
     * @param iArr 待查找的数组
     * @return 查找结果
     */
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

    /**
     * 找数组iArr中包含r的下标和数字
     *
     * @param r      待匹配的数字
     * @param iArr   查找的数组
     * @param result 查找的结果。保存所有的结果
     */
    private static void dataClassify(int r, int[] iArr, List<Integer> result) {

        // 保存结果的对象
        List<Integer> temp = new LinkedList<>();
        for (int i = 0; i < iArr.length; i++) {
            // 找到匹配的就将下标和值添加到结果中
            if (check(r, iArr[i])) {
                temp.add(i);
                temp.add(iArr[i]);
            }
        }

        // 如果找到数字
        if (!temp.isEmpty()) {
            result.add(r);
            result.add(temp.size() / 2);
            result.addAll(temp);
        }
    }

    /**
     * 判断r中是否包含j
     *
     * @param r 要包含的数字
     * @param i 待匹配的数字
     * @return 匹配结果
     */
    private static boolean check(int r, int i) {
        return ("" + i).contains("" + r);
    }

}
