package backtrack;

public class BackPkg {

    public int getMaxV(int[] w, int[] v, int c) {
        int n = w.length;
        return dfs(n - 1, c, w, v);
    }

    private int dfs(int i, int c, int[] w, int[] v) {
        if (i < 0) {
            return 0;
        }
        if (c < w[i]) {
            return dfs(i - 1, c, w, v);
        }
        return Math.max(dfs(i - 1, c, w, v), dfs(i - 1, c - w[i], w, v) + v[i]);
    }
}
