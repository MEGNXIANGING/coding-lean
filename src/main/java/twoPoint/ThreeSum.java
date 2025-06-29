package twoPoint;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, -1, -4, -1};
        quickSort(nums, 0, nums.length - 1);
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        int len = nums.length;
        for (int i = 0; i < len - 2; i++) {
            int num = nums[i];
            if (i > 0 && num == nums[i - 1]) {
                //跳过相同的数
                continue;
            }
            if (num + nums[i + 1] + nums[i + 2] > 0) {
                //前三个数大于0，说明大于0的数不存在
                break;
            }
            int j = i + 1;
            int k = len - 1;
            if (num+nums[k]+nums[k-1]<0){
                continue;
            }
            while (j < k) {
                int sum = num + nums[j] + nums[k];
                if (sum > 0) {
                    k--;
                } else if (sum < 0) {
                    j++;
                } else {
                    res.add(List.of(num, nums[j], nums[k]));
                    while (j < k && nums[j] == nums[j + 1]) {
                        j++;
                    }
                    while (j < k && nums[k] == nums[k - 1]) {
                        k--;
                    }
                    j++;
                    k--;
                }
            }
        }
        return res;
    }

    public List<List<Integer>> threeSum2(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        int len = nums.length;

        for (int i = 0; i < len - 2; i++) {
            int num = nums[i];
            if (num > 0) break;  // 提前终止，因为数组已排序
            if (i > 0 && num == nums[i - 1]) continue;  // 跳过重复的 num

            int j = i + 1, k = len - 1;
            while (j < k) {
                int sum = num + nums[j] + nums[k];
                if (sum < 0) {
                    j++;
                } else if (sum > 0) {
                    k--;
                } else {
                    res.add(List.of(num, nums[j], nums[k]));
                    // 跳过重复的 nums[j] 和 nums[k]
                    while (j < k && nums[j] == nums[j + 1]) j++;
                    while (j < k && nums[k] == nums[k - 1]) k--;
                    j++;
                    k--;
                }
            }
        }
        return res;
    }


    private static void quickSort(int[] nums, int left, int right) {
        if (left >= right) {
            return;
        }
        int pre = nums[left];
        int lt = left + 1;
        int gt = right;
        int i = left + 1;
        while (i <= gt) {
            if (nums[i] < pre) {
                swap(nums, lt++, i++);
            } else if (nums[i] == pre) {
                i++;
            } else {
                swap(nums, i, gt--);
            }
        }
        swap(nums, left, lt - 1);
        quickSort(nums, left, lt - 2);
        quickSort(nums, gt + 1, right);
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
