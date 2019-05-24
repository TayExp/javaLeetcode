package leetcode;

public class S_312_BurstBalloons {
    public int maxCoins(int[] nums) {
        // get nums[left] * nums[i] * nums[right] coins.
        // After the burst, the left and right then becomes adjacent.
    	int n = nums.length;
    	if(n == 0) return 0;
    	int[][] dp = new int[n][n];
    	for(int len = 1; len <= n; len++) {
    		for(int start = 0; start <= n - len; start++) {
    			int end = start + len - 1;
    			for(int i = start; i <= end; i++) {
//    				int coins = nums[i] * getnum(nums,i-1) * getnum(nums,i+1);
    				int coins = nums[i] * getnum(nums,start-1) * getnum(nums,end+1);
    				coins += i==start?0:dp[start][i-1];
    				coins += i==end?0:dp[i+1][end];
    				dp[start][end]=Math.max(coins, dp[start][end]);
    			}
    		}
    	}
        return dp[0][n-1];
    }
    
    private int getnum(int[] nums, int i) {
    	if(i < 0 || i >= nums.length)
    		return 1;
    	return nums[i];
    }
}
