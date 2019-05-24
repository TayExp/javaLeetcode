package leetcode;

public class S_011_ContainerWithMostWater {
	public int maxArea(int[] height) {
		int begin = 0, end = height.length - 1;
		int maxarea=0;
		while(begin<end){
			// No errors in express!!
			maxarea = Math.max(maxarea, Math.min(height[begin], height[end]) * (end - begin));
			if (height[begin] < height[end])
				begin ++;
			else
				end--;
		}
		return maxarea;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new S_011_ContainerWithMostWater().maxArea(new int[] { 1, 8, 6, 2, 5, 4, 8, 3, 7 }));
	}

}
