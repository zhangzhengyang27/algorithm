package class06;

/*
给定一个二叉树，找出其最大深度。
二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
*/
// 测试链接104：https://leetcode.com/problems/maximum-depth-of-binary-tree
public class Code04_MaximumDepthOfBinaryTree {

	public static class TreeNode {
		public int val;
		public TreeNode left;
		public TreeNode right;
	}

	// 以root为头的树，最大高度是多少返回！
	public static int maxDepth(TreeNode root) {
		if (root == null) {
			return 0;
		}
		return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
	}

}
