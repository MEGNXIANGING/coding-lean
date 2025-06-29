package sort;

public class MrSort {

    public static void main(String[] args) {

        int[] nums = new int[]{1, 2, 8, 6, 4, 5, 3, 8, 5, 3, 4};
        int len=nums.length;
        int []tmp=new int[len];
        mrSort(nums, 0, nums.length - 1,tmp);
        for (int i : nums) {
            System.out.println(i);
        }
    }

    private static void mrSort(int[] nums, int left, int right, int[] tmp) {
        if (left==right){
            return;
        }
        int mid=(left+right)/2;
        mrSort(nums,left,mid,tmp);
        mrSort(nums,mid+1,right,tmp);
        for (int i = left; i <=right ; i++) {
            tmp[i]=nums[i];
        }
        int i=left;
        int j=mid+1;
        for (int k = left; k <=right ; k++) {
            if (i==mid+1){
                nums[k]=nums[j];
                j++;
            }else if (j==right+1){
                nums[k]=tmp[i];
                i++;
            }else if (tmp[i]<=tmp[j]){
                nums[k]=tmp[i];
                i++;
            }else {
                nums[k]=nums[j];
                j++;
            }
        }
        
    }
}
