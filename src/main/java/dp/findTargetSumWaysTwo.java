package dp;

public class findTargetSumWaysTwo {
    /**
     * 设置+ 为p
     * 则为-的是n-p
     * p-(n-p)=t
     * p=t+n/2
     * t+n=s
     * s不能为负数 并且不能%2为1
     */
    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for (int n : nums) {
            sum += n;
        }
        if (target > sum || target < -sum) return 0;
        if ((target + sum) % 2 != 0) return 0;


        int p = (sum + target) / 2;
        if (p < 0) return 0; // 确保P非负


        int n = nums.length;
        int[][] f = new int[n + 1][p + 1];
        //初始化
        f[0][0] = 1;
        //先遍历物品
        for (int i = 1; i <= n; i++) {
            //遍历背包
            for (int j = 0; j <= p; j++) {
                if (j < nums[i - 1]) {
                    f[i][j] = f[i - 1][j];
                }
                if (j >= nums[i - 1]) {
                    f[i][j] = f[i - 1][j] + f[i - 1][j - nums[i-1]];
                }
            }
        }
        return f[n][p];

    }

    public int findTargetSumWays3(int[] nums, int target) {
        int sum = 0;
        for (int n : nums) {
            sum += n;
        }

        if (target > sum || target < -sum || (sum + target) % 2 != 0) {
            return 0;
        }
        int p=(sum+target)/2;
        if (p < 0) return 0; // 确保p非负

        int n = nums.length;
        int []f=new int[p+1];
        f[0]=1;
        for (int i = 0; i <n; i++) {
            for (int j = p; j >=nums[i] ; j--) {
                if (j<nums[i]){
                    f[j]=f[j-1];
                }else {
                    f[j] = f[j] + f[j - nums[i]];
                }
            }
        }
        return f[p];

    }


    public int findTargetSumWays2(int[] nums, int target) {
        int sum = 0;
        for (int n : nums) {
            sum += n;
        }
        if (sum + target < 0 || (sum + target) % 2 == 1) {
            return 0;
        }
        int t = (sum + target) / 2;
        int[][] f = new int[nums.length][t + 1];

        // 初始化第一个物品
        f[0][0] = 1;

        // 动态规划过程
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j <= t; j++) {
                if (j < nums[i]) {
                    f[i][j] = f[i - 1][j];
                } else {
                    f[i][j] = f[i - 1][j] + f[i - 1][j - nums[i]];
                }
            }
        }

        return f[nums.length - 1][t];
    }
}
