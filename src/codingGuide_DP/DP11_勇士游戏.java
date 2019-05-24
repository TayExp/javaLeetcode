package codingGuide_DP;

public class DP11_勇士游戏 {

	// 经典dp[i][j]=min{向下的要求，向右的要求}
	// 从右下角开始	
	public int minHP1(int[][] m) {
		if(m == null || m.length == 0 || m[0] == null || m[0].length == 0) return 1;
		int row = m.length, col = m[0].length;
		int[][] dp = new int[row--][col--];
		dp[row][col] = Math.max(1, 1-m[row][col]);
		// 最后一行
		for(int j = col-1; j >= 0; j--)
			dp[row][j] = Math.max(dp[row][j+1]-m[row][j], 1);
		// 往上一行一行地
		for(int i = row-1; i >= 0; i--) {
			dp[i][col] = Math.max(1, dp[i+1][col]-m[i][col]);
			for(int j = col-1; j >= 0; j--)
				dp[i][j] = Math.min(Math.max(1, dp[i+1][j]-m[i][j]), Math.max(1, dp[i][j+1])-m[i][j]);
		}
		return dp[0][0];
	}
	
	// 空间压缩至Omin{M, N}
	public static int minHP2(int[][] m) {
		if(m == null || m.length == 0 || m[0] == null || m[0].length == 0) return 1;
		int more = Math.max(m.length, m[0].length);
		int less = Math.min(m.length, m[0].length);
		boolean rowmore = m.length == more;
		int[] dp = new int[less];
		dp[less-1] = Math.max(1, 1-m[m.length-1][m[0].length-1]);
		int row = 0, col = 0;
		// 最后一行
		for(int j = less-2; j >= 0; j--) {
			row = rowmore ? more-1: j;
			col = rowmore ? j : more-1;
			dp[j] = Math.max(dp[j+1]-m[row][col], 1);
		}
		// 往上一行一行地
		for(int i = more-2; i >= 0; i--) {
			row = rowmore? i : less - 1;
			col = rowmore? less - 1 : i;
			dp[less-1] = Math.max(1, dp[less-1]-m[row][col]);//rowmore:[i][col]
			for(int j = col-1; j >= 0; j--) {
				row = rowmore ? i : j;
				col = rowmore ? j : i;
				dp[j] = Math.min(Math.max(1, dp[j]-m[row][col]), Math.max(1, dp[j+1])-m[row][col]);
				// i+1,j未更新过的dp[j]  i,j+1更新过的dp[j+1]（从后往前已经实现更新）
			}
		}
		return dp[0];
	}
}
