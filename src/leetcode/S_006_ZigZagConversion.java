package leetcode;

public class S_006_ZigZagConversion {
	public String convert(String s, int n) {
		if (n == 1)
			return s;
		int len = s.length();
		int id = len / (2 * n - 2);
		if (len % (2 * n - 2) != 0)
			id++;
		Character[][] zigzag = new Character[n][id * (n - 1)];
		for (int i = 0; i < id; i++) {
			for (int j = 0; j < n; j++)
				if (i * (2 * n - 2) + j < len)
					zigzag[j][i * (n - 1)] = s.charAt(i * (2 * n - 2) + j);
			for(int j=1,k = n-2; k>0;k--,j++)
				if (i * (2 * n - 2) + j + n - 1 < len)
					zigzag[k][i * (n - 1) + j] = s.charAt(i * (2 * n - 2) + j + n - 1);
		}
		StringBuilder str  =new StringBuilder();
		for (int i = 0; i < n;i++)
			for (int j = 0; j < (id * (n - 1)); j++)
				if(zigzag[i][j]!=null)
					str.append(zigzag[i][j]);
		return str.toString();
	}

	public static void main(String[] args) {

		System.out.println(new S_006_ZigZagConversion().convert("ABCD", 3));
		System.out.println(new S_006_ZigZagConversion().convert("PAYPALISHIRI", 4));
	}
}
