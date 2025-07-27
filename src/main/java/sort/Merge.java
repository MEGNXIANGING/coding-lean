package sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Merge {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (o1, o2) -> o1[0] - o2[0]);
        List<int[]> ans = new ArrayList<>();
        for (int[] c : intervals) {
            int m = ans.size();
            if (m > 0 && ans.get(m - 1)[1] >= c[0]) {
                ans.get(m - 1)[1] = Math.max(ans.get(m - 1)[1], c[1]);
            } else {
                ans.add(c);
            }
        }
        return ans.toArray(new int[ans.size()][]);
    }
}
