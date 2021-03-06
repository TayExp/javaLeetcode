package leetcode;

public class S_032_LongestParenthese {

	public int longestValidParentheses(String s) {
		int left = 0, right = 0, maxLength = 0;
		for (int i = 0; i < s.length(); i++){
			if(s.charAt(i) == '(')  left++;
			else right ++ ;
			if(left == right) maxLength = Math.max(maxLength, 2*left);
			if(left<right){
				left = 0;
				right = 0;
			}	
		}
		left = 0;
		right = 0;
		for (int i = s.length()-1; i >= 0; i--){
			if(s.charAt(i) == '(')  left++;
			else right ++ ;
			if(left == right) maxLength = Math.max(maxLength, 2*left);
			if(left>right){
				left = 0;
				right = 0;
			}	
		}
		return maxLength;		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
