package leetcode;

public class S_029_Divide2 {

	public int divide(int a, int b) {
		if (a == Integer.MIN_VALUE && b == Integer.MIN_VALUE)
			return 1;
		else if (b == Integer.MIN_VALUE)
			return 0;
		else if (a == Integer.MIN_VALUE) {
			long res = div(a + 1, b);
			res = res + div((int) (a - multi((int) res, b)), b);
			return (int) (res > Integer.MAX_VALUE ? Integer.MAX_VALUE
					: (res < Integer.MIN_VALUE ? Integer.MIN_VALUE : res));
		} else
			return div(a, b);
	}

	int multi(int a, int b) {
		int res = 0;
		while (b != 0) {
			if ((b & 1) != 0) {// 该末位为1
				res = res + a;
			}
			a <<= 1;// a左移一位，计算到了更高位的b
			b >>>= 1; // b右移一位
		}
		return res;
	}
	public int div(int a, int b) {
		int x = Math.abs(a);
		int y = Math.abs(b);
		int res = 0;
		for (int i = 31; i > -1; i--) {
			if ((x >> i) >= y) {// a是否包含b*2^i
				res = res | (1 << i);
				x = x - (y << i);
			}
		}
		return (a < 0) ^ (b < 0) ? (-res) : res;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new S_029_Divide2().divide(Integer.MIN_VALUE, -1));
		System.out.println(new S_029_Divide2().divide(10, -3));
	}

}
