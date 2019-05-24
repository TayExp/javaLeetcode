package targetOffer;

/*数组中出现次数超过数组长度一半的数字
 * 二分法logn
 * 利用题目特性，进行抵消：
 * 				辅助 变量times
 * 				if nums[i]==result,times++
 * 				else times--或者times重新从1计数
 */
public class Solution_28_222 {
	public int MoreThanHalfNum_Solution(int[] array) {
		if (array.length == 0)
			return 0;
		int result = array[0], times = 1;
		for (int i = 1; i < array.length; i++) {
			if (array[i] == result)
				times++;
			else {
				if (times > 0)
					times--;
				else {
					times = 1;
					result = array[i];
				}
			}
		}
		times = 0;
		for (int num : array)
			if (num == result)
				times++;
		if (times * 2 > array.length)
			return result;
		else
			return 0;
	}
}
