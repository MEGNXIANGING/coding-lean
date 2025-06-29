package sidingWindow;

public class MinSubArrayLen {
    public static void main(String[] args) {
        int []nums={2,3,1,2,4,3};
        System.out.println(minSubArrayLen(7,nums));
    }
    public static int minSubArrayLen(int target, int[] nums) {
        int i=0;
        int sum=0;
        int res=Integer.MAX_VALUE;
        for (int j = 0; j <nums.length; j++) {
            sum+=nums[j];
            while (sum>=target){
                res=Math.min(res,(j-i)+1);
                sum-=nums[i];
                i++;
            }
        }
        return res==Integer.MAX_VALUE?0:res;
    }
}
