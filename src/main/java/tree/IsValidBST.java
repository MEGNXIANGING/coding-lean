package tree;

public class IsValidBST {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        return dfsBst(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean dfsBst(TreeNode root, long minValue, long maxValue) {
        if (root == null) {
            return true;
        }
        long x = root.val;
        return x > minValue && x < maxValue
                && dfsBst(root.left, minValue, x)
                && dfsBst(root.right, x, maxValue);
    }

    private  long pre = Long.MIN_VALUE;

    public boolean isValidONBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (!isValidONBST(root.left)) {
            return false;
        }
        long x = root.val;
        if (x <= pre) {
            return false;
        }
        pre = x;
        return isValidONBST(root.right);
    }



    public boolean isValidBST2(TreeNode root) {
        return dfs2(root)[1]!=Long.MAX_VALUE;
    }

    private long[] dfs2(TreeNode node) {
        if (node == null) {
            return new long[]{Long.MAX_VALUE, Long.MIN_VALUE};
        }
        long[] left = dfs2(node.left);
        long[] right = dfs2(node.right);
        long x = node.val;
        // 也可以在递归完左子树之后立刻判断，如果发现不是二叉搜索树，就不用递归右子树了
        if (x <= left[1] || x >= right[0]) {
            return new long[]{Long.MIN_VALUE, Long.MAX_VALUE};
        }
        return new long[]{Math.min(left[0], x), Math.max(right[1], x)};
    }

}
