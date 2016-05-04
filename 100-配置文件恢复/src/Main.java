import java.util.*;

/**
 * Author: 王俊超
 * Time: 2016-05-04 21:02
 * CSDN: http://blog.csdn.net/derrantcm
 * Github: https://github.com/Wang-Jun-Chao
 * Declaration: All Rights Reserved !!!
 */
public class Main {

    private final static String[] ACTION = {
            "reset", "reset what",
            "reset board", "board fault",
            "board add", "where to add",
            "board delet", "no board at all",
            "reboot backplane", "impossible",
            "backplane abort", "install first"
    };

    private final static String UC = "unkown command";


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
//        Scanner scanner = new Scanner(Main.class.getClassLoader().getResourceAsStream("data2.txt"));
        List<String> cmds = new LinkedList<>();
        while (scanner.hasNextLine()) {
            String cmd = scanner.nextLine();
            cmds.add(cmd);
//            System.out.println(num + " " + command);
        }
        System.out.print(fileRestore(cmds));
        scanner.close();
    }

    private static String fileRestore(List<String> cmds) {

        StringBuilder builder = new StringBuilder();
        for (String cmd : cmds) {
//            System.out.println(cmd + ": " + getAction(cmd));
            builder.append(getAction(cmd)).append('\n');
        }
        return builder.toString();
    }

    private static String getAction(String cmd) {

        String[] part = cmd.split("(\\s)+");

        // 如果是一字串，只有第一个命令是一字串
        if (part.length == 1) {
            // 是以part[0]开头
            if (ACTION[0].startsWith(part[0])) {
                // 返回执行命令
                return ACTION[1];
            } else {
                return UC;
            }
        } else if (part.length == 2) {
            // 除了第一个命令其它的都是二字串
            int count = 0;
            String result = UC;
            // 检查是否匹配命令
            for (int i = 2; i < ACTION.length; i += 2) {
                String[] cmdPart = ACTION[i].split("(\\s)+");
                if (cmdPart[0].startsWith(part[0]) && cmdPart[1].startsWith(part[1])) {
                    count++;
                    result = ACTION[i + 1];
                }
            }

            // 刚好找到一个匹配的
            if (count == 1) {
                return result;
            }
            // 没有找到或者找到多个匹配的
            else {
                return UC;
            }

        }
        // 除了一字串和二字串，没有其它串
        else {
            return UC;
        }
    }
}
