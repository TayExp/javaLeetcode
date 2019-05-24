package leetcode;

public class S_055_JumpGame {
    public boolean canJump1(int[] nums) {
        return canJump(nums,nums.length-1);
    }
    
    private boolean canJump(int[] nums, int end){
    	if(end == 0)
    		return true;
    	int i = end - 1;
    	boolean result = false;
    	while(i >= 0){
    		if(end - i <= nums[i])
        		result = canJump(nums, i);
    		if(result)
    			break;
    		i -- ;
    	}
    	return result;
    }
    //贪婪算法
    public boolean canJump2(int[] nums) {
        int last = nums.length - 1;
        for (int i = last; i>=0; i--){
        	if(nums[i]+i >= last)
        		last = i;
        }
        return last == 0;
    }
    //自底而上动态规划
    enum Index {GOOD, BAD, UNKNOWN};
    public boolean canJump(int[] nums) {
    	Index[] memo = new Index[nums.length];
    	for(int i = 0; i<memo.length-1;i++)
    		memo[i] = Index.UNKNOWN;
    	memo[memo.length-1] = Index.GOOD;
    	for(int i = nums.length-2; i>=0; i--){
    		
    	}
        return false;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
