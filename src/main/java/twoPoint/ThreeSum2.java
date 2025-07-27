package twoPoint;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class ThreeSum2 {


    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans=new ArrayList<>();

        quickSort(0, nums.length - 1, nums);
        for (int i = 0; i < nums.length - 2; i++) {
            int num=nums[i];
            if (num>0)break;
            if (i>0 && nums[i]==nums[i-1]) continue;
            int j=i+1; int k=nums.length-1;
            while (j<k){
                int sum=num+nums[j]+nums[k];
                if (sum>0){
                    k--;
                }else if (sum<0){
                    j++;
                }else {
                    ans.add(List.of(num, nums[j], nums[k]));
                    while (j<k && nums[j]==nums[j+1]) j++;
                    while (j<k && nums[k]==nums[k-1]) k--;
                    j++;
                    k--;
                }
            }
        }
        return ans;
    }

    private void quickSort(int left, int right, int[] nums) {
        if (left >= right) {
            return;
        }
     
        int randomPivotIndex = left + new Random().nextInt(right - left + 1);
        swap(nums, left, randomPivotIndex);
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
        quickSort(left, lt - 2, nums);
        quickSort(gt + 1, right, nums);
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}
