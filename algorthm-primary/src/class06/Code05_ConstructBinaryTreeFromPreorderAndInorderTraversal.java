package class06;

import java.util.HashMap;

/*
从前序与中序遍历序列构造二叉树
给定两个整数数组preorder和inorder，其中preorder是二叉树的先序遍历，inorder是同一棵树的中序遍历，请构造二叉树并返回其根节点。
preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
*/
//测试链接：https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal
public class Code05_ConstructBinaryTreeFromPreorderAndInorderTraversal {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }
    // 第一种方法
    public static TreeNode buildTree1(int[] pre, int[] in) {
        if (pre == null || in == null || pre.length != in.length) {
            return null;
        }
        return f(pre, 0, pre.length - 1, in, 0, in.length - 1);
    }

    // 有一棵树，先序结果是pre[L1...R1]，中序结果是in[L2...R2]
    // 请建出整棵树返回头节点
    public static TreeNode f(int[] pre, int L1, int R1, int[] in, int L2, int R2) {
        //  处理左树，或右树为空
        if (L1 > R1) {
            return null;
        }
        TreeNode head = new TreeNode(pre[L1]);
        if (L1 == R1) {
            return head;
        }
        int find = L2;
        // pre[L1] 肯定是头结点，要在中序种也找到头结点，然后分组
        while (in[find] != pre[L1]) {
            find++;
        }
        // find - L2  确定第一组的个数  根节点左边到的先序，左边的中序
        head.left = f(pre, L1 + 1, L1 + find - L2, in, L2, find - 1);
        // 根节点右边到的现需，右边边的中序
        head.right = f(pre, L1 + find - L2 + 1, R1, in, find + 1, R2);
        return head;
    }

    //    ------------------------------------------------------------------------------------------------------------------------------

    // 第二种方法
    public static TreeNode buildTree2(int[] pre, int[] in) {
        if (pre == null || in == null || pre.length != in.length) {
            return null;
        }
        HashMap<Integer, Integer> valueIndexMap = new HashMap<>();
        for (int i = 0; i < in.length; i++) {
            valueIndexMap.put(in[i], i);
        }
        return g(pre, 0, pre.length - 1, in, 0, in.length - 1, valueIndexMap);
    }

    // 有一棵树，先序结果是pre[L1...R1]，中序结果是in[L2...R2]
    // 请建出整棵树返回头节点
    public static TreeNode g(int[] pre, int L1, int R1, int[] in, int L2, int R2, HashMap<Integer, Integer> valueIndexMap) {
        if (L1 > R1) {
            return null;
        }
        //  省去遍历的时间
        TreeNode head = new TreeNode(pre[L1]);
        if (L1 == R1) {
            return head;
        }

        int find = valueIndexMap.get(pre[L1]);
        head.left = g(pre, L1 + 1, L1 + find - L2, in, L2, find - 1, valueIndexMap);
        head.right = g(pre, L1 + find - L2 + 1, R1, in, find + 1, R2, valueIndexMap);
        return head;
    }

}
