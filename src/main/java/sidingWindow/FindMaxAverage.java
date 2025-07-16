package sidingWindow;

public class FindMaxAverage {
    public double findMaxAverage(int[] nums, int k) {
        int sum = 0;
        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }
        double ans = (double) sum / 4;
        int left = 0;
        for (int i = k; i < nums.length; i++) {
            sum += nums[i];
            sum -= nums[left];
            left++;
            ans = Math.max(ans, (double) sum / k);
        }
        return ans;
    }
}
