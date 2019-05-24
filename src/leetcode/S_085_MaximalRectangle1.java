package leetcode;

public class S_085_MaximalRectangle1 {
	public int maximalRectangle(char[][] matrix) {
	    if(matrix.length == 0)
	    	return 0;
		int maxArea = 0;
		int[] height = new int[matrix[0].length];
		for(char[] row : matrix){
			for(int i = 0; i < matrix[0].length; i++)
				if(row[i] == '0')
					height[i] = 0;
				else
					height[i]++;
			maxArea = Math.max(maxArea, largestRectangleArea2(height));
		}
		return maxArea;
		
	}
	
	public int largestRectangleArea2(int[] heights) {
        int maxArea = 0, len = heights.length;
        int[] leftLeast = new int[len];
        int[] rightLeast = new int[len];
        leftLeast[0] = -1;
        rightLeast[len-1] = len;
        for(int i = 1; i < len; i++){
        	int p = i-1;
        	while(p >= 0 && heights[p] >= heights[i])
        		p = leftLeast[p];
        	leftLeast[i] = p;
        }
        for(int i = len - 2; i >= 0; i--){
        	int p = i+1;
        	while(p < len && heights[p] >= heights[i])
        		p = rightLeast[p];
        	rightLeast[i] = p;
        }
        for(int i = 0; i < len; i++)
        	maxArea = Math.max(maxArea, heights[i]*(rightLeast[i]-leftLeast[i]-1));
		return maxArea;
	}
}
