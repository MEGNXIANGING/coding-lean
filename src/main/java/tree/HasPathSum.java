package tree;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

public class HasPathSum {
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

    public boolean hasPathSum(TreeNode root, int targetSum) {
        int sum = 0;
        if (root == null) {
            return false;
        }
        return  dfs(root, sum ,targetSum);
    }

    private boolean dfs(TreeNode root, int sum,int targetSum) {
        if (root == null) {
            return false;
        }
        sum += root.val;
        if (root.left == null && root.right==null) {
            return sum==targetSum;
        }
        return dfs(root.left, sum ,targetSum) || dfs(root.right, sum ,targetSum);
    }

//    public boolean hasPathSum2(TreeNode root, int targetSum) {
//        if (root == null) return false;
//        return dfs(root, 0, targetSum);
//    }
//
//    private boolean dfs(TreeNode node, int currentSum, int targetSum) {
//        if (node == null) return false;
//
//        currentSum += node.val;
//
//        // 到达叶子节点时检查路径和
//        if (node.left == null && node.right == null) {
//            return currentSum == targetSum;
//        }
//
//        // 递归检查左右子树
//        return dfs(node.left, currentSum, targetSum) ||
//                dfs(node.right, currentSum, targetSum);
//    }
}







