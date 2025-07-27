package dp;

import java.util.Arrays;

public class MaxSubArray {
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        Integer[] memo = new Integer[n]; // memo[i]记录以nums[i]结尾的最大和
        memo[0] = nums[0];
        int max = nums[0];

        // 计算每个memo[i]
        dfs(n - 1, memo, nums);

        // 找出最大值
        for (int num : memo) {
            max = Math.max(max, num);
        }
        return max;
    }

    private int dfs(int i, Integer[] memo, int[] nums) {
        if (memo[i] != null) return memo[i];

        int prev = dfs(i - 1, memo, nums);
        memo[i] = Math.max(nums[i], prev + nums[i]);
        return memo[i];
    }
    public int maxSubArray2(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n]; // dp[i]表示以nums[i]结尾的最大子数组和
        dp[0] = nums[0];
        int max = dp[0];
        for (int i = 1; i < n; i++) {
            dp[i] = Math.max(nums[i], dp[i-1] + nums[i]);
            max= Math.max(max, dp[i]);
        }
        return max;
    }



}
