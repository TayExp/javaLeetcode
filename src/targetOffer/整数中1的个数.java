package targetOffer;

public class 整数中1的个数 {
	public int NumberOf1Between1AndN_Solution(int n) {
		if(n <= 0) return 0;
		if(n <= 9) return 1;
		int ret = 0;
		String str =  String.valueOf(n);
		int len = str.length();
		// 最高位是1
		if(str.charAt(0) == '1') {
			ret += n+1- (int) Math.pow(10, len-1);
		}else {
			ret += (int) Math.pow(10, len-1);
		}
		ret += (str.charAt(0)-'0') * (len-1) * (int) Math.pow(10, len-2);
		// 最高位是0
		ret += NumberOf1Between1AndN_Solution(Integer.parseInt(str.substring(1)));
		return ret;
	}
}
