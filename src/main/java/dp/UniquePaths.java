package dp;

import java.util.Arrays;

public class UniquePaths {
    public int uniquePaths(int m, int n) {
        int[][] ab = new int[m][n];
        for (int i = 0; i < m; i++) {
            ab[i][0] = 1;
        }
        for (int i = 0; i < n; i++) {
            ab[0][i] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                ab[i][j] = ab[i][j - 1] + ab[i - 1][j];
            }
        }
        return ab[m - 1][n - 1];
    }


    public int uniquePaths3(int m, int n) {
        int[] dp = new int[n];
        Arrays.fill(dp,1);
        for (int i = 1; i < m; i++) {
            for (int j = 1; j <n ; j++) {
                dp[j]+=dp[j-1];
            }
        }
        return dp[n-1];
    }

    public int uniquePaths2(int m, int n) {
        int N = m + n - 2; // 总步数
        int k = Math.min(m - 1, n - 1); // 选择较小的组合数参数，减少计算量
        long result = 1;

        // 计算组合数 C(N, k) = N! / (k! * (N-k)!)
        for (int i = 1; i <= k; i++) {
            result = result * (N - k + i) / i;
        }

        return (int) result;
    }

}
