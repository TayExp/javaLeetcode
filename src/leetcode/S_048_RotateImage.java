package leetcode;
//分清行列坐标
//分清循环起止
public class S_048_RotateImage {
    public void rotate(int[][] matrix) {
    	int n = matrix.length;
    	int circle = (n)/2;
    	for(int i = 0; i < circle; i++){
    		for(int j = 0; i + j < n - i - 1; j++){
    			int temp = matrix[i][i+j];
    			matrix[i][i+j] = matrix[n-i-1 - j][i];
                matrix[n-i-1 - j][i] = matrix[n-i-1][n-i-1 - j];
                matrix[n-i-1][n-i-1 - j] = matrix[i+j][n-i-1];	
                matrix[i+j][n-i-1] = temp;
    		}
    	}
    }
	public static void main(String[] args) {
		new S_048_RotateImage().rotate(new int[][]{{1,2,3},{4,5,6},{7,8,9}});
	}

}
