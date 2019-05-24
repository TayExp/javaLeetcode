package leetcode;

public class S_006_ZigZagConversion2 {
	public String convert(String s, int numRows) {
		if (numRows == 1)
			return s;
		StringBuilder sb = new StringBuilder();
		int cycleLen = (2 * numRows) - 2;
		int n = s.length();
		for (int i = 0; i < numRows; i++) {
			for (int j = 0; j + i < n; j += cycleLen) {
				sb.append(s.charAt(i+j));
				if(i!=0 && i!=(numRows-1) && (j+cycleLen-i<n))
					sb.append(s.charAt(j + cycleLen - i));
			}
		}
		return sb.toString();
	}

	public static void main(String[] args) {

		System.out.println(new S_006_ZigZagConversion2().convert("ABCD", 3));
		System.out.println(new S_006_ZigZagConversion2().convert("PAYPALISHIRI", 4));
	}
}
