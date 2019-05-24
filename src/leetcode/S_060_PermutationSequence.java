package leetcode;

import java.util.ArrayList;

public class S_060_PermutationSequence {
	public String getPermutation(int n, int k) {
		//assume n! >= k > 0 && n > 0
		ArrayList<Integer> nums = new ArrayList<>();
	    for(int i = 1; i <= n; i++)
	        	nums.add(i);
        StringBuilder sb = new StringBuilder();
        int count = 1;
        for(int i = 2; i <= n; i++)
        	count *= i; // n!
        int firstNum, pop;
        while(!nums.isEmpty()){
        	count = count /nums.size();
        	firstNum = k / count;
        	pop = k % count;
        	if(pop == 0 || firstNum == nums.size()){
        		if(pop == 0)
        			sb.append(nums.remove(firstNum-1));
        		for(int i = nums.size()-1; i >=0; i--)
        			sb.append(nums.get(i));
        		break;
        	}
        	sb.append(nums.remove(firstNum));
        	k = pop;
        }	
        return sb.toString();
	}
}
