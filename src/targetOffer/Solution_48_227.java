package targetOffer;

/*
 * 两数相加
 * 1.异或 相加不进位
 * 2.与且左移一位  只进位
 */
public class Solution_48_227 {
	public int Add(int num1, int num2) {
		while (num2 != 0) {
			int sum = num1 ^ num2;
			int carry = (num1 & num2) << 1;
			num1 = sum;
			num2 = carry;
		}
		return num1;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new Solution_48_227().Add(34, 25));
	}

}
