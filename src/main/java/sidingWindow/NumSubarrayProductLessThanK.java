package sidingWindow;

import java.util.Arrays;

public class NumSubarrayProductLessThanK {
    public static void main(String[] args) {
        int[] nums = new int[]{10, 5, 2, 6};
        System.out.println(numSubarrayProductLessThanK(nums, 100));
    }


    public int numSubarrayProductLessThanK3(int[] nums, int k) {
        if (k <= 1) {
            return 0;
        }
        int res = 0;
        int left = 0;
        int n = nums.length;
        int sum = 1;
        for (int i = 0; i < n; i++) {
            sum *= nums[i];
            while (sum >= k) {
                sum /= nums[left];
                left++;
            }
            res += i - left + 1;
        }

        return res;
    }


    public static int numSubarrayProductLessThanK(int[] nums, int k) {
        if (k <= 1) {
            return 0;
        }
        int res = 0;
        int sum = 1;
        int left = 0;
        for (int i = 0; i < nums.length; i++) {
            sum *= nums[i];
            while (sum >= k) {
                sum /= nums[left];
                left++;
            }
            res += i - left + 1;
        }
        return res;
    }

    public int numSubarrayProductLessThanK2(int[] nums, int k) {
        if (k <= 1) {
            return 0;
        }
        int ans = 0;
        int prod = 1;
        int left = 0;
        for (int right = 0; right < nums.length; right++) {
            prod *= nums[right];
            while (prod >= k) { // 不满足要求
                prod /= nums[left];
                left++; // 缩小窗口
            }
            // 对于固定的 right，有 right-left+1 个合法的左端点
            ans += right - left + 1;
        }
        return ans;
    }
}
