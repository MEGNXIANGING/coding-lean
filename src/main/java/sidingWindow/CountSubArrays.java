package sidingWindow;

public class CountSubArrays {
    public long countSubArrays(int[] nums, int k) {
        long res = 0;
        long sum = 0;
        int left = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            //巧妙算 len
            while (sum * (i - left + 1) >= k) {
                sum -= nums[left];
                left++;
            }
            res += i - left + 1;
        }
        return res;
    }


    public long countSubarrays2(int[] nums, long k) {
        long count = 0;
        long sum = 0;
        int left = 0;

        for (int right = 0; right < nums.length; right++) {
            sum += nums[right];

            // 收缩窗口直到sum * length < k
            while (sum * (right - left + 1) >= k) {
                sum -= nums[left];
                left++;
            }

            // 以right结尾的子数组数量为(right - left + 1)
            count += right - left + 1;
        }

        return count;
    }
}
