package leetcode;

public class S_321_CreateMaxiumNumber2 {
    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
    	int n1 = nums1.length, n2 = nums2.length;
    	// 可压缩至一维数组,倒着来
    	int[][] dp1 = new int[n1][k];
    	int[][] dp2 = new int[n2][k];
    	fill(nums1, dp1, k);
    	fill(nums2, dp2, k);
    	// 以下用到dp1 和dp2 最后一行
    	int num1, num2, ret = Math.max(dp1[n1-1][k-1], dp2[n2-1][k-1]);
    	
    	for(int i = 0; i < k-1; i++) {
    		int j = k - i - 2;
    		if(i < n1 && j < n2) {
    			num1 = dp1[n1-1][i];
        		num2 = dp2[n2-1][j];
        		ret = Math.max(ret, merge(num1, num2));
    		}
    	}
    	int[] re = new int[k];
    	for(int i = k-1; i >= 0; i--) {
    		re[i] = ret%10;
    		ret /= 10;
    	}
    	return re;
    }
    
    public int merge(int num1, int num2) {
    	int me = 0;
    	while(num1 > 0 || num2 > 0) {
    		if(num2 == 0 || num1 % 10 < num2 % 10) {
    			me = me * 10 + num1 % 10;
    			num1 /= 10;
    		} else {
    			me = me * 10 + num2 % 10;
    			num2 /= 10;
    		}
    	}
    	int ret = 0;
    	while(me > 0) {
    		ret = ret * 10 + me%10;
    		me /= 10;
    	}
    	return ret;
    }
    
    public void fill(int[] nums, int[][] dp, int k) {
    	for(int i = 0; i < dp.length; i++) {
    		for(int j = 0; j < Math.min(i+1, k); j++) {    			
    			dp[i][j] = Math.max(i>0 ? dp[i-1][j]:0, (j > 0?dp[i-1][j-1]*10 : 0) + nums[i]);
    		}
    	}
    }
    
    public static void main(String[] args) {
		System.out.println(new S_321_CreateMaxiumNumber2().maxNumber(new int[]{6,7}, new int[]{6,0,4}, 5));
	}
}
