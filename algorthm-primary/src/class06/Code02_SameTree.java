package class06;

/*
给你两棵二叉树的根节点 p 和 q ，编写一个函数来检验这两棵树是否相同。
如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的。
*/
// 测试链接100：https://leetcode.com/problems/same-tree
public class Code02_SameTree {

	public static class TreeNode {
		public int val;
		public TreeNode left;
		public TreeNode right;
	}

	public static boolean isSameTree(TreeNode p, TreeNode q) {
		//	如果pq有一个为空，另一个不为空
		if (p == null ^ q == null) {
			return false;
		}
		if (p == null && q == null) {
			return true;
		}
		// 都不为空
		return p.val == q.val && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
	}

}
