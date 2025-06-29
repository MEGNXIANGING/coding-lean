package dp;

import java.util.List;

public class Rob {
    // 打家劫舍方法，参数为存储房屋金额的列表，返回能偷窃到的最大金额
    public int rob(int[] nums) {
        int n = nums.length;
        // 用于缓存计算结果，初始值 -1 表示未计算过
        int[] cache = new int[n];
        for (int i = 0; i < n; i++) {
            cache[i] = -1;
        }
        return dfs(nums, n - 1, cache);
    }

    // 递归辅助方法，i 表示当前处理到的房屋索引，cache 用于缓存已计算结果
    private int dfs(int[] nums, int i, int[] cache) {
        // 如果索引小于 0，说明没有房屋可以考虑，返回 0
        if (i < 0) {
            return 0;
        }
        // 如果缓存中已有结果，直接返回，避免重复计算
        if (cache[i] != -1) {
            return cache[i];
        }
        // 两种选择：不偷当前房屋（取 dfs(i - 1) 的结果）；偷当前房屋（取 dfs(i - 2) + 当前房屋金额的结果），取较大值
        int res = Math.max(dfs(nums, i - 1, cache), dfs(nums, i - 2, cache) + nums[i]);
        // 将计算结果存入缓存
        cache[i] = res;
        return res;
    }

}
