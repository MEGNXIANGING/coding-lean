package twoPoint.water;

public class Trap {
    public int trap(int[] height) {
        //时间复杂度 O(N)
        //空间复杂度 O(N)
        int res = 0;
        int n = height.length;
        int[] preMax = new int[n];
        preMax[0] = height[0];
        for (int i = 1; i < n; i++) {
            preMax[i] = Math.max(preMax[i - 1], height[i]);
        }
        int[] sufMax = new int[n];
        sufMax[n - 1] = height[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            sufMax[i] = Math.max(sufMax[i + 1], height[i]);
        }
        int index = 0;
        while (index < n) {
            res += Math.min(preMax[index], sufMax[index]) - height[index];
            index++;
        }
        return res;
    }

    public int trap2(int[] height) {
        //时间复杂度 O(N)
        //空间复杂度 O(1)
        int res = 0;
        int left = 0;
        int right = height.length - 1;
        int preMax = 0;
        int subMax = 0;
        while (left < right) {
            preMax=Math.max(preMax,height[left]);
            subMax=Math.max(subMax,height[right]);
            if (preMax>subMax){
                res+=subMax-height[right];
                right--;
            }else {
                res+=preMax-height[left];
                left++;
            }
        }
        return res;
    }
}
