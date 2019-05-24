package targetOffer;

/* 表示数值的字符串
 * e后面必须有有且必须得是整数，e/E，前面+/- 几点几
 */
public class Solution_53_228 {
	public boolean isNumeric(char[] str) {
		if (str.length == 0)
			return false;
		int p = 0, end = str.length;
		if (str[p] == '+' || str[p] == '-')
			p++;
		while (p < end && str[p] >= '0' && str[p] <= '9')
			p++;
		if (p == end)
			return true;
		if (str[p] != '.' && str[p] != 'e' && str[p] != 'E')
			return false;
		if (str[p] == '.') {
			p++;
			while (p < end && str[p] >= '0' && str[p] <= '9')
				p++;
			if (p == end)
				return true;
		}
		if (str[p] == 'e' || str[p] == 'E') {
			p++;
			if (p < end && (str[p] == '+' || str[p] == '-'))
				p++;
			if (p == end)
				return false;
		}
		while (p < end)
			if (str[p] < '0' || str[p] > '9')
				return false;
			else
				p++;
		return true;
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new Solution_53_228().isNumeric("1.79769313486232E+308".toCharArray()));
	}
}
