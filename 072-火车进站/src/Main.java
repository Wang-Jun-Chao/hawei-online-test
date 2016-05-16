import java.util.*;

/**
 * Author: 王俊超
 * Date: 2016-01-04 16:41
 * All Rights Reserved !!!
 */
public class Main {
    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
        Scanner scanner = new Scanner(Main.class.getClassLoader().getResourceAsStream("data.txt"));
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            String[] ss = new String[n];
            for (int i = 0; i < n; i++) {
                ss[i] = scanner.next();
            }

            System.out.println(trainOut(ss));
        }

        scanner.close();
    }

    /**
     * 此处所谓字典序排序的意思是这n辆火车有多少种出站的可能顺序（也就是数据结构中的栈有多少种出栈顺序）。
     * 思路为用三个变量分别存储待进站火车，站中火车和已出站火车，其中待进站火车用Queue（队列）存储和站中
     * 火车采用stack（栈）存储，已出站火车采用StringBuilder来存储，具体实现是采用递归的方法，递归函数
     * 的参数为当前待进站火车、站中火车、已出站火车的值所组成的三元组，递归结束条件是，未进站火车和站中火
     * 车均为空，此时输出已出站火车即为所有出站的一种可能，递推关系为对于当前情况有让下一辆火车进站或让站
     * 中的一辆火车出站两种可能，对于两种可能分别调用递归函数，即可得出问题的解。
     *
     * @param ss
     * @return
     */
    private static String trainOut(String[] ss) {

//        Arrays.sort(ss);

        List<List<String>> result = new ArrayList<>();
        List<String> out = new ArrayList<>(ss.length);
        List<String> unout = new ArrayList<>(ss.length);
        trainOut(0, ss, out, unout, result);

        Collections.sort(result, new Comparator<List<String>>() {

            @Override
            public int compare(List<String> a, List<String> b) {

                int min = a.size() < b.size() ? a.size() : b.size();


                for (int i = 0; i < min; i++) {
                    String as = a.get(i);
                    String bs = b.get(i);
                    if (as.compareTo(bs) != 0) {
                        return as.compareTo(bs);
                    }
                }
                return a.size() - b.size();
            }
        });

        StringBuilder builder = new StringBuilder(256);
        for (List<String> list : result) {
            StringBuilder b = new StringBuilder(64);
            for (String s : list) {
                b.append(s).append(' ');
            }
            b.setCharAt(b.length() - 1, '\n');

            builder.append(b);
        }

        return builder.toString();
    }

    /**
     * 火车进站
     *
     * @param i      火车编号
     * @param ss     所有的火车
     * @param out    火车已经出站的序列
     * @param unout  火车还未出站的序列
     * @param result 保存所有可能的结果
     */
    private static void trainOut(int i, String[] ss, List<String> out, List<String> unout, List<List<String>> result) {

        // 所有的火车已经进站
        if (i >= ss.length) {
            List<String> list = new ArrayList<>();
            for (String s : out) {
                list.add(s);
            }

            // 先进后出
            for (int j = unout.size() - 1; j >= 0; j--) {
                list.add(unout.get(j));
            }

            result.add(list);

            return;
        }

        // 第i辆车进来就出去了
        out.add(ss[i]);
        trainOut(i + 1, ss, out, unout, result);
        // 还原
        out.remove(out.size() - 1);

        // 第i辆车进来没有出去
        unout.add(ss[i]);
        trainOut(i + 1, ss, out, unout, result);
        // 还原
        unout.remove(unout.size() - 1);
    }
}
