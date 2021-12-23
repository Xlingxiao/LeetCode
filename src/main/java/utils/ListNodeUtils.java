package utils;

import pojo.ListNode;

/**
 * 链表工具
 */
public class ListNodeUtils {

    public static ListNode getListNode(int min, int max, int count) {
        if (count < 1) {
            return null;
        }
        ListNode head = new ListNode(0);
        ListNode node = head;
        int a = max - min;
        for (int i = 0; i < count; i++) {
            int val = (int) ((Math.random() * a) + min);
            ListNode listNode = new ListNode(val);
            node.next = listNode;
            node = listNode;
        }
        return head.next;
    }

    public static void printNode(ListNode node) {
        System.out.println();
        while (node != null) {
            System.out.print(node.val + "-");
            node = node.next;
        }
        System.out.println();

    }
}
