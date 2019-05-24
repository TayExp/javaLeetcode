package leetcode;

public class S_032_LongestParenthese2 {

	public int longestValidParentheses(String s) {
		int maxLength = 0;
		int [] dp = new int[s.length()];
		for (int i = 1; i< s.length(); i++){
			if(s.charAt(i) == ')'){
				if(s.charAt(i-1) == '(')
					dp[i] = i >= 2?(dp[i-2] + 2):2;
				else if(i-dp[i-1] > 0 && s.charAt(i-1-dp[i-1])=='(')
					dp[i] = dp[i-1] + (i-2 >= dp[i-1] ?(dp[i-2-dp[i-1]] + 2) :2);				maxLength = Math.max(maxLength, dp[i]);
			}
		}
		return maxLength;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
