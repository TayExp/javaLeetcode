package leetcode;

public class S_343_IntegerBreak {
    public int integerBreak(int n) {
        int[] dp = new int[n+1];
        for(int i = 0; i <= n; i++) dp[i] = i;
        for(int i = 3; i <= n; i++){
            for(int j = 2; j < i; j++){
                dp[i] = Math.max(dp[i], dp[j] * (i-j));
            }
        }
        return n <= 2?1:dp[n];
    }
    
    public static void main(String[] args) {
		System.out.println(new S_343_IntegerBreak().integerBreak(10));
	}
}
