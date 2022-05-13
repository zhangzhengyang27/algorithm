package class04;

import java.util.LinkedList;
import java.util.Queue;

//用单链表实现队列
public class LinkedListToQueue {
    public static class Node<V> {
        public V value;
        public Node<V> next;

        public Node(V v) {
            value = v;
            next = null;
        }
    }

    public static class MyQueue<V> {
        private Node<V> head;
        private Node<V> tail;
        private int size;

        public MyQueue() {
            head = null;
            tail = null;
            size = 0;
        }

        public boolean isEmpty() {
            return size == 0;
        }

        public int size() {
            return size;
        }

        // 新增一个节点
        public void offer(V value) {
            Node<V> cur = new Node<V>(value);
            //头尾都指向cur
            if (tail == null) {
                head = cur;
                tail = cur;
            } else {
                tail.next = cur;
                tail = cur;
            }
            size++;
        }

        // 从头结点删除一个  C/C++的同学需要做节点析构的工作
        public V poll() {
            V ans = null;
            if (head != null) {
                ans = head.value;
                head = head.next;
                size--;
            }
            //  表示所有的数据都被删除了
            if (head == null) {
                tail = null;
            }
            return ans;
        }

        // 查看头节点  C/C++的同学需要做节点析构的工作
        public V peek() {
            V ans = null;
            if (head != null) {
                ans = head.value;
            }
            return ans;
        }

    }

    // 测试代码
    public static void testQueue() {
        MyQueue<Integer> myQueue = new MyQueue<>();
        Queue<Integer> test = new LinkedList<>();
        int testTime = 5000000;
        int maxValue = 200000000;
        System.out.println("测试开始！");
        for (int i = 0; i < testTime; i++) {
            if (myQueue.isEmpty() != test.isEmpty()) {
                System.out.println("Oops!");
            }
            if (myQueue.size() != test.size()) {
                System.out.println("Oops!");
            }
            double decide = Math.random();
            if (decide < 0.33) {
                int num = (int) (Math.random() * maxValue);
                myQueue.offer(num);
                test.offer(num);
            } else if (decide < 0.66) {
                if (!myQueue.isEmpty()) {
                    int num1 = myQueue.poll();
                    int num2 = test.poll();
                    if (num1 != num2) {
                        System.out.println("Oops!");
                    }
                }
            } else {
                if (!myQueue.isEmpty()) {
                    int num1 = myQueue.peek();
                    int num2 = test.peek();
                    if (num1 != num2) {
                        System.out.println("Oops!");
                    }
                }
            }
        }
        if (myQueue.size() != test.size()) {
            System.out.println("Oops!");
        }
        while (!myQueue.isEmpty()) {
            int num1 = myQueue.poll();
            int num2 = test.poll();
            if (num1 != num2) {
                System.out.println("Oops!");
            }
        }
        System.out.println("测试结束！");
    }

    public static void main(String[] args) {
        testQueue();
    }
}
