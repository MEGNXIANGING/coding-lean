package dp;

public class IntegerBreak {

    public int integerBreak(int n) {
        int[] dp = new int[n + 1];
        dp[2] = 1;

        for (int i = 2; i <= n; i++) {
            for (int j = 0; j <= i - j; j++) {
                dp[i] = Math.max(dp[i], Math.max(j * (i - j), dp[i - j] * j));
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        integerBreak2(6);
    }

    public static int integerBreak2(int n) {
        int[] dp = new int[n + 1];
        dp[2] = 1;

        for (int i = 3; i <= n; i++) {
            System.out.println("\n计算 dp[" + i + "]:");
            for (int j = 1; j <= i / 2; j++) {
                int option1 = j * (i - j);
                int option2 = j * dp[i - j];
                int currentMax = Math.max(option1, option2);
                System.out.printf("  j=%d: 不拆分=%d, 拆分=%d, 当前最大值=%d\n", j, option1, option2, currentMax);

                if (currentMax > dp[i]) {
                    System.out.printf("    更新 dp[%d] 从 %d 到 %d\n", i, dp[i], currentMax);
                    dp[i] = currentMax;
                }
            }
        }
        return dp[n];
    }


    public int integerBreak3(int n) {
        int[] f = new int[n + 1];
        f[2] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 0; j <= i - j; j++) {
                //与f[i]本身对比是因为需要判断f[i]前一列的值和当前列的值比较
                f[i] = Math.max(f[i], Math.max(j * (i - j), j * f[i - j]));
            }
        }
        return f[n];
    }

}

