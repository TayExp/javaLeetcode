package leetcode;

public class S_200_NumberofIslands {
    public int numIslands(char[][] grid) {
    	if(grid.length == 0 || grid[0].length == 0) return 0;
    	int count = 0;
        boolean[][] board = new boolean[grid.length] [grid[0].length];
        for(int i = 0; i < grid.length;i++)
        	for(int j = 0; j< grid[0].length; j++)
        		if(!board[i][j] && grid[i][j] == '1'){
        			count ++;
        			dfs(grid, i, j, board);
        		}
        return count;
    }

	private void dfs(char[][] grid, int i, int j, boolean[][] board) {
		if(i>=0 && j>=0 && i<grid.length && j < grid[0].length && !board[i][j] && grid[i][j]=='1'){
			board[i][j] = true;
			dfs(grid, i+1, j, board);
			dfs(grid, i-1, j, board);
			dfs(grid, i, j+1, board);
			dfs(grid, i, j-1, board);
		}
		
	}
}
