package backtrack;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LetterCombinations {
    /**
     * 输入：digits = "23"
     * 输出：["ad","ae","af","bd","be","bf","cd","ce","cf"]
     */
    private static final String[] MAPPING = new String[]{"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public static void main(String[] args) {
        String digits="23";
        for (String letterCombination : letterCombinations(digits)) {
            System.out.println(letterCombination);
        }

    }
    public static List<String> letterCombinations(String digits) {
        //获取数组长度
        int n = digits.length();
        if (n == 0) {
            return List.of();
        }
        List<String> ans = new ArrayList<>();
        char[] path = new char[n];
        dfs(0, ans, path, digits.toCharArray());
        return ans;

    }

    private static void dfs(int i, List<String> ans, char[] path, char[] digits) {
        if (i == digits.length) {
            ans.add(new String(path));
            return;
        }
        String letters = MAPPING[digits[i] - '0'];
        for (char c:letters.toCharArray()){
            path[i]=c;
            dfs(i+1,ans,path,digits );
        }
    }
}

class Solution {
    private static final String[] MAPPING = new String[]{"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public List<String> letterCombinations(String digits) {
        int n = digits.length();
        if (n == 0) {
            return List.of();
        }
        List<String> ans = new ArrayList<>();
        char[] path = new char[n]; // 注意 path 长度一开始就是 n，不是空数组
        dfs(0, ans, path, digits.toCharArray());
        return ans;
    }

    private void dfs(int i, List<String> ans, char[] path, char[] digits) {
        if (i == digits.length) {
            ans.add(new String(path));
            return;
        }
        String letters = MAPPING[digits[i] - '0'];
        for (char c : letters.toCharArray()) {
            path[i] = c; // 直接覆盖
            dfs(i + 1, ans, path, digits);
        }
    }
}