package dp;

public class LengthOfLIS {
    public int lengthOfLIS(int[] nums) {
        int ans = 0;
        int n = nums.length;
        int[] memo = new int[n];
        for (int i = 0; i < n; i++) {
            ans = Math.max(ans, dfs(memo, nums, i));
        }
        return ans;
    }

    private int dfs(int[] memo, int[] nums, int i) {
        if (memo[i] != 0) { // 修正：检查memo[i]是否已计算
            return memo[i];
        }
        int res = 0;
        for (int j = 0; j < i; j++) {
            if (nums[j] < nums[i]) {
                res = Math.max(res, dfs(memo, nums, j));
            }
        }
        res++;
        memo[i] = res; // 存储结果
        return res;
    }

    public int lengthOfLIS2(int[] nums) {
        int n = nums.length;
        int[] f = new int[n];
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            int item = nums[i];
            for (int j = 0; j < i; j++) {
                if (nums[j] < item) {
                    f[i]= Math.max(f[i],f[j]);
                }
            }
            ans = Math.max(ans, ++f[i]);
        }
        return ans;
    }
}



