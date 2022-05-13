package class04;

/*
K个节点的组内逆序调整问题：
给定一个单链表的头节点head，和一个正数k
实现k个节点的小组内部逆序，如果最后一组不够k个就不调整
例子:
调整前：1 -> 2 -> 3 -> 4 -> 5 -> 6 -> 7 -> 8，k = 3
调整后：3 -> 2 -> 1 -> 6 -> 5 -> 4 -> 7 -> 8
*/
// 测试链接25：https://leetcode.com/problems/reverse-nodes-in-k-group/
public class ReverseNodesInKGroup {
    // 不要提交这个类
    public static class ListNode {
        public int val;
        public ListNode next;
    }

    public static ListNode reverseKGroup(ListNode head, int k) {
        ListNode start = head;
        // 给定一组中的第一个，和一组的个数，返回一组的最后一个
        ListNode end = getKGroupEnd(start, k);
        if (end == null) {
            return head;
        }
        // 第一组凑齐了！
        head = end;
        reverse(start, end);

        // 上一组的结尾节点
        ListNode lastEnd = start;
        while (lastEnd.next != null) {
            start = lastEnd.next;
            end = getKGroupEnd(start, k);
            if (end == null) {
                return head;
            }
            reverse(start, end);
            // 上一组节点的 lastEnd 指向这一组的end节点
            lastEnd.next = end;
            lastEnd = start;
        }
        return head;
    }

    // 给定一组中的第一个，和一组的个数，返回一组的最后一个
    public static ListNode getKGroupEnd(ListNode start, int k) {
        while (--k != 0 && start != null) {
            start = start.next;
        }
        return start;
    }

    // 反转链表
    public static void reverse(ListNode start, ListNode end) {
        end = end.next;
        ListNode pre = null;
        ListNode cur = start;
        ListNode next = null;
        while (cur != end) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        start.next = end;
    }

}
