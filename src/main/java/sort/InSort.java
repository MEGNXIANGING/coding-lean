package sort;

import java.util.Arrays;
import java.util.Random;

public class InSort {
    private final static Random random = new Random(System.currentTimeMillis());

    public static void main(String[] args) {
        int[] nums = {7, 5, 4, 8, 9, 6, 5, 3, 15, 13, 12, 1, 5, 2, 3, 15, 8, 4};
        System.out.println(Arrays.toString(sortArray(nums)));
    }

    public static int[] sortArray(int[] nums) {
        int le = nums.length;
        if (le <= 16) {
            intSort(nums);
        } else {
            quickSort(nums, 0, le - 1);
        }
        return nums;
    }

    private static void quickSort(int[] nums, int left, int right) {
        if (left >= right) {
            return;
        }
        int randomIndex = left + random.nextInt(right - left + 1);
        swap(nums, randomIndex, left);
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
                swap(nums, gt--, i);
            }
        }
        swap(nums, left, lt - 1);
        quickSort(nums, left, lt - 2);
        quickSort(nums, gt + 1, right);
    }

    private static void intSort(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            int temp = nums[i];
            int j;
            for (j = i; j > 0; j--) {
                if (nums[j - 1] > temp) {
                    nums[j] = nums[j - 1];
                } else {
                    break;
                }
            }
            nums[j] = temp;
        }
    }


    private static int[] intSort2(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            for (int j = i; j > 0; j--) {
                if (nums[j - 1] > nums[j]) {
                    swap(nums, j - 1, j);
                } else {
                    break;
                }
            }
        }
        return nums;
    }

    private static void swap(int[] nums, int index1, int index2) {
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }
}
