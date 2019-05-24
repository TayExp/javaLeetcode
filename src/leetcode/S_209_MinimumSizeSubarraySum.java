package leetcode;

public class S_209_MinimumSizeSubarraySum {
    public int minSubArrayLen(int s, int[] nums) {
        if(nums.length == 0) return 0;
    	int len = nums.length, minlen = len+1;
        int left = 0, sum = 0;
        for(int right = 0; minlen > 1 && right < len  ; right++){
        	sum += nums[right];
        	while(sum >= s){
        		minlen = Math.min(minlen, right+1-left);
        		sum -= nums[left++];
        	}
        }
        return minlen == len+1?0:minlen;
    }
}
