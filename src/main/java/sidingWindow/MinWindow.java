package sidingWindow;

import java.util.HashMap;
import java.util.Map;

public class MinWindow {
    public String minWindow(String s, String t) {
        if (s.length() == 0 || t.length() == 0) {
            return "";
        }
        Map<Character, Integer> tm = new HashMap<>();
        int tCount = 0;
        for (char c : t.toCharArray()) {
            tm.put(c, tm.getOrDefault(c, 0) + 1);
            tCount++;
        }

        Map<Character, Integer> sm = new HashMap<>();
        int left = 0;
        int i = 0;
        int have = 0;
        int right = s.length() - 1;
        int res = Integer.MAX_VALUE;
        int restart=0;
        char[] chars = s.toCharArray();
        while (left <= right) {
            char ch = chars[left];
            if (tm.containsKey(ch)) {
                sm.put(ch, sm.getOrDefault(ch, 0) + 1);
                if (sm.get(ch) >= tm.get(ch)) {
                    have += tm.get(ch);
                }
            }
            while (have == tCount) {
                if (res>left - i + 1){
                    res =left - i + 1;
                    restart=left;
                }

                char iCh = chars[i];
                if (tm.containsKey(iCh)) {
                    sm.put(iCh, sm.getOrDefault(iCh, 0) + 1);
                    if (sm.get(iCh) >= tm.get(iCh)) {
                        sm.put(iCh, sm.get(iCh) - 1);
                        if (tm.get(iCh) > sm.get(iCh)) {
                            have -= tm.get(iCh);
                        }
                    }

                }
                i++;
            }
            left++;

        }
        return res==Integer.MAX_VALUE?"":s.substring(restart,restart+res-1);
    }
}
