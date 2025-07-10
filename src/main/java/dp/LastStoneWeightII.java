package dp;

public class LastStoneWeightII {
    public int lastStoneWeightII(int[] stones) {
        int sum = 0;
        for (int s : stones) {
            sum += s;
        }
        int t = sum >>1;
        /**
         * 0/1背包问题
         */
        int[] f = new int[t + 1];
        for (int i = 0; i < stones.length; i++) {
            for (int j = t; j >= stones[i]; j--) {
                f[j] = Math.max(f[j], f[j - stones[i]] + stones[i]);
            }
        }
        return sum - f[t] - f[t];
    }
}
