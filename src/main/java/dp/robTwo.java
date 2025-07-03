package dp;

public class robTwo {

    public int rob(int[] nums) {
        int n = nums.length;
        return Math.max(nums[0] + robM(nums, 2, n - 1), robM(nums, 1, n));
    }

    public int robM(int[] nums, int start, int right) {
        int f1 = 0;
        int f0 = 0;
        for (int i = start; i < right; i++) {
            int newF = Math.max(f1, f0 + nums[i]);
            f0 = f1;
            f1 = newF;
        }
        return f1;
    }

}
