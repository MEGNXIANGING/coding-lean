package monotonicStack;

import java.util.ArrayDeque;
import java.util.Stack;

public class DailyTemperatures {
    public int[] dailyTemperatures(int[] te) {
        ArrayDeque<Integer> st = new ArrayDeque<>();
        Stack<Integer> stack = new Stack<>();
        int n = te.length;
        int[] ans = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            int t = te[i];
            while (!st.isEmpty() && t >= te[st.peek()]) {
                st.pop();
            }
            if (!st.isEmpty()) {
                ans[i] = st.peek() - i;
            }
            st.push(i);
        }
        return ans;

    }

    public int[] dailyTemperatures2(int[] te) {
        ArrayDeque<Integer> st = new ArrayDeque<>();
        Stack<Integer> stack = new Stack<>();
        int n = te.length;
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            int t = te[i];
            while (st.isEmpty() && t > te[st.peek()]) {
                Integer j = st.pop();
                ans[i] = i - j;
            }
            st.push(i);
        }
        return ans;

    }
}
