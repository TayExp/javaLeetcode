package targetOffer;

import java.util.Arrays;

/*
 * 扑克牌顺子
 * 排序
 * 统计开头的0的个数
 * gap = sum(big-small-1)
 * 注意：一旦有相同的非0的数，则返回false
 */
public class Solution_45_226 {
	public boolean isContinuous(int[] numbers) {
		if (numbers.length == 0)
			return false;
		Arrays.sort(numbers);
		int i = 0, end = numbers.length;
		int zero = 0, gap = 0;
		for (; i < end; i++) {
			if (numbers[i] != 0)
				break;
			zero++;
		}
		int small = i, big = i + 1;
		while (big < end) {
			if (numbers[small] == numbers[big])
				return false;
			gap += numbers[big] - numbers[small] - 1;
			small++;
			big++;
		}
		return zero >= gap;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
