import java.util.Scanner;

/**
 * Author: 王俊超
 * Date: 2015/12/22 16:52
 * All Rights Reserved !!!
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
//        Scanner scanner = new Scanner(Main.class.getClassLoader().getResourceAsStream("data.txt"));

        int[] result = new int[7];

        while (scanner.hasNext()) {
            String input = scanner.nextLine();
            ipAndMaskRecognize(input, result);
        }

        scanner.close();
    }

    private static void ipAndMaskRecognize(String input, int[] result) {
        String[] pare = input.split("~");

        ipRecognize(pare[0], result);
        maskRecognize(pare[1], result);
    }

    /**
     * 获取IP地址
     *
     * @param addr 点分十进制表示的IP地址字符串
     * @return result[0] = 1表示正确返回了IP地址，其它的表示IP地址错误，result[1]表示IP地址的内容
     */
    private static int[] getAddress(String addr) {
        int[] result = new int[2];

        String[] part = addr.split(".");

        // 如果没有4部分
        if (part.length != 4) {
            return result;
        }

        try {

        } catch (Exception e) {
            return result;
        }


        return result;
    }


    private static void maskRecognize(String s, int[] result) {
    }

    private static void ipRecognize(String s, int[] result) {

    }
}
