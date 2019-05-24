package leetcode;

public class S_041_FirstMissingNum {
	public int firstMissingPositive(int[] nums) {
		if(nums.length == 0)
			return 1;
		int n = nums.length;
		for(int i = 0; i < n; i++)
			if(nums[i]<=0 || nums[i] > n)
				nums[i] = n + 1;
		for(int i = 0; i < n; i++){
			int num = Math.abs(nums[i]);//n+1 or- (n+1)
			if(num > n)
				continue;
			num--;
			if(nums[num] > 0)
				nums[num] = - nums[num];
		}
		for(int i = 0; i < n; i++)
			if(nums[i] > 0)
				return i+1;
		return n+1;
    }
	public static void main(String[] args) {
		System.out.println(new S_041_FirstMissingNum().firstMissingPositive(new int[]{3,4,-1,1}));

	}

}
