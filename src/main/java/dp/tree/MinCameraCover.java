package dp.tree;

public class MinCameraCover {
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


    public int minCameraCover(TreeNode root) {
        int[] dfs = dfs(root);
        return Math.min(dfs[0],dfs[2]);

    }

    private int[] dfs(TreeNode node) {
        if (node == null) {
            return new int[]{Integer.MIN_VALUE / 2, 0, 0};
        }
        int[] l = dfs(node.left);
        int[] r = dfs(node.right);
        int chose = Math.min(l[0], l[1]) + Math.min(r[0], r[1]) + 1;
        int byFa = Math.min(l[0], l[2]) + Math.min(r[0], r[2]);
        int byc = Math.min(Math.min(l[0] + r[2], l[2] + r[0]), l[0] + r[0]);
        return new int[]{chose, byFa, byc};
    }
}
