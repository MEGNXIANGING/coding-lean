package twoResearch;public class SearchRangeTwo {
    public int[] searchRange(int[] nums, int target) {
        int[]res= new int[]{-1,-1};
        if (nums.length==0){
            return res;
        }
        int leftIndex=getLeftIndex(nums,target);
        if (leftIndex==-1){
            return res;
        }
        int rightIndex=getRightIndex(nums,target);
        res[0]=leftIndex;
        res[1]=rightIndex;
        return res;
    }

    public int[] searchRange2(int[] nums, int target) {
        int leftIndex=getIndex(nums,target,true);
        int rightIndex=getIndex(nums,target,false);
        return new int[]{leftIndex,rightIndex};
    }

    public int getIndex(int[] nums, int target,boolean isLeft){
        int left=0;
        int right=nums.length-1;
        int index=-1;
        while (left<=right){
            int mid=left+(right-left)/2;
            if (nums[mid]>target){
                right=mid-1;
            }else if (nums[mid]<target){
                left=mid+1;
            }else {
                index=mid;
                if (isLeft){
                    right=mid-1;
                }else {
                    left=mid+1;
                }
            }
        }
        return index;
    }

    private int getLeftIndex(int[] nums, int target) {
        int left=0;
        int right=nums.length-1;
        while (left<right){
            int mid=left+(right-left)/2;
            if (nums[mid]<target){
                left=mid+1;
            }else {
                right=mid;
            }
        }
        return nums[left]==target?left:-1;
    }
    private int getRightIndex(int[] nums, int target) {
        int left=0;
        int right=nums.length-1;
        while (left<right) {
            int mid = left + (right - left+1) / 2;
            if (nums[mid]>target){
                right=mid-1;
            }else {
                left=mid;
            }
        }
        return left;
    }
}
