package arrary;

public class FindMaxConsecutiveOnes {
    public static void main(String[] args) {
        int []test={1,0,1,1,0,1};
        System.out.println(findMaxConsecutiveOnes(test));
    }
    public static int findMaxConsecutiveOnes(int[] nums) {
        int max=0;
        int res=0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i]==1){
                res++;
            }else {
                max=Math.max(max,res);
                res=0;
            }
        }
        return Math.max(max,res);

    }
}
