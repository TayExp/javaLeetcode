package leetcode;

import java.util.LinkedList;
import java.util.List;

public class S_315_CountSmallerNumbersAfterSelf {
    public List<Integer> countSmaller(int[] nums) {
        LinkedList<Integer> ret = new LinkedList<>();
        int n;
        if((n=nums.length) == 0) return ret;
        for(int i = n-1; i >= 0; i--){
            int cn = 0;
            for(int j = n-1; j > i; j--)
                if(nums[i] > nums[j]) cn ++;
            ret.addFirst(cn);
        }
        return ret;
    }
}
