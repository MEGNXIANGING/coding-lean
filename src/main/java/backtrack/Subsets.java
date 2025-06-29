package backtrack;

import java.util.ArrayList;
import java.util.List;

public class Subsets {
    /**
     * 示例 1：
     * <p>
     * 输入：nums = [1,2,3]
     * 输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
     * 示例 2：
     * <p>
     * 输入：nums = [0]
     * 输出：[[],[0]]
     */
    public static void main(String[] args) {
        int [] nums ={1,2,3};
        List<List<Integer>> subsets = subsets(nums);
        System.out.println(subsets);
    }
    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        dfs2(0, ans, nums, new ArrayList<>());
        return ans;
    }


    private static void dfs2(int i, List<List<Integer>> ans, int[] nums, List<Integer> path) {
        ans.add(new ArrayList<>(path));// 复制 path
        for (int j = i; j < nums.length; j++) {
            path.add(nums[j]);
            dfs2(j+1,ans,nums,path);
            path.remove(path.size()-1);// 恢复现场
        }
    }


    private static void dfs(int i, List<List<Integer>> ans, int[] nums, List<Integer> path) {
        System.out.println("i的值为"+i);
        if (i == nums.length) {
            System.out.println(path);
            ans.add(new ArrayList<>(path));// 复制 path
            return;
        }
        dfs(i+1,ans,nums,path);
        path.add(nums[i]);
        dfs(i+1,ans,nums,path);
        path.remove(path.size()-1);// 恢复现场

    }



    private final List<List<Integer>> ans = new ArrayList<>();
    private final List<Integer> path = new ArrayList<>();
    private int[] nums;

    public List<List<Integer>> subsets1(int[] nums) {
        this.nums = nums;
        dfs1(0);
        return ans;
    }

    private void dfs1(int i) {
        if (i == nums.length) { // 子集构造完毕
            ans.add(new ArrayList<>(path)); // 复制 path
            return;
        }

        // 不选 nums[i]
        dfs1(i + 1);

        // 选 nums[i]
        path.add(nums[i]);
        dfs1(i + 1);
        path.remove(path.size() - 1); // 恢复现场
    }

}
