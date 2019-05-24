package leetcode;

public class S_221_MaximalSquare {

    public int maximalSquare(char[][] matrix) {   	
    	if(matrix.length == 0 || matrix[0].length == 0) return 0;
    	int m = matrix.length, n = matrix[0].length;
        int[][] board = new int[m][n];
        int maxarea = 0;
        for(int i = 0; i < m; i++ ) 
        	if(matrix[i][0] == '1') {
        		board[i][0] = 1;
        		maxarea = 1;
        	}
        
        for(int i = 0; i < n; i++ ) 
        	if(matrix[0][i] == '1') {
        		board[0][i] = 1;
        		maxarea = 1;
        	}
        for(int i = 1; i < m; i++ ) 
        	for(int j = 1; j < n; j++) 
        		if(matrix[i][j] == '1') {
        			board[i][j] = localmax(matrix,board,i,j); 
        			maxarea = Math.max(maxarea, board[i][j]);
        		}
		return maxarea * maxarea;
    }

	private int localmax(char[][] matrix, int[][] board, int i, int j) {
		int cn = 1;
		for(int k = 1; k <= board[i-1][j-1]; k++) {
			if(matrix[i-k][j] == '0' || matrix[i][j-k] == '0')
				break;
			cn ++;
		}
		return cn;
	}
	public static void main(String[] args) {
		System.out.println(new S_221_MaximalSquare().maximalSquare(new char[][] {{'1','0','1','0','0'},{'1','0','1','1','1'},{'1','1','1','1','1'},{'1','0','0','1','0'}}));
	}
}