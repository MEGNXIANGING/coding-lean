package sort;

public class KNums {
    public static void main(String[] args) {
        int[] nums = {3, 2, 3, 1, 2, 4, 5, 5, 6};
        findKthLargest(nums, 2);
    }

    public static int findKthLargest(int[] nums, int k) {
        quickSort(nums, 0, nums.length - 1);
        return nums[nums.length - k];
    }

    private static void quickSort(int[] nums, int left, int right) {
        if (left >= right) {
            return;
        }
        int pivotIndex = left + (int) (Math.random() * (right - left + 1));
        swap(nums, left, pivotIndex);
        int pre = nums[left];
        int lt = left + 1;
        int gt = right;
        int i = left + 1;
        while (i <= gt) {
            if (nums[i] < pre) {
                swap(nums, i++, lt++);
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

    private static void swap(int[] nums, int index1, int index2) {
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }
}
