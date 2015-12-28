import java.util.*;

/**
 * Author: 王俊超
 * Date: 2015-12-28 17:04
 * All Rights Reserved !!!
 */
public class Main {
    public static void main(String[] args) {
        //Scanner scanner = new Scanner(System.in);
        Scanner scanner = new Scanner(Main.class.getClassLoader().getResourceAsStream("data.txt"));

        while (scanner.hasNext()) {
            int val = scanner.nextInt();
            int n = scanner.nextInt();

            int line = 0;
            Map<Integer, Goods> map = new HashMap<>();
            while (scanner.hasNext()) {

                line++;

                int v = scanner.nextInt();
                int w = scanner.nextInt();
                int t = scanner.nextInt();

                // 如果是主件
                if (t == 0) {
                    map.put(line, new Goods(v, w, t, new ArrayList<Goods>()));
                }
                // 如果是附件
                else {
                    map.get(t).list.add(new Goods(v, w, t, null));
                }
            }
        }


        scanner.close();
    }


    private static int cart(List<Goods> list, int v, int n) {
        int result = 0;

        return result;
    }


    private static class Goods {
        // 物品的价格
        private int v;
        // 物品的重要度
        private int w;
        // 是主件还是附件
        private int t;
        // 附件列表
        private List<Goods> list;

        public Goods(int v, int w, int t, List<Goods> list) {
            this.v = v;
            this.w = w;
            this.t = t;
            this.list = list;
        }
    }
}
