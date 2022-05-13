package class04;

import java.util.ArrayList;
import java.util.List;

// 双链表的反转逆序操作
public class reverseDoubleList {
    public static class DoubleNode {
        public int value;
        public DoubleNode last;
        public DoubleNode next;

        public DoubleNode(int data) {
            value = data;
        }
    }

    //	双链表的逆序
    public static DoubleNode reverseDoubleList(DoubleNode head) {
        DoubleNode pre = null;
        DoubleNode next = null;
        while (head != null) {
            next = head.next;
            head.next = pre;
            // 比单链表反转多了一步操作
            head.last = next;
            pre = head;
            head = next;
        }
        return pre;
    }

    //  测试双链表的反转，需要额外的一个链表
    public static DoubleNode testReverseDoubleList(DoubleNode head) {
        if (head == null) {
            return null;
        }
        // 先拷贝一个
        ArrayList<DoubleNode> list = new ArrayList<>();
        while (head != null) {
            list.add(head);
            head = head.next;
        }
        // 处理反转操作
        list.get(0).next = null;
        DoubleNode pre = list.get(0);
        int N = list.size();
        for (int i = 1; i < N; i++) {
            DoubleNode cur = list.get(i);
            cur.last = null;
            cur.next = pre;
            pre.last = cur;
            pre = cur;
        }
        return list.get(N - 1);
    }

    // 随机生成双链表 for test
    public static DoubleNode generateRandomDoubleList(int len, int value) {
        int size = (int) (Math.random() * (len + 1));
        if (size == 0) {
            return null;
        }
        size--;
        DoubleNode head = new DoubleNode((int) (Math.random() * (value + 1)));
        DoubleNode pre = head;
        while (size != 0) {
            DoubleNode cur = new DoubleNode((int) (Math.random() * (value + 1)));
            pre.next = cur;
            // 比单链表多了这个操作
            cur.last = pre;
            pre = cur;
            size--;
        }
        return head;
    }

    // 获取原始的列表
    public static List<Integer> getDoubleListOriginOrder(DoubleNode head) {
        List<Integer> ans = new ArrayList<>();
        while (head != null) {
            ans.add(head.value);
            head = head.next;
        }
        return ans;
    }

    // 原始链表的从最后开始遍历
    public static boolean checkDoubleListReverse(List<Integer> origin, DoubleNode head) {
        DoubleNode end = null;
        for (int i = origin.size() - 1; i >= 0; i--) {
            if (!origin.get(i).equals(head.value)) {
                return false;
            }
            end = head;
            head = head.next;
        }
        for (int i = 0; i < origin.size(); i++) {
            if (!origin.get(i).equals(end.value)) {
                return false;
            }
            end = end.last;
        }
        return true;
    }

    // for test
    public static void main(String[] args) {
        int len = 50;
        int value = 100;
        int testTime = 100000;
        System.out.println("test begin!");
        for (int i = 0; i < testTime; i++) {
            // 随机生成一条双链表，返回头结点
            DoubleNode node3 = generateRandomDoubleList(len, value);
            // 获取原始的链表
            List<Integer> list3 = getDoubleListOriginOrder(node3);
            // 返回反转后的头结点
            node3 = reverseDoubleList(node3);
            // 对比是否反转
            if (!checkDoubleListReverse(list3, node3)) {
                System.out.println("Oops3!");
            }

            DoubleNode node4 = generateRandomDoubleList(len, value);
            List<Integer> list4 = getDoubleListOriginOrder(node4);
            node4 = reverseDoubleList(node4);
            if (!checkDoubleListReverse(list4, node4)) {
                System.out.println("Oops4!");
            }

        }
        System.out.println("test finish!");

    }
}
