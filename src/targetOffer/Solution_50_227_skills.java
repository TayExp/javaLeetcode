package targetOffer;

/* 长度为n的数组里的所有数字都在0到n-1的范围
 * 找出数组中任意一个重复的数字
 * 方法：如果没有找到，则交换nums[i] 和nums[nums[i]],即:使所位对应所数
 * 找到的标志：交换之前就 成立nums[i]==nums[nums[i]]，并且i !=nums[i]
 */
public class Solution_50_227_skills {
	public boolean duplicate(int numbers[], int length, int[] duplication) {
		if (length == 0) {
			duplication[0] = -1;
			return false;
		}
		duplication[0] = -1;
		for (int i = 0; i < length; i++) {
			if (numbers[i] == numbers[numbers[i]] && i != numbers[i]) {
				duplication[0] = numbers[i];
				return true;
			}
			int tmp = numbers[i];
			numbers[i] = numbers[tmp];
			numbers[tmp] = tmp;
		}
		return false;
	}
}
