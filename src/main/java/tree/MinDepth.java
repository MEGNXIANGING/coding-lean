package tree;

public class MinDepth {
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

    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int i = maxDepth(root.left);
        int i1 = maxDepth(root.right);
        System.out.println(i + "测试" + i1);
        return Math.min(i, i1) + 1;
    }

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }

    public int minDepth2(TreeNode root) {
        // 空节点就没有高度，返回0
        if (root == null) return 0;
        // 左右子树都为空，则只有根节点，返回高度1
        if (root.left == null && root.right == null) {
            return 1;
        }
        // 若左子树为空
        if (root.left == null) {
            return minDepth2(root.right) + 1;
        }
        // 若右子树为空
        if (root.right == null) {
            return minDepth2(root.left) + 1;
        }
        // 若左右子树都不为空，返回左右子树高度的最小值 在+1
        return Math.min(minDepth2(root.left), minDepth2(root.right)) + 1;
    }


}
