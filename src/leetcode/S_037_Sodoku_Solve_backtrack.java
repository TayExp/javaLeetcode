package leetcode;

public class S_037_Sodoku_Solve_backtrack {
    public void solveSudoku(char[][] board) {
        if(board.length == 0 || board[0].length == 0) return;
    	solveSudokuCore(board);
    }
    
    private boolean solveSudokuCore(char[][] board){
    	for(int i = 0; i< 9;i++){
    		for(int j = 0; j < 9;j++)
    			if(board[i][j] == '.'){
    				for(char c = '1'; c<='9'; c++){//1---9不是0---9
    					if(suitable(board,i,j,c)){
    						board[i][j] = c;
    						if(solveSudokuCore(board))
    							return true;
    						else
    							board[i][j] = '.';
    					}
    				}
    				return false;
    			}
    		}
    	return true;
    }
	private boolean suitable(char[][] board, int i, int j, char c) {
		for(int id = 0; id < 9; id++){
			if(board[id][j]==c) return false;
			if(board[i][id]==c) return false;
			if(board[3*(i/3)+id/3][id%3+3*(j/3)] == c) return false;
		}
		return true;
	}

	public static void main(String[] args) {
		char[][] board = new char[][]{
			{'5','3','.','.','7','.','.','.','.'},
			{'6','.','.','1','9','5','.','.','.'},
			{'.','9','8','.','.','.','.','6','.'},
			{'8','.','.','.','6','.','.','.','3'},
			{'4','.','.','8','.','3','.','.','1'},
			{'7','.','.','.','2','.','.','.','6'},
			{'.','6','.','.','.','.','2','8','.'},		                              
			{'.','.','.','4','1','9','.','.','5'},
			{'.','.','.','.','8','.','.','7','9'} };
		new S_037_Sodoku_Solve_backtrack().solveSudoku(board);

	}

}
