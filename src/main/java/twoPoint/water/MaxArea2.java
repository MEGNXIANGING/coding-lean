package twoPoint.water;

public class MaxArea2 {
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int ans = 0;
        while (left < right) {
            if (height[left] < height[right]) {
                ans = Math.max((right - left) * height[left], ans);
                left++;
            } else {
                ans = Math.max((right - left) * height[right], ans);
                right--;
            }
        }
        return ans;

    }
}
