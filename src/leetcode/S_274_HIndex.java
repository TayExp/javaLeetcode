package leetcode;

import java.util.Arrays;

public class S_274_HIndex {
	public int hIndex(int[] citations) {
        int n = citations.length;
        Arrays.sort(citations);
        for(int i = n-1; i >= 0; i--) {
        	if(citations[i] < n-i)
        		return n-i-1;
        }
        return n;
    }
}
