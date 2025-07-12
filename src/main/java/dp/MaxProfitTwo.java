package dp;

public class MaxProfitTwo {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] f = new int[n + 2][2];
        f[1][1] = Integer.MIN_VALUE;
        for (int i = 0; i <n ; i++) {
            f[i+2][0]=Math.max(f[i+1][0],f[i+1][1]+prices[i]);
            f[i+2][1]=Math.max(f[i+1][1],f[i][0]-prices[i]);
        }
        return f[n+1][0];
    }

    public int maxProfit2(int[] prices) {
        int pr0= 0;
        int f0= 0;
        int f1= Integer.MIN_VALUE;
        for (int c:prices){
            int new_f=Math.max(f0,f1+c);
            f1=Math.max(f1,pr0-c);
            pr0=f0;
            f0=new_f;
        }
        return f0;
    }
}
