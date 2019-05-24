package codingGuide_DP;

public class DP07_最长公共子序列 {
	public int[][] getdp(char[] str1, char[] str2){
		int[][] dp = new int[str1.length][str2.length];
		dp[0][0] = str1[0] == str2[0] ? 1: 0;
		for(int i = 1; i < str1.length; i++)
			if(dp[i-1][0] == 1 || str1[i] == str2[0]) 
				dp[i][0] = 1;
		for(int j = 1; j < str2.length; j++)
			if(dp[0][j-1] == 1 || str2[j] == str1[0])
				dp[0][j] = 1;
		for(int i = 1; i < str1.length; i++) {
			for(int j = 1; j < str2.length; j++) {
				dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
				if(str1[i] == str2[j])
					dp[i][j] = Math.min(dp[i][j], dp[i-1][j-1]+1);
			}
		}
		return dp;				
	}
	public String longestCommonSequence(String s1, String s2) {
		if(s1 == null || s1.equals("") || s2 == null || s2.equals("")) return "";
		char[] str1 = s1.toCharArray();
		char[] str2 = s2.toCharArray();
		int[][] dp = getdp(str1, str2);
		int m = str1.length - 1, n = str2.length-1;
		char[] res = new char[dp[m][n]];
		int index = res.length-1;
		while(index >= 0) {
			if(m > 0 && dp[m][n] == dp[m-1][n]) {
				m--;
			} else if(n > 0 && dp[m][n] == dp[m][n-1]) {
				n--;
			}else {
				res[index--] = str1[m];
				m--;
				n--;
			}
		}
		return String.valueOf(res);
	}
}
