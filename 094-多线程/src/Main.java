import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Author: 王俊超
 * Date: 2016-05-03 11:25
 * CSDN: http://blog.csdn.net/derrantcm
 * Github: https://github.com/Wang-Jun-Chao
 * Declaration: All Rights Reserved !!!
 */
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            for (int i = 0; i < n; i++) {
                System.out.print("ABCD");
            }
            System.out.println();
        }

        scanner.close();
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////
    // TODO 应用使用下面的方法进行操作
    ////////////////////////////////////////////////////////////////////////////////////////////////////


    /**
     * 打印线程
     */
    public static class WriteThread extends Thread {
        // 打印次数
        private final int times;
        // 线程名称
        private final String name;
        // 打印顺序变量
        private final AtomicInteger order;
        // 当前线程的特别标识
        private final int flag;
        // 所有的线程数
        private final int all;
        // 保存结果
        private final StringBuilder builder;

        public WriteThread(int times, String name, AtomicInteger order, int flag, int all, StringBuilder builder) {
            this.times = times;
            this.name = name;
            this.order = order;
            this.flag = flag;
            this.all = all;
            this.builder = builder;
        }

        @Override
        public void run() {
            int count = 0;
            // 一直输出到指定次数
            while (count < times) {
                // 判断是否轮到自己输出
                if (order.get() == flag) {
                    // 输出计数加一
                    count++;
                    // 输出内容
                    builder.append(name);
                    // 指定下一个线程进行输出
                    order.set((flag + 1) % all);
                }
            }
        }
    }

    public static void main2(String[] args) throws InterruptedException {
        Scanner scanner = new Scanner(System.in);
//        Scanner scanner = new Scanner(Main2.class.getClassLoader().getResourceAsStream("data.txt"));

        // 读取并保存所有的输入
        List<Integer> input = new LinkedList<>();
        while (scanner.hasNextLong()) {
            input.add(scanner.nextInt());
        }

        // 计算结果
        List<StringBuilder> result = new LinkedList<>();
        for (int num : input) {
            StringBuilder builder = new StringBuilder();
            result.add(builder);
            AtomicInteger order = new AtomicInteger(0);
            WriteThread a = new WriteThread(num, "A", order, 0, 4, builder);
            WriteThread b = new WriteThread(num, "B", order, 1, 4, builder);
            WriteThread c = new WriteThread(num, "C", order, 2, 4, builder);
            WriteThread d = new WriteThread(num, "D", order, 3, 4, builder);
            a.start();
            b.start();
            c.start();
            d.start();
            a.join();
            b.join();
            c.join();
            d.join();

        }

        for (StringBuilder b : result) {
            System.out.println(b);
        }

        scanner.close();
    }
}


