package codingGuide_DP;

public class DP08_最长公共子串 {

	// 空间复杂度O(m*n)
	// dp[i][j]:以把s1(i)和s2(j)当公共子串最后一个字符的最大长度
	// 斜向下45°即可
	public int[][] getdp(char[] str1, char[] str2){
		int[][] dp = new int[str1.length][str2.length];
		for(int i = 0; i < str1.length; i++)
			dp[i][0] = str1[i] == str2[0] ? 1 : 0;
		for(int j = 0; j < str2.length; j++)
			dp[0][j] = str2[j] == str1[0] ? 1 : 0;
		for(int i = 1; i < str1.length; i++) {
			for(int j = 1; j < str2.length; j++) {
				dp[i][j] = str1[i] == str2[j]? (dp[i-1][j-1]+1) : 0;
			}
		}
		return dp;
	}
	public String longestCommonString1(String s1, String s2) {
		if(s1 == null || s1.length() == 0 || s2 == null || s2.length() == 0) return "";
		char[] str1 = s1.toCharArray();
		char[] str2 = s2.toCharArray();
		int [][] dp = getdp(str1, str2);
		int end = 0, max = 0;
		for(int i = 0; i < str1.length; i++)
			for(int j = 0; j < str2.length; j++)
				if(dp[i][j] > max) {
					end = i;
					max = dp[i][j];
				}
		return s1.substring(end-max+1, end+1);
	}
	
	// 空间复杂度O（1）
	public String longestCommonString2(String s1, String s2) {
		if(s1 == null || s1.length() == 0 || s2 == null || s2.length() == 0) return "";
		char[] str1 = s1.toCharArray();
		char[] str2 = s2.toCharArray();
		int row = 0, col = str2.length-1, max = 0, end = 0;// -45°斜线从上到下画
		while(row < str1.length) {
			int i = row, j = col, len = 0;
			// 向右下遍历
			while(i < str1.length &&j < str2.length) {
				if(str1[i] != str2[j])
					len = 0;
				else
					len++;
				if(len > max) {
					end = i;
					max = len;
				}
			}
			if(col > 0) col--;
			else row++;
		}
		return s1.substring(end-max+1, end+1);
	}
}
