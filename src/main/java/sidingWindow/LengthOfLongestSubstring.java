package sidingWindow;

import java.util.Arrays;

public class LengthOfLongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        char[] chars = s.toCharArray();
        int[] temp = new int[128];
        int left = 0;
        int ans = 0;
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            temp[c]++;
            while (temp[c] > 1) {
                temp[chars[left]]--;
                left++;
            }
            ans=Math.max(ans,i-left+1);
        }
        return ans;
    }

    public int lengthOfLongestSubstring2(String s) {
        int[] lastSeen = new int[128]; // 记录字符最后出现的位置+1
        Arrays.fill(lastSeen, -1); // 初始化为-1
        int left = 0;
        int ans = 0;

        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            // 如果字符已经出现过，并且在当前窗口内
            if (lastSeen[c] >= left) {
                // 更新最大长度（在移动left前计算）
                ans = Math.max(ans, right - left);
                // 移动左指针到重复字符的下一个位置
                left = lastSeen[c] + 1;
            }
            // 记录字符最后出现的位置
            lastSeen[c] = right;
        }
        // 最后再检查一次（处理没有重复字符的情况）
        ans = Math.max(ans, s.length() - left);

        return ans;
    }

    public int lengthOfLongestSubstring3(String S) {
        char[] s = S.toCharArray(); // 转换成 char[] 加快效率（忽略带来的空间消耗）
        int n = s.length;
        int ans = 0;
        int left = 0;
        int[] cnt = new int[128]; // 也可以用 HashMap<Character, Integer>，这里为了效率用的数组
        for (int right = 0; right < n; right++) {
            char c = s[right];
            cnt[c]++;
            while (cnt[c] > 1) { // 窗口内有重复字母
                cnt[s[left]]--; // 移除窗口左端点字母
                left++; // 缩小窗口
            }
            ans = Math.max(ans, right - left + 1); // 更新窗口长度最大值
        }
        return ans;
    }

}
