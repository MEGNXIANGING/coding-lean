package backtrack;

import java.util.*;

public class FindSubsequences {
    List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> findSubsequences(int[] nums) {
        dfs(0, nums, new ArrayList<>());
        return ans;
    }

    private void dfs(int i, int[] nums, List<Integer> path) {
        if (path.size() >= 2) {
            ans.add(new ArrayList<>(path));
        }
        Set<Integer> set = new HashSet<>();
        for (int j = i; j < nums.length; j++) {
            if (set.contains(nums[j])) {
                continue;
            }
            if (path.isEmpty() || nums[j] >= path.get(path.size() - 1)) {
                path.add(nums[j]);
                set.add(nums[j]);
                dfs(j + 1, nums, path);
                path.remove(path.size() - 1);
            }
        }
    }
}
