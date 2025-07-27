package sidingWindow;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindAnagrams {
    public static void main(String[] args) {
        String s = "cbaebabacd";
        String p = "abc";
        System.out.println(findAnagrams2(s, p));
    }

    public static List<Integer> findAnagrams3(String s, String p) {
        int[] ss = new int[26];
        int[] ps = new int[26];
        for (char c : p.toCharArray()) {
            ss[c - 'a']++;
        }
        char[] chars = s.toCharArray();
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < chars.length; i++) {
            ps[chars[i] - 'a']++;
            int left = i - p.length() + 1;
            if (left < 0) {
                continue;
            }
            if (Arrays.equals(ss, ps)) {
                res.add(left);
            }
            //出
            ps[chars[left] - 'a']--;
        }
        return res;
    }

    public static List<Integer> findAnagrams(String s, String p) {
        char[] ps = p.toCharArray();
        Arrays.sort(ps);
        char[] chars = s.toCharArray();
        List<Integer> res = new ArrayList<>();
        int left = 0;
        char[] temp = new char[ps.length];
        for (int i = 0; i < chars.length; i++) {
            if (i < ps.length - 1) {
                temp[i] = chars[i];
                continue;
            }
            temp[ps.length - 1] = chars[i];
            char[] clone = temp.clone();
            Arrays.sort(clone);
            if (Arrays.equals(clone, ps)) {
                res.add(left);
            }
            for (int j = 1; j < ps.length; j++) {
                temp[j - 1] = temp[j];
            }
            left++;
        }
        return res;
    }

    public static List<Integer> findAnagrams2(String s, String p) {
        List<Integer> ans = new ArrayList<>();
        int[] cntP = new int[26]; // 统计 p 的每种字母的出现次数
        int[] cntS = new int[26]; // 统计 s 的长为 p.length() 的子串 s' 的每种字母的出现次数
        for (char c : p.toCharArray()) {
            cntP[c - 'a']++; // 统计 p 的字母
        }
        for (int right = 0; right < s.length(); right++) {
            cntS[s.charAt(right) - 'a']++; // 右端点字母进入窗口
            int left = right - p.length() + 1;
            if (left < 0) { // 窗口长度不足 p.length()
                continue;
            }
            if (Arrays.equals(cntS, cntP)) { // s' 和 p 的每种字母的出现次数都相同
                ans.add(left); // s' 左端点下标加入答案
            }
            cntS[s.charAt(left) - 'a']--; // 左端点字母离开窗口
        }
        return ans;
    }
}
