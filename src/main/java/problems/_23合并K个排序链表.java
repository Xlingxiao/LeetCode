package problems;

/**
 * @Author: LX
 * @Date: 2019/4/8 22:08
 * @Version: 1.0
 */
public class _23合并K个排序链表 {
    public ListNode mergeKLists(ListNode[] lists) {
        int len = lists.length;
        if (len  < 1) return null;
        if (len == 1) return lists[0];
        merge(lists, new ListNode(Integer.MIN_VALUE), 0, lists.length - 1);
        return lists[0];
    }

    void merge(ListNode[] lists,ListNode assist, int left, int right) {
        if (left >= right) {
            return;
        } else {
            int mid = (left + right) / 2;
            merge(lists,assist, left, mid);
            merge(lists,assist, mid + 1, right);
            /*这里每次排序使用的是left和right进行，
                但是对于mid 和 right 的排序来说
                排好序的链表是存储在lists[mid+1]中的
                所以就应该吧lists[mid + 1] 的值付给lists[right]
                否则会出现漏值的情况
            */
            lists[right] = lists[mid + 1];
            lists[left] = sort(lists[left], lists[right], assist);
        }
    }

    ListNode sort(ListNode first, ListNode second, ListNode assist) {
        /*因为上面的赋值操作可能导致first和second是相等的，这样就会陷入死循环，所以这里进行判断*/
        if (first == second) return first;
        ListNode node = assist;
        while (first != null && second != null) {
            if (first.val < second.val) {
                node.next = first;
                node = node.next;
                first = first.next;
            } else {
                node.next = second;
                node = node.next;
                second = second.next;
            }
        }
        if (first != null) node.next = first;
        if (second != null) node.next = second;
        return assist.next;
    }
}
