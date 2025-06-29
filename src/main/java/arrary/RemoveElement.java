package arrary;

public class RemoveElement {
    public static void main(String[] args) {
        int[] nums={3,2,2,3};
        System.out.println(removeElement(nums,3));
    }
    public static int removeElement(int[] nums, int val) {
        int len=nums.length;
        if (len==0){
            return 0;
        }
        int j=0;
        for (int i = 0; i <len; i++) {
            if (nums[i]!=val){
                nums[j]=nums[i];
                j++;
            }
        }
        return j;

    }
}
