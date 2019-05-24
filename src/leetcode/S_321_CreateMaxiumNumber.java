package leetcode;

public class S_321_CreateMaxiumNumber {
    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
    	int n1 = nums1.length, n2 = nums2.length;
    	int[] ans = new int[k];
    	for(int i = Math.max(0, k-n1); i <= k && i <= n2; i++) {
    		int[] candidate = merge(maxArray(nums1,k-i), maxArray(nums2,i),k);
    		if(greater(candidate,0,ans,0)) ans = candidate;
    	}
    	return ans;
    }
    
    private int[] merge(int[] nums1, int[] nums2, int k) {
    	int[] ans = new int[k];
    	for(int i = 0,j = 0, r = 0; r < k; r++) 
    		ans[r] = greater(nums1,i,nums2,j) ? nums1[i++] : nums2[j++];
    	return ans;
    }
    public boolean greater(int[] nums1, int i, int[] nums2, int j) {
    	while(i < nums1.length && j < nums2.length && nums1[i] == nums2[j]) {
    		i++;
    		j++;
    	}
    	return j == nums2.length || (i<nums1.length && nums1[i]>nums2[j]);
    }
    public int[] maxArray(int[] nums, int k) {
    	int n = nums.length;
    	int[] dp = new int[k];
    	for(int i = 0, j = 0; i < n; i++) {
    		// 后面的数够用并且更大
    		while(n - i > k - j && j > 0 && nums[i] > dp[j-1]) 
    			j--;
    		if(j < k) dp[j++] = nums[i];
    	}
    	return dp;
    }
    
    public static void main(String[] args) {
		System.out.println(new S_321_CreateMaxiumNumber().maxNumber(new int[]{6,7}, new int[]{6,0,4}, 5));
	}
}
