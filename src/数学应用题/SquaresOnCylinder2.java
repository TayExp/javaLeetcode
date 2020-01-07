package 数学应用题;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* 1 2 4 8 16 32 64 128 8 = 263
每一列只有一个方格被涂黑
每一行八个涂黑
*/

public class SquaresOnCylinder2 {
	
	private final int white = -1;
	private Set<Integer> boardflatted = new HashSet<>();
	private void printboard(int[][] board,int n, int k) {
		for(int j = 0; j < n; j++) {
			for(int i = 0; i < k; i++) 
				System.out.print(board[j][i] + "\t");
			System.out.println();
		}
		System.out.println(n+1);
		System.out.println("——————————————————————————————————————————————————————————");
	}
	
	public int[][] solveNQueens(int len, int n) {
		//len=263 n = 8
		// board 桉顺序保存每一行黑色格的索引
		int[][] board = new int[len][n]; //存放index
		// 提高时间效率，保存每一行已经存在的间隔，同时其大小等于已填好的数个数
		// 还可以定义一个哈希set,存board中所有的值，isvalid函数直接换成contains()
		List<Set<Integer>> intervals = new ArrayList<>();
		intervals.add(new HashSet<Integer>());
		for(int i = 0; i < len; i++)  
			for(int j = 0; j < n; j++)
				board[i][j] = white; 
		solve(board, intervals, n, 0);
		return board;
    }
	
	private void solve(int[][] board, List<Set<Integer>> intervals, int n, int row){
		
		Set<Integer> set = intervals.get(row);
		// set表示间隔，size为1 时,内部有唯一元素0
		if(set.isEmpty()) {
			for(int col = 0; col <= 128; col++) {
				if(isValid(board, row, col)) {
					set.add(0);
					board[row][0] = col;
					solve(board, intervals, n, row);
					board[row][0] = white;
					set.remove(0);
				}
			}
			
		} else {
			for(int i = 1; i <= 128; i *= 2) {
				if(set.contains(i)) {
					continue;
				}
				int col = board[row][set.size()-1] + 1 + i;
				if(col > 262) return;
				if(!boardflatted.contains(col)){
					board[row][set.size()] = col;
					boardflatted.add(col);
					set.add(i);
					if(set.size() == 8) {
						printboard(board, row+1, n);
						intervals.add(new HashSet<Integer>());
						solve(board, intervals, n, row+1);
					}else {
						solve(board, intervals, n, row); 
					}
					set.remove(i);
					boardflatted.remove(board[row][set.size()] );
					board[row][set.size()] = white;
					
					
				}	
			}
		}
	}

	private boolean isValid(int[][] board, int row, int col) {
		for(int j = 0; j < row; j++)
			for( int i = 0;i < board[0].length;i++)
				if(col == board[j][i])
					return false;
		return true;
	}

	public static void main(String[] args) {
		System.out.println(new SquaresOnCylinder2().solveNQueens(263,8));
	}

}
