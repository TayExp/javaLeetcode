package codingGuide_DP;

public class DP15_跳跃游戏 {
	public int jump(int[] arr) {
		if(arr == null || arr.length == 0) return 0;
		// jump步，最多跳cur,jump+1步最多跳next
		int jump = 0, cur = 0, next = 0;
		for(int i = 0; i  < arr.length; i++) {
			if(cur < i) {
				cur = next;
				jump++;
			}
			next = Math.max(next, i+arr[i]);
		}
		return jump;
	}
    public int jump1(int[] nums) {
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
    
    //gready
    public boolean canJump(int[] nums) {
        int last = nums.length - 1;
        for (int i = last; i>=0; i--){
        	if(nums[i]+i >= last)
        		last = i;
        }
        return last == 0;
    }
}
