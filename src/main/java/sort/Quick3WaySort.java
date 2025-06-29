package sort;

import java.util.Random;

public class Quick3WaySort {

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 8, 6, 4, 5, 3, 8, 5, 3, 4};
        quick3WaySort2(nums, 0, nums.length - 1);
        for (int i : nums) {
            System.out.println(i);
        }
    }

    private static void quick3WaySort(int[] nums, int left, int right) {
        if (left >= right) {
            return;
        }
        int pivot = nums[left];
        int lt = left + 1;
        int gt = right;
        int i = left + 1;
        while (i <= gt) {
            if (nums[i] < pivot) {
                swap(nums, lt, i);
                lt++;
                i++;
            } else if (nums[i] == pivot) {
                i++;
            } else {
                swap(nums, gt, i);
                gt--;
            }
            swap(nums, left, lt - 1);
            quick3WaySort2(nums, left, lt - 2);
            quick3WaySort2(nums, gt + 1, right);
        }
    }

    private static void quick3WaySort2(int[] nums, int left, int right) {
        if (left >= right) {
            return;
        }
        int pivot = nums[left];
        int lt = left + 1;
        int gt = right;
        int i = left + 1;
        while (i <= gt) {
            if (nums[i] < pivot) {
                swap(nums, lt, i);
                lt++;
                i++;
            } else if (nums[i] == pivot) {
                i++;
            } else {
                swap(nums, gt, i);
                gt--;
            }
        }
        swap(nums, left, lt - 1);
        quick3WaySort2(nums, left, lt - 2);
        quick3WaySort2(nums, gt + 1, right);
    }


    private static void swap(int[] nums, int index1, int index2) {
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }

}
