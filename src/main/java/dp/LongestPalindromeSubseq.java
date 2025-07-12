package dp;

import java.lang.reflect.Array;
import java.util.Arrays;

public class LongestPalindromeSubseq {
    public int longestPalindromeSubseq(String s) {
        char[] chars = s.toCharArray();
        int n = chars.length;
        int[][] f = new int[n][n];
        for (int[] c : f) {
            Arrays.fill(c, -1);
        }
        return dfs(0, n - 1, f, chars);
    }

    private int dfs(int i, int j, int[][] f, char[] chars) {
        if (i > j) {
            return 0;
        }
        if (i == j) {
            return 1;
        }
        if (f[i][j] != -1) {
            return f[i][j];
        }
        if (chars[i] == chars[j]) {
            return f[i][j] = dfs(i + 1, j - 1, f, chars) + 2;
        }
        return f[i][j] = Math.max(dfs(i + 1, j, f, chars), dfs(i, j - 1, f, chars));
    }

    public int longestPalindromeSubseq2(String s) {
        char[] chars = s.toCharArray();
        int n = chars.length;
        int[][] f = new int[n][n];
        for (int i = n-1; i >=0; i--) {
            f[i][i]=1;
            for (int j = i+1; j <n; j++) {
                if (chars[i]==chars[j]){
                    f[i][j]=f[i+1][j-1]+2;
                }else {
                    f[i][j]=Math.max(f[i+1][j],f[i][j-1]);
                }
            }
        }
        return f[0][n-1];
    }

    public int longestPalindromeSubseq3(String S) {
        char[] s = S.toCharArray();
        int n = s.length;
        int[][] f = new int[n][n];
        for (int i = n - 1; i >= 0; i--) {
            f[i][i] = 1;
            for (int j = i + 1; j < n; j++) {
                f[i][j] = s[i] == s[j] ? f[i + 1][j - 1] + 2 :
                        Math.max(f[i + 1][j], f[i][j - 1]);
            }
        }
        return f[0][n - 1];
    }

}
