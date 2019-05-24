package targetOffer;

import java.util.ArrayList;

/*
 * 和为S的两个数字
 */
public class Solution_42_226 {
	public ArrayList<Integer> FindNumbersWithSum(int[] array, int sum) {
		int i = 0, j = array.length - 1;
		ArrayList<Integer> list = new ArrayList<>();
		while (i < j) {
			if (array[i] + array[j] == sum) {
				list.add(array[i]);
				list.add(array[j]);
				return list;
			} else if (array[i] + array[j] < sum) {
				i++;
			} else
				j--;
		}
		return list;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
