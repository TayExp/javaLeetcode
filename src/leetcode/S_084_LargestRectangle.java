package leetcode;

import java.util.Stack;

public class S_084_LargestRectangle {
	public int largestRectangleArea1(int[] heights) {
        int maxArea = 0;
        Stack<Integer> stack = new Stack<>();
        for(int i = 0;i<=heights.length;i++){
        	int h = i == heights.length? 0 : heights[i];
        	if(stack.isEmpty() || h>= heights[stack.peek()]){ //注意条件
        		stack.push(i);
        	}else{
        		maxArea = Math.max(maxArea, heights[stack.pop()] * (stack.isEmpty()?i:i-1-stack.peek()));
        		i--;
        	}
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
	
	public static void main (String[] args){
		System.out.println(new S_084_LargestRectangle().largestRectangleArea2(new int[]{2,1,2}));
	}
    
}
