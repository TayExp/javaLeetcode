package leetcode;

import java.util.HashMap;
import java.util.Map;

public class S_001_TwoSum {
	
	public int[] twoSum(int[] nums, int target) {
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i< nums.length; i++){
			int targetNum = target - nums[i];
			if (map.containsKey(targetNum))
				return new int[] {map.get(targetNum), i};
			map.put(nums[i], i);
		}
		throw new IllegalArgumentException("No solution.");
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
