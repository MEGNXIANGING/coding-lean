package twoResearch;

import java.util.Arrays;
import java.util.Random;


public class TriangleNumber {
    private final static Random random = new Random(System.currentTimeMillis());

    public static void main(String[] args) {
        int[] arr = new int[]{2, 2, 3, 4};
        int[] temp = new int[arr.length];
//        quickSort(arr, 0, arr.length - 1);
//        mrSort(arr,0,arr.length-1,temp);
        inesSort(arr);
        for (int i : arr) {
            System.out.println(i);
        }
    }

    private static void inesSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int temp = arr[i];
            int j = 0;
            for (j = i; j >= 0; j--) {
                if (arr[j - 1] > temp) {
                    arr[j] = arr[j - 1];
                } else {
                    break;
                }
            }
            arr[j] = temp;
        }
    }


    private static void mrSort(int[] arr, int left, int right, int[] temp) {
        if (left == right) {
            return;
        }
        int mid = (right + left) / 2;
        mrSort(arr, left, mid, temp);
        mrSort(arr, mid + 1, right, temp);
        for (int i = left; i <= right; i++) {
            temp[i] = arr[i];
        }
        int i = left;
        int j = mid + 1;
        for (int k = left; k <= right; k++) {
            if (i > mid) {
                arr[k] = temp[j];
                j++;
            } else if (j > right) {
                arr[k] = temp[i];
                i++;
            } else if (temp[i] <= temp[j]) {
                arr[k] = temp[i];
                i++;
            } else {
                arr[k] = temp[j];
                j++;
            }
        }
    }

    public int triangleNumber(int[] nums) {
        int le = nums.length;
        quickSort(nums, 0, le - 1);
        int count = 0;
        for (int i = 0; i < le - 2; i++) {
            for (int j = i + 1; j < le - 1; j++) {
                int sum = nums[i] + nums[j];

                int left = j + 1;
                int right = le;

                while (left < right) {
                    int mid = (left + right) / 2;
                    if (nums[mid] < sum) {
                        left = mid + 1;
                    } else {
                        right = mid;
                    }
                }
                count += left - j - 1;
            }
        }
        return count;
    }

    public int triangleNumber2(int[] nums) {
        Arrays.sort(nums);
        int len = nums.length;
        int count = 0;
        for (int i = 0; i < len - 2; i++) {
            for (int j = i + 1; j < len - 1; j++) {
                // 找到第 1 个大于等于两边之和的下标
                int left = j + 1;
                int right = len;
                while (left < right) {
                    int mid = (left + right) / 2;
                    if (nums[mid] < nums[i] + nums[j]) {
                        left = mid + 1;
                    } else {
                        right = mid;
                    }
                }
                count += (left - j - 1);
            }
        }
        return count;
    }


    private static void quickSort(int[] nums, int left, int right) {
        if (left >= right) {
            return;
        }
        int randomIndex = left + random.nextInt(right - left + 1);
        swap(nums, left, randomIndex);
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

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}
