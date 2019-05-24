package leetcode;

public class S_027_RemoveElement {
	public int removeElement(int[] nums, int val) {
		int len = nums.length;
		int i = 0, j = len - 1;
		while (i < j) {
			while (j >= 0 && nums[j] == val)
				j--;
			while (i < j && nums[i] != val)
				i++;
			if (i < j && nums[i] == val) {
				nums[i] = nums[j];
				nums[j] = val;
			}
		}
		while (j >= 0 && nums[j] == val)
			j--;
		return j + 1;
	}

	public static void main(String[] args) {
		System.out.println(new S_027_RemoveElement().removeElement(new int[] { 0, 4, 4, 0, 4, 4, 4, 0, 2 }, 4));
		System.out.println(new S_027_RemoveElement().removeElement(new int[] {}, 4));

	}
}
