package leetcode;

public class S_052_NQueens {
	public int  totalNQueens(int n) {
		char[][] board = new char[n][n];
		int[] count = new int[]{0};
		for(int i = 0; i < n; i++)  
			for(int j = 0; j< n; j++)
				board[i][j] = '.'; 
		solve( board,  n, 0, count);
		return count[0];
    }
	
	
	private void solve(char[][] board, int n, int col,int[] count){
		if( col == n){
			count[0]++;
			return;
		}
		for(int row = 0; row < n; row++)
			if(isValid(board, row, col)){
				board[row][col] = 'Q';
				solve(board, n, col+1, count);
				board[row][col] = '.';
			}
	}

	private boolean isValid(char[][] board, int row, int col) {
		for(int j = 0; j < col; j++)
			for( int i = 0;i < board.length;i++)
				if(board[i][j] == 'Q' && (i == row || i-j == row - col||i+j==col+row))
					return false;
		return true;
	}

	public static void main(String[] args){
		System.out.println(new S_052_NQueens().totalNQueens(4));
	}
}
