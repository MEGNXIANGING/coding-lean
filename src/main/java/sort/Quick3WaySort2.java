package sort;

import java.util.Arrays;

public class Quick3WaySort2 {

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 8, 6, 4, 5, 3, 8, 5, 3, 4};
        quick3WaySort(arr, 0, arr.length - 1);
        for (int i : arr) {
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
        }
        swap(nums, left, lt - 1);
        quick3WaySort(nums, left, lt - 2);
        quick3WaySort(nums, gt + 1, right);
    }

    private static void swap(int[] arr, int index1, int index2) {
        int temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }

}
