import org.omg.SendingContext.RunTime;

import java.util.List;
import java.util.Scanner;

/**
 * Author: 王俊超
 * Date: 2015-12-24 16:10
 * All Rights Reserved !!!
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
//        Scanner scanner = new Scanner(Main.class.getClassLoader().getResourceAsStream("data.txt"));
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            ListNode head = new ListNode(0);
            ListNode prev = head;
            while ((--n) >= 0) {
                prev.next = new ListNode(scanner.nextInt());
                prev = prev.next;
            }
            int k = scanner.nextInt();

            System.out.println(findKthToTail(head, k));
        }

        scanner.close();
    }

    /**
     * 找倒数第k个结点，假设k是有效的
     *
     * @param head
     * @param k
     * @return
     */
    private static ListNode findKthToTail(ListNode head, int k) {

        ListNode prev = head;

        while (--k >= 0 && prev != null) {
            prev = prev.next;
        }

        // 说明k已经超出了链表的长度
        if (prev == null) {
            throw new RuntimeException("k=" + k + "不合法");
        }

        // 注释掉的才是正确答案
//        while (prev != null) {
//            prev = prev.next;
//            head = head.next;
//        }

        // 如果从0开始，即链表尾部第一个是倒数第0个那么下面是正确的
        while (prev.next != null) {
            prev = prev.next;
            head = head.next;
        }

        return head;
    }


    private static class ListNode {
        int v;
        ListNode next;

        ListNode(int v) {
            this.v = v;
        }

        @Override
        public String toString() {
            return "" + v;
        }
    }
}
