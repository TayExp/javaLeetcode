package 数学应用题;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* 1 2 4 8 16 32 64 128 8 = 263
每一列只有一个方格被涂黑
每一行八个涂黑
*/

public class SquaresOnCylinder {
	private int COUNT = 0;
	private final int white = 0;
	private final int black = 1;
	
	public List<List<String>> solveNQueens(int n) {
		List<List<String>> ret = new ArrayList<>();
		int[][] board = new int[n][n];
		for(int i = 0; i < n; i++)  
			for(int j = 0; j< n; j++)
				board[i][j] = white; 
		
		List<Set<Integer>> setlists = new ArrayList<>();
		for(int i = 0; i < 263; i++) {
			setlists.add(new HashSet<Integer>());
		}
		
		solve(ret, board, setlists, n, 0, -1);
		return ret;
    }
	
	//n = 263
	private void solve(List<List<String>> ret, int[][] board, List<Set<Integer>> setlists, int n, int col, int lastrow){
		Set<Integer> set = setlists.get(col);
		// set表示间隔，size为1 时,内部有唯一元素0
		if( col == n && set.size() == 8){ 
			ret.add(toList(board));
			System.out.println(toList(board));
			System.out.println(++COUNT);
			return;
		}
		int row = lastrow;
		while(row < n) {
			int interval = 0;
			if(row + 1 < n && set.size() == 0) {
				row++;
				set.add(0);
			}else {
				for(interval = 1; row + interval + 1 < n && interval <= 128; interval *= 2) {
					if(!set.contains(interval)) {
						row = row + interval + 1;
						set.add(interval);
						break;
					}
				}
			}
			if(isValid(board, row, col)){
				board[row][col] = black;
				if(set.size() == 8) {
					solve(ret, board, setlists, n, col+1, -1);
				}else {
					solve(ret, board, setlists, n, col, row); //lastrow = row;
				}
				board[row][col] = white;
				set.remove(interval);
			}	
		}
			
	}

	private boolean isValid(int[][] board, int row, int col) {
		for(int j = 0; j < col; j++)
			for( int i = 0;i < board.length;i++)
				if(board[i][j] == black && i == row)
					return false;
		return true;
	}


	private List<String> toList(int[][] board){
		List<String> list = new ArrayList<>();
		for(int i = 0; i < board.length; i++){
			StringBuilder sb = new StringBuilder();
			for(int j = 0; j < board.length; j++)
				sb.append(board[i][j]);
			list.add(sb.toString());
		}
		return list;
	}
	public static void main(String[] args) {
		System.out.println(new SquaresOnCylinder().solveNQueens(8));
	}

}
