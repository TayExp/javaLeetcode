package leetcode;


import java.util.List;

public class S_120_Triangle {
    public int minimumTotal(List<List<Integer>> triangle) { 
		int m = triangle.size();
		if(m == 0) return 0;
		int[][] level = new int[2][m];
        int curr = 0;
		level[0][0] = triangle.get(0).get(0);
		for(int i = 1; i < m; i++){
            curr = 1 - curr;
            List<Integer> row = triangle.get(i);
			for(int j = 0; j < i + 1; j++)
				level[curr][j] = row.get(j) + j == 0? level[1-curr][j]:
						(j == i? level[1-curr][j-1]:Math.min(level[1-curr][j], level[1-curr][j-1]));
		}
		int minSum = level[curr][0];
		for(int sum : level[curr])
			minSum = Math.min(minSum, sum);
		return minSum;
    }
}
