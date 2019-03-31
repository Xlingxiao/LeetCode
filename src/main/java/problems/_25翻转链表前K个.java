package problems;

import org.junit.jupiter.api.Test;
import pojo.ListNode;

@SuppressWarnings("ALL")
public class _25翻转链表前K个 {
    @Test
    void Main() {
        ListNode node = new ListNode(1);
        ListNode head = node;
        int k = 3;
        for (int i = 0; i < k; i++) {
            node.next = new ListNode(i);
            node = node.next;
        }
        display(head.next);
        ListNode result = reverseKGroup(head.next, 2);
        display(result);

    }

    /*思路：
    * 如果head节点小于等于1直接返回
    * 遍历K
    * */
    private ListNode myHead = new ListNode(0);
    private ListNode reallyHead = new ListNode(0);
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head==null || head.next==null || k < 2) return head;
        ListNode node = reallyHead;
        node.next = head;
        while (true) {
            try {
                node.next = onceReverse(node.next, k);
                node = find(node, k);
            } catch (Exception e) {
                return reallyHead.next;
            }
        }


    }

    /*执行一次翻转操作*/
    private ListNode onceReverse(ListNode head, int k) {
//        如果剩下的串小于2直接返回
        if (head==null || head.next==null || k < 2) return head;
        myHead.next = head;
        /*分别对应一个链表的头节点
        * 真正要反转的第一个节点
        * 要反转的最后一个节点
        * 要反转的最后一个节点的上一个节点*/
        ListNode l, i, j, r = null, end;
        l = myHead;
        i = head;
        /*执行翻转操作*/
        while (!(i == r)) {
            k -= 2;
            r = find(i, k);
            j = r.next;
            end = j.next;
            j.next = i.next == j ? i : i.next;
            l.next = j;
            l = l.next;
            r.next = i;
            i.next = end;
            i = j.next;
        }
        /*返回翻转后的第一个节点*/
        return myHead.next;
    }



    private ListNode find(ListNode head, int k) {
        for (int i = 0; i < k; i++) {
            head = head.next;
        }
        return head;
    }

    void display(ListNode node) {
        while (node != null) {
            System.out.print(node.val + "--->");
            node = node.next;
        }
        System.out.println();
    }
}
