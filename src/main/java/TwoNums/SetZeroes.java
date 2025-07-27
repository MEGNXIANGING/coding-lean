package TwoNums;

import java.util.HashSet;
import java.util.Set;

public class SetZeroes {
    public void setZeroes(int[][] matrix) {
        Set<Integer> zeroRwo = new HashSet<>();
        Set<Integer> zeroCol = new HashSet<>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 0) {
                    zeroRwo.add(i);
                    zeroCol.add(j);
                }
            }
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (zeroRwo.contains(i) || zeroCol.contains(j)) {
                    matrix[i][j] = 0;
                }
            }
        }
    }
}
