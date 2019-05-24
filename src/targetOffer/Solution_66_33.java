package targetOffer;

/* 回溯法：机器人的运动范围
 * 
 */
public class Solution_66_33 {
	public int movingCount(int threshold, int rows, int cols) {
		return movingCountCore(threshold, rows, cols, new int[rows * cols], 0, 0);
	}

	private int movingCountCore(int threshold, int rows, int cols, int[] visited, int row, int col) {
		int count = 0;
		if (check(row, col, threshold, rows, cols, visited)) {
			visited[row * cols + col] = 1;
			count = 1 + movingCountCore(threshold, rows, cols, visited, row + 1, col)
					+ movingCountCore(threshold, rows, cols, visited, row - 1, col)
					+ movingCountCore(threshold, rows, cols, visited, row, col + 1)
					+ movingCountCore(threshold, rows, cols, visited, row, col - 1);
		}
		return count;
	}

	private boolean check(int a, int b, int threshold, int rows, int cols, int[] visited) {
		return a >= 0 && a < rows && b >= 0 && b < cols && visited[a * cols + b] == 0
				&& (digitSum(a) + digitSum(b)) <= threshold;
	}
	private int digitSum(int num) {
		int sum = 0;
		while (num != 0) {
			sum += num % 10;
			num /= 10;
		}
		return sum;
	}
}
