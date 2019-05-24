package leetcode;

public class S_153_154_FindMinimumInRotatedArray {
	 public int findMin(int[] nums) {
    	if (nums.length == 0) return 0;
		int start = 0, end = nums.length - 1, mid = start;
		while(nums[start] >= nums[end]){
			if (end - start == 1)
				return nums[end];
			mid = (start + end)/2;
			if(nums[start] == nums[end] && nums[start] == nums[mid]){
				int ret = nums[start];
				for (int i = start+1; i < end; i ++)
					ret = Math.min(ret, nums[i]);
				return ret;
			}
			if (nums[mid] >= nums[start])
				start = mid;
			else if (nums[mid] <= nums[end])
				end = mid;
		}
		return nums[mid];
	}
}
