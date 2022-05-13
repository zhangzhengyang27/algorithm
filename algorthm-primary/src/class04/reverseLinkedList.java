package class04;

import java.util.ArrayList;
import java.util.List;

// 单链表的反转逆序操作
public class reverseLinkedList {
    public static class Node {
        public int value;
        public Node next;

        public Node(int data) {
            value = data;
        }
    }
    //	单链表的逆序  传进来的形参其实是复制了一份的，修改它不影响外面的值
    public static Node reverseLinkedList(Node head) {
        Node pre = null;
        Node next = null;
        while (head != null) {
            // 提前记录next
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }

    //  测试单链表的反转，需要额外的一个链表
    public static Node testReverseLinkedList(Node head) {
        if (head == null) {
            return null;
        }
        ArrayList<Node> list = new ArrayList<>();
        while (head != null) {
            list.add(head);
            head = head.next;
        }
        list.get(0).next = null;
        int N = list.size();
        for (int i = 1; i < N; i++) {
            list.get(i).next = list.get(i - 1);
        }
        return list.get(N - 1);
    }
    // 随机生成单链表 for test
    public static Node generateRandomLinkedList(int len, int value) {
        int size = (int) (Math.random() * (len + 1));
        if (size == 0) {
            return null;
        }
        size--;
        Node head = new Node((int) (Math.random() * (value + 1)));
        Node pre = head;
        while (size != 0) {
            Node cur = new Node((int) (Math.random() * (value + 1)));
            pre.next = cur;
            pre = cur;
            size--;
        }
        return head;
    }
    // 获取原始的列表
    public static List<Integer> getLinkedListOriginOrder(Node head) {
        List<Integer> ans = new ArrayList<>();
        while (head != null) {
            ans.add(head.value);
            head = head.next;
        }
        return ans;
    }
    // 原始链表的从最后开始遍历
    public static boolean checkLinkedListReverse(List<Integer> origin, Node head) {
        for (int i = origin.size() - 1; i >= 0; i--) {
            if (!origin.get(i).equals(head.value)) {
                return false;
            }
            head = head.next;
        }
        return true;
    }
    public static void f(Node head) {
        head = head.next;
    }

    // for test
    public static void main(String[] args) {
        int len = 50;
        int value = 100;
        int testTime = 100000;
        System.out.println("test begin!");
        for (int i = 0; i < testTime; i++) {
            // 随机生成一条单链表，返回头结点
            Node node1 = generateRandomLinkedList(len, value);
            // 获取原始的单链表
            List<Integer> list1 = getLinkedListOriginOrder(node1);
            // 拷贝了一份值node1传递，返回反转后的头结点
            node1 = reverseLinkedList(node1);
            // 对比是否反转
            if (!checkLinkedListReverse(list1, node1)) {
                System.out.println("Oops1!");
            }

            // 相同的操作
            Node node2 = generateRandomLinkedList(len, value);
            List<Integer> list2 = getLinkedListOriginOrder(node2);
            node2 = testReverseLinkedList(node2);
            if (!checkLinkedListReverse(list2, node2)) {
                System.out.println("Oops2!");
            }
        }
        System.out.println("test finish!");

    }
}
