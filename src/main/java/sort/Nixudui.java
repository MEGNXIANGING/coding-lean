package sort;

public class Nixudui {
    public static void main(String[] args) {
        int[] nums={9, 7, 5, 4, 6};
        System.out.println(reversePairs(nums));
    }
    public static int reversePairs(int[] record) {
        int le = record.length;
        if (le < 2) {
            return 0;
        }
        int temp[] = new int[le];
        return mrSort(record, 0, le - 1, temp);
    }

    private static int mrSort(int[] record, int left, int right, int[] temp) {
        if (left >= right) {
            return 0;
        }
        int mid = left + (right - left) / 2;
        int count = mrSort(record, left, mid, temp)+ mrSort(record, mid + 1, right, temp);
        if (record[mid] <= record[mid + 1]) {
            return count;
        }
        return count + merge(record, left, right, mid, temp);
    }

    private static int merge(int[] record, int left, int right, int mid, int[] temp) {
        for (int i = left; i <=right ; i++) {
            temp[i]=record[i];
        }
        int i=left;
        int j=mid+1;
        int count=0;
        for (int k = left; k <=right; k++) {
            if (i>mid){
                record[k] = temp[j++];
            }else if (j>right){
                record[k] = temp[i++];
            }else if (temp[i]<=temp[j]){
                record[k] = temp[i++];
            }else {
                record[k] = temp[j++];
                count+=mid-i+1;
            }
        }
        return count;
    }

    private static int mergeSort(int[] nums, int left, int right, int[] temp) {
        if (left >= right) {
            return 0;
        }
        int mid = left + (right - left) / 2;
        int count = mergeSort(nums, left, mid, temp) + mergeSort(nums, mid + 1, right, temp);

        // 优化：如果已经有序，直接返回
        if (nums[mid] <= nums[mid + 1]) {
            return count;
        }

        // 合并并计算逆序对
        int i = left, j = mid + 1, k = 0;
        while (i <= mid && j <= right) {
            if (nums[i] <= nums[j]) {
                temp[k++] = nums[i++];
            } else {
                temp[k++] = nums[j++];
                count += mid - i + 1; // 关键：左边剩下的都比右边当前数大
            }
        }

        // 处理剩余元素
        while (i <= mid) {
            temp[k++] = nums[i++];
        }
        while (j <= right) {
            temp[k++] = nums[j++];
        }

        // 写回原数组
        System.arraycopy(temp, 0, nums, left, right - left + 1);

        return count;
    }
}
