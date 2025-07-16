package monotonicStack;

public class Trap {
    public int trap(int[] height) {
        int n=height.length;
        int l=0;
        int r=n-1;
        int lMax=0;
        int rMax=0;
        int ans=0;
        while (l<r){
            lMax=Math.max(lMax,height[l]);
            rMax=Math.max(rMax,height[r]);
            if (lMax>rMax){
                ans+=rMax-height[r];
                r--;
            }else {
                ans+=lMax-height[l];
                l++;

            }
        }
        return ans;
    }
}
