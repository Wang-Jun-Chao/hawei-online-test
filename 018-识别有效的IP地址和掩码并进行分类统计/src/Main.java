import java.util.Scanner;

/**
 * Author: 王俊超
 * Date: 2015/12/22 16:52
 * All Rights Reserved !!!
 */
public class Main {

    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
        Scanner scanner = new Scanner(Main.class.getClassLoader().getResourceAsStream("data.txt"));
        // 0：A、1：B、2：C、3：D、4：E、5：错误IP地址或错误掩码、6：私有IP的个数
        int[] result = new int[7];

        while (scanner.hasNextLine()) {
            String input = scanner.next();
            ipAndMaskRecognize(input, result);
        }
        scanner.close();

        StringBuilder builder = new StringBuilder();
        for (int i : result) {
            builder.append(i).append(' ');
        }

        System.out.print(builder.substring(0, builder.length() - 1));
    }

    private static void ipAndMaskRecognize(String input, int[] result) {
        String[] pare = input.split("~");

//        System.out.println(Arrays.toString(pare));

        if (pare.length != 2) {
            result[5]++;
            return;
        }

        // 第一步：验证是否是正确的IP地址和掩码格式，其中有一个错误就不需要在进行其它操作
        // 第二步：验证IP地址的类型
        if (validate(pare[0]) && validate(pare[1]) && maskRecognize(pare[1])) {

            // 识别IP地址种类
            int type = ipRecognize(pare[0]);

//            System.out.println(input + ": " + type);

            // 私有地址，并且有可能还是A类或者C类地址
            if (type > 6) {
                type -= 7;
                result[6]++;
            }

            // ABCDE类型
            if (type > 0) {
                // 对应类型计数增加
                result[type - 1]++;
            }
        }
        // 错误IP地址或错误掩码
        else {
            result[5]++;
        }
    }

    /**
     * 验证是否是有效的IP地址格式
     * @param s 点分十进制表示的合法IP地址字符串
     * @return true：有效，false：无效
     */
    private static boolean validate(String s) {

        String[] part = s.split("\\.");

        // 如果没有4部分
        if (part.length != 4) {
            return false;
        }

        try {
            for (String p : part) {
                int a = Integer.parseInt(p);
                if (a < 0 || a > 255) {
                    return false;
                }
            }
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    /**
     * 获取IP地址
     *
     * @param addr 点分十进制表示的合法IP地址字符串
     * @return result 表示IP地址的内容，1代表A类，2代表B类。。。
     */
    private static int ipRecognize(String addr) {
        String[] part = addr.split("\\.");

        int a = Integer.parseInt(part[0]);
        int b = Integer.parseInt(part[1]);

        // 6表示错误IP地址
        int result = 6;
        // A类地址
        if (a >= 1 && a <= 126) {
            result = 1;
        }
        // B类地址
        else if (a >= 128 && a <= 191) {
            result = 2;
        }
        // C类地址
        else if (a >= 192 && a <= 223) {
            result = 3;
        }
        // D类地址
        else if (a >= 224 && a <= 239) {
            result = 4;
        }
        // E类地址
        else if (a >= 240 && a <= 255) {
            result = 5;
        }

        // 私有地址，用7表示
        // 是私有地址并且是A类地址
        if (a == 10) {
            result = 7 + 1;
        }

        // 仅仅只是私有地址
        if (a == 172 && (b >= 16 || b <= 31)) {
            result = 7 + 2;
        }

        // 是私有地址并且是C类地址
        if (a == 192 && b == 168) {
            result = 7 + 3;
        }

        // 其它情况返回6;说明其只是一个格式符合要求的地址，并非ABCDE或者私有地址
        return result;
    }


    /**
     * 验证是否是有效的掩码格式
     *
     * @param s
     * @return
     */
    private static boolean maskRecognize(String s) {
        String[] part = s.split("\\.");
        int addr = Integer.parseInt(part[0]) << 24;
        addr += Integer.parseInt(part[1]) << 16;
        addr += Integer.parseInt(part[2]) << 8;
        addr += Integer.parseInt(part[3]);

        int and = 0x80_00_00_00;

        int zero = 0;
        // 只要在1前面出现了0，说明不合法
        for (int i = 0; i < 31; i++) {
            // 当前位为0
            if ((addr & and) == 0) {
                zero++;
            }
            // 当前位为1
            else {
                // 如果之前已经出现过0和1
                if (zero != 0) {
                    return false;
                }
            }

            and >>>= 1;
        }

        return true;
    }


}
