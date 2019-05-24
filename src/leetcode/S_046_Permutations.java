package leetcode;

import java.util.ArrayList;
import java.util.List;

public class S_046_Permutations {
	public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ret = new ArrayList<>();
        permuteCore(ret, nums, 0);
        return ret;
    }
	private void permuteCore(List<List<Integer>> ret, int[] nums, int start) {
		if(nums.length == start){
			List<Integer> list = new ArrayList<>();
			for(int n : nums) list.add(n);
			ret.add(list);
		}
		for(int i = start; i < nums.length;  i++){
			if(nums[i] == nums[start] && start!=i)
				continue;
			swap(nums, start, i);
			permuteCore(ret, nums.clone(), start+1);
			//swap(nums, len, i);
		}
	}
	private void swap(int[] nums, int j, int i) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}
	public static void main(String[] args) {
		System.out.println(new S_046_Permutations().permute(new int[]{1,1,2}));
	}
}
