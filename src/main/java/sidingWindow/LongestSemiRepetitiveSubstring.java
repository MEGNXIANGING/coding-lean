package sidingWindow;

import sort.KNums;

public class LongestSemiRepetitiveSubstring {
    public int longestSemiRepetitiveSubstring(String s) {
        int res=1;
        int left=0;
        int sum=0;
        char[] chars = s.toCharArray();
        for (int i = 1; i <chars.length ; i++) {
            if (chars[i]==chars[i-1]){
                sum++;
            }
            if (sum>1){
                left++;
                while (chars[left]!=chars[left-1]){
                    left++;
                }
                sum=1;
            }
            res=Math.max(res,i-left+1);
        }
        return res;
    }


























    public int longestSemiRepetitiveSubstring2(String S) {
        char[] s = S.toCharArray();
        int ans = 1;
        int same = 0;
        int left = 0;
        for (int right = 1; right < s.length; right++) {
            if (s[right] == s[right - 1]) {
                same++;
            }
            if (same > 1) { // same == 2
                left++;
                while (s[left] != s[left - 1]) {
                    left++;
                }
                same = 1;
            }
            ans = Math.max(ans, right - left + 1);
        }
        return ans;
    }
}
