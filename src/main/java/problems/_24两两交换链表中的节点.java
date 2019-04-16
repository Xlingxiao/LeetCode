package problems;

/**
 * @Author: LX
 * @Date: 2019/4/8 22:08
 * @Version: 1.0
 */
public class _24两两交换链表中的节点 {
    public ListNode swapPairs(ListNode head) {
        if (head == null) return null;
        if (head.next == null) return head;
        ListNode headNode = new ListNode(0);
        headNode.next = head;
        ListNode lNode = head;
        ListNode rNode = lNode.next;
        head = headNode;
        ListNode tail;
        // 上一次交换之后后面只有一个节点导致rNode为null
        while (rNode != null) {
            // 交换
            // tail 保存整个链表剩下的部分
            tail = rNode.next;
            // 将lNode和rNode分别单独拿出来
            lNode.next = null;
            // rNode.next = null;
            // 交换节点
            rNode.next = lNode;
            //接上前面
            head.next = rNode;
            head = lNode;
            //接上后面
            lNode.next = tail;
            //相当于后面没有节点了
            if (tail == null) break;
            lNode = lNode.next;
            rNode = lNode.next;
        }

        return headNode.next;
    }
}
