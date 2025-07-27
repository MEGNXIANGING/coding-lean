package twoPoint;

public class MoveZeroes2 {
    public void moveZeroes(int[] nums) {
        int j=0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i]!=0){
                nums[j]=0;
                j++;
            }
        }
        for (int i = j; i <nums.length ; i++) {
            nums[i]=0;
        }
    }
}
