package class07;

/*
给定一个二叉树，判断它是否是高度平衡的二叉树：
一个二叉树每个节点的左右两个子树的高度差的绝对值不超过1；

搜索二叉树：就是左树比我小，右树比我大
*/
// 测试链接110：https://leetcode.com/problems/balanced-binary-tree
public class Code02_BalancedBinaryTree {

    public static class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public static class Info {
        public boolean isBalanced;
        public int height;

        public Info(boolean i, int h) {
            isBalanced = i;
            height = h;
        }
    }

    public static boolean isBalanced(TreeNode root) {
        return process(root).isBalanced;
    }

    public static Info process(TreeNode root) {
        if (root == null) {
            return new Info(true, 0);
        }
		//  左树是否平衡，和左树的高度
        Info leftInfo = process(root.left);
		//  右树是否平衡，和右树的高度
        Info rightInfo = process(root.right);
        // 比较左树和右树的高度最大值+1；
        int height = Math.max(leftInfo.height, rightInfo.height) + 1;
        // 判断是否平衡
        boolean isBalanced = leftInfo.isBalanced && rightInfo.isBalanced && Math.abs(leftInfo.height - rightInfo.height) < 2;

        return new Info(isBalanced, height);
    }

}
