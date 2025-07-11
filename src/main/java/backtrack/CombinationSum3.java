package backtrack;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum3 {

    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ans = new ArrayList<>();
        dfs(9, k, n, ans, new ArrayList<>());
        return ans;
    }

    private void dfs(int i, int k, int t, List<List<Integer>> ans, List<Integer> path) {
        int d = k - path.size();
        if (t < 0 || t > (i * 2 - d + 1) * d / 2) { // 剪枝
            return;
        }
        if (d == 0) {
            ans.add(new ArrayList<>(path));
            return;
        }
        for (int j = i; j >= d; j--) {
            path.add(j);
            dfs(j - 1, k, t - j, ans, path);
            path.remove(path.size() - 1);
        }
    }
}

class Solutio3 {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ans = new ArrayList<>();
        dfs(9, k, n, ans, new ArrayList<>(), 0);
        return ans;
    }

    private void dfs(int i, int k, int n, List<List<Integer>> ans, List<Integer> path, int sum) {
        int d = k - path.size();
        //长度剪枝
        if (i < d) {
            return;
        }
        if (path.size() == k) {
            if (sum == n) {
                ans.add(new ArrayList<>(path));
                return;
            }
        }
        for (int j = i; j >= 1; j--) {
            sum += j;
            path.add(j);
            dfs(j - 1, k, n, ans, path, sum);
            path.remove(path.size() - 1);
            sum -= j;
        }
    }
}


class Solution2 {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> path = new ArrayList<>(k);
        dfs(9, n, k, ans, path);
        return ans;
    }

    private void dfs(int i, int t, int k, List<List<Integer>> ans, List<Integer> path) {
        int d = k - path.size(); // 还要选 d 个数
        if (t < 0 || t > (i * 2 - d + 1) * d / 2) { // 剪枝
            return;
        }
        if (d == 0) { // 找到一个合法组合
            ans.add(new ArrayList<>(path));
            return;
        }
        for (int j = i; j >= d; j--) {
            path.add(j);
            dfs(j - 1, t - j, k, ans, path);
            path.remove(path.size() - 1);
        }
    }
}

