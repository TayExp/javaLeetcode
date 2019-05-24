package leetcode;

public class S_045_JumpGameII {
    //贪婪算法
    public int jump(int[] nums) {
        int steps = 0, last = nums.length - 1;
        while(last > 0){
	        for (int i = 0; i < last; i++){
	        	if(nums[i]+i >= last){
	        		last = i;
	        		steps++;
	        		break;
	        	}
	        }
        }
        return steps;
    }
}
