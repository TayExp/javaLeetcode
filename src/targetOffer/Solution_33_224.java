package targetOffer;

/*
 * 从小到大的第N个丑数，1算第一个
 * 只包含质因子2,3,5
 * 尽量减少不必要的计算：
 * 在已有丑数中乘2,3,5选择结果中最小的那个作为下个丑数
 */
public class Solution_33_224 {
	public int GetUglyNumber_Solution(int index) {
		if (index == 0)
			return 0;
		int[] uglyNums = new int[index];
		uglyNums[0] = 1;
		int cur_index = 1, cur_id1 = 0, cur_id2 = 0, cur_id3 = 0, cur_id5 = 0;
		while (cur_index < index) {
			uglyNums[cur_index] = Math.min(Math.min(uglyNums[cur_id2] * 2, uglyNums[cur_id3] * 3),
					uglyNums[cur_id5] * 5);
			while (uglyNums[cur_id2] * 2 <= uglyNums[cur_index])
				cur_id2++;
			while (uglyNums[cur_id3] * 3 <= uglyNums[cur_index])
				cur_id3++;
			while (uglyNums[cur_id5] * 5 <= uglyNums[cur_index])
				cur_id5++;
			cur_index++;
		}
		return uglyNums[index - 1];
	}
}
