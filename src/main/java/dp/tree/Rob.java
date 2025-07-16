package dp.tree;

public class Rob {
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

    public int rob(TreeNode root) {
        int[] dfs = dfs(root);
        return Math.max(dfs[0], dfs[1]);
    }

    private int[] dfs(TreeNode node) {
        if (node == null) {
            return new int[]{0, 0};
        }
        int[] left = dfs(node.left);
        int[] right = dfs(node.right);
        int rob = left[1] + right[1] + node.val;
        int notRob = Math.max(left[0], left[1]) + Math.max(right[0], right[1]); // 不选
        return new int[]{rob, notRob};
    }
}
