package problems;

/**
 * @Author: LX
 * @Date: 2019/4/8 21:54
 * @Version: 1.0
 */
public class _2两数相加 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(-1);
        ListNode node = head;
        int flag = 0;
        while (l1 != null || l2 != null) {
            int a = (l1!=null) ? l1.val:0;
            int b = (l2!=null) ? l2.val:0;
            int tmp = a + b + flag;
            //int tmp = l1.val + l2.val + flag;
            flag = tmp / 10;
            node.next = new ListNode(tmp % 10);
            node = node.next;
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }
        if(flag > 0 ) node.next = new ListNode(flag);
        return head.next;
    }

}
