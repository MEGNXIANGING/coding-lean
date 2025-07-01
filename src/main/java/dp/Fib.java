package dp;

public class Fib {
    public int fib(int n) {
        if (n==0 || n==1){
            return n;
        }
        int[] dp = new int[n+1];
        dp[0]=0;
        dp[1]=1;
        for (int i = 2; i <=n ; i++) {
            dp[i]=dp[i-1]+dp[i-2];
            dp[i] %= 1000000007;
        }
        return dp[n];
    }

    public int fib2(int n) {
        if (n <= 1) return n;
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        for (int index = 2; index <= n; index++){
            dp[index] = dp[index - 1] + dp[index - 2];
        }
        return dp[n];
    }

    public int fib3(int n) {
        if (n==0 || n==1){
            return n;
        }
        int f0=0;
        int f1=1;
        for (int i = 2; i <=n ; i++) {
            int c=f0+f1;
            c %= 1000000007;
            f0=f1;
            f1=c;
        }
        return f1;
    }

}
