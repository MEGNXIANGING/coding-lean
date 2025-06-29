package twoResearch;

public class SearchInsert {
    public int searchInsert(int[] nums, int target) {
        //第一个大于或者等于target
        if (target < nums[0]) {
            return 0;
        }
        if (target > nums[nums.length - 1]) {
            return nums.length;
        }
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int mid = (left + right) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }

    public int searchInsert2(int[] nums, int target) {
        //第一个大于或者等于target
        if (target < nums[0]) {
            return 0;
        }
        if (target > nums[nums.length - 1]) {
            return nums.length;
        }
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid =  (right + left) / 2;
            if (nums[mid]>target){
                right=mid-1;
            }else if (nums[mid]<target){
                left=mid+1;
            }else {
                return mid;
            }
        }
        return left;
    }
}
