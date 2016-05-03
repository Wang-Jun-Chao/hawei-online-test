import java.util.List;
import java.util.Scanner;

/**
 * Author: 王俊超
 * Date: 2016-05-03 09:47
 * CSDN: http://blog.csdn.net/derrantcm
 * Github: https://github.com/Wang-Jun-Chao
 * Declaration: All Rights Reserved !!!
 */
public class Main {
    private static class ListNode {
        int key;
        ListNode next;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
//        Scanner scanner = new Scanner(Main.class.getClassLoader().getResourceAsStream("data.txt"));
        while (scanner.hasNextLong()) {
            int num = scanner.nextInt();
            int h = scanner.nextInt();
            ListNode head = new ListNode();
            head.key = h;

            for (int i = 0; i < num - 1; i++) {
                int newVal = scanner.nextInt();
                int afterVal = scanner.nextInt();
                addNode(newVal, afterVal, head);
            }

            int del = scanner.nextInt();

            head = delete(del, head);
            System.out.println(getString(head));

        }
        scanner.close();
    }

    private static String getString(ListNode head) {
        StringBuilder builder = new StringBuilder();

        while (head!= null) {
            builder.append(head.key).append(' ');
            head = head.next;
        }

//        return builder.substring(0, builder.length() - 1);
        return builder.toString();
    }

    private static void addNode(int newVal, int afterVal, ListNode head) {
        ListNode n = head;
        while (n != null) {
            if (n.key == afterVal) {
                ListNode node = new ListNode();
                node.key = newVal;
                node.next = n.next;
                n.next = node;
                break;
            }
            n = n.next;
        }
    }

    private static ListNode delete(int val, ListNode head) {
        if (head.key == val) {
            ListNode ret = head.next;
            head.next = null;
            return ret;
        } else {
            ListNode prev = head;
            while (prev.next != null) {
                if (prev.next.key == val) {
                    prev.next = prev.next.next;
                    break;
                }
                prev = prev.next;
            }

            return head;
        }
    }
}
