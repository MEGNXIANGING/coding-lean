package sidingWindow;

public class LongestSubarray {
    public int longestSubarray(int[] nums) {
        int ans = 0;
        int left = 0;
        int count0 = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                count0++;
            }
            while (count0 > 1) {
                if (nums[left] == 0) {
                    count0--;
                }
                left++;
            }
            ans = Math.max(ans, i - left + 1);
        }
        return ans - 1;
    }

    public int longestSubarray2(int[] nums) {
        int ans = 0;
        int cnt0 = 0;
        int left = 0;
        for (int right = 0; right < nums.length; right++) {
            // 1. 入，nums[right] 进入窗口
            cnt0 += 1 - nums[right]; // 维护窗口中的 0 的个数
            while (cnt0 > 1) { // 不符合题目要求
                // 2. 出，nums[left] 离开窗口
                cnt0 -= 1 - nums[left]; // 维护窗口中的 0 的个数
                left++;
            }
            // 3. 更新答案，注意不是 right-left+1，因为我们要删掉一个数
            ans = Math.max(ans, right - left);
        }
        return ans;
    }

}
