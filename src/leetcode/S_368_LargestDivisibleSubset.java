package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class S_368_LargestDivisibleSubset {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);
    	int maxlen = 1, maxid = 0, n = nums.length;
        List<Integer> ret = new ArrayList<>();
        if(n == 0) return ret;
        int[] dp = new int[n];
        int[] id = new int[n];
        for(int i = 0; i < n; i++) {
        	dp[i] = 1;
        	id[i] = i;
        	for(int j = i-1; j >= 0; j--) {
        		if(nums[i] % nums[j] == 0) {
        			if(dp[j] + 1 > dp[i]) {
        				dp[i] = dp[j] + 1;
        				id[i] = j;
        			}
        		}
        	}
        	if(maxlen < dp[i]) {
        		maxlen = dp[i];
        		maxid = i;
        	}
        }
        ret.add(nums[maxid]);
        while(id[maxid] != maxid) {
        	maxid = id[maxid];
        	ret.add(nums[maxid]);
        	
        }
        return ret;
    }
    public static void main(String[] args) {
		System.out.println(new S_368_LargestDivisibleSubset().largestDivisibleSubset(new int[] {1,2,3,4,5,6,7,8,9,10,11,12,24}));
	}
}
