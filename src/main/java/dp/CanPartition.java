package dp;

import java.util.Arrays;

public class CanPartition {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int item : nums) {
            sum += item;
        }
        if (sum % 2 == 1) {
            //偶数场景
            return false;
        }
        int k = sum / 2;
        int n = nums.length - 1;
        int[][] meo = new int[n][k + 1];
        for (int[] c : meo) {
            Arrays.fill(c, -1);
        }
        return dfs(n - 1, k, nums, meo);
    }

    private boolean dfs(int i, int j, int[] nums, int[][] meo) {
        if (i < 0) {
            return j == 0;
        }
        if (meo[i][j] != -1) {
            return meo[i][j] == 1;
        }
        boolean res = j >= nums[i] && dfs(i - 1, j - nums[i], nums, meo) || dfs(i - 1, j, nums, meo);
        meo[i][j] = res ? 1 : 0;
        return res;
    }


    public boolean canPartition2(int[] nums) {
        int sum = 0;
        for (int item : nums) {
            sum += item;
        }
        if (sum % 2 == 1) {
            //偶数场景
            return false;
        }
        int k = sum / 2;
        int n = nums.length - 1;
        boolean[][] f = new boolean[n + 1][k + 1];
        f[0][0] = true;
        for (int i = 0; i < n; i++) {
            int x = nums[i];
            for (int j = 0; j <= k; j++) {
                f[i + 1][j] = j >= x && f[i][j - x] || f[i][j];
            }
        }
        return f[n][k];
    }

    public boolean canPartition3(int[] nums) {
        int sum = 0;
        for (int item : nums) {
            sum += item;
        }
        if (sum % 2 == 1) {
            //偶数场景
            return false;
        }
        int k = sum / 2;
        int n = nums.length - 1;
        boolean[] f = new boolean[k + 1];
        f[0] = true;
        int s2 = 0;

        for (int i = 0; i <= n; i++) {
            s2 = Math.min(s2 + nums[i], k);
            for (int j = s2; j >=0; j--) {
                f[j]=f[j] || f[j-nums[i]];
            }
            if (f[k]) {
                return true;
            }
        }
        return f[k];
    }
}
