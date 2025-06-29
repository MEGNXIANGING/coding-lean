package sort;

import java.util.Random;

public class QueckSort {
    public static void main(String[] args) {
       int []arr= new int[]{1,3,5,7,3,2,5,6};
        quickSort(arr,0,arr.length-1);
       for (int i:arr){
           System.out.println(i);
       }

    }
    // 快速排序主函数
    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(arr, low, high); // 分区，返回基准的位置
            quickSort(arr, low, pivotIndex - 1);  // 递归排序左半部分
            quickSort(arr, pivotIndex + 1, high); // 递归排序右半部分
        }
    }

    // 分区函数（核心）
    private static int partition(int[] arr, int low, int high) {
        int randomIndex = new Random().nextInt(high - low + 1) + low;
        swap(arr, randomIndex, high);
        int pivot = arr[high];  // 选择最右边的元素作为基准
        int i = low - 1;        // i 是“小个子队伍”的末尾指针

        for (int j = low; j < high; j++) {
            // 如果当前元素 <= 基准，就把它放到“小个子队伍”末尾
            if (arr[j] <= pivot) {
                i++;
                swap(arr, i, j); // 交换 i 和 j 的位置
            }
        }

        // 最后把基准放到中间位置（i+1）
        swap(arr, i + 1, high);
        return i + 1; // 返回基准的最终位置
    }

    // 交换数组中两个元素的位置
    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }



}
