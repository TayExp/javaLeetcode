package codingGuide_DP;

public class DP03_换钱的最小货币数 {
	/* 原问题：
	 * arr中所有的值都是正数不重复
	 * 每种值或多次使用
	 * aim，最少货币数
	 */
	
	/* 补充问题：
	 * arr中所有的值都是正数可重复
	 * target，最少货币数
	 */
	
	// 原问题的经典DP O(N*aim)
	//dp[i][j] : 使用arr[:i]组成j的最小张数
	public int minCoins1(int[] arr, int aim) {
		if(arr == null || arr.length == 0 || aim < 0)
			return -1;
		int n = arr.length;
		int max = Integer.MAX_VALUE;
		int[][] dp = new int[n][aim+1];
		for(int i = 1; i <= aim; i++) {
			dp[0][i] = max;
			if(i-arr[0] >= 0 && dp[0][i-arr[0]] != max)
				dp[0][i] = dp[0][i-arr[0]]+1;
		}
		int left = 0;
		for(int i = 1; i < n; i++) {
			for(int j = 1; j <= aim; j++) {
				left = max;
				if(j - arr[i] >= 0 && dp[i][j-arr[i]]!= max)
					left = dp[i][j-arr[i]] + 1;
				dp[i][j] = Math.min(left, dp[i-1][j]);
			}
		}
		return dp[n-1][aim] != max?dp[n-1][aim] : -1;
	}
	
	// 空间压缩方法
	public int minCoins2(int[] arr, int aim) {
		if(arr == null || arr.length == 0 || aim < 0)
			return -1;
		int n = arr.length;
		int max = Integer.MAX_VALUE;
		int[] dp = new int[aim+1];
		for(int i = 1; i <= aim; i++) {
			dp[i] = max;
			if(i-arr[0] >= 0 && dp[i-arr[0]] != max)
				dp[i] = dp[i-arr[0]]+1;
		}
		int left = 0;
		for(int i = 1; i < n; i++) {
			for(int j = 1; j <= aim; j++) {
				left = max;
				if(j - arr[i] >= 0 && dp[j-arr[i]]!= max)
					left = dp[j-arr[i]] + 1;
				dp[j] = Math.min(left, dp[j]);
			}
		}
		return dp[aim] != max?dp[aim] : -1;
	}
	
	// 补充问题：每张货币用一次的经典DP
	public int minCoins3(int[] arr, int aim) {
		if(arr == null || arr.length == 0 || aim < 0)
			return -1;
		int n = arr.length;
		int max = Integer.MAX_VALUE;
		int[][] dp = new int[n][aim+1];
		for(int i = 1; i <= aim; i++) {
			dp[0][i] = max;
		}
		if(arr[0] <= aim)
			dp[0][arr[0]] = 1;
		// 左上角某个位置的值
		int leftup = 0;
		for(int i = 1; i < n; i++) {
			for(int j = 1; j <= aim; j++) {
				leftup = max;
				if(j-arr[i] >= 0 && dp[i-1][j-arr[i]] != max) //与之前的区别 i -> i-1(上次的、未更新的
					leftup= dp[i-1][j-arr[i]] + 1;
				dp[i][j] = Math.min(leftup, dp[i-1][j]);
			}
		}
		return dp[n-1][aim] != max?dp[n-1][aim]:-1;
	}

	public int minCoins4(int[] arr, int aim) {
		if(arr == null || arr.length == 0 || aim < 0)
			return -1;
		int n = arr.length;
		int max = Integer.MAX_VALUE;
		int[] dp = new int[aim+1];
		for(int i = 1; i <= aim; i++) {
			dp[i] = max;
		}
		if(arr[0] <= aim)
			dp[arr[0]] = 1;
		// 左上角某个位置的值
		int leftup = 0;
		for(int i = 1; i < n; i++) {
			for(int j = aim; j > 0; j--) {//与之前的区别 j-- (上次的、未更新的
				leftup = max;
				if(j-arr[i] >= 0 && dp[j-arr[i]] != max) //与之前的区别 i -> i-1
					leftup = dp[j-arr[i]] + 1;
				dp[j] = Math.min(leftup, dp[j]);
			}
		}
		return dp[aim] != max?dp[aim]:-1;
	}
}
