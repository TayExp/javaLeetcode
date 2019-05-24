package targetOffer;

/*
 * 求1-n的和
 
 * ++ -- + - << >> ^ < > && || & | =
 * 解法1：利用短路特性 &&
 * 解法2：利用短路特性||
 * 解法3：用除0异常退出递归
 */
public class Solution_47_227 {
	public int Sum_Solution(int n) {
		int sum = n;
		boolean flag = (n > 0) && ((sum += Sum_Solution(n - 1)) > 0);
		return sum;
	}
}
