package sidingWindow;

public class MinOperations {
    /**
     * 输入：nums = [1,1,4,2,3], x = 5
     */
    public static void main(String[] args) {
        int[] nums = {3, 2, 20, 1, 1, 3};
        System.out.println(minOperations(nums, 10));
    }

    public static int minOperations(int[] nums, int x) {
        int res = nums.length + 1;
        int sum = 0;
        int left = 0;
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > x) {
                index++;
                continue;
            }
            sum += nums[i];
            while (sum >= x) {
                if (sum == x) {
                    res = Math.min(res, i - index - left + 1);
                }
                sum -= nums[left];
                left++;
            }
        }
        return res == nums.length + 1 ? -1 : res;
    }

    public static int minOperations2(int[] nums, int x) {
        //todo 没看懂
        int totalSum = 0;
        for (int num : nums) {
            totalSum += num;
        }

        int target = totalSum - x;
        if (target < 0) return -1;  // x > totalSum
        if (target == 0) return nums.length;  // 需要移除所有元素

        int left = 0;
        int currentSum = 0;
        int maxLen = -1;

        for (int right = 0; right < nums.length; right++) {
            currentSum += nums[right];

            while (currentSum > target && left <= right) {
                currentSum -= nums[left];
                left++;
            }

            if (currentSum == target) {
                maxLen = Math.max(maxLen, right - left + 1);
            }
        }

        return (maxLen == -1) ? -1 : nums.length - maxLen;
    }
}
