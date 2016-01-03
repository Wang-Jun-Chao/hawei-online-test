import java.util.Scanner;

/**
 * Author: 王俊超
 * Date: 2016-01-03 12:59
 * Declaration: All Rights Reserved !!!
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
//        Scanner scanner = new Scanner(Main.class.getClassLoader().getResourceAsStream("data.txt"));
        while (scanner.hasNext()) {
            String subnet = scanner.next();
            String ip1 = scanner.next();
            String ip2 = scanner.next();

            System.out.println(subnetJudgement(subnet, ip1, ip2));
        }

        scanner.close();
    }

    private static int subnetJudgement(String subnet, String ip1, String ip2) {

        //  1：IP地址或子网掩码格式非法
        if (!ipValidate(subnet) || !ipValidate(ip1) || !ipValidate(ip2)) {
            return 1;
        }

        int subnetInt = ipStrToInt(subnet);

        //  1：子网掩码格式非法
        if (!subnetMaskValidate(subnetInt)) {
            return 1;
        }

        int b = ipStrToInt(ip2);
        int a = ipStrToInt(ip1);

        // 0：IP1与IP2属于同一子网络
        if ((a & subnetInt) == (b & subnetInt)) {
            return 0;
        }
        // 2：IP1与IP2不属于同一子网络
        else {
            return 2;
        }



    }

    /**
     * 验证IP地址的格式是否正确
     *
     * @param ip IP地址
     * @return true：格式正确，false：格式不正确
     */
    private static boolean ipValidate(String ip) {
        String[] part = ip.split("\\.");

//        if (part.length != 4) {
//            return false;
//        }

        for (String s : part) {
            try {
                int num = Integer.parseInt(s);
                if (num < 0 || num > 255) {
                    return false;
                }
            } catch (Exception ex) {
                return false;
            }
        }

        return true;
    }

    /**
     * 子网掩码验证，网络号部分全为“1”和主机号部分全为“0”
     *
     * @param ip
     * @return
     */
    private static boolean subnetMaskValidate(int ip) {
        boolean hasZero = false;
        int and = 0x80000000;
        while (and != 0) {
            // 所处理的位位置为0
            if ((ip & and) == 0) {
                // 说明出现了0
                hasZero = true;
            }
            // 如果位置为1
            else {
                // 之前已经有0出现过，那说明1是不连续的，所以子网掩码不合法
                if (hasZero) {
                    return false;
                }
            }

            // 无符号右移一位
            and >>>= 1;
        }

        return true;
    }

    /**
     * 将点分十进制的IP地址转换成整数表示
     *
     * @param ip 点分十进制的IP地址
     * @return IP地址的整数表
     */
    private static int ipStrToInt(String ip) {
        String[] part = ip.split("\\.");
        int intIP = 0;

        for (int i = 0; i < part.length; i++) {
            int t = Integer.parseInt(part[i]);
            intIP += t << (24 - 8 * i);
        }

        return intIP;
    }
}
