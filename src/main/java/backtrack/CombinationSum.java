package backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(candidates);
        dfs(0, candidates, ans, target, 0, new ArrayList<>());
        return ans;
    }

    private void dfs(int i, int[] candidates, List<List<Integer>> ans, int target, int sum, List<Integer> path) {

        if (sum == target) {
            ans.add(new ArrayList<>(path));
            return;
        }
        for (int j = i; j < candidates.length; j++) {
            if (sum + candidates[j] > target) {
                return;
            }
            path.add(candidates[j]);
            dfs(j, candidates, ans, target, sum + candidates[j], path);
            path.remove(path.size() - 1);
        }
    }
}

// 剪枝优化
class Solution6 {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates); // 先进行排序
        backtracking(res, new ArrayList<>(), candidates, target, 0, 0);
        return res;
    }

    public void backtracking(List<List<Integer>> res, List<Integer> path, int[] candidates, int target, int sum, int idx) {
        // 找到了数字和为 target 的组合
        if (sum == target) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = idx; i < candidates.length; i++) {
            // 如果 sum + candidates[i] > target 就终止遍历
            if (sum + candidates[i] > target) break;
            path.add(candidates[i]);
            backtracking(res, path, candidates, target, sum + candidates[i], i);
            path.remove(path.size() - 1); // 回溯，移除路径 path 最后一个元素
        }
    }
}
