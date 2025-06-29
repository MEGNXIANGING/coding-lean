package backtrack;

import java.util.ArrayList;
import java.util.List;

public class GenerateParenthesis {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        char[] path = new char[2 * n];
        dfs(0, n, ans, path, 0);
        return ans;
    }

    private void dfs(int i, int n, List<String> ans, char[] path, int open) {
        if (i == 2 * n) {
            ans.add(new String(path));
            return;
        }
        if (open < n) {
            path[i] = '(';
            dfs(i + 1, n, ans, path, open + 1);
        }
        if (i - open < open) {
            path[i] = ')';
            dfs(i + 1, n, ans, path, open);
        }
    }
}


class Solution4 {
    private int n;
    private final List<String> ans = new ArrayList<>();
    private char[] path;

    public List<String> generateParenthesis(int n) {
        this.n = n;
        path = new char[n * 2]; // 所有括号长度都是一样的 n*2
        dfs(0, 0);
        return ans;
    }

    // 目前填了 i 个括号
    // 这 i 个括号中有 open 个左括号，i-open 个右括号
    private void dfs(int i, int open) {
        if (i == n * 2) { // 括号构造完毕
            ans.add(new String(path)); // 加入答案
            return;
        }
        if (open < n) { // 可以填左括号
            path[i] = '('; // 直接覆盖
            dfs(i + 1, open + 1); // 多了一个左括号
        }
        if (i - open < open) { // 可以填右括号
            path[i] = ')'; // 直接覆盖
            dfs(i + 1, open);
        }
    }
}

