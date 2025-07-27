package sidingWindow;

public class LengthOfLongestSubstring2 {
    public int lengthOfLongestSubstring(String s) {
        char[] chars = s.toCharArray();
        int[] temp = new int[128];
        int ans = 0;
        int left = 0;
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            temp[c]++;
            while (temp[c] > 1) {
                temp[chars[left]]--;
                left++;
            }
            ans = Math.max(ans, i - left + 1);
        }
        return ans;
    }
}
