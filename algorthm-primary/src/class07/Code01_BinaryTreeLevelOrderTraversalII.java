package class07;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
给你二叉树的根节点 root，返回其节点值 自底向上的层序遍历 。（即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历）
*/
// 测试链接：https://leetcode.com/problems/binary-tree-level-order-traversal-ii
public class Code01_BinaryTreeLevelOrderTraversalII {

    public static class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> ans = new LinkedList<>();
        if (root == null) {
            return ans;
        }
        // 队列
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        /*
        * 1、拿出此时队列的size，size有多少2）进行多少回
        * 2、弹出节点，有左加左，有右加右
        * 刚进入while的时候，size为1
        */

        while (!queue.isEmpty()) {
            // int size = queue.size(); queue的size是动态增加的 ，后面再一直增加 queue.add(curNode.left);
            int size = queue.size();
            List<Integer> curAns = new LinkedList<>();
            for (int i = 0; i < size; i++) {
                TreeNode curNode = queue.poll();
                curAns.add(curNode.val);
                if (curNode.left != null) {
                    queue.add(curNode.left);
                }
                if (curNode.right != null) {
                    queue.add(curNode.right);
                }
            }
            ans.add(0, curAns);
        }
        return ans;
    }

}
