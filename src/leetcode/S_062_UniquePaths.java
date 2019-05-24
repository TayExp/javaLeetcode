package leetcode;

public class S_062_UniquePaths {
    public int uniquePaths1(int m, int n) {
        if(m==1 || n==1)
        	return 1;
        return uniquePaths(m-1, n) + uniquePaths(m, n-1);
    }
    public int uniquePaths(int m, int n) {
        int[][] paths = new int[m][n];
        for(int i = 0; i < m;paths[i][0] = 1, i++);
        for(int i = 0; i < n;paths[0][i] = 1, i++);
        for(int i = 1; i < m; i++)
        	for(int j = 1; j < n; j++)
        		paths[i][j] = paths[i-1][j]+paths[i][j-1];
        return paths[m-1][n-1];
    }
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
    	int m = obstacleGrid.length, n = obstacleGrid[0].length;
    	int[][] paths = new int[m][n];
        for(int i = 0; i < m; i++){
        	if(obstacleGrid[i][0] == 1)
        		break;
        	paths[i][0] = 1;
        }
        for(int i = 0; i < n; i++){
        	if(obstacleGrid[0][i] == 1)
        		break;
        	paths[0][i] = 1;
        }
        for(int i = 1; i < m; i++)
        	for(int j = 1; j < n; j++)
        		if(obstacleGrid[i][j] == 0)
        			paths[i][j] = paths[i-1][j]+paths[i][j-1];
        		else
        			paths[i][j] = 0;
        return paths[m-1][n-1];
    }
}
