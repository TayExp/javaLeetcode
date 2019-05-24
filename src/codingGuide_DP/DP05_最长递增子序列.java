package codingGuide_DP;

import java.util.Arrays;

public class DP05_最长递增子序列 {
	// 巧妙：O(n^2)
	public int lengthOfLIS(int[] nums) {
		if(nums == null || nums.length == 0) return 0;
		int len = 1;
		int[] dp = new int[nums.length];
		dp[0] = nums[0];
		for(int i = 1; i < nums.length; i++) {
			int j = 0;
			while(j < len) {
				if(nums[i] <= dp[j])
					break;
				j++;
			}
			dp[j] = nums[i];
			if(j == len) 
				len++;
		}
		return len;
	}
	
	// dp[i]表示以arr[i]结尾的最长递增序列长度
	public int[] getdp1(int[] arr) {
		int[] dp = new int[arr.length];
		for(int i = 0; i< arr.length; i++) {
			dp[i] = 1;
			for(int j = 0; j < i; j++) {
				if(arr[i] > arr[j])
					dp[i] = Math.max(dp[i], dp[j]+1); // key
			}
		}
		return dp;
	}
	// 根据dp求具体序列
	public int[] generateLIS(int[] arr, int[] dp){
		int len = 0;
		int index = 0;
		for(int i =0; i < dp.length; i++) {
			if(dp[i] > len) {
				len = dp[i];
				index = i;
			}
		}
		int[] lis = new int[len];
		lis[--len] = arr[index];
		for(int i = index; i >= 0; i--) {
			if(arr[i] < arr[index] && dp[i] == dp[index]-1) { //key
				lis[--len] = arr[i];
				index = i;
			}
		}
		return lis;
	}
	
	// 二分查找O（nlogn)
	public int lengthOfLIS2(int[] nums) {
		int[] dp = new int[nums.length];
		int len = 0;
		for(int num : nums) {
			int i = Arrays.binarySearch(dp, 0, len, num);
			if(i < 0) // (-(insertion point) - 1). 
				i = -(i+1); 
			dp[i] = num;
			if(i == len)
				len++;
		}
		return len;
	}
	// ends[0..right]为有效区，ends[right+1...]为无效区
	public int[] getdp3(int[] arr) {
		int[] dp = new int[arr.length];
		int[] ends = new int[arr.length];
		ends[0] = arr[0];
		dp[0] = 1;
		int right = 0, l = 0, r = 0, m = 0 ;
		for(int i = 1; i < arr.length; i++) {
			l = 0;
			r = right; // Arrays.binarySearch(dp, 0, len, num);
			while(l <= r) {
				m = (l+r) /2 ;
				if(arr[i] > ends[m])
					l = m+1;
				else
					r= m -1;
			}
			right = Math.max(right, l);
			ends[l] = arr[i];
			dp[i] = l+1;
		}
		return dp;
	}
	
	public int[] lis2(int[] arr) {
		if(arr == null || arr.length == 0) return null;
		return generateLIS(arr, getdp3(arr));
	}
}
