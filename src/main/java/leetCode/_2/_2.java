package leetCode._2;

import pojo.ListNode;
import utils.DataUtil;
import utils.ListNodeUtils;

/**
 * 给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
 * <p>
 * 请你将两个数相加，并以相同形式返回一个表示和的链表。
 * <p>
 * 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 * 输入：l1 = [2,4,3], l2 = [5,6,4]
 * 输出：[7,0,8]
 * 解释：342 + 465 = 807.
 * 示例 2：
 * <p>
 * 输入：l1 = [0], l2 = [0]
 * 输出：[0]
 * 示例 3：
 * <p>
 * 输入：l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
 * 输出：[8,9,9,9,0,0,0,1]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/add-two-numbers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class _2 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode listNode = ListNodeUtils.getListNode(9, 9, 5);
        ListNode listNode2 = ListNodeUtils.getListNode(8, 9, 2);
        ListNodeUtils.printNode(listNode);
        ListNodeUtils.printNode(listNode2);
        ListNode result = solution.addTwoNumbers(listNode, listNode2);
        ListNodeUtils.printNode(result);

    }


}

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode n1 = l1;
        ListNode n2 = l2;
        ListNode result = new ListNode(0);
        ListNode head = result;
        int swap = 0;
        while (n1 != null || n2 != null) {
            int value = swap;
            value += n1 == null ? 0 : n1.val;
            value += n2 == null ? 0 : n2.val;
            if (value > 9) {
                swap = value / 10;
                value = value % 10;
            }else {
                swap = 0;
            }
            result.next = new ListNode(value);
            result = result.next;
            n1 = n1 == null ? n1 : n1.next;
            n2 = n2 == null ? n2 : n2.next;
        }
        if (swap > 0) {
            result.next = new ListNode(swap);
        }

        return head.next;
    }

}