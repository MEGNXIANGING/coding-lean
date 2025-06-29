package sort;

import java.util.Collections;
import java.util.List;

public class CountPairs {
    public static void main(String[] args) {
        List<Integer> nums = List.of(-1, 1, 2, 3, 1);
        System.out.println(countPairs(nums,3));
    }
    public static int countPairs(List<Integer> nums, int target) {
        int len = nums.size();
        if (len <= 1) {
            return 0;
        }
        int count=0;
        for (int i = 0; i < len - 1; i++) {
            Integer num = nums.get(i);
            int j=i+1;
            while (j<len){
                if (num+nums.get(j)<target){
                    count++;
                }
                j++;
            }
        }
        return count;
    }

    public static int countPairs2(List<Integer> nums, int target) {
        Collections.sort(nums);
        int len = nums.size();
        if (len <= 1) {
            return 0;
        }
        int count=0;
        int left=0;
        int right=len-1;
        while (left<right){
            int sum=nums.get(left)+nums.get(right);
            if (sum>=target){
                right--;
            }else {
                count+=right-left;
                left++;
            }
        }
        return count;
    }

    public int countPairs3(List<Integer> nums, int target) {
        Collections.sort(nums);
        int ans = 0;
        int left = 0;
        int right = nums.size() - 1;
        while (left < right) {
            if (nums.get(left) + nums.get(right) < target) {
                ans += right - left;
                left++;
            } else {
                right--;
            }
        }
        return ans;
    }
}
