package leetcode;

public class S_008_StringToInteger {

	public int myAtoi(String str) {
		String s = getNumbers(str.trim());
		if (s.length() == 0)
			return 0;
		int res = 0;
		int i = 1, isMinus = 1;
		if (s.charAt(0) == '-')
			isMinus = -1;
		else if (s.charAt(0) != '+')
			i = 0;
		for (; i < s.length(); i++) {
			int dig = (s.charAt(i) - '0');
			if (isMinus * res > Integer.MAX_VALUE / 10
					|| (isMinus * res == Integer.MAX_VALUE / 10 && isMinus * dig > 7))
				return Integer.MAX_VALUE;
			if (isMinus * res < Integer.MIN_VALUE / 10
					|| (isMinus * res == Integer.MIN_VALUE / 10 && isMinus * dig < -8))
				return Integer.MIN_VALUE;
			res = res * 10 + dig;
		}

		return res * isMinus;
	    }

	public String getNumbers(String str) {
		StringBuilder res = new StringBuilder();
		int i;
		if (str.charAt(0) == '+' || str.charAt(0) == '-') {
			i = 1;
			if (str.length() == 1)
				return "";
			res.append(str.charAt(0));
		}
		else
			i = 0;
		for (; i < str.length(); i++) {
			if (str.charAt(i) < '0' || str.charAt(i) > '9')
				return res.toString();
			res.append(str.charAt(i));
		}
		return res.toString();
	  }
	public static void main(String[] args) {
		// A to i
		System.out.println(new S_008_StringToInteger().myAtoi("     +12  a3aa"));
	}

}
