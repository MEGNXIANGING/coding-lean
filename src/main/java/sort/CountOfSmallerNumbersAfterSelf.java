package sort;

import java.util.ArrayList;
import java.util.List;

public class CountOfSmallerNumbersAfterSelf {

    public static void main(String[] args) {
        int [] nums={5,2,6,1};
        countSmaller(nums);
    }

    public static List<Integer> countSmaller(int[] nums) {
        List<Integer> res = new ArrayList<>();
        int le = nums.length;
        int[] temp = new int[le];
        int[] index = new int[le];
        for (int i = 0; i < le; i++) {
            index[i]=i;
        }
        int[] ans = new int[le];
        mrSort(nums,0,le-1,temp,index,ans);
        for (int i = 0; i <le ; i++) {
            res.add(ans[i]);
        }
        return res;
    }

    private static void mrSort(int[] nums, int left, int right, int[] temp, int[] index, int[] ans) {
        if (left>=right){
            return;
        }
        int mid=left+(right-left)/2;
        mrSort(nums,left,mid,temp,index,ans);
        mrSort(nums,mid+1,right,temp,index,ans);
        mrNums(nums,left,right,temp,index,ans,mid);
    }

    private static void mrNums(int[] nums, int left, int right, int[] temp, int[] index, int[] ans, int mid) {
        for (int i = left; i <=right ; i++) {
            temp[i]=index[i];
        }
        int i=left;
        int j=mid+1;
        for (int k = left; k <=right ; k++) {
            if (i==mid+1){
                index[k]=temp[j++];
            }else if (j==right+1){
                index[k]=temp[i++];
                ans[index[k]]+=right-mid;
            }else if (nums[temp[i]]<=nums[temp[j]]){
                index[k]=temp[i++];
                ans[index[k]]+=j-mid-1;
            }else {
                index[k]=temp[j++];
            }
        }
    }
}
