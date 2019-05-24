package leetcode;

public class S_132_PalindromePartitioningII {
    public int minCut(String s) {
    	if(s.length()==0) return 0;
        int[] cut = new int[s.length()];
        boolean[][] pal = new boolean[s.length()][s.length()];
        cut[0] = 0;
        for(int i = 1; i < s.length(); i++){
        	cut[i] = cut[i-1] + 1;
        	for(int j = 0; j < i; j++){
        		if(s.charAt(j) == s.charAt(i) && (j+1 >= i-1 || pal[j+1][i-1])){
        			pal[j][i] = true;
        			cut[i] = j==0?0: Math.min(cut[i], cut[j-1]+1);
        		}
        	}
        }
        return cut[cut.length-1];
    }
}
