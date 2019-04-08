package problems;

/**
 * @Author: LX
 * @Date: 2019/4/8 22:06
 * @Version: 1.0
 */
public class _19删除链表的倒数第N个节点 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head.next == null) return null;
        ListNode r_head = new ListNode(0);
        r_head.next = head;
        ListNode currentNode = r_head,
                endNode = r_head;
        for (int i = 0; i < n; i++) endNode = endNode.next;
        while (endNode.next != null) {
            endNode = endNode.next;
            currentNode = currentNode.next;
        }
        currentNode.next = currentNode.next.next;
        return r_head.next;
    }
}
