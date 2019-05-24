package leetcode;

public class S_188_BestTimeBuySellIV_dp {
	public int maxProfit(int k, int[] prices) {
        if(prices.length == 0) return 0;
        if(prices.length/2 <= k){
        	int ret = 0;
        	for(int i = 1; i < prices.length; i++)
        		if(prices[i] > prices[i-1])
        			ret += prices[i] - prices[i-1];
        	return ret;
        }
        int local = 0;
        int[][] dp = new int[k+1][prices.length];
        for(int i = 1; i <= k; i++){
        	local = dp[i-1][0] - prices[0];
        	for(int j = 1; j < prices.length; j++){
        		dp[i][j] = Math.max(dp[i][j-1], local + prices[j]);
        		local = Math.max(local, dp[i-1][j] - prices[j]);
        	}
        }
        return dp[k][prices.length-1];
    }
}
