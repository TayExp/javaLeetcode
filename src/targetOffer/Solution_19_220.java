package targetOffer;

import java.util.ArrayList;

/*
 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字
 */
public class Solution_19_220 {
	public ArrayList<Integer> printMatrix(int[][] matrix) {
		ArrayList<Integer> result = new ArrayList<>();
		if (matrix.length == 0)
			return result;
		int rows = matrix.length, cols = matrix[0].length;
		if (cols == 0)
			return result;
		int floors = (Math.min(rows, cols) + 1) / 2;
		int rowStart = 0, rowEnd = rows - 1, colStart = 0, colEnd = cols - 1;
		for (int i = 0; i < floors; i++) {
			for (int j = colStart; j <= colEnd; j++)
				result.add(matrix[rowStart][j]);
			if (++rowStart > rowEnd)
				break;
			for (int j = rowStart; j <= rowEnd; j++)
				result.add(matrix[j][colEnd]);
			if (--colEnd < colStart)
				break;
			for (int j = colEnd; j >= colStart; j--)
				result.add(matrix[rowEnd][j]);
			rowEnd--;
			for (int j = rowEnd; j >= rowStart; j--)
				result.add(matrix[j][colStart]);
			colStart++;
		}
		return result;
	}

	public static void main(String[] args) {
		int[][] matrix = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 }, { 13, 14, 15, 16 } };
		ArrayList<Integer> result = new Solution_19_220().printMatrix(matrix);
		for (Integer i : result)
			System.out.println(i);

	}
}
