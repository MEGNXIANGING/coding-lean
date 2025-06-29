package sidingWindow;

import java.util.HashMap;
import java.util.Map;

public class MaxSubarrayLength {
    public static void main(String[] args) {
        int[] nums = {1, 2, 2, 2, 3};
        System.out.println(maxSubarrayLength(nums, 2));
    }

    public static int maxSubarrayLength(int[] nums, int k) {
        int left = 0;
        int res = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int count = map.getOrDefault(nums[i], 0) + 1;
            map.put(nums[i], count);
            while (count>k){
                int leftNum = nums[left];
                map.put(leftNum, map.get(leftNum) - 1);
                left++;
                count=map.get(nums[i]);
            }
            // 更新最大长度
            res = Math.max(res, i - left + 1);
        }
        return res;
    }

    public int maxSubarrayLength3(int[] nums, int k) {
        int ans = 0;
        int left = 0;
        Map<Integer, Integer> cnt = new HashMap<>();
        for (int right = 0; right < nums.length; right++) {
            cnt.merge(nums[right], 1, Integer::sum); // cnt[nums[right]]++
            while (cnt.get(nums[right]) > k) {
                cnt.merge(nums[left], -1, Integer::sum); // cnt[nums[left]]--
                left++;
            }
            ans = Math.max(ans, right - left + 1);
        }
        return ans;
    }



    public int maxSubarrayLength2(int[] nums, int k) {
        int left = 0;
        int res = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int right = 0; right < nums.length; right++) {
            // 更新当前元素的频率
            int count = map.getOrDefault(nums[right], 0) + 1;
            map.put(nums[right], count);

            // 如果当前元素频率超过k，收缩窗口
            while (count > k) {
                int leftNum = nums[left];
                map.put(leftNum, map.get(leftNum) - 1);
                left++;
                count = map.get(nums[right]);
            }

            // 更新最大长度
            res = Math.max(res, right - left + 1);
        }

        return res;
    }
}
