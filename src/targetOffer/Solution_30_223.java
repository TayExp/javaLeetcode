package targetOffer;

/*连续子数组的最大和
 * 
 */
public class Solution_30_223 {
	public int FindGreatestSumOfSubArray(int[] array) {
		if (array.length == 0)
			return 0;
		int sum = 0;
		int max_sum = array[0];
		for (int num : array) {
			sum += num;
			if (sum > max_sum)
				max_sum = sum;
			if (num > sum) {
				sum = num;
				if (sum > max_sum)
					max_sum = sum;
			}
		}
		return max_sum;
	}
}
