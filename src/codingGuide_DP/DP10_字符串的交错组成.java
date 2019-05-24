package codingGuide_DP;

public class DP10_字符串的交错组成 {
	public boolean interleave1(String s1, String s2, String s3) {
		if(s1 == null || s2 == null || s3 == null || s1.length()+s2.length()!=s3.length()) return false;
		char[] str1 = s1.toCharArray(), str2 = s2.toCharArray(), str3 = s3.toCharArray();
		boolean[][] dp = new boolean[str1.length+1][str2.length+1];
		dp[0][0] = true;
		for(int i = 1; i <= str1.length; i++) {
			if(str1[i-1] != str3[i-1])
				break;
			dp[i][0] = true;
		}
		for(int j = 1; j <= str2.length; j++) {
			if(str2[j-1] != str3[j-1])
				break;
			dp[0][j] = true;
		}
		for(int i = 1; i <= str1.length; i++) {
			for(int j = 1; j <= str2.length; j++) {
				if(str1[i-1]==str3[i+j-1] && dp[i-1][j] || str2[j-1] == str3[i+j-1] && dp[i][j-1])//i-1 j-1  i+j-1
					dp[i][j] = true;
			}
		}
		return dp[str1.length][str2.length];
		
	}
	
	public boolean interleave2(String s1, String s2, String s3) {
		if(s1 == null || s2 == null || s3 == null || s1.length()+s2.length()!=s3.length()) return false;
		char[] str1 = s1.toCharArray(), str2 = s2.toCharArray(), str3 = s3.toCharArray();
		char[] longs = str1.length >= str2.length ? str1 : str2;
		char[] shorts = str1.length >= str2.length ? str2 : str1;
		boolean[] dp = new boolean[shorts.length+1];
		dp[0] = true;
		for(int i = 1; i <= shorts.length; i++) {
			if(str1[i-1] != str3[i-1])
				break;
			dp[i] = true;
		}
		for(int i = 1; i <= longs.length; i++) {
			dp[0] = dp[0] & longs[i-1] == str3[i-1];//更新行头
			for(int j = 1; j <= shorts.length; j++) {
				if(longs[i-1]==str3[i+j-1] && dp[j] || shorts[j-1] == str3[i+j-1] && dp[j-1])//i-1 j-1  i+j-1
					dp[j] = true;
				else
					dp[j] = false;
			}
		}
		return dp[shorts.length];
		
	}
}
