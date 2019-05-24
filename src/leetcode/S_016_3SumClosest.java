package leetcode;

import java.util.Arrays;

public class S_016_3SumClosest {

	public int threeSumClosest(int[] nums, int target) {
		int result = nums[0]+nums[1]+nums[2];
		Arrays.sort(nums);
		for(int i = 0;i<nums.length-2;i++){
			int lo = i + 1, hi = nums.length - 1;
			while (lo < hi) {
				int sum = nums[i] + nums[lo] + nums[hi];
				if (sum > target)
					hi--;
				if (sum < target)
					lo++;
				if (Math.abs(sum - target) < Math.abs(result - target))
					result = sum;
				if (result == target)
					return result;
				}
			}
		return result;
	}
}
