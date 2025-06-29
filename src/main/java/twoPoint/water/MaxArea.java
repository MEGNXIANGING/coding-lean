package twoPoint.water;

public class MaxArea {

    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length;
        int area = 0;
        //短板效应，那边短调整哪边
        while (left < right) {
            area=Math.max(area,(right-left)*Math.min(height[left],height[right]));
            if (height[left]<height[right]){
                left++;
            }else {
                right--;
            }
        }
        return area;
    }
}
