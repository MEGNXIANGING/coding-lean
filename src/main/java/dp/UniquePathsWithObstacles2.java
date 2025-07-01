package dp;

public class UniquePathsWithObstacles2 {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] dp = new int[m][n];
        for (int i = 0; i < n; i++) {
            if (obstacleGrid[0][i] == 0) {
                dp[0][i] = 1;
            } else {
                break;
            }
        }
        for (int i = 0; i < m; i++) {
            if (obstacleGrid[i][0] == 0) {
                dp[i][0] = 1;
            } else {
                break;
            }
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (obstacleGrid[i][j] != 1) {
                    dp[i][j] = dp[i][j - 1] + dp[i - 1][j];
                } else {
                    dp[i][j] = 0;
                }
            }
        }
        return dp[m - 1][n - 1];
    }

    public int uniquePathsWithObstacles4(int[][] obstacleGrid) {
        int n = obstacleGrid[0].length;
        int[] f = new int[n + 1];
        f[1] = 1;
        for (int[] row : obstacleGrid) {
            for (int j = 0; j < n; j++) {
                if (row[j] == 0) {
                    f[j + 1] = f[j];
                } else {
                    f[j + 1] = 0;
                }
            }
        }
        return f[n];
    }


    public int uniquePathsWithObstacles2(int[][] obstacleGrid) {
        int n = obstacleGrid[0].length;
        int[] f = new int[n + 1];
        f[1] = 1;
        for (int[] row : obstacleGrid) {
            for (int j = 0; j < n; j++) {
                if (row[j] == 0) {
                    f[j + 1] += f[j];
                } else {
                    f[j + 1] = 0;
                }
            }
        }
        return f[n];
    }


    public int uniquePathsWithObstacles3(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[] f = obstacleGrid[0];
        f[0] ^= 1; // 0 变成 1，1 变成 0
        for (int j = 1; j < n; j++) {
            f[j] = f[j] == 1 ? 0 : f[j - 1];
        }
        for (int i = 1; i < m; i++) {
            if (obstacleGrid[i][0] == 1) {
                f[0] = 0;
            }
            for (int j = 1; j < n; j++) {
                if (obstacleGrid[i][j] == 0) {
                    f[j] += f[j - 1];
                } else {
                    f[j] = 0;
                }
            }
        }
        return f[n - 1];
    }


}
