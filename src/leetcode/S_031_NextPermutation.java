package leetcode;

public class S_031_NextPermutation {
	public void nextPermutation(int[] nums) {
		int i = nums.length - 1;
		while (i > 0 && nums[i - 1] >= nums[i])
			i--;
		if (i > 0) {
			int j = nums.length - 1;
			while (j >= i && nums[j] <= nums[i - 1])
				j--;
			swap(nums, i - 1, j);
		}
		reverse(nums, i);

	}

	private void swap(int[] nums, int i, int j) {
		int tmp = nums[i];
		nums[i] = nums[j];
		nums[j] = tmp;
	}

	private void reverse(int[] nums, int start) {
		int i = start, j = nums.length - 1;
		while (i < j)
			swap(nums, i++, j--);
	}
	public static void main(String[] args) {
		int[] a = new int[] { 1, 2, 3 };
		new S_031_NextPermutation().nextPermutation(a);
		for (int num : a)
			System.out.println(num);

	}

}
