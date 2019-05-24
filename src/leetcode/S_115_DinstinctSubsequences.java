package leetcode;

public class S_115_DinstinctSubsequences {
	public int numDistinct(String s, String t) {
        int m = s.length(), n = t.length();
        if(n > m || n == 0 || m==0) return m==0?1:0;
        int[] dp = new int[n];
        dp[0] = (s.charAt(0) == t.charAt(0)?1:0);
        for(int i = 1; i < m; i++)
        	for(int j = n-1; j >= 0; j--)
        		if(t.charAt(j) == s.charAt(i))
        			dp[j] += ( j == 0?1:dp[j-1]);
        	
        return dp[n-1];
    }
}
