package dp;

public class MinDistance {
    public int minDistance(String word1, String word2) {
        char[] d1 = word1.toCharArray();
        char[] d2 = word2.toCharArray();
        int m = d1.length;
        int n = d2.length;
        int[][] f = new int[m + 1][n + 1];
        for (int i = 0; i < d1.length; i++) {
            for (int j = 0; j < d2.length; j++) {
                f[i + 1][j + 1] = d1[i] == d2[j] ? f[i][j] :Math.max(f[i+1][j],Math.max(f[i][j+1],f[i][j]))+1;
            }
        }
        return f[m][n];
    }
    public int minDistance2(String word1, String word2) {
        char[] s = word1.toCharArray();
        char[] t = word2.toCharArray();
        int n = s.length;
        int m = t.length;
        int[][] f = new int[n + 1][m + 1];
        for (int j = 0; j < m; j++) {
            f[0][j + 1] = j + 1;
        }
        for (int i = 0; i < n; i++) {
            f[i + 1][0] = i + 1;
            for (int j = 0; j < m; j++) {
                f[i + 1][j + 1] = s[i] == t[j] ? f[i][j] :
                        Math.min(Math.min(f[i][j + 1], f[i + 1][j]), f[i][j]) + 1;
            }
        }
        return f[n][m];


    }
}
