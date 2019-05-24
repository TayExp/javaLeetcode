package leetcode;

public class S_130_SurroundedRegions {
    public void solve(char[][] board) {
    	if(board.length <= 2 || board[0].length <= 2)
    		return;
    	int m = board.length, n = board[0].length;
    	boolean[][] visited = new boolean[m][n];
    	for(int i = 0; i < m; i ++){
    		dfs(board, i, 0, visited);
    		dfs(board, i, n-1, visited);
    	}
    	for(int j = 1; j < n-1; j++){
    		dfs(board, 0, j, visited);
    		dfs(board, m-1, j, visited);
    	}
    	
    	for(int i = 0; i < m; i++)
    		for(int j = 0; j < n; j++)
    			if(!visited[i][j] && board[i][j]=='O')
    				board[i][j] = 'X';
    }

	private void dfs(char[][] board, int x, int y, boolean[][] visited) {
		if(x<0 || y<0 || x>=board.length || y>= board[0].length || 
				visited[x][y] || board[x][y] == 'X')
			return;
		visited[x][y] = true;
		dfs(board, x, y+1, visited);
		dfs(board, x+1, y, visited);
		dfs(board, x, y-1, visited);
		dfs(board, x, y+1, visited);
		
	}

	
}
