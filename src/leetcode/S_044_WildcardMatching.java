package leetcode;

public class S_044_WildcardMatching {
	
    public boolean isMatch(String s, String p) {
        if(s==null || p == null)
            return s==p;
        boolean[][] dp = new boolean[s.length()+1][p.length()+1]; //动态规划，矩阵
        dp[0][0]=true;
        for(int row=0, col=1; col<dp[0].length;col++){
            if(p.charAt(col-1) == '*')
                dp[row][col]=true;
            else
                break;
         // 找第一个非 * ，前面的均设为true
        }
        // 填充矩阵
        for(int row=1; row<dp.length;row++){
            for(int col=1;col<dp[0].length;col++){
                char str = s.charAt(row-1);
                char pattn = p.charAt(col-1);
                if(str == pattn || pattn == '?'){ // ?的递推
                    dp[row][col] = dp[row-1][col-1];
                } else if(pattn == '*'){//*的递推
                    dp[row][col] = dp[row][col-1] || dp[row-1][col];
                }
            }
        }
        
        return dp[s.length()][p.length()];
        
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new S_044_WildcardMatching().isMatch("acdcb", "a*c?b"));
		System.out.println(new S_044_WildcardMatching().isMatch("", "?"));
		System.out.println(new S_044_WildcardMatching().isMatch("aaaa", "***a"));
		System.out.println(new S_044_WildcardMatching().isMatch("aaaa", "****"));
		System.out.println(new S_044_WildcardMatching().isMatch("mississippi","m??*ss*?i*pi"));
		
	}

}
