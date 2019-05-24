package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class S_018_4Sum_2 {
	public List<List<Integer>> fourSum(int[] nums, int target) {
		Arrays.sort(nums);
		List<List<Integer>> result = new ArrayList<>();
		int len = nums.length;
		for (int i = 0; i < len; i++) {
			if (i > 0 && nums[i - 1] == nums[i] && !result.isEmpty())
				if (result.get(result.size() - 1).get(0) == nums[i])
					continue;
			for (int j = i + 1; j < len; j++) {
				if (nums[j - 1] == nums[j] && !result.isEmpty())
					if (result.get(result.size() - 1).get(1) == nums[j]
							&& result.get(result.size() - 1).get(0) == nums[i])// 前两个都相等
						continue;
				int p = j+1;
				int q = len-1;
				int sum2 = target- nums[i]-nums[j];
				while(p<q){
					if (nums[p] + nums[q] == sum2)
						if (result.isEmpty() || (!result.isEmpty() && (result.get(result.size() - 1).get(0) != nums[i]
								|| result.get(result.size() - 1).get(1) != nums[j]
								|| result.get(result.size() - 1).get(2) != nums[p]))) {
							List<Integer> list = new ArrayList<>();
							list.add(nums[i]);
							list.add(nums[j]);
							list.add(nums[p]);
							list.add(nums[q]);
							result.add(list);
							p++;
						}
					if (p < q) {
						if (nums[p] + nums[q] > sum2)
							q--;
						else
							p++;
					}
				}
			}
		}
		return result;
	}

	public static void main(String[] args) {
		// System.out.println(new S_018_4Sum_2().fourSum(new int[] { -3, -2, -1,
		// 0, 0, 1, 2, 3 }, 0));
		// System.out.println(new S_018_4Sum_2().fourSum(new int[] { 0, 0, 0, 0
		// }, 0));
		// System.out.println(new S_018_4Sum_2().fourSum(new int[] { -1, -5, -5,
		// -3, 2, 5, 0, 4 }, -7));
		// System.out.println(new S_018_4Sum_2().fourSum(new int[] { 0, 0, 4, -2,
		// -3, -2, -2, -3 }, -1));
		// System.out.println(new S_018_4Sum_2().fourSum(new int[] { -5, -4, -3,
		// -2, -1, 0, 0, 1, 2, 3, 4, 5 }, 0));
		// System.out.println(new S_018_4Sum_2().fourSum(new int[] { 2, 0, 3, 0,
		// 1, 2, 4 }, 7));
		System.out.println(new S_018_4Sum_2().fourSum(new int[] { 0, -1, 0, 1, -2, -5, 3, 5, 0 }, 6));

	}
}
