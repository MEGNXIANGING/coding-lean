package sidingWindow;

import java.util.*;

public class MaxVowels {
    public int maxVowels(String s, int k) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        boolean[] vos = new boolean[128];
        vos['a']=true;
        vos['e']=true;
        vos['i']=true;
        vos['o']=true;
        vos['u']=true;
        int count=0;
        char[] chars = s.toCharArray();
        for (int i = 0; i <k ; i++) {
            if (vos[chars[i]]){
                count++;
            }
        }

        int max=count;
        if (max==k){
            return count;
        }
        for (int i = k; i <chars.length; i++) {
            if (vos[chars[i]]){
                count++;
            }
            if (vos[chars[i-k]]){
                count--;
            }

            max=Math.max(count,max);
            if (max==k){
                return max;
            }
        }
        return max;

    }

    public int maxVowels2(String s, int k) {
        if (s == null || s.length() == 0 || k <= 0) {
            return 0;
        }

        final Set<Character> vowels = Set.of('a', 'e', 'i', 'o', 'u');
        char[] chars = s.toCharArray();
        int count = 0;

        // 计算第一个窗口的元音数量
        for (int i = 0; i < k; i++) {
            if (vowels.contains(chars[i])) {
                count++;
            }
        }

        int max = count;
        if (max == k) return k;  // 提前终止

        // 滑动窗口
        for (int i = k; i < chars.length; i++) {
            char oldChar = chars[i - k];
            char newChar = chars[i];

            if (vowels.contains(oldChar)) {
                count--;
            }
            if (vowels.contains(newChar)) {
                count++;
            }

            max = Math.max(max, count);
            if (max == k) return k;  // 提前终止
        }

        return max;
    }

    public int maxVowels3(String s, int k) {
        if (s == null || s.length() == 0 || k <= 0) {
            return 0;
        }

        boolean[] isVowel = new boolean[128]; // ASCII 范围
        isVowel['a'] = true;
        isVowel['e'] = true;
        isVowel['i'] = true;
        isVowel['o'] = true;
        isVowel['u'] = true;

        char[] chars = s.toCharArray();
        int count = 0;

        // 计算第一个窗口的元音数量
        for (int i = 0; i < k; i++) {
            if (isVowel[chars[i]]) {
                count++;
            }
        }

        int max = count;
        if (max == k) return k; // 提前终止
        // 滑动窗口
        for (int i = k; i < chars.length; i++) {
            if (isVowel[chars[i - k]]) count--;
            if (isVowel[chars[i]]) count++;

            max = Math.max(max, count);
            if (max == k) return k; // 提前终止
        }

        return max;
    }
}
