package twoPoint.water;

public class Trap2 {
    public int trap(int[] height) {
        int ans = 0;
        int left = 0;
        int right = height.length - 1;
        int preMax = 0;
        int subMax = 0;
        while (left < right) {
            preMax = Math.max(preMax, height[left]);
            subMax = Math.max(subMax, height[right]);
            if (preMax < subMax) {
                ans += preMax - height[left++];
            } else {
                ans += subMax - height[right--];
            }
        }
        return ans;
    }
}
