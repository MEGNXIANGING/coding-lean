package backtrack;

import java.util.ArrayList;
import java.util.List;

public class Combine {
    /**
     * 输入：n = 4, k = 2
     * 输出：
     * [
     * [2,4],
     * [3,4],
     * [2,3],
     * [1,2],
     * [1,3],
     * [1,4],
     * ]
     */
    public static void main(String[] args) {
        List<List<Integer>> combine = combine(4, 2);
        System.out.println(combine);

    }

    public static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ans = new ArrayList<>();
        dfs2(n, k, ans, new ArrayList<>());
        return ans;
    }



    private static void dfs2(int i, int k, List<List<Integer>> ans, List<Integer> path) {
        int d = k - path.size();
//        if (i < d) {
//            return;
//        }
        if (path.size() == k) {
            ans.add(new ArrayList<>(path));
            return;
        }

        for (int j = i; j >= d; j--) {
            path.add(j);
            dfs2(j - 1, k, ans, path);
            path.remove(path.size() - 1);
        }
    }

    private static void dfs(int i, int k, int n, List<List<Integer>> ans, List<Integer> path) {
        int d = k - path.size();
        if (n - i + 1 < d) {
            return;
        }
        if (path.size() == k) {
            ans.add(new ArrayList<>(path));
            return;
        }

        for (int j = i; j <= n; j++) {
            path.add(j);
            dfs(j + 1, k, n, ans, path);
            path.remove(path.size() - 1);
        }
    }
}
