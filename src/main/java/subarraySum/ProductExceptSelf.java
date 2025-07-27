package subarraySum;

public class ProductExceptSelf {
    /**
     * pre[i]=p[0]*p[i-1]
     * sub[i]=sub[i+1]*sub[n-1]
     * answer[i]=pre[i] *  sub[i]
     *
     * @param nums
     * @return
     */
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] pre = new int[n];
        pre[0] = 1;
        for (int i = 1; i < n; i++) {
            pre[i] = pre[i - 1] * nums[i-1];
        }
        int[] sub = new int[n];
        sub[n - 1] = 1;
        for (int i = n - 2; i >= 0; i--) {
            sub[i] = sub[i + 1] * nums[i+1];
        }
        int[] answer = new int[n];
        for (int i = 0; i < n; i++) {
            answer[i]=pre[i] * sub[i];
        }
        return answer;
    }
}
