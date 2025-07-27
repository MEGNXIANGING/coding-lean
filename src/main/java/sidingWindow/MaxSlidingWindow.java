package sidingWindow;

import java.util.ArrayDeque;
import java.util.Deque;

public class MaxSlidingWindow {
    public static void main(String[] args) {
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        System.out.println(maxSlidingWindow2(nums, 3));
    }

    public static int[] maxSlidingWindow2(int[] nums, int k) {
        int[] res = new int[nums.length - k + 1];
        Deque<Integer> q = new ArrayDeque();
        for (int i = 0; i < nums.length; i++) {
            int x = nums[i];
            //入
            while (!q.isEmpty() && nums[q.getLast()] <= x) {
                q.removeLast();
            }
            q.addLast(i);
            //出
            int left = i - k + 1;
            //5-3=2+1=3>2;
            if (q.getFirst() < left) {
                q.removeFirst();
            }
            if (left >= 0) {
                res[left]=nums[q.getFirst()];
            }
        }
        return res;
    }


    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] ans = new int[n - k + 1]; // 窗口个数
        Deque<Integer> q = new ArrayDeque<>(); // 更快的写法见【Java 数组】

        for (int i = 0; i < n; i++) {
            // 1. 右边入
            while (!q.isEmpty() && nums[q.getLast()] <= nums[i]) {
                q.removeLast(); // 维护 q 的单调性
            }
            q.addLast(i);

            // 2. 左边出
            int left = i - k + 1; // 窗口左端点
            if (q.getFirst() < left) { // 队首已经离开窗口了
                q.removeFirst();
            }

            // 3. 在窗口左端点处记录答案
            if (left >= 0) {
                // 由于队首到队尾单调递减，所以窗口最大值就在队首
                ans[left] = nums[q.getFirst()];
            }
        }

        return ans;
    }
}
