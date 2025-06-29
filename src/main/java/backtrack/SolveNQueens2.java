package backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SolveNQueens2 {
    List<List<String>> ans = new ArrayList<>();

    public List<List<String>> solveNQueens(int n) {
        //定义一个二维数组定义棋盘
        char[][] chars = new char[n][n];
        //给棋盘进行初始化
        for (char[] c : chars) {
            Arrays.fill(c, '.');
        }
        dfs(n, 0, chars);
        return ans;
    }

    private void dfs(int n, int row, char[][] chars) {
        if (row == n) {
            List<String> list = new ArrayList<>();
            for (char[] c : chars) {
                list.add(new String(c));
            }
            ans.add(list);
            return;
        }
        for (int col = 0; col < n; col++) {
            if (isValid(row, col, n, chars)) {
                chars[row][col] = 'Q';
                dfs(n, row + 1, chars);
                chars[row][col] = '.';
            }
        }
    }

    private boolean isValid(int row, int col, int n, char[][] chars) {
        //判断列
        for (int i = 0; i < row; i++) {
            if (chars[i][col] == 'Q') {
                return false;
            }
        }
        // 检查左上对角线
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (chars[i][j] == 'Q') {
                return false;
            }
        }
        // 检查右上对角线
        for (int i = row-1, j = col + 1; i >= 0 && j < n; i--, j++) {
            if (chars[i][j] == 'Q') {
                return false;
            }
        }
        return true;
    }
}
