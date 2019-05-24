package leetcode;

public class S_029_Divide {

	public int divide(int a, int b) {
		if (a == Integer.MIN_VALUE && b == Integer.MIN_VALUE)
			return 1;
		else if (b == Integer.MIN_VALUE)
			return 0;
		else if (a == Integer.MIN_VALUE){
			int res = div(add(a,1),b);//增加一点算，之后再处理回来
			return add(res, div(minus(a, multi(res, b)), b));
		}
		else 
			return div(a,b);
	}

	public int div(int a, int b) {
		// 取正
		int x = isNeg(a) ? negNum(a) : a;
		int y = isNeg(b) ? negNum(b) : b;
		int res = 0;
		for (int i = 31; i > -1; i = minus(i, 1)) {
			if ((x >> i) >= y) {// a是否包含b*2^i
				res = res | (1 << i);
				x = minus(x, y << i);
			}
		}
		return isNeg(a) ^ isNeg(b) ? negNum(res) : res;
	}

	int minus(int a, int b) {
		return add(a, negNum(b));
	}

	public boolean isNeg(int n) {
		return (n<0);
	}

	int negNum(int n) {
		return add(~n, 1);
	}

	int add(int a, int b) {
	    	int sum = a;
	    	while(b!=0){
	    		sum = a^b;
	    		b = (a&b)<<1;
	    		a = sum;
	    	}
	    	return sum;
	}

	int multi(int a, int b) {
		int res = 0;
		while (b != 0) {
			if ((b & 1) != 0) {// 该末位为1
				res = add(res, a);
			}
			a <<= 1;// a左移一位，计算到了更高位的b
			b >>= 1; // b右移一位
		}
		return res;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
