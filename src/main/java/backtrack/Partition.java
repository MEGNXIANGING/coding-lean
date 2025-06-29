package backtrack;

import java.util.ArrayList;
import java.util.List;

public class Partition {
    public List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();
        dfs(0, s, ans, new ArrayList<>());
        return ans;
    }

    private void dfs(int i, String s, List<List<String>> ans, List<String> path) {
        if (i == s.length()) {
            ans.add(new ArrayList<>(path));
            return;
        }
        for (int j = i; j < s.length(); j++) {
            if (isFlag(i, j, s)) {
                path.add(s.substring(i, j + 1));
                dfs(j + 1, s, ans, path);
                path.remove(path.size() - 1);
            }
        }

    }

    private boolean isFlag(int i, int j, String s) {
        char[] chars = s.toCharArray();
        while (i < j) {
            if (chars[i] != chars[j]) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
