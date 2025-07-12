package dp;

import java.util.Arrays;

public class MinScoreTriangulation {
    public int minScoreTriangulation(int[] values) {
        int n = values.length;
        int[][] f = new int[n][n];
        for (int[] c : f) {
            Arrays.fill(c, -1);
        }
        return dfs(0, n - 1, values, f);
    }

    private int dfs(int i, int j, int[] v, int[][] f) {
        if (i + 1 == j) {
            return 0;
        }
        if (f[i][j] != -1) {
            return f[i][j];
        }
        int res = Integer.MAX_VALUE;
        for (int k = i + 1; k < j; k++) {
            res = Math.min(res, dfs(i, k, v, f) + dfs(k, j, v, f)+ v[i] * v[j] * v[k]) ;
        }
        return f[i][j]=res;
    }
}
