package sort;

public class Rotate {
    public void rotate(int[] nums, int k) {
        int n = nums.length - 1;
        for (int i = 0; i < k; i++) {
            int num = nums[n];
            for (int j = n - 1; j >= 0; j--) {
                nums[j + 1] = nums[j];
            }
            nums[0]=num;
        }
    }

    public void rotate2(int[] nums, int k) {
        int n = nums.length;
        k %= n; // 轮转 k 次等于轮转 k % n 次
        reverse(nums, 0, n - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, n - 1);
    }

    private void reverse(int[] nums, int i, int j) {
        while (i < j) {
            int temp = nums[i];
            nums[i++] = nums[j];
            nums[j--] = temp;
        }
    }


}
