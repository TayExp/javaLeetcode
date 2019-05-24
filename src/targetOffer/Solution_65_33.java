package targetOffer;

/* 回溯法 矩阵中的路径
 * 
 */
public class Solution_65_33 {
	public boolean hasPath(char[] matrix, int rows, int cols, char[] str) {
		if (matrix.length == 0 || str.length == 0 || rows < 1 || cols < 1)
			return false;
		for (int i = 0; i < rows; i++)
			for (int j = 0; j < cols; j++)
				if (hasPathCore(matrix, new boolean[matrix.length], rows, cols, i, j, str, new int[] { 0 }))
					return true;
		return false;
	}

	public boolean hasPathCore(char[] matrix, boolean[] visited, int rows, int cols,
			int row, int col, char[] str, int[] pathlength) {
		if(pathlength[0] == str.length)
			return true;
		boolean hasPath = false;
		if (row < rows && row >= 0 && col < cols && col >= 0 && !visited[row * cols + col]
				&& matrix[row * cols + col] == str[pathlength[0]]) {
			pathlength[0]++;
			visited[row * cols + col] = true;
			hasPath = hasPathCore(matrix, visited, rows, cols, row, col - 1, str, pathlength)
					|| hasPathCore(matrix, visited, rows, cols, row - 1, col, str, pathlength)
					|| hasPathCore(matrix, visited, rows, cols, row + 1, col, str, pathlength)
					|| hasPathCore(matrix, visited, rows, cols, row, col + 1, str, pathlength);
			if (!hasPath) {
				pathlength[0]--;
				visited[row * cols + col] = false;
			}
		}
		return hasPath;
	}

	public static void main(String[] args) {
		System.out.println(new Solution_65_33().hasPath("ABCESFCSADEE".toCharArray(), 3, 4, "ABCCED".toCharArray()));
		System.out.println(new Solution_65_33().hasPath("ABCEHJIGSFCSLOPQADEEMNOEADIDEJFMVCEIFGGS".toCharArray(), 5, 8,
				"SGGFIECVAASABCEHJIGQEMS".toCharArray()));
	}
}
