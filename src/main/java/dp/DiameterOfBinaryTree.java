package dp;

public class DiameterOfBinaryTree {
    private int ans;
    public int diameterOfBinaryTree(TreeNode root) {
        dfs(root);
        return ans;
    }

    private int dfs(TreeNode node) {
        if (node==null){
            return -1;
        }
        int l=dfs(node.left)+1;
        int r=dfs(node.right)+1;
        ans=Math.max(l+r,ans);
        return Math.max(l,r);
    }


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}

