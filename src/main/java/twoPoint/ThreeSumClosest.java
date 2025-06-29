package twoPoint;

import java.util.Arrays;

/**
 *
 代码
 测试用例
 测试用例
 测试结果
 16. 最接近的三数之和
 给你一个长度为 n 的整数数组 nums 和 一个目标值 target。请你从 nums 中选出三个整数，使它们的和与 target 最接近。
 返回这三个数的和。
 假定每组输入只存在恰好一个解
 输入：nums = [-1,2,1,-4], target = 1
 输出：2
 解释：与 target 最接近的和是 2 (-1 + 2 + 1 = 2)。
 示例 2：

 输入：nums = [0,0,0], target = 1
 输出：0
 解释：与 target 最接近的和是 0（0 + 0 + 0 = 0）。
 */
public class ThreeSumClosest {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int min=Integer.MAX_VALUE;
        int ans=0;
        for (int i = 0; i < nums.length-2; i++) {
            int num=nums[i];
            int left=i+1;
            int right=nums.length-1;
            //优化点1 如果和下一个数一致，无需重复寻找
            if (i>0 && num==nums[i-1]){
                continue;
            }
            //优化点2 如果等于直接返回
            if (num+nums[i+1]+nums[i+2]==target){
                return target;
            }

            //优化点3  只能跳过，因为还有=、还有大于场景
            int sum=num+nums[right]+nums[right-1];
            if (sum<target){
                if (target-sum<min){
                    min = target - sum;
                    ans=sum;
                }
                continue;
            }

            while (left<right){
                sum=nums[left]+nums[right]+num;
                if (sum>target){
                    if (sum-target<min){
                        min=sum-target;
                        ans=sum;
                    }
                    right--;
                }else if (sum==target){
                    return sum;
                }else {
                    if (target-sum<min){
                        min=target-sum;
                        ans=sum;
                    }
                    left++;
                }
            }
        }
        return ans;
    }

    public int threeSumClosest2(int[] nums, int target) {
        Arrays.sort(nums);
        int ans = 0, n = nums.length;
        int minDiff = Integer.MAX_VALUE;
        for (int i = 0; i < n - 2; i++) {
            int x = nums[i];
            if (i > 0 && x == nums[i - 1]) {
                continue; // 优化三
            }

            // 优化一

            int s = x + nums[i + 1] + nums[i + 2];
            if (s > target) { // 后面无论怎么选，选出的三个数的和不会比 s 还小
                if (s - target < minDiff) {
                    ans = s; // 由于下面直接 break，这里无需更新 minDiff
                }
                break;
            }

            // 优化二
            s = x + nums[n - 2] + nums[n - 1];
            if (s < target) { // x 加上后面任意两个数都不超过 s，所以下面的双指针就不需要跑了
                if (target - s < minDiff) {
                    minDiff = target - s;
                    ans = s;
                }
                continue;
            }

            // 双指针
            int j = i + 1, k = n - 1;
            while (j < k) {
                s = x + nums[j] + nums[k];
                if (s == target) {
                    return target;
                }
                if (s > target) {
                    if (s - target < minDiff) { // s 与 target 更近
                        minDiff = s - target;
                        ans = s;
                    }
                    k--;
                } else { // s < target
                    if (target - s < minDiff) { // s 与 target 更近
                        minDiff = target - s;
                        ans = s;
                    }
                    j++;
                }
            }
        }
        return ans;
    }

}
