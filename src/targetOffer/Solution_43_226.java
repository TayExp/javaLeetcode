package targetOffer;

/*
 * 循环左移n                                                
 * 前n序列翻转；后面序列翻转；
 * 整体翻转
 */
public class Solution_43_226 {
	public String LeftRotateString(String str, int n) {
		if (str == "")
			return "";
		n = n % str.length();
		return reverse(reverse(str.substring(0, n)) + reverse(str.substring(n, str.length())));
	}

	public String reverse(String str) {
		StringBuilder sb = new StringBuilder();
		for (int i = str.length() - 1; i >= 0; i--)
			sb.append(str.charAt(i));
		return sb.toString();

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new Solution_43_226().LeftRotateString("", 6));
	}

}
