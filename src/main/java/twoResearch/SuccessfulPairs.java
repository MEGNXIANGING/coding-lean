package twoResearch;

import java.util.Arrays;

public class SuccessfulPairs {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
//        quickSort(potions, 0, potions.length - 1);
        Arrays.sort(potions);
        for (int i = 0; i < spells.length; i++) {
            long target=(success-1)/spells[i];
            if (target < potions[potions.length - 1]) {
                spells[i] = potions.length - searchTwo3(potions, (int) target);
            } else {
                spells[i] = 0;
            }
        }
        return spells;
    }

    private static int searchTwo(int[] nums, int target) {
        int left = 0;
        int right = nums.length;
        while (left < right) {
            int mid = (left + right) >>> 1;
            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }

    private static int searchTwo1(int[] nums, int target) {
        int left = 0;
        int right = nums.length-1;
        while (left <= right) {
            int mid = (left + right) >>> 1;
            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid-1;
            }
        }
        return left;
    }


    private static int searchTwo3(int[] nums, int target) {
        int left = -1;
        int right = nums.length-1;
        while (left+1 < right) {
            int mid = (left + right) >>> 1;
            if (nums[mid] < target) {
                left = mid ;
            } else {
                right = mid;
            }
        }
        return right;
    }

    private int upperBound(int[] nums, int target) {
        int left = -1, right = nums.length; // 开区间 (left, right)
        while (left + 1 < right) { // 区间不为空
            // 循环不变量：
            // nums[left] <= target
            // nums[right] > target
            int mid = (left + right) >>> 1;
            if (nums[mid] > target) {
                right = mid; // 二分范围缩小到 (left, mid)
            } else {
                left = mid; // 二分范围缩小到 (mid, right)
            }
        }
        return right;
    }


    class Solution {
        public int[] successfulPairs(int[] spells, int[] potions, long success) {
            Arrays.sort(potions);
            for (int i = 0; i < spells.length; i++) {
                long target = (success - 1) / spells[i];
                if (target < potions[potions.length - 1]) {
                    // 这样写每次二分就只用比两个 int 的大小，避免把 potions 中的元素转成 long 比较
                    spells[i] = potions.length - upperBound(potions, (int) target);
                } else {
                    spells[i] = 0;
                }
            }
            return spells;
        }

        // 直接二分 long 是 28ms，改成 int 是 26ms
        private int upperBound(int[] nums, int target) {
            int left = -1, right = nums.length; // 开区间 (left, right)
            while (left + 1 < right) { // 区间不为空
                // 循环不变量：
                // nums[left] <= target
                // nums[right] > target
                int mid = (left + right) >>> 1;
                if (nums[mid] > target) {
                    right = mid; // 二分范围缩小到 (left, mid)
                } else {
                    left = mid; // 二分范围缩小到 (mid, right)
                }
            }
            return right;
        }
    }




    private static void quickSort(int[] nums, int left, int right) {
        if (left >= right) {
            return;
        }
        int pre = nums[left];
        int lt = left + 1;
        int gt = right;
        int i = left + 1;
        while (i <= gt) {
            if (nums[i] < pre) {
                swap(nums, lt++, i++);
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

    // 交换数组中两个元素的位置
    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public int[] successfulPairs2(int[] spells, int[] potions, long success) {
        Arrays.sort(potions);
        for (int i = 0; i < spells.length; i++) {
            int num = spells[i];
            int index = searchTwo(potions, success, num);
            spells[i] = potions.length - index;
        }
        return spells;
    }

    private static int searchTwo(int[] nums, long target, int num) {
        int left = -1;
        int right = nums.length;
        while (left+1 < right) {
            int mid = left + (right - left) / 2;
            if ((long) num * nums[mid] < target) {
                left = mid ;
            } else {
                right = mid;
            }
        }
        return right;
    }

}
