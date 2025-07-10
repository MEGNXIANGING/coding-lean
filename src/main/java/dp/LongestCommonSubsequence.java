package dp;

public class LongestCommonSubsequence {
    /**
     * todo 不会
     */
    public int longestCommonSubsequence(String text1, String text2) {
        char[] m = text1.toCharArray();
        char[] n = text2.toCharArray();
        int[][] f = new int[m.length + 1][n.length + 1];
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < n.length; j++) {
                f[i][j] = m[i] == n[j] ? f[i][j] + 1 : Math.max(f[i + 1][j], f[i][j + 1]);
            }
        }
        return f[m.length][n.length];
    }
}
