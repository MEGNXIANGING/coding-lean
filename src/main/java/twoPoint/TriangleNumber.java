package twoPoint;

import java.util.Arrays;

public class TriangleNumber {
    public int triangleNumber(int[] nums) {
        int n = nums.length;
        int count=0;
        Arrays.sort(nums);
        for (int i = 0; i < n - 2; i++) {
            int k=i+2;
            for (int j = i+1; j <n-1 ; j++) {
                while (k<n && nums[i]+nums[j]>nums[k]){
                    k++;
                }
                count += Math.max(0, k - j - 1);
            }
        }
        return count;
    }

    public int triangleNumber2(int[] nums) {
        Arrays.sort(nums);
        int ans = 0;
        for (int k = 2; k < nums.length; k++) {
            int c = nums[k];
            int i = 0; // a=nums[i]
            int j = k - 1; // b=nums[j]
            while (i < j) {
                if (nums[i] + nums[j] > c) {
                    // 由于 nums 已经从小到大排序
                    // nums[i]+nums[j] > c 同时意味着：
                    // nums[i+1]+nums[j] > c
                    // nums[i+2]+nums[j] > c
                    // ...
                    // nums[j-1]+nums[j] > c
                    // 从 i 到 j-1 一共 j-i 个
                    ans += j - i;
                    j--;
                } else {
                    // 由于 nums 已经从小到大排序
                    // nums[i]+nums[j] <= c 同时意味着
                    // nums[i]+nums[j-1] <= c
                    // ...
                    // nums[i]+nums[i+1] <= c
                    // 所以在后续的内层循环中，nums[i] 不可能作为三角形的边长，没有用了
                    i++;
                }
            }
        }
        return ans;
    }

    private void quickSort(int[] nums, int left, int right) {
        if (left >= right) {
            return;
        }
        int pre = nums[left];
        int lt = left + 1;
        int gt = right;
        int i = left + 1;
        //[left lt)  [lt ...gt]  (gt right]
        while (i <= gt) {
            if (nums[i] < pre) {
                swap(nums, i++, lt++);
            } else if (nums[i] == pre) {
                i++;
            } else {
                swap(nums, i, gt--);
            }
        }
        swap(nums, left, lt -1);
        quickSort(nums, left, lt -2);
        quickSort(nums, gt + 1, right);
    }

    // 交换数组中两个元素的位置
    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}
