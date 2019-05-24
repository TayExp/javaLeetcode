package leetcode;

public class S_042_TrappedWater2 {
	public int trap(int[] height) {
        int ret = 0, maxLeft = 0, maxRight = 0, size = height.length;
        for(int i = 0; i < size; i++){
        	for(int j = i; j<size; j++)
        		maxRight = Math.max(maxRight, height[j]);
        	for(int j = i; j>=0; j--)
        		maxLeft = Math.max(maxLeft, height[j]);
        	ret += Math.min(maxRight, maxLeft)-height[i];
        }
        return ret;
        	
    }
}
