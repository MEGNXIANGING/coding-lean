package sort;

import java.lang.reflect.Array;
import java.util.Arrays;

public class FirstMissingPositive {
    public static void main(String[] args) {
        int[] nums = {3, 4, -1, 1};
        firstMissingPositive2(nums);
    }

    public int firstMissingPositive(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        if (nums[0] > 1 || nums[n - 1] < 0) {
            return 1;
        }
        for (int i = 1; i < n; i++) {
            if (nums[i - 1] > 0 && nums[i - 1] + 1 != nums[i]) {
                return nums[i - 1] + 1;
            }
        }
        return nums[n - 1] + 1;

    }

    public static int firstMissingPositive2(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            while (nums[i] >= 1 && nums[i] < n && nums[i] != nums[nums[i] - 1]) {
                int j = nums[i] - 1;
                int tem = nums[j];
                nums[j] = nums[i];
                nums[i] = tem;
            }
        }
        for (int i = 0; i < n; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }
        return n + 1;

    }
}
