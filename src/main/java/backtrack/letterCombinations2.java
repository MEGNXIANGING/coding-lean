package backtrack;

import java.util.ArrayList;
import java.util.List;

public class letterCombinations2 {
    private static final String[] MAPPER = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<>();
        char[] chars = new char[digits.length()];
        char[] digitsChar = digits.toCharArray();
        dfs(0, ans, chars, digitsChar);
        return ans;
    }

    private void dfs(int i, List<String> ans, char[] path, char[] digitsChas) {
        if (i == digitsChas.length) {
            ans.add(new String(path));
            return;
        }
        String letters = MAPPER[digitsChas[i] - '0'];
        for (char c : letters.toCharArray()) {
            path[i] = c; // 直接覆盖
            dfs(i + 1, ans, path, digitsChas);
        }
    }
}
