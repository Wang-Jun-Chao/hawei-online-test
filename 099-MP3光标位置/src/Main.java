import java.util.Scanner;

/**
 * Author: 王俊超
 * Time: 2016-05-04 20:01
 * CSDN: http://blog.csdn.net/derrantcm
 * Github: https://github.com/Wang-Jun-Chao
 * Declaration: All Rights Reserved !!!
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
//        Scanner scanner = new Scanner(Main.class.getClassLoader().getResourceAsStream("data.txt"));
        while (scanner.hasNext()) {
            int num = scanner.nextInt();
            String command = scanner.next();
//            System.out.println(num + " " + command);
            System.out.println(locatePointer(num, command));
        }
        scanner.close();
    }

    private static String locatePointer(int num, String command) {

        if (num < 5) {
            return lessThan5(num, command);
        } else {
            return greatThan4(num, command);
        }


    }

    /**
     * 求光标的位置，歌曲数大于4
     *
     * @param num     总共的歌曲数目
     * @param command 命令
     * @return 当前选中歌曲
     */
    private static String greatThan4(int num, String command) {
        int curr = 1;
        // 屏幕可以显示的第一个光标
        int top = 1;
        // 屏幕可以显示的最后一个光标
        int bot = 4;


        StringBuilder builder = new StringBuilder(command.length() * 2);

        for (int i = 0; i < command.length(); i++) {
            char c = command.charAt(i);

            // 如果是向上的
            if (c == 'U') {
                curr--;

                // 如果翻到第一首歌的上面
                if (curr < 1) {
                    curr = num;
                    // 更新窗口可以显示的范围
                    bot = num;
                    top = num - 3;
                }
                // 非第一首歌上面
                else {
                    // 已经超过显示的范围
                    if (curr < top) {
                        top = curr;
                        bot = curr + 3;
                    }
                }
            } else if (c == 'D') {
                curr++;

                // 如果翻到最后一首歌的下面了
                if (curr > num) {
                    curr = 1;

                    // 更新窗口可以显示的范围
                    bot = 4;
                    top = 1;
                }
                // 不是最后一首歌
                else {
                    // 已经超过显示的范围
                    if (curr > bot) {
                        bot = curr;
                        top = curr - 3;
                    }
                }
            }

            // 如果是最后一个命令，记录页面显示的范围和光标的位置
            if (i == command.length() - 1) {
                for (int j = top; j <= bot; j++) {
                    // 计录光标的范围
                    builder.append(j).append(' ');
                }
                builder.setCharAt(builder.length() - 1, '\n');
                // 计录光标的位置
                builder.append(curr).append('\n');
            }
        }


        return builder.substring(0, builder.length() - 1);
    }

    /**
     * 求光标的位置，歌曲数小于5
     *
     * @param num     总共的歌曲数目
     * @param command 命令
     * @return 当前选中歌曲
     */
    private static String lessThan5(int num, String command) {

        StringBuilder builder = new StringBuilder(command.length() * 2);

        // 当前光标的位置，以0计
        int curr = 0;
        for (int i = 0; i < command.length(); i++) {
            char c = command.charAt(i);
            if (c == 'U') {
                curr = (curr - 1 + num) % num;

            } else if (c == 'D') {
                curr = (curr + 1 + num) % num;
            }

            // 如果是最后一个命令，记录页面显示的范围和光标的位置
            if (i == command.length() - 1) {
                for (int j = 1; j <= num; j++) {
                    // 计录光标的范围
                    builder.append(j).append(' ');
                }
                builder.setCharAt(builder.length() - 1, '\n');
                // 计录光标的位置
                builder.append(curr + 1).append('\n');
            }


        }

        return builder.substring(0, builder.length() - 1);
    }
}
