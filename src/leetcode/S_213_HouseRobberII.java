package leetcode;

public class S_213_HouseRobberII {
	public int rob(int[] nums) {
        if(nums.length == 0) return 0;
        if(nums.length == 1) return nums[0];
        int ret = 0, addable = 0, unaddable = nums[1];
        for(int i = 2; i < nums.length; i++){
            int tmp = addable;
            addable = Math.max(unaddable, addable);
            unaddable = tmp + nums[i];
        }
        ret = Math.max(addable,unaddable);
        addable = 0;
        unaddable = nums[0];
        for(int i = 1; i < nums.length-1; i++){
            int tmp = addable;
            addable = Math.max(unaddable, addable);
            unaddable = tmp + nums[i];
        }
        ret = Math.max(ret, Math.max(addable,unaddable));
        
        return ret;
    }
	public static void main(String[] args) {
		System.out.println(new S_213_HouseRobberII().rob(new int[] {1,2,1,1}));

	}

}
