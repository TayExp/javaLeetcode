package leetcode;

public class S_059_SpiralMatrixII {
    public int[][] generateMatrix(int n) {
       int[][] ret = new int[n][n];
       int count = 1;;
       for(int i = 0; i < (n+1)/2; i++){
    	   for(int j = i; j < n - i;j++) ret[i][j] = count++;
    	   if((n&1) == 1 && i == n/2) break;
       	   for(int k = i+1; k<n-i; k++) ret[k][n-i-1] = count++;
       	   for(int j = n-i-2;j>=i;j--) ret[n-i-1][j] = count++;
       	   if(i == (n-1)/2) break;
       	   for(int k = n-i-2;k>i;k--) ret[k][i] = count++;
       	  }
       return ret;
    }
    public static void main(String[] args){
    	System.out.println(new S_059_SpiralMatrixII().generateMatrix(4));
    }
}
