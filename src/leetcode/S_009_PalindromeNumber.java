package leetcode;

public class S_009_PalindromeNumber {
	public boolean isPalindrome(int x) {
		String sx = new String();
		sx = Integer.toString(x);
		int len = sx.length();
		for (int i = 0; i < len / 2; i++) {
			if (sx.charAt(i) != sx.charAt(len - 1 - i))
				return false;
		}
		return true;
	}
	public static void main(String[] args) {
		System.out.println(new S_009_PalindromeNumber().isPalindrome(121));

	}

}
