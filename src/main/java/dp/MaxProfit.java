package dp;

import java.util.Arrays;

public class MaxProfit {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] f = new int[n + 1][2];
        f[0][0] = 0;
        f[0][1] = -prices[0];
        for (int i = 0; i < n - 1; i++) {
            f[i + 1][0] = Math.max(f[i][1] + prices[i], f[i][0]);
            f[i + 1][1] = Math.max(f[i][0] - prices[i], f[i][1]);
        }
        return f[n][0];
    }

    public int maxProfit2(int[] prices) {
        int n = prices.length;
        int[][] memo = new int[n + 1][2];
        for (int[] c : memo) {
            Arrays.fill(c, -1);
        }
        return dfs(n - 1, 0, prices, memo);
    }

    private int dfs(int i, int flag, int[] prices, int[][] memo) {
        if (i < 0) {
            return flag == 1 ? Integer.MIN_VALUE : 0;
        }
        if (memo[i][flag] != -1) {
            return memo[i][flag];
        }

        if (flag == 1) {
            // 当前持有股票：可以选择继续持有或卖出
            memo[i][flag] = Math.max(dfs(i - 1, 1, prices, memo),
                    dfs(i - 1, 0, prices, memo) - prices[i]);
        } else {
            // 当前不持有股票：可以选择保持不持有或买入
            memo[i][flag] = Math.max(dfs(i - 1, 0, prices, memo),
                    dfs(i - 1, 1, prices, memo) + prices[i]);
        }

        return memo[i][flag];
    }
}
