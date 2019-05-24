package leetcode;

import java.util.ArrayList;
import java.util.List;

public class S_051_NQueens {
	public List<List<String>> solveNQueens(int n) {
		List<List<String>> ret = new ArrayList<>();
		char[][] board = new char[n][n];
		for(int i = 0; i < n; i++)  
			for(int j = 0; j< n; j++)
				board[i][j] = '.'; 
		solve(ret, board,  n, 0);
		return ret;
    }
	
	
	private void solve(List<List<String>> ret, char[][] board, int n, int col){
		if( col == n){
			ret.add(toList(board));
			return;
		}
		for(int row = 0; row < n; row++)
			if(isValid(board, row, col)){
				board[row][col] = 'Q';
				solve(ret, board, n, col+1);
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


	private List<String> toList(char[][] board){
		List<String> list = new ArrayList<>();
		for(int i = 0; i < board.length; i++){
			list.add(new String(board[i]));
		}
		return list;
	}
	public static void main(String[] args){
		System.out.println(new S_051_NQueens().solveNQueens(4));
	}
}
