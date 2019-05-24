package targetOffer;

public class Solution_44_226 {
	public String ReverseSentence(String str) {
		StringBuilder sb = new StringBuilder();
		int flag = str.length();
		for (int i = str.length() - 1; i >= 0; i--)
			if (str.charAt(i) == ' ') {
				sb.append(str.substring(i + 1, flag));
				flag = i;
				sb.append(" ");
			}
		sb.append(str.substring(0, flag));
		return sb.toString();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("student. a am I".length());
		System.out.println(new Solution_44_226().ReverseSentence(""));
	}

}
