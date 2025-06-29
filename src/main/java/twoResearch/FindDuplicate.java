package twoResearch;

public class FindDuplicate {
    public static void main(String[] args) {
        int[] nums = {3,1,4,2,3};
        System.out.println(findDuplicate(nums));
    }
    public static int findDuplicate(int[] nums) {
        int len = nums.length;
        if (len < 2) {
            return -1;
        }
        int left = 1;
        int right = len - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            int count = 0;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] <= mid) {
                    count++;
                }
            }
            if (count <= mid) {

                left = mid + 1;
            } else {
                right = mid;

            }

        }
        return left;
    }
}
