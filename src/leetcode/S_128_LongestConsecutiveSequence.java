package leetcode;

import java.util.Arrays;

public class S_128_LongestConsecutiveSequence {
	public int longestConsecutive(int[] nums) {
       Arrays.sort(nums);
       int ret = nums.length == 0?0:1, cur = 1;
       for(int i = 1; i < nums.length; i++){
    	   if(nums[i]-nums[i-1] == 0)
    		   continue;
    	   if(nums[i]-nums[i-1] == 1){
    		   cur++;
    		   ret = Math.max(cur, ret);
    	   }else{
    		   cur = 1;
    	   }
       }
       return ret;
    }
}
