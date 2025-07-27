package hash;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class LongestConsecutive {
    public int longestConsecutive(int[] nums) {
        int ans =0;
        Set<Integer> sets = new HashSet<>();
        for (int c:nums){
            sets.add(c);
        }
        for(int x:sets){
            if (sets.contains(x-1)){
                continue;
            }
            int y=x+1;
            while (sets.contains(y)){
                y++;
            }
            //y-1的时候符合要求，所以y-1-x+1=y-x;
            ans=Math.max(ans,y-x);
        }
        return ans;

    }
}
