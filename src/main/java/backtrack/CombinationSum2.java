package backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum2 {
    List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        int n = candidates.length;
        Arrays.sort(candidates);
        boolean[] flags = new boolean[n];
        Arrays.fill(flags, false);
        dfs(0, candidates, flags, new ArrayList<>(), target, 0);
        return ans;
    }

    private void dfs(int i, int[] candidates, boolean[] flags, List<Integer> path, int target, int sum) {
        if (sum > target) {
            return;
        }
        if (sum == target) {
            ans.add(new ArrayList<>(path));
        }

        for (int j = i; j < candidates.length; j++) {
            if (j > 0 && candidates[i] == candidates[j - 1] && flags[j]) {
                continue;
            }
            path.add(candidates[j]);
            flags[i] = true;
            dfs(j + 1, candidates, flags, path, target, sum += candidates[j]);
            path.remove(path.size() - 1);
            flags[i] = false;
        }
    }
}

class Solution10 {
    List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        dfs(0, candidates, new ArrayList<>(), target, 0);
        return ans;
    }

    private void dfs(int start, int[] candidates, List<Integer> path, int target, int sum) {
        if (sum > target) {
            return;
        }
        if (sum == target) {
            ans.add(new ArrayList<>(path));
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            // 跳过重复选择，避免生成重复组合
            if (i > start && candidates[i] == candidates[i - 1]) {
                continue;
            }
            // 选择当前元素
            path.add(candidates[i]);
            // 递归处理下一个元素，注意i+1表示每个元素只能使用一次
            dfs(i + 1, candidates, path, target, sum + candidates[i]);
            // 回溯，撤销选择
            path.remove(path.size() - 1);
        }
    }
}
