package sort;

import java.util.Arrays;

public class SortArrayByParity {
    public static void main(String[] args) {
        int[] nums = {2, 3, 2, 1, 1, 4};
        sortArrayByParity(nums);
        System.out.println(Arrays.toString(nums));

    }

    public static int[] sortArrayByParity(int[] nums) {
        int j=nums.length-1;
        int i=0;
        while (i<j){
            if (nums[i]%2==1){
                //奇数
                swap(nums,i,j);
                j--;
            }else {
                i++;
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
