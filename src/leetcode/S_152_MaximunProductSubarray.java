package leetcode;

public class S_152_MaximunProductSubarray {
    public int maxProduct(int[] nums) {
    	if(nums.length  == 0) return 0;
        if(nums.length == 1) return nums[0];
    	int[] maxNega = new int[nums.length];  	
    	int[] maxPosi = new int[nums.length];
    	if(nums[0] < 0) maxNega[0] = nums[0];
    	else if(nums[0] > 0) maxPosi[0] = nums[0];
    	for(int i = 1; i < nums.length; i++){
    		if(nums[i] > 0){
    			maxNega[i] = (maxNega[i-1] < 0 ? maxNega[i-1]:0)*nums[i];
    			maxPosi[i] = (maxPosi[i-1] > 0 ? maxPosi[i-1]:1)*nums[i];
    		} else if(nums[i] < 0){
    			maxNega[i] = (maxPosi[i-1] > 0 ?maxPosi[i-1]:1) * nums[i];
    			maxPosi[i] = (maxNega[i-1] < 0 ?maxNega[i-1]:0) * nums[i];
    		} 
    	}
    	int maxprod = maxPosi[0];
    	for (int n : maxPosi)
    		maxprod = Math.max(maxprod, n);
    	return maxprod;
    }
    public static void main(String[] args) {
		System.out.println(new S_152_MaximunProductSubarray().maxProduct(new int[]{0,1,2,3,-2,2,3,4,-2,0,4,5,-2,-6}));
	}
}
