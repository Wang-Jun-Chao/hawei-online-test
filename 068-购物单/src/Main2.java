import java.util.*;

/**
 * // TODO 这个有问题，对题目的理解有偏差
 * Author: 王俊超
 * Date: 2015-12-28 17:04
 * All Rights Reserved !!!
 */
public class Main2 {
    public static void main(String[] args) {
        //Scanner scanner = new Scanner(System.in);
        Scanner scanner = new Scanner(Main2.class.getClassLoader().getResourceAsStream("data.txt"));

        while (scanner.hasNext()) {

            String[] ss = scanner.nextLine().split("\\s+");

            int val = Integer.parseInt(ss[0]);
            int n = Integer.parseInt(ss[1]);

            List<Goods> list = new ArrayList<>();

            for (int i = 1; i <= n; i++) {
                ss = scanner.nextLine().split("\\s+");

                int v = Integer.parseInt(ss[0]);
                int w = Integer.parseInt(ss[1]);
                int t = Integer.parseInt(ss[2]);

                list.add(new Goods(v, w, t, i));
            }

            System.out.println(cart(list, val, n));
        }

        scanner.close();
    }


    private static int cart(List<Goods> list, int v, int n) {
        Set<Integer> set = new HashSet<>();
        int[] maxSum = {Integer.MIN_VALUE};
        int[] buy = new int[list.size()];
        // 某个最优解，本题中用不到
        int[] best = new int[list.size()];
        cartHelper(list, set, 0, v, n, 0, maxSum, buy, best);
        System.out.println(Arrays.toString(best));

        int result = 0;
        for (int i = 0; i < best.length; i++) {
            Goods g  = list.get(i);
            result += best[i]*g.v*g.w;
        }

        System.out.println(result);
        return maxSum[0];
    }

    /**
     * 计算购物车
     *
     * @param list    当前的商品列表
     * @param set     主件物品编号集合
     * @param i       当前处理的物品编号
     * @param v       剩余可用的金钱，初始值为可用的最大金额
     * @param n       剩余可以购买的商品件数，初始值为可买的最多的商品数量
     * @param currSum 当前的和 初始值为0
     * @param maxSum  记录到的最大的和，初始值为最小的整数
     */
    private static void cartHelper(List<Goods> list, Set<Integer> set, int i, int v, int n, int currSum, int[] maxSum, int[] buy, int[] best) {

        // 所有的物品都买了，或者买的物品超出了最多可以购买的数量，
        // 或者钱已经用完了
        if (i >= list.size() || n <= 0 || v <= 0) {
            return;
        }

        // 获取第i个物品
        Goods g = list.get(i);


        // 如果是主件，或者是附件，但是已经购买了主件
        if (g.t == 0 || set.contains(g.t)) {
            // 钱足够，(t>0&&n>0)这两个条件是隐含的
            if (v >= g.v) {
                // 剩下的钱减少
                v -= g.v;
                // 可买的件数减少
                n--;
                // 添加编号
                set.add(g.n);
                // 计算和
                currSum += g.v * g.w;
                buy[i] = 1;

                // 更新最大值
                if (maxSum[0] < currSum) {
                    maxSum[0] = currSum;

                    for (int j = 0; j < buy.length; j++) {
                        best[j] = buy[j];
                    }
                }

                // 处理下一件商品
                i++;
                cartHelper(list, set, i, v, n, currSum, maxSum,buy, best);
                i--;
                // 还原操作不买i物品
                currSum -= g.v * g.w;
                set.remove(g.n);
                n++;
                v += g.v;
                buy[i] = 0;
            }
        }

        // 不买i物品，不论是买不买得起i物品
        cartHelper(list, set, ++i, v, n, currSum, maxSum, buy, best);
    }


    private static class Goods {
        // 物品的价格
        private int v;
        // 物品的重要度
        private int w;
        // 是主件还是附件
        private int t;
        // 物品编号
        private int n;

        public Goods(int v, int w, int t, int n) {
            this.v = v;
            this.w = w;
            this.t = t;
            this.n = n;
        }
    }
}
