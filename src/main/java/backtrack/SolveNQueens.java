package backtrack;

import java.util.*;

public class SolveNQueens {
    // 存储最终所有符合条件的棋盘布局
    List<List<String>> ans = new ArrayList<>();
    // 记录每一行皇后所在的列索引，例如col[0]=3表示第0行的皇后在第3列
    int[] col;
    // 棋盘的大小（N×N）
    int n;

    // 主方法：求解N皇后问题并返回所有可能的布局
    public List<List<String>> solveNQueens(int n) {
        this.n = n;
        col = new int[n];
        // 初始化可用列的集合（初始时所有列都可用）
        Set<Integer> availableCols = new HashSet<>();
        for (int i = 0; i < n; i++) {
            availableCols.add(i);
        }
        // 从第0行开始深度优先搜索
        dfs(0, availableCols);
        return ans;
    }

    // 检查在第r行第c列放置皇后是否合法
    private boolean valid(int r, int c) {
        // 遍历之前所有行已放置的皇后
        for (int R = 0; R < r; R++) {
            int C = col[R];
            // 检查是否在同一对角线上（正对角线：行差等于列差；反对角线：行和等于列和）
            if (r - c == R - C || r + c == R + C) {
                return false;
            }
        }
        return true;
    }

    // 深度优先搜索函数
    // r: 当前处理的行索引
    // s: 当前可用的列集合
    private void dfs(int r, Set<Integer> s) {
        // 终止条件：如果已经处理完所有行（r等于n），说明找到了一个有效解
        if (r == n) {
            // 构建当前解的棋盘布局
            List<String> board = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                StringBuilder row = new StringBuilder();
                for (int j = 0; j < n; j++) {
                    // 根据col数组生成每一行的字符串（Q表示皇后，.表示空位）
                    if (j == col[i]) {
                        row.append('Q');
                    } else {
                        row.append('.');
                    }
                }
                board.add(row.toString());
            }
            ans.add(board); // 将当前解添加到结果列表
            return;
        }

        // 遍历当前所有可用列
        for (int c : new HashSet<>(s)) {
            // 检查在第r行第c列放置皇后是否合法
            if (valid(r, c)) {
                col[r] = c; // 记录当前行的皇后位置
                s.remove(c); // 从可用列中移除当前选择的列
                dfs(r + 1, s); // 递归处理下一行
                s.add(c); // 回溯：恢复当前列，尝试其他可能性
            }
        }
    }


}


/**
 * LeetCode 51 N皇后
 */
class SolveNQueens4 {

    private List<List<String>> ans = new ArrayList<>();

    // 记录每一行 的那一列被放置过 皇后
    private int[] solved;
    // 记录第c列上面是否放置过皇后
    private boolean[] onPath;
    // 记录 坐标（r, c）所在的对角线上面， 上面是否有放置过皇后
    private boolean[] diag1; // 副对角线
    private boolean[] diag2; // 主对角线
    //有几个皇后
    private int n;

    public List<List<String>> solveNQueens(int n) {
        // 初始化数据模型
        this.n = n;
        this.solved = new int[n];
        this.onPath = new boolean[n];
        /**
         * 副对角线 r + c
         * 最大值 下标 为 n -1 + n -1
         * 也就是 2n - 2
         * 所以槽位需要 2n - 2 + 1  = 2n -1 个
         */
        this.diag1 = new boolean[2 * n - 1];
        /**
         * 主对角线 r-c+n-1
         * 因为r-c 可能为负值， 最小值为 0 - （n-1）；
         * 所以给结果加个n-1 可以消除负值； 每个坐标算的值统一加个常数， 也能保证占位逻辑不变
         * 加了n-1 后， n个槽位就放不下了；  槽位需要增加n-1个
         * 所以槽位需要 n + (n -1) = 2n -1 个
         */
        this.diag2 = new boolean[2 * n - 1];

        //开始深搜
        dfs(0);

        return ans;

    }

    /**
     * @param r 行号
     */
    private void dfs(int r) {
        if (r == n) {
            // 收集
            // . 代表没有放置过 皇后， Q代表皇后
            List<String> ans1 = new ArrayList<>(n);
            for (int rr = 0; rr < solved.length; rr++) {
                int cc = solved[rr];
                char[] chars = new char[n];
                Arrays.fill(chars, '.');
                chars[cc] = 'Q';
                ans1.add(new String(chars));
            }
            ans.add(ans1);
            return;
        }

        //遍历每一列c 因为第r行的第c列有放皇后的可能性
        for (int c = 0; c < n; c++) {
            if (!diag1[r + c] && !diag2[r - c + n - 1] && !onPath[c]) {// 如果当前坐标可以放皇后
                // 在第r行 第c列放置皇后
                solved[r] = c;
                //标识当前列和主副对角线已经放置过皇后的标识
                onPath[c] = diag1[r + c] = diag2[r - c + n - 1] = true;
                //当前行已经放过皇后了， 可以递推去放置下一行的皇后
                dfs(r + 1);
                // 恢复现场，
                // 主要是为了当前行的其他列切片去尝试深搜的时候， 不被上一列，也就是兄弟切片的干扰
                onPath[c] = diag1[r + c] = diag2[r - c + n - 1] = false;
            }
        }
    }

}