package codingGuide_DP;
/* 换钱的方法数
 * arr中数都是正数且不重复
 * 可以使用任意次
 * aim, 求换钱方法数
 */

// 体现暴力递归、记忆搜索、动态规划之间的关系
// 动态规划优化
public class DP04_换钱的方法数 {

	// 暴力递归,最差O（aim^N)
	public int coins(int[] arr, int aim) {
		if(arr == null || arr.length == 0 || aim < 0) return 0;
		return process1(arr, 0 ,aim);
	}
	private int process1(int[] arr, int index, int aim) {
		int res = 0;
		if(index == arr.length)
			res = aim == 0 ? 1:0;
		else {
			for(int i = 0; arr[index] * i <= aim; i++)
				res += process1(arr, index+1, aim - arr[index]*i);
		}
		return res;
	}
	
	// 记忆搜索 ：Map二维表，O(N*aim^2)
	// 分析递归函数的状态可以由哪些变量表示，做出相应维度和大小的map
	public int coins2(int[] arr, int aim) {
		if(arr == null || arr.length == 0 || aim < 0) return 0;
		int[][] map = new int[arr.length+1][aim+1]; 
		return process2(arr, 0 ,aim, map);
	}
	private int process2(int[] arr, int index, int aim, int[][] map) {
		int res = 0;
		if(index == arr.length)
			return aim == 0? 1:0;
		else {
			int mapValue = 0;
			for(int i = 0; arr[index] * i <= aim; i++) {
				mapValue = map[index+1][aim-arr[index]*i];
				if(mapValue != 0) {
					res += mapValue == -1? 0:mapValue;
				}else {
					res += process2(arr, index+1, aim-arr[index] * i, map);
				}
			}
		}
		map[index][aim] = res == 0? -1 :res;
		return res;
	}
	
	// 动态规划 ：dp[N][aim+1]，O(N*aim^2)
	// 本质上与记忆搜索方法等价, 后者单纯地对计算过的递归过程进行记录、不关注路径
	// 而下动态规划规定了计算顺序
	public int coins3(int[] arr, int aim) {
		if(arr == null || arr.length == 0 || aim < 0) return 0;
		int[][] dp = new int[arr.length][aim+1];
		for(int i = 0; i < arr.length; i++)
			dp[i][0] = 1;
		for(int j = 1; arr[0] * j <= aim; j++)
			dp[0][arr[0]*j] = 1;
		int num = 0;
		for(int i = 1; i < arr.length; i++) {
			for(int j = 1; j <= aim; j++) {
				num = 0;
				for(int k = 0; j - arr[i]*k >= 0; k++) {
					num += dp[i-1][j-arr[i]*k];
				}
				dp[i][j] = num;
			}
		}
		return dp[arr.length-1][aim];
	}
	
	// 动态规划 ：时间压缩 ，O(N*aim)
	public int coins4(int[] arr, int aim) {
		if(arr == null || arr.length == 0 || aim < 0) return 0;
		int[][] dp = new int[arr.length][aim+1];
		for(int i = 0; i < arr.length; i++)
			dp[i][0] = 1;
		for(int j = 1; arr[0] * j <= aim; j++)
			dp[0][arr[0]*j] = 1;
		for(int i = 1; i < arr.length; i++) {
			for(int j = 1; j <= aim; j++) {
				dp[i][j] = dp[i-1][j];
				dp[i][j] += j-arr[i] >= 0 ? dp[i][j-arr[i]]:0;
			}
		}
		return dp[arr.length-1][aim];
	}
	
	// 动态规划 ：空间也压缩
	public int coins5(int[] arr, int aim) {
		if(arr == null || arr.length == 0 || aim < 0) return 0;
		int[] dp = new int[aim+1];
		for(int j = 1; arr[0] * j <= aim; j++)
			dp[arr[0]*j] = 1;
		for(int i = 1; i < arr.length; i++) {
			for(int j = 1; j <= aim; j++) {
				dp[j] += j-arr[i] >= 0 ? dp[j-arr[i]]:0;
			}
		}
		return dp[aim];
	}
}
