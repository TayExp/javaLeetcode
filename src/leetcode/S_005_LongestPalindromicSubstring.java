package leetcode;

//最长回文
public class S_005_LongestPalindromicSubstring {

	public String longestPalindrome(String s) {

		int oriLength = s.length();
		if (oriLength == 0)
			return "";
		int maxLength = 1;
		String res = s.substring(0, 1);
		for (int i = 0; i < oriLength; i++) {
			for (int j = 1; (i - j >= 0) && (i + j < oriLength); j++) {
				if (s.charAt(i - j) == s.charAt(i + j)){
					if (2 * j + 1 > maxLength) {
						maxLength = 2 * j + 1;
						res = s.substring(i - j, i + j + 1);
					}
				} else
					break;
			}
		}
		for (int i = 0; i < oriLength - 1; i++) {
			for (int j = 1; (i - j + 1 >= 0) && (i + j < oriLength); j++) {
				if (s.charAt(i - j + 1) == s.charAt(i + j)) {
					if (2 * j > maxLength) {
						maxLength = 2 * j;
						res = s.substring(i - j + 1, i + j + 1);
					}
				} else
					break;
			}
		}
		return res;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new S_005_LongestPalindromicSubstring().longestPalindrome("babad"));
		System.out.println(new S_005_LongestPalindromicSubstring().longestPalindrome("cbbd"));
		System.out.println(new S_005_LongestPalindromicSubstring().longestPalindrome("aaaa"));
		System.out.println(new S_005_LongestPalindromicSubstring().longestPalindrome("ccc"));
	}

}
