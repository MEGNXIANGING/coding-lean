package twoResearch;

public class MaximumCount {
    public static void main(String[] args) {
        int[] nums = new int[]{-3, -2, -1, 0, 0, 1, 2};
        maximumCount(nums);
    }

    public static int maximumCount(int[] nums) {
        int index1 = searchNum2(nums, 0);
        int index2 = searchNum2(nums, 1);
        return Math.max(index1, nums.length - index2);
    }

    public static int searchNum(int[] nums, int target) {
        int left = 0;
        int right = nums.length; //[left right}
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }


    public static int searchNum1(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1; //[left right]
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }

    public static int searchNum2(int[] nums, int target) {
        int left = -1;
        int right = nums.length; //[left right]
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid;
            } else {
                right = mid;
            }
        }
        return right;
    }


}
