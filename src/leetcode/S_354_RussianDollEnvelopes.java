package leetcode;

import java.util.Arrays;
import java.util.Comparator;

public class S_354_RussianDollEnvelopes {
    public int maxEnvelopes(int[][] envelopes) {
    	if(envelopes.length == 0 || envelopes[0].length != 2) return 0;
        Arrays.sort(envelopes, new Comparator<int[]>() {
        	public int compare(int[] a, int[] b) {
        		// [3, 4] cannot contains [3, 3],
        		// so we need to put [3, 4] before [3, 3] when sorting 
        		return a[0]-b[0] == 0 ? b[1]-a[1]:a[0]-b[0]; // 相同w按h大顺序排
        	}
		});
        int[] dp = new int[envelopes.length];
        int len = 0;
        for(int[] en : envelopes) {
        	int index = Arrays.binarySearch(dp, 0, len, en[1]);
        	if(index < 0)
        		index = -(index+1);
        	dp[index] = en[1];
        	if(index == len)
        		len++;
        }
        return len;
    }
}
