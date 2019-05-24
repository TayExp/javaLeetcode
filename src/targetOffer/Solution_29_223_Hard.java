package targetOffer;

/*
 * 最小的K个数
 * 分割成两部分
 */
import java.util.ArrayList;
import java.util.Collections;
public class Solution_29_223_Hard {
	public ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {
		ArrayList<Integer> result = new ArrayList<>();
		int len = input.length;
		if (len == 0 || len < k || k == 0)
			return result;
		if (len > k) {
			int start = 0, end = len - 1, index;
			do {
				index = Partition(input, start, end);
				if (index > k) {
					end = index - 1;
				} else {
					start = index;
				}
			} while (index - 1 != k && index != k);
		}
		for (int i = 0; i < k; i++)
			result.add(input[i]);
		Collections.sort(result);
		return result;
	}

	public int Partition(int[] numbers, int start, int end) {
		int i = start + 1, j = end, devide = numbers[start];
		while (i < j) {
			while (i < j && numbers[i] <= devide)
				i++;
			while (i < j && numbers[j] >= devide)
				j--;
			if (i < j) {
				swap(numbers, i, j);
			}
		}
		if (j == 0 || numbers[j] <= devide) {
			swap(numbers, start, j);
			return j + 1;
		} else {
			swap(numbers, start, j - 1);
			return j;
		}
	}

	public void swap(int[] numbers, int i, int j) {
		int tmp = numbers[i];
		numbers[i] = numbers[j];
		numbers[j] = tmp;
	}

	public static void main(String[] args) {
		System.out.println(new Solution_29_223_Hard().GetLeastNumbers_Solution(new int[] { 4, 5, 1, 6, 2, 7, 3, 8 }, 4));
	}
}
