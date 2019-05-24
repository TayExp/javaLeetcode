package targetOffer;

/*
 * 圆圈中最后剩下的数
 * 指定一个数m,让编号为0的小朋友开始报数。每次喊到m-1的那个小朋友
 * 不再回到圈中,从他的下一个小朋友开始,继续0...m-1报数
 * 直到剩下最后一个小朋友,
 * “倒看过程”，每次改变m个位置取余
 */
public class Solution_46_227_strongskills {
	public int LastRemaining_Solution(int n, int m) {
		if (n <= 0 || m <= 0)
			return -1;
		int last = 0; // 还有1个人时，第0个
		for (int i = 2; i <= n; i++)
			last = (last + m) % i;// i个人，第几个？
		return last;
	}

}
