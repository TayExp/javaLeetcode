package leetcode;

public class S_329_LongestIncreasingPath {
	int[][] dis = {{1,0},{-1,0},{0,1},{0,-1}};
    public int longestIncreasingPath(int[][] matrix) {
        if(matrix == null || matrix.length == 0 || matrix[0] == null ||matrix[0].length == 0)
        		return 0;
        int m = matrix.length, n = matrix[0].length;
        int ret = 0;
        int [][] dp = new int[m][n];
        for(int i = 0; i < m; i++)
        	for(int j = 0; j < n; j++)
        		ret = Math.max(ret, dfs(matrix, dp, i, j));
        return ret;
    }

    public int dfs(int[][] matrix,int[][] state, int i, int j){
	    if(state[i][j] > 0) return state[i][j];
	    int max = 0;
	    for(int m = 0; m < dis.length; m++){
	        if(i + dis[m][0] >= 0 && i + dis[m][0] < matrix.length && j + dis[m][1] >= 0 && j + dis[m][1] < matrix[0].length 
	        		&& matrix[i+dis[m][0]][j+dis[m][1]] > matrix[i][j]){
	            max = Math.max(max,dfs(matrix,state,i + dis[m][0],j + dis[m][1]));
	        }
	    }
	    state[i][j] = 1 + max;
	    return state[i][j];  
    }
    
    
	private int recursion(int[][] matrix, boolean[][] visited, int i, int j, int last) {
		int ret = 0;
        if(isValid(i, j, matrix, visited) && matrix[i][j] > last){
            visited[i][j] = true;
            ret++;
            ret = Math.max(ret, 1+recursion(matrix, visited, i+1, j, matrix[i][j]));
            ret = Math.max(ret, 1+recursion(matrix, visited, i-1, j, matrix[i][j]));
            ret = Math.max(ret, 1+recursion(matrix, visited, i, j+1, matrix[i][j]));
            ret = Math.max(ret, 1+recursion(matrix, visited, i, j-1, matrix[i][j]));
            visited[i][j] = false;
        }
		return ret;
	}
	private boolean isValid(int i, int j, int[][] matrix, boolean[][] visited) {
		return i >= 0 && j >= 0 && i < matrix.length && j <matrix[0].length && !visited[i][j];
	}
}
