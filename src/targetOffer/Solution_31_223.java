package targetOffer;

/*：1-n中数字1出现的次数
 * 分部分处理
 */
public class Solution_31_223 {
	public int NumberOf1Between1AndN_Solution(int n) {
		if (n <= 0)
			return 0;
		String strNum = Integer.toString(n);
		int len = strNum.length(), result = 0;
		if (n <= 9)
			return 1;
		// 先计算最高位不为0的数们
		if (strNum.charAt(0) > '1')
			result += (int) Math.pow(10, len - 1);
		else
			result += n - (int) Math.pow(10, len - 1) + 1;
		// 其他数位上1的个数
		result += (strNum.charAt(0) - '0') * (len - 1) * (int) Math.pow(10, len - 2);
		// 再计算最高位位0的数们
		result += NumberOf1Between1AndN_Solution((int) (n % Math.pow(10, len - 1)));
		return result;
	}
}
