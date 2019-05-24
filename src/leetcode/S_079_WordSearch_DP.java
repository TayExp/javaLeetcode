package leetcode;

public class S_079_WordSearch_DP {
	 public boolean exist(char[][] board, String word) {
		 if( word.equals("")) return true;
		 if(board.length == 0 || board[0].length == 0) return false;
		 int m = board.length, n = board[0].length;
		 for(int i = 0; i < m; i++)
			 for(int j = 0; j < n; j++)
				 if(backtrack(board, new boolean[m][n], word.toCharArray(), i, j, 0))
					 return true;
		 return false;
	  }

	private boolean backtrack(char[][] board, boolean[][] used, char[] word, int row, int col ,int checkedLen) {
		if(checkedLen == word.length)
			return true;
		boolean result = false;
		if(row >= 0 && row < board.length && col >= 0 && col < board[0].length && 
				!used[row][col] && board[row][col] == word[checkedLen]){
			used[row][col] = true;
			result = backtrack(board, used, word, row+1, col, checkedLen+1) ||
					backtrack(board, used, word, row-1, col, checkedLen+1) ||
					backtrack(board, used, word, row, col+1, checkedLen+1) ||
					backtrack(board, used, word, row, col-1, checkedLen+1);	
			used[row][col] = false;
		}
		return result;
	}
	public static void main(String[] args){
		
		System.out.println(new S_079_WordSearch_DP().exist(new char[][]{{'A','B','C','E'},
			{'S','F','E','S'}, {'A','D','E','E'}},"ABCESEEEFS"));
		System.out.println(new S_079_WordSearch_DP().exist(new char[][]{{'A','B','C','E'},
			{'S','F','C','S'}, {'A','D','E','E'}}, "ABCB"));
	}
}
