package targetOffer;

/*
 * 统计一个数字在“排序”数组中出现的次数。
 * 二分法，找到起始位置和终了位置
 */
public class Solution_37_225 {
	public int GetNumberOfK(int[] array, int k) {
		if (array.length == 0)
			return 0;
		int first = getFirst(array, k, 0, array.length - 1);
		if (first == -1)
			return 0;
		return -first + 1 + getLast(array, k, 0, array.length - 1);
	}

	int getFirst(int[] array, int k, int start, int end) {
		if (start > end)
			return -1;
		int middle = (start + end) / 2;
		if (array[middle] == k) {
			while (middle >= 0 && array[middle] == k)
				middle--;
			return middle + 1;
		} else if (array[middle] < k) {
			return getFirst(array, k, middle + 1, end);
		} else {
			return getFirst(array, k, start, middle - 1);
		}
	}

	int getLast(int[] array, int k, int start, int end) {
		if (start > end)
			return -1;
		int middle = (start + end) / 2;
		if (array[middle] == k) {
			while (middle <= end && array[middle] == k)
				middle++;
			return middle - 1;
		} else if (array[middle] < k) {
			return getLast(array, k, middle + 1, end);
		} else {
			return getLast(array, k, start, middle - 1);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out
				.println(new Solution_37_225().GetNumberOfK(new int[] { 1, 1, 1, 1, 1 }, 1));
	}

}
