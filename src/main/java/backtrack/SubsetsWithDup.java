package backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetsWithDup {
    List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        qkSort(nums,0,nums.length-1);
        dfs(0, nums, new ArrayList<>());
        return ans;
    }




    private void dfs(int i, int[] nums, List<Integer> path) {
        ans.add(new ArrayList<>(path));
        if (i == nums.length) {
            return;
        }

        for (int j = i; j < nums.length; j++) {
            if (j > i && nums[j] == nums[j - 1]) {
                continue;
            }
            path.add(nums[j]);
            dfs(j + 1, nums, path);
            path.remove(path.size() - 1);
        }
    }


    private void qkSort(int[] nums, int left, int right) {
        if (left>=right){
            return;
        }
        int pre=nums[left];
        int lt=left+1;
        int gt=right;
        int i=left+1;
        while (i<=gt){
            if (nums[i]<pre){
                swap(nums,lt++,i++);
            }else if (nums[i]==pre){
                i++;
            }else {
                swap(nums,i,gt--);
            }
        }
        swap(nums,left,lt-1);
        qkSort(nums,left,lt-2);
        qkSort(nums,gt+1,right);
    }
    // 交换数组中两个元素的位置
    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
