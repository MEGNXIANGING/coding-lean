package tree;

import java.util.ArrayList;
import java.util.List;

public class PreorderTraversal {
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

        public List<Integer> preorderTraversal(TreeNode root) {

            List<Integer> res = new ArrayList<>();
            dfs(root, res);
            return res;
        }
        private void  dfs(TreeNode root, List<Integer> res){
            if (root == null) {
                return;
            }
            dfs(root.left,res);
            dfs(root.right,res);
            res.add(root.val);
        }
    }
}
