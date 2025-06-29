package heap;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Random;

public class FindKthLargest {
    private static final Random random = new Random();

    public int findKthLargest(int[] nums, int k) {
//        PriorityQueue<Integer> Maxheap = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> res = new PriorityQueue<>(Collections.reverseOrder());
        for (int num:nums) {
            res.add(num);
        }
        for (int i = 0; i <k-1; i++) {
            res.poll();
        }
        return res.poll()  ;
    }

    public static void main(String[] args) {
        int[] nums1={3,2,3,1,2,4,5,5,6};
        int kthLargest2 = findKthLargest2(nums1, 2);
        System.out.println(kthLargest2);
    }

    public static int findKthLargest2(int[] nums, int k) {
//        PriorityQueue<Integer> Maxheap = new PriorityQueue<>(Collections.reverseOrder());

        quickSort(nums,0,nums.length-1);
        return  nums[nums.length-k];
    }
    public static void quickSort(int[]nums,int left,int right){
        if (left>=right){
            return;
        }
        int pivotIndex = left + random.nextInt(right - left + 1);
        swap(nums,left,pivotIndex);
        int pre=nums[left];
        int lt=left+1;
        int gt=right;
        int i=left+1;
        while (i<=gt){
            if (nums[i]<pre){
                swap(nums,i++,lt++);
            }else if (nums[i]==pre){
                i++;
            }else {
                swap(nums,i,gt--);
            }
        }
        swap(nums,left,lt-1);
        quickSort(nums,left,lt-2);
        quickSort(nums,gt+1,right);
    }
    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }



}
