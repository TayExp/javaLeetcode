package leetcode;

import java.util.List;

public class S_139_WordBreak {
	public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length()+1];
        dp[0] = true;
        for(int i = 1; i < dp.length; i++){
        	for(String str : wordDict){
        		if(s.substring(0, i).endsWith(str)&&dp[i-str.length()]){
        			dp[i] = true;
        			break;
        		}
        	}
        }
        return dp[s.length()];
    }
}
