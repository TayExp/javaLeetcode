package leetcode;

import java.util.ArrayList;
import java.util.List;

public class S_229_MajorityElementII {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> ret = new ArrayList<>();
        if(nums.length == 0) return ret;
        int count1 = 0, count2 = 0, candidate1 = 0, candidate2 = 0;
        for(int n : nums) {
        	if(n == candidate1) count1++;
        	else if(n == candidate2) count2++;
        	else if(count1 == 0) {
        		count1 = 1;
        		candidate1 = n;
        	}else if(count2 == 0) {
        		count2 = 1;
        		candidate2 = n;
        	}else {
        		count1--;
        		count2--;
        	}
        }
        count1 = 0;
        count2 = 0;
        for(int n : nums) {
        	if(n == candidate1) count1++;
        	else if(n == candidate2) count2++;
        }
        if(count1 > nums.length/3) ret.add(candidate1);
        if(count2 > nums.length/3) ret.add(candidate2);
        return ret;
    }
//    for(int num : nums){
//		if(num == candidate1) count1+=2;
//		else count1--;
//		if(num == candidate2) count2 += 2;
//		else count2--;
//	}
//	if(count1 > 0) rst.add(candidate1);
//	if(count2 > 0) rst.add(candidate2);
	public static void main(String[] args) {
		System.out.println(new S_229_MajorityElementII().majorityElement(new int[] {1,3,4,1,3,4,1,3}));

	}

}
