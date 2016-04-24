import java.util.Scanner;

/**
 * 思路：给定购物单，逐级增加金额和件数，直到达到购物单上限止（商品件数或者总金额）；
 * 逐级计算出所对应的最大乘积值，并在此过程中，比较出到此级为止的乘积最大值
 * Author: 王俊超
 * Time: 2016-${NONTH}-24 08:30
 * CSDN: http://blog.csdn.net/derrantcm
 * Github: https://github.com/Wang-Jun-Chao
 * Declaration: All Rights Reserved !!!
 */
public class Main {
    public static void main(String[] aStrings) {
        Scanner scanner = new Scanner(System.in);
//        Scanner scanner = new Scanner(Main2.class.getClassLoader().getResourceAsStream("data2.txt"));
        while (scanner.hasNext()) {
            // 总的钱数
            int total = scanner.nextInt();
            // 希望购买物品的个数
            int num = scanner.nextInt();
            // 每个物品的价格
            int[] price = new int[num + 1];
            // 每个物品的权重
            int[] value = new int[num + 1];
            // 是主件还是附件
            int[] check = new int[num + 1];

            // 每一个数赋0
            price[0] = 0;
            value[0] = 0;
            check[0] = 0;

            // 读取输入数据
            for (int i = 1; i <= num; i++) {
                price[i] = scanner.nextInt();
                value[i] = scanner.nextInt();
                check[i] = scanner.nextInt();
            }

            // 结果数组
            // 行代表物品个数，列代表钱数
            int[][] result = new int[num + 1][total + 1];
            // 第一行赋0
            for (int j = 0; j <= num; j++) {
                result[j][0] = 0;
            }

            for (int i = 1; i <= total; i++) {
                for (int j = 1; j <= num; j++) {

                    // 如果是附件
                    if (check[j] > 0) {

                        // result[j-1][i-price[j]] 表示使用i-price[j]的总钱数，最多买j-1个物品的最大值

                        // 总的钱数比(当前物品+他的主件)所需要的钱多
                        if (i > price[j] + price[check[j]]) {

                            int w = result[j - 1][i - price[j]] + value[j] * price[j];
                            result[j][i] = w > result[j - 1][i] ? w : result[j - 1][i];
                        }

                    } else {
                        // 总钱数可以买主件
                        if (i >= price[j]) {
                            int w = result[j - 1][i - price[j]] + value[j] * price[j];
                            result[j][i] = w > result[j - 1][i] ? w : result[j - 1][i];
                        }
                    }

                }
            }
            System.out.println(result[num][total]);
        }
        scanner.close();
    }
}
