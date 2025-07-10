package backtrack;

import java.util.HashMap;
import java.util.Map;

public class SubarraySum {
    int count = 0;

    public int subarraySum(int[] nums, int k) {
        // 遍历所有起点
        for (int start = 0; start < nums.length; start++) {
            dfs(nums, k, start, 0);
        }
        return count;
    }

    void dfs(int[] nums, int k, int index, int sum) {
        if (index >= nums.length) return;

        sum += nums[index];
        if (sum == k) count++;

        // 必须连续，只考虑下一个元素
        dfs(nums, k, index + 1, sum);
    }

    public int subarraySum2(int[] nums, int k) {
        int count = 0, sum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1); // 初始前缀和为0出现1次

        for (int num : nums) {
            sum += num; // 计算当前前缀和
            // 检查是否存在前缀和 = sum - k
            if (map.containsKey(sum - k)) {
                count += map.get(sum - k);
            }
            // 更新当前前缀和出现次数
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return count;
    }
}
