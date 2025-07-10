package dp;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

public class LengthOfLongestSubsequence {
    public int lengthOfLongestSubsequence(List<Integer> nums, int target) {
        int []f=new int[target+1];
        Arrays.fill(f,Integer.MIN_VALUE);
        f[0]=0;
        for (Integer item:nums){
            for (int i = target; i >=item ; i--) {
                f[i]=Math.max(f[i],f[i-item]+1);
            }
        }
        return f[target]>0?f[target]:-1;

    }
}
