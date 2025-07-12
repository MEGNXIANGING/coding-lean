package dp;

import java.util.Arrays;

public class MaxProfit4 {
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        int[][][] f = new int[n + 1][k+2][2];
        for (int[][] mat : f) {
            for (int[] row : mat) {
                Arrays.fill(row, Integer.MIN_VALUE / 2); // 防止溢出
            }
        }
        for (int j = 1; j <= k + 1; j++) {
            f[0][j][0] = 0;
        }

        for (int i = 0; i < n; i++) {
            int p = prices[i];
            for (int j = 1; j <= k + 1; j++) {
                f[i + 1][j][0] = Math.max(f[i][j][0], f[i][j][1] + p);
                f[i + 1][j][1] = Math.max(f[i][j][1], f[i][j-1][0] + p);
            }

        }
        return f[n][k+1][0];
    }
}
