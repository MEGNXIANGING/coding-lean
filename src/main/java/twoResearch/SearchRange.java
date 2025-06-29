package twoResearch;

public class SearchRange {
    public static void main(String[] args) {
        int []nums={1};
        for (int i : searchRange(nums,0)) {
            System.out.println(i);
        }

    }
    public static int[] searchRange(int[] nums, int target) {
        int le=nums.length;
        if (le==0){
            return new int[]{-1,-1};
        }
        int startNum=getStartNum(nums,target);
        if (startNum==-1){
            return new int[]{-1,-1};
        }
        int endNum=getEndNum(nums,target);
        return new int[]{startNum,endNum};
    }

    private static int  getEndNum(int[] nums, int target) {
        int left=0;
        int right=nums.length-1;
        while (left<right){
            int mid=(left+right+1)/2;
            if (nums[mid]>target){
                //left...mid-1
                right=mid-1;
            }else {
                left=mid;
            }
        }
        if (nums[left]==target){
            return left;
        }
        return -1 ;
    }

    private static int getStartNum(int[] nums, int target) {
        int left=0;
        int right=nums.length-1;
        while (left<right){
            int mid=(left+right)/2;
            if (nums[mid]<target){
                //left...mid-1
                left=mid+1;
            }else {
                right=mid;
            }
        }
        if (nums[left]==target){
            return left;
        }
        return -1 ;
    }


}
