package sort;

import java.util.Arrays;

public class colourType {

    public static void main(String[] args) {
        int[] nums = {2, 0, 2, 1, 1, 0};
        sortColors2(nums);
        System.out.println(Arrays.toString(nums));

    }

    public static void sortColors(int[] nums) {
        int le = nums.length;
        /**
         * [0....zero]
         * (zero...i)
         * [two....len-1]
         */
        int zero = -1;
        int two = le;
        int i = 0;
        while (i < two) {
            if (nums[i] == 0) {
                zero++;
                swap(nums, zero, i);
                i++;
            } else if (nums[i] == 1) {
                i++;
            } else {
                two--;
                swap(nums, two, i);
            }
        }
    }

    public static void sortColors2(int[] nums) {
        int le = nums.length;
        /**
         * [0....zero)
         * [zero...i]
         * (two....len-1]
         */
        int zero = 0;
        int two = le-1;
        int i = 0;
        while (i <= two) {
            if (nums[i] == 0) {
                swap(nums, zero, i);
                zero++;
                i++;
            } else if (nums[i] == 1) {
                i++;
            } else {
                swap(nums, two, i);
                two--;
            }
        }
    }

    private static void swap(int[] nums, int index1, int index2) {
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }
}
