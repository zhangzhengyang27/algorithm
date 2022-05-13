package class07;

// 验证搜索二叉树
/*
给你一个二叉树的根节点 root ，判断其是否是一个有效的二叉搜索树。
有效 二叉搜索树定义如下：
节点的左子树只包含 小于 当前节点的数。
节点的右子树只包含 大于 当前节点的数。
所有左子树和右子树自身必须也是二叉搜索树。
*/
public class Code05_IsBinarySearchTree {

    public static class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public boolean isValidBST(TreeNode root) {
        return process(root).isBST;
    }
    public static class Info {
        public boolean isBST;
        public int max;
        public int min;

        public Info(boolean is, int ma, int mi) {
            isBST = is;
            max = ma;
            min = mi;
        }
    }

    // 根据子节点往上推断
    public static Info process(TreeNode x) {
        if (x == null) {
            return null;
        }
        Info leftInfo = process(x.left);
        Info rightInfo = process(x.right);
        int max = x.val;
        int min = x.val;
        if (leftInfo != null) {
            max = Math.max(leftInfo.max, max);
            min = Math.min(leftInfo.min, min);
        }
        if (rightInfo != null) {
            max = Math.max(rightInfo.max, max);
            min = Math.min(rightInfo.min, min);
        }
        boolean isBST = true;
        if (leftInfo != null && !leftInfo.isBST) {
            isBST = false;
        }
        if (rightInfo != null && !rightInfo.isBST) {
            isBST = false;
        }
        boolean leftMaxLessX = leftInfo == null ? true : (leftInfo.max < x.val);
        boolean rightMinMoreX = rightInfo == null ? true : (rightInfo.min > x.val);
        // && 有一个为false 就是false;如果都不为true那么isBST则是false
        if (!(leftMaxLessX && rightMinMoreX)) {
            isBST = false;
        }
        return new Info(isBST, max, min);
    }

//    public static Info process(TreeNode x) {
//        if (x == null) {
//            return null;
//        }
//        Info leftInfo = process(x.left);
//        Info rightInfo = process(x.right);
//        int max = x.val;
//        int min = x.val;
//        if (leftInfo != null) {
//            max = Math.max(leftInfo.max, max);
//            min = Math.min(leftInfo.min, min);
//        }
//        if (rightInfo != null) {
//            max = Math.max(rightInfo.max, max);
//            min = Math.min(rightInfo.min, min);
//        }
//        boolean isBST = false;
//        boolean leftIsBst = leftInfo == null ? true : leftInfo.isBST;
//        boolean rightIsBst = rightInfo == null ? true : rightInfo.isBST;
//        boolean leftMaxLessX = leftInfo == null ? true : (leftInfo.max < x.val);
//        boolean rightMinMoreX = rightInfo == null ? true : (rightInfo.min > x.val);
//        if (leftIsBst && rightIsBst && leftMaxLessX && rightMinMoreX) {
//            isBST = true;
//        }
//        return new Info(isBST, max, min);
//    }

}
