package leetcode;

public class S_036_ValidSudoku {

	public boolean isValidSudoku(char[][] board) {
		for(int i = 0; i < 9; i++){
			if(!checkRow(board, i, 9))
				return false;
			if(!checkCol(board, i, 9))
				return false;
			if(i==0 || i==3 || i==6){
				for(int j = 0;j<=6;j+=3)
					if(!checkBox(board, i, j, 3))
						return false;
			}
		}
		return true;
	}
	
	private boolean checkRow(char[][] board, int i, int len){
		int[] hashTable = new int[9];
		for (int j = 0;j < len;j++){
			char ch = board[i][j];
			if(ch != '.') //1<=ch<=9
				if(hashTable[ch-'0'-1] > 0)
					return false;
				else
					hashTable[ch-'0'-1]++;
		}
		return true;
	}
	private boolean checkCol(char[][] board, int i, int len){
		int[] hashTable = new int[9];
		for (int j = 0;j < len;j++){
			char ch = board[j][i];
			if(ch != '.') //1<=ch<=9
				if(hashTable[ch-'0'-1] > 0)
					return false;
				else
					hashTable[ch-'0'-1]++;
		}
		return true;
	}
	private boolean checkBox(char[][] board, int row,int col, int len){
		int[] hashTable = new int[9];
		for (int i = 0;i < len;i++)
			for(int j = 0; j< len; j++){
				char ch = board[row+i][col+j];
				if(ch != '.') //1<=ch<=9
					if(hashTable[ch-'0'-1] > 0)
						return false;
					else
						hashTable[ch-'0'-1]++;
			}
		return true;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
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
		System.out.println(new S_036_ValidSudoku().isValidSudoku(board));
	}

}
