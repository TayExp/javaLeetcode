package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class S_078_Subsets {
	public List<List<Integer>> subsets(int[] nums) {
		List<List<Integer>> ret = new ArrayList<>();   
		Arrays.sort(nums);
        backtrack(ret, new ArrayList<Integer>(), nums, 0);
        return ret;
    }

	private void backtrack(List<List<Integer>> ret, ArrayList<Integer> list, int[] nums, int start) {
		ret.add(new ArrayList<Integer>(list));
		for(int i = start; i < nums.length; i++){
			list.add(nums[i]);
			backtrack(ret, list, nums, i + 1);
			list.remove(list.size()-1);
		}
	}
	
}
