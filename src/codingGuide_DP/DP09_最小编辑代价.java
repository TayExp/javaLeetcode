package codingGuide_DP;

public class DP09_最小编辑代价 {
	public int minCost1(String s1, String s2, int ic, int dc, int rc) {
		if(s1 == null || s2 == null) return 0;
		char[] str1 = s1.toCharArray();
		char[] str2 = s2.toCharArray();
		int m = str1.length + 1, n = str2.length + 1;
		int [][] dp = new int[m][n];
		for(int i = 1; i < m; i++) 
			dp[i][0] = dc * i;
		for(int j = 1; j < n; j++)
			dp[0][j] = ic * j;
		for(int i = 1; i < str1.length; i++)
			for(int j = 1; j < str2.length; j++) {
				if(str1[i] == str2[j])
					dp[i][j] = dp[i-1][j-1];
				else
					dp[i][j] = dp[i-1][j-1] + rc;
				dp[i][j] = Math.min(dp[i][j], dp[i-1][j]+dc);
				dp[i][j] = Math.min(dp[i][j], dp[i][j-1]+ic);
			}
		return dp[m-1][n-1];
	}
	// s2 作为列
	
	
	// 短的作为列: 长的往短的上面变
	public int minCost2(String s1, String s2, int ic, int dc, int rc) {
		if(s1 == null || s2 == null) return 0;
		char[] str1 = s1.toCharArray(), str2 = s2.toCharArray();
		char[] longs = str1.length >= str2.length ? str1 : str2;
		char[] shorts = str1.length >= str2.length ? str2 : str1;
		if(str1.length < str2.length) {
			int tmp = ic;
			ic = dc;
			dc = tmp;
		}
		int[] dp = new int[shorts.length+1];
		for(int i = 1; i < shorts.length; i++)
			dp[i] = ic * i;
		for(int i = 1; i <= longs.length; i++) {
			int pre = dp[0]; //dp[i-1][0]
			dp[0] = dc * i;   //dp[i][0]
			for(int j = 1; j <= shorts.length; j++) {
				int tmp = dp[j]; //dp[i-1][j]
				if(longs[i-1] == shorts[j-1])
					dp[j] = pre; //dp[i][j] = dp[i-1][j-1]
				else
					dp[j] = pre + rc;
				dp[j] = Math.min(dp[j], dp[j-1]+ic); //dp[i][j], dp[i][j-1]+ic
				dp[j] = Math.min(dp[j], tmp+dc); //dp[i][j], dp[i-1][j]+dc
				pre = tmp; //dp[i-1][j]
			}
		}
		return dp[shorts.length];
	}
}
