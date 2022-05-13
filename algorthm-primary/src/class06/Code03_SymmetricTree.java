package class06;

/*
给你一个二叉树的根节点 root ， 检查它是否轴对称。
*/
// 测试链接101：https://leetcode.com/problems/symmetric-tree
public class Code03_SymmetricTree {

	public static class TreeNode {
		public int val;
		public TreeNode left;
		public TreeNode right;
	}

	public static boolean isSymmetric(TreeNode root) {
		return isMirror(root, root);
	}

	public static boolean isMirror(TreeNode h1, TreeNode h2) {
		//	一个为空，一个不为空
		if (h1 == null ^ h2 == null) {
			return false;
		}
		if (h1 == null && h2 == null) {
			return true;
		}
		return h1.val == h2.val && isMirror(h1.left, h2.right) && isMirror(h1.right, h2.left);
	}

}
