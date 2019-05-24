package leetcode;

public class S_097_InterleavingString {
    public boolean isInterleave(String s1, String s2, String s3) {
        int m = s1.length(), n = s2.length();
        if(m+n != s3.length())  return false;
        boolean[][] dp = new boolean[m+1][n+1];
        dp[0][0] = true;
        for(int i = 1; i <= m; i++){
        	if(s1.charAt(i-1) != s3.charAt(i-1))
        		break;
        	dp[i][0] = true;
        }
        for(int i = 1; i <= n; i++){
        	if(s2.charAt(i-1) != s3.charAt(i-1))
        		break;
        	dp[0][i] = true;
        }
       
        for(int i = 1; i <= m; i++)
            for(int j = 1; j <= n; j++){
                if(dp[i-1][j] && s1.charAt(i-1)==s3.charAt(i+j-1)||
                        dp[i][j-1] && s2.charAt(j-1) == s3.charAt(i+j-1))
                    dp[i][j] = true;
            }
            	
        return dp[m][n];	
    }
    public static void main(String[] args){
    	System.out.println(new S_097_InterleavingString().isInterleave("", "", ""));
    }
}
