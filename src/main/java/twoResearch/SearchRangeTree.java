package twoResearch;

public class SearchRangeTree {
    //03xf牛逼
    public int[] searchRange(int[] nums, int target) {
        int index1 = searchTarget(nums, target);
        if (index1 == nums.length || nums[index1] != target) return new int[]{-1,-1};
        //第一个大于目标的索引-1就是最后一个值。
        int index2 = searchTarget(nums, target + 1)-1;
        return new int[]{index1,index2};
    }

    private int searchTarget(int[] nums, int target){
        int left=0;
        int right=nums.length-1; //[left right]
        while (left<=right){
            int mid=left+(right-left)/2;
            if (nums[mid]<target){
                left=mid+1;
            }else {
                right=mid-1;
            }
        }
        return left;
    }

    private int searchTarget2(int[] nums, int target){
        int left=0;
        int right=nums.length; //[left right)
        while (left<right){
            int mid=left+(right-left)/2;
            if (nums[mid]<target){
                left=mid+1;
            }else {
                right=mid;
            }
        }
        return left;
    }

    private int searchTarget3(int[] nums, int target){
        int left=-1;
        int right=nums.length; //[left right)
        while (left+1<right){
            int mid=left+(right-left)/2;
            if (nums[mid]<target){
                left=mid;
            }else {
                right=mid;
            }
        }
        return right;
    }

}
