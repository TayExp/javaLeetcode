package leetcode;
/*
 *  the minimum number of operations required to convert word1 to word2.
    Insert a character
    Delete a character
    Replace a character

 */
public class S_072_EditDistance {
	public int minDistance(String word1, String word2) {
        int m = word1.length(), n = word2.length();
		int[][] cost = new int[m+1][n+1];
        for(int i = 0; i <= m; cost[i][0] = i, i++);
        for(int i = 1; i <= n; cost[0][i] = i, i++);
        for(int i = 1; i <= m; i++)
        	for(int j = 1; j<=n; j++){
        		if(word1.charAt(i) == word2.charAt(j))
        			cost[i][j] = cost[i-1][j-1];
        		else
        			cost[i][j] = Math.min(cost[i-1][j-1], Math.min(cost[i][j-1], cost[i-1][j]))+1;
        	}
        return cost[m][n];
    }
}
