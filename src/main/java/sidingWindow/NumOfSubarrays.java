package sidingWindow;

class NumOfSubArrays {
    public static void main(String[] args) {
        int[] arr = new int[]{2, 2, 2, 2, 5, 5, 5, 8};
        System.out.println(numOfSubArrays(arr, 3, 4));
    }

    public static int numOfSubArrays(int[] arr, int k, int threshold) {
        int ans = 0;
        int sum = 0;
        for (int i = 0; i < k; i++) {
            sum += arr[i];
        }
        if (sum / k >= threshold) {
            ans++;
        }
        for (int i = k; i < arr.length ; i++) {
            sum += arr[i];
            sum -= arr[i-k];
            if (sum / k >= threshold) {
                ans++;
            }
        }
        return ans;
    }
}
