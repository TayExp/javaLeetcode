package leetcode;

import java.util.TreeSet;

public class S_363_MaxSumRectangleNoLargerThanK {
    public int maxSumSubmatrix(int[][] matrix, int target) {
        if(matrix.length == 0 || matrix[0].length == 0) return 0;
        int rows = matrix.length, cols = matrix[0].length;
        int result = Integer.MIN_VALUE;
        for(int i = 0; i < rows; i++) {
        	int[] sumPerCol = new int[cols];
        	for(int j = i; j >= 0; j--) {
        		int sumCur = 0;
        		TreeSet<Integer> set = new TreeSet<>();
        		set.add(0);
        		for(int k = 0; k <cols; k++) {
        			sumPerCol[k] += matrix[j][k];
        			sumCur += sumPerCol[k];
        			Integer sub = set.ceiling(sumCur - target);
        			if(sub != null)
        				result = Math.max(result, sumCur - sub);
        			set.add(sumCur);
        		}
        	}
        }
        return result;
    }
}
