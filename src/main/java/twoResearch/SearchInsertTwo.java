package twoResearch;

public class SearchInsertTwo {
    public int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        if (target > nums[nums.length - 1]) {
            return nums.length;
        }
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

    public int searchInsert1(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        if (target > nums[nums.length - 1]) {
            return nums.length;
        }
        //[left right]
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }

    public int searchInsert2(int[] nums, int target) {
        int left = 0;
        int right = nums.length;
        if (target > nums[nums.length - 1]) {
            return nums.length;
        }
        //[left right)
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return right;
    }

}
