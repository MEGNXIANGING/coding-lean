package dp;

public class MinCostClimbingStairs {
    public int minCostClimbingStairs(int[] cost) {
        int a = cost[0];
        int b = cost[1];
        for (int i = 2; i <= cost.length; i++) {
            int c = 0;
            if (i == cost.length) {
                c = Math.min(b, a);
            } else {
                c = Math.min(b, a) + cost[i];
            }
            a = b;
            b = c;
        }
        return b;
    }

    public int minCostClimbingStairs2(int[] cost) {

        int a=cost[0];
        int b=cost[1];
        for (int i = 2; i <cost.length ; i++) {
            int c=Math.min(b,a)+cost[i];
            a=b;
            b=c;
        }
        return b;
    }


}
