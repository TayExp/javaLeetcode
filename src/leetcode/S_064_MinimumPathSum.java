package leetcode;

public class S_064_MinimumPathSum {
	public int minPathSum(int[][] grid) {
		int m = grid.length, n = grid[0].length; 
        int[][] paths = new int[m][n];
        paths[0][0] = grid[0][0];
        for(int i = 1; i < m; paths[i][0] = paths[i-1][0]+grid[i][0], i++);
        for(int i = 1; i < n; paths[0][i] = paths[0][i-1]+grid[0][i], i++);
        for(int i = 1; i < m; i++)
        	for(int j = 1; j < n; j++)
        		paths[i][j] = Math.min(paths[i-1][j],paths[i][j-1])+grid[i][j];
        return paths[m-1][n-1];
	 }
}
