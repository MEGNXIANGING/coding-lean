package sort;

public class ReversePairs {
    public static void main(String[] args) {
        int[] nums = {2,4,3,5,1};
        System.out.println(reversePairs(nums));
    }

    public static int reversePairs(int[] nums) {
        int le = nums.length;
        if (le < 2) {
            return 0;
        }
        int[] temp = new int[le];
        return mrSort(nums, 0, le - 1, temp);
    }

    private static int mrSort(int[] nums, int left, int right, int[] temp) {
        if (left >= right) {
            return 0;
        }
        int mid = left + (right - left) / 2;
        int count = mrSort(nums, left, mid, temp) + mrSort(nums, mid + 1, right, temp);
        int i = left;
        int j = mid + 1;
        while (i <= mid && j <= right) {
            if (nums[i] > nums[j] * 2L ) {
                count += mid - i + 1;
                j++;
            } else {
                i++;
            }
        }
        if (nums[mid] <= nums[mid + 1]) {
            return count;
        }
        MrNums(nums, left, right, temp, mid);
        return count;
    }

    private static void MrNums(int[] nums, int left, int right, int[] temp, int mid) {
        System.arraycopy(nums, left, temp, left, right - left + 1);
        int i = left;
        int j = mid + 1;
        for (int k = left; k <= right; k++) {
            if (i > mid) {
                nums[k] = temp[j++];
            } else if (j > right) {
                nums[k] = temp[i++];
            } else if (temp[i] <= temp[j]) {
                nums[k] = temp[i++];
            } else {
                nums[k] = temp[j++];
            }
        }
    }
}
